package com.albreem.hkmaapp;

import android.animation.*;
import android.app.*;
import android.app.Activity;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class Page5Activity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	private String b = "";
	private double one = 0;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear5;
	private TextView textview2;
	private LinearLayout linear4;
	private ListView listview1;
	
	private Intent intent = new Intent();
	private SharedPreferences last;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.page5);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		listview1 = findViewById(R.id.listview1);
		last = getSharedPreferences("last", Activity.MODE_PRIVATE);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!last.getString("endedf", "").equals("")) {
					listview1.smoothScrollToPosition((int)(Double.parseDouble(last.getString("endedf", ""))));
				}
				else {
					listview1.smoothScrollToPosition((int)(0));
				}
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= 21) { Window
			w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor("#FB8C00")); }
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
		try{
			java.io.InputStream inputstream1 = getAssets().open("5.json");
			map = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		} catch (Exception e) {
			    
		}
		_fab.hide();
		if (!last.getString("endedf", "").equals("")) {
			_fab.show();
		}
		else {
			
		}
	}
	
	@Override
	public void onBackPressed() {
		intent.setClass(getApplicationContext(), StartActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		last.edit().putString("endedf", String.valueOf((long)(one))).commit();
		startActivity(intent);
		finish();
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
				_view = _inflater.inflate(R.layout.view, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(map.get((int)_position).get("text").toString());
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					b = textview1.getText().toString();
					Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND); sendIntent.putExtra(Intent.EXTRA_TEXT,b); sendIntent.setType("text/plain"); Intent shareIntent = Intent.createChooser(sendIntent,null); startActivity(shareIntent);
				}
			});
			Animation animation;
			        animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
			        animation.setDuration(500);
			        linear4.startAnimation(animation);
			        animation = null;
			one = _position;
			
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