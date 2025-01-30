package ps.albreem.quizzes.app7;

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

public class StartViewActivity extends Activity {
	
	private String app_description = "";
	private String app_package = "";
	private String logo = "";
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear2;
	private Button button1;
	private LinearLayout linear3;
	private Button button2;
	private LinearLayout linear4;
	private Button button3;
	private LinearLayout linear5;
	private Button button4;
	private LinearLayout linear6;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder dio;
	private SharedPreferences a;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start_view);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		button1 = findViewById(R.id.button1);
		linear3 = findViewById(R.id.linear3);
		button2 = findViewById(R.id.button2);
		linear4 = findViewById(R.id.linear4);
		button3 = findViewById(R.id.button3);
		linear5 = findViewById(R.id.linear5);
		button4 = findViewById(R.id.button4);
		linear6 = findViewById(R.id.linear6);
		dio = new AlertDialog.Builder(this);
		a = getSharedPreferences("a", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.gofundme.com/f/dr-mohammed-salem-salem-albreem"));
				startActivity(intent);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), QuizzesViewActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AppInfoViewActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://albreem.blogspot.com/2023/05/blog-post.html?m=1"));
				startActivity(intent);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://play.google.com/store/apps/dev?id=6256682954033888909"));
				startActivity(intent);
			}
		});
	}
	
	private void initializeLogic() {
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		app_package = "ps.albreem.quizzes.app7";
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		button3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		button4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		_view_shadow(button1, 57, "#00BCD4");
		_view_shadow(button2, 57, "#00BCD4");
		_view_shadow(button3, 57, "#00BCD4");
		_view_shadow(button4, 57, "#00BCD4");
	}
	
	@Override
	public void onBackPressed() {
		if (a.contains("x")) {
			finishAffinity();
		}
		else {
			dio.setTitle("هل نال اعجابك التطبيق ؟");
			dio.setMessage("أتمنى من حضرتك ان تشاركنا رأيك في استخدامك لتطبيق و شكرا لاستخدامك تطبيقي المتواضع سيدي/تي ");
			dio.setPositiveButton("تقييم التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					a.edit().putString("x", "x").commit();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=".concat(app_package)));
					startActivity(intent);
				}
			});
			dio.setNegativeButton("الخروج من التطبيق", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			dio.create().show();
		}
	}
	public void _view_shadow(final View _view, final double _V, final String _color) {
		_view.setElevation((float)_V);
		_view.setOutlineAmbientShadowColor(Color.parseColor(_color));
		_view.setOutlineSpotShadowColor(Color.parseColor(_color));
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