package com.albreem.solve.almada;

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
import android.widget.ScrollView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class StartActivity extends Activity {
	
	private double x = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear16;
	private ImageView imageview1;
	private LinearLayout linear3;
	private Button button12;
	private LinearLayout linear2;
	private Button button13;
	private LinearLayout linear5;
	private Button button14;
	private LinearLayout linear4;
	private Button button15;
	private LinearLayout linear7;
	private Button button16;
	private LinearLayout linear6;
	private Button button17;
	private LinearLayout linear9;
	private Button button18;
	private LinearLayout linear10;
	private Button button19;
	private LinearLayout linear11;
	private Button button20;
	private LinearLayout linear12;
	private Button button21;
	private LinearLayout linear13;
	private Button button22;
	private LinearLayout linear14;
	private Button button23;
	private LinearLayout linear15;
	private Button button24;
	private LinearLayout linear17;
	private Button button25;
	private LinearLayout linear18;
	private Button button26;
	private LinearLayout linear19;
	private Button button27;
	private LinearLayout linear20;
	
	private Intent intent = new Intent();
	private SharedPreferences f;
	private AlertDialog.Builder waring2;
	private AlertDialog.Builder waring;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear16 = findViewById(R.id.linear16);
		imageview1 = findViewById(R.id.imageview1);
		linear3 = findViewById(R.id.linear3);
		button12 = findViewById(R.id.button12);
		linear2 = findViewById(R.id.linear2);
		button13 = findViewById(R.id.button13);
		linear5 = findViewById(R.id.linear5);
		button14 = findViewById(R.id.button14);
		linear4 = findViewById(R.id.linear4);
		button15 = findViewById(R.id.button15);
		linear7 = findViewById(R.id.linear7);
		button16 = findViewById(R.id.button16);
		linear6 = findViewById(R.id.linear6);
		button17 = findViewById(R.id.button17);
		linear9 = findViewById(R.id.linear9);
		button18 = findViewById(R.id.button18);
		linear10 = findViewById(R.id.linear10);
		button19 = findViewById(R.id.button19);
		linear11 = findViewById(R.id.linear11);
		button20 = findViewById(R.id.button20);
		linear12 = findViewById(R.id.linear12);
		button21 = findViewById(R.id.button21);
		linear13 = findViewById(R.id.linear13);
		button22 = findViewById(R.id.button22);
		linear14 = findViewById(R.id.linear14);
		button23 = findViewById(R.id.button23);
		linear15 = findViewById(R.id.linear15);
		button24 = findViewById(R.id.button24);
		linear17 = findViewById(R.id.linear17);
		button25 = findViewById(R.id.button25);
		linear18 = findViewById(R.id.linear18);
		button26 = findViewById(R.id.button26);
		linear19 = findViewById(R.id.linear19);
		button27 = findViewById(R.id.button27);
		linear20 = findViewById(R.id.linear20);
		f = getSharedPreferences("data", Activity.MODE_PRIVATE);
		waring2 = new AlertDialog.Builder(this);
		waring = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.gofundme.com/f/dr-mohammed-salem-salem-albreem"));
				startActivity(intent);
			}
		});
		
		button12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(0)));
				intent.putExtra("head", button12.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(1)));
				intent.putExtra("head", button13.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(2)));
				intent.putExtra("head", button14.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(3)));
				intent.putExtra("head", button15.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(4)));
				intent.putExtra("head", button16.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(5)));
				intent.putExtra("head", button17.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(6)));
				intent.putExtra("head", button18.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(7)));
				intent.putExtra("head", button19.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(8)));
				intent.putExtra("head", button20.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(9)));
				intent.putExtra("head", button21.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(10)));
				intent.putExtra("head", button22.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(11)));
				intent.putExtra("head", button23.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(12)));
				intent.putExtra("head", button24.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(13)));
				intent.putExtra("head", button25.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(14)));
				intent.putExtra("head", button26.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		button27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(getApplicationContext(), ViewActivity.class);
				intent.putExtra("number", String.valueOf((long)(15)));
				intent.putExtra("head", button27.getText().toString());
				startActivity(intent);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		button12.setText("معلومات عامة حول المعدة");
		button13.setText("انواع الالم المعدة");
		button14.setText("الاهتمام بالمعدة");
		button15.setText("تمارين المعدة");
		button16.setText("اسباب الآلم المعدة");
		button17.setText("كيفية علاج برد المعدة");
		button19.setText("أعشاب لنزلات البرد");
		button18.setText("ألم في الجانب الأيسر من البطن");
		button20.setText("مشروبات لعلاج البرد");
		button21.setText("علاج حرقة المعدة");
		button22.setText("اطعمة تزيد من انزيمات الهضم");
		button23.setText("أسباب الغثيان المفاجئ");
		button24.setText("أسباب المغص والإسهال");
		button25.setText("أعراض التسمم");
		button26.setText("مرض البواسير");
		button27.setText("علاج عسر الهضم والانتفاخ");
		x = 0;
		button12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button18.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button18.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button20.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button21.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button21.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button22.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button22.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button23.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button24.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button24.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button25.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button25.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button26.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button26.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		button27.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF2196F3));
		button27.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
	}
	
	@Override
	public void onBackPressed() {
		if (f.contains("x")) {
			finishAffinity();
		}
		else {
			waring.setTitle("هل نال اعجابك التطبيق ؟");
			waring.setMessage("أتمنى من حضرتك ان تشاركنا رأيك في استخدامك لتطبيق و شكرا لاستخدامك تطبيقي المتواضع سيدي/تي ");
			waring.setPositiveButton("تقييم التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					f.edit().putString("x", "x").commit();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.albreem.solve.almada"));
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