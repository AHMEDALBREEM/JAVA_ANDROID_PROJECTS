package com.albreem.nokta;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class OptionaActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> mapp = new ArrayList<>();
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private ListView listview1;
	
	private Intent travel = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.optiona);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		listview1 = findViewById(R.id.listview1);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				travel.setAction(Intent.ACTION_VIEW);
				travel.setData(Uri.parse("https://www.gofundme.com/f/dr-mohammed-salem-salem-albreem"));
				startActivity(travel);
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
			}
		});
	}
	
	private void initializeLogic() {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت فلسطينية 🇵🇸");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت مصرية 🇪🇬");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت ليبية 🇱🇾");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت خليجية 🇰🇼🇶🇦");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت جزائرية 🇩🇿");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت عراقية 🇮🇶");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت سورية 🇸🇾");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت  الأردنية 🇯🇴");
			mapp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("text", "نكت  مغربية 🇲🇦");
			mapp.add(_item);
		}
		
		listview1.setAdapter(new Listview1Adapter(mapp));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		if (Build.VERSION.SDK_INT >= 21) { Window
			w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor("#000000")); }
		
		_effect(listview1, 40, 40, "#FFFFFF");
	}
	
	@Override
	public void onBackPressed() {
		travel.setClass(getApplicationContext(), SelectActivity.class);
		startActivity(travel);
		finish();
	}
	public void _effect(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		
		
		ab.setColor(Color.parseColor(_color));
		
		ab.setCornerRadius((float) _radius);
		
		_view.setElevation((float) _shadow);
		
		_view.setBackground(ab);
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
				_view = _inflater.inflate(R.layout.custom, null);
			}
			
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final Button button1 = _view.findViewById(R.id.button1);
			
			button1.setText(mapp.get((int)_position).get("text").toString());
			Animation animation;
			        animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
			        animation.setDuration(500);
			        linear3.startAnimation(animation);
			        animation = null;
			button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
			button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)25, (int)1, 0xFFFFFFFF, 0xFFFB8C00));
			button1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					travel.setClass(getApplicationContext(), CustomViewActivity.class);
					travel.putExtra("text", mapp.get((int)_position).get("text").toString());
					travel.putExtra("a", getIntent().getStringExtra("a"));
					travel.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(travel);
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