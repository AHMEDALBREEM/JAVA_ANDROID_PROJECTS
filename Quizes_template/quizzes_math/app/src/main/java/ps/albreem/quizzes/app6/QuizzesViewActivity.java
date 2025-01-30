package ps.albreem.quizzes.app6;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class QuizzesViewActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> list_map = new ArrayList<>();
	
	private ListView listview1;
	
	private Intent move = new Intent();
	private SharedPreferences question_set;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.quizzes_view);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		listview1 = findViewById(R.id.listview1);
		question_set = getSharedPreferences("questions", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if ((Double.parseDouble(question_set.getString("question_set_unlock", "")) > _position) || (Double.parseDouble(question_set.getString("question_set_unlock", "")) == _position)) {
					move.setClass(getApplicationContext(), QuestionsViewActivity.class);
					move.putExtra("current", String.valueOf((long)(_position)));
					startActivity(move);
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "قم بإجتياز الاختبار السابق ، مستواك : ".concat(String.valueOf((long)(Double.parseDouble(question_set.getString("question_set_unlock", "")) + 1)).concat(" ، المستوى السؤال : ".concat(String.valueOf((long)(_position + 1))))));
				}
			}
		});
	}
	
	private void initializeLogic() {
		if (!question_set.contains("question_set_unlock")) {
			question_set.edit().putString("question_set_unlock", "0").commit();
		}
		try{
			java.io.InputStream inputstream1 = getAssets().open("start.json");
			list_map = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(list_map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		} catch (Exception e) {
			    
		}
	}
	
	@Override
	public void onBackPressed() {
		move.setClass(getApplicationContext(), StartViewActivity.class);
		startActivity(move);
		finish();
	}
	public void _view_shadow(final View _view, final double _V, final String _color) {
		_view.setElevation((float)_V);
		_view.setOutlineAmbientShadowColor(Color.parseColor(_color));
		_view.setOutlineSpotShadowColor(Color.parseColor(_color));
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom_view, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView number_question_set = _view.findViewById(R.id.number_question_set);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView question_set_text = _view.findViewById(R.id.question_set_text);
			
			number_question_set.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
			question_set_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
			if ((Double.parseDouble(question_set.getString("question_set_unlock", "")) > _position) || (Double.parseDouble(question_set.getString("question_set_unlock", "")) == _position)) {
				imageview1.setImageResource(R.drawable.ic_lock_open_black);
			}
			question_set_text.setText(list_map.get((int)_position).get("question_set_text").toString());
			number_question_set.setText(String.valueOf((long)(Double.parseDouble(list_map.get((int)_position).get("number_question_set").toString()))));
			_view_shadow(linear1, 57, "#000000");
			linear1.setBackgroundColor(0xFFEEEEEE);
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}