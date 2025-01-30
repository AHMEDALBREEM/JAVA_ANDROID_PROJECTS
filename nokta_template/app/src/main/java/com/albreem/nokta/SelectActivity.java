package com.albreem.nokta;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class SelectActivity extends Activity {
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear7;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private Button button5;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	
	private Intent ndj = new Intent();
	private AlertDialog.Builder x;
	private SharedPreferences s;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.select);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		linear7 = findViewById(R.id.linear7);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		button5 = findViewById(R.id.button5);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		button3 = findViewById(R.id.button3);
		button4 = findViewById(R.id.button4);
		x = new AlertDialog.Builder(this);
		s = getSharedPreferences("d", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ndj.setAction(Intent.ACTION_VIEW);
				ndj.setData(Uri.parse("https://www.gofundme.com/f/dr-mohammed-salem-salem-albreem"));
				startActivity(ndj);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ndj.setClass(getApplicationContext(), OptionaActivity.class);
				ndj.putExtra("a", "a");
				ndj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ndj);
				finish();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ndj.setClass(getApplicationContext(), OptionaActivity.class);
				ndj.putExtra("a", "b");
				ndj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ndj);
				finish();
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ndj.setClass(getApplicationContext(), OptionaActivity.class);
				ndj.putExtra("a", "c");
				ndj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(ndj);
				finish();
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ndj.setAction(Intent.ACTION_VIEW);
				ndj.setData(Uri.parse("https://albreem.blogspot.com/2023/05/blog-post.html"));
				startActivity(ndj);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ndj.setAction(Intent.ACTION_VIEW);
				ndj.setData(Uri.parse("https://play.google.com/store/apps/dev?id=6256682954033888909"));
				startActivity(ndj);
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= 21) { Window
			w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor("#000000")); }
		
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFB8C00));
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFB8C00));
		button3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFB8C00));
		button4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFB8C00));
		button5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFB8C00));
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
		button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
		button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
		button5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
	}
	
	@Override
	public void onBackPressed() {
		if (s.contains("x")) {
			finishAffinity();
		}
		else {
			x.setTitle("هل نال اعجابك التطبيق ؟");
			x.setMessage("أتمنى من حضرتك ان تشاركنا رأيك في استخدامك لتطبيق و شكرا لاستخدامك تطبيقي المتواضع سيدي/تي ");
			x.setPositiveButton("تقييم التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					s.edit().putString("x", "x").commit();
					ndj.setAction(Intent.ACTION_VIEW);
					ndj.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.albreem.nokta"));
					startActivity(ndj);
				}
			});
			x.setNegativeButton("الخروج من التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			x.create().show();
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