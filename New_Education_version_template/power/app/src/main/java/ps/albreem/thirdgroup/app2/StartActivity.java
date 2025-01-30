package ps.albreem.thirdgroup.app2;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class StartActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private ListView listview1;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder waring;
	private AlertDialog.Builder waring2;
	private SharedPreferences a;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		listview1 = findViewById(R.id.listview1);
		waring = new AlertDialog.Builder(this);
		waring2 = new AlertDialog.Builder(this);
		a = getSharedPreferences("a", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.gofundme.com/f/dr-mohammed-salem-salem-albreem"));
				startActivity(intent);
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= 21) { Window
			w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor("#018055")); }
		imageview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF018055));
		try{
			java.io.InputStream inputstream1 = getAssets().open("start.json");
			map = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		} catch (Exception e) {
			    
		}
	}
	
	@Override
	public void onBackPressed() {
		if (a.contains("x")) {
			finishAffinity();
		}
		else {
			waring.setTitle("هل نال اعجابك التطبيق ؟");
			waring.setMessage("أتمنى من حضرتك ان تشاركنا رأيك في استخدامك لتطبيق و شكرا لاستخدامك تطبيقي المتواضع سيدي/تي ");
			waring.setPositiveButton("تقييم التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					a.edit().putString("x", "x").commit();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=".concat(getIntent().getStringExtra("pak"))));
					startActivity(intent);
				}
			});
			waring.setNegativeButton("الخروج من التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			waring.create().show();
		}
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
				_view = _inflater.inflate(R.layout.start_view, null);
			}
			
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final Button button4 = _view.findViewById(R.id.button4);
			
			button4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF018055));
			button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
			button4.setText(map.get((int)_position).get("head").toString());
			button4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), Page1Activity.class);
					intent.putExtra("head", map.get((int)_position).get("head").toString());
					intent.putExtra("info", map.get((int)_position).get("info").toString());
					startActivity(intent);
					finish();
				}
			});
			
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