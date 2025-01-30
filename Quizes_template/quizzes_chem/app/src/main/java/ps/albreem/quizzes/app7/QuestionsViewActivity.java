package ps.albreem.quizzes.app7;

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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class QuestionsViewActivity extends Activity {
	
	private double question_no_ = 0;
	private boolean answer_2_ = false;
	private boolean answer_3_ = false;
	private boolean answer_1_ = false;
	private boolean answer_4_ = false;
	private boolean answered = false;
	private String number_private = "";
	private double no_que = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear17;
	private LinearLayout linear16;
	private TextView question_no;
	private TextView textview11;
	private TextView question_text;
	private LinearLayout answer11;
	private LinearLayout answer22;
	private LinearLayout answer33;
	private LinearLayout answer44;
	private LinearLayout linear13;
	private LinearLayout linear19;
	private LinearLayout answerlayer;
	private TextView answer1_text;
	private CheckBox answer1;
	private TextView answer2_text;
	private CheckBox answer2;
	private TextView answer3_text;
	private CheckBox amswer3;
	private TextView answer4_text;
	private CheckBox amswer4;
	private Button return_try;
	private LinearLayout linear22;
	private Button check_answer;
	private LinearLayout linear23;
	private Button next;
	private TextView answer_text;
	private TextView textview9;
	
	private Intent intent = new Intent();
	private SharedPreferences questions_set;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.questions_view);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear17 = findViewById(R.id.linear17);
		linear16 = findViewById(R.id.linear16);
		question_no = findViewById(R.id.question_no);
		textview11 = findViewById(R.id.textview11);
		question_text = findViewById(R.id.question_text);
		answer11 = findViewById(R.id.answer11);
		answer22 = findViewById(R.id.answer22);
		answer33 = findViewById(R.id.answer33);
		answer44 = findViewById(R.id.answer44);
		linear13 = findViewById(R.id.linear13);
		linear19 = findViewById(R.id.linear19);
		answerlayer = findViewById(R.id.answerlayer);
		answer1_text = findViewById(R.id.answer1_text);
		answer1 = findViewById(R.id.answer1);
		answer2_text = findViewById(R.id.answer2_text);
		answer2 = findViewById(R.id.answer2);
		answer3_text = findViewById(R.id.answer3_text);
		amswer3 = findViewById(R.id.amswer3);
		answer4_text = findViewById(R.id.answer4_text);
		amswer4 = findViewById(R.id.amswer4);
		return_try = findViewById(R.id.return_try);
		linear22 = findViewById(R.id.linear22);
		check_answer = findViewById(R.id.check_answer);
		linear23 = findViewById(R.id.linear23);
		next = findViewById(R.id.next);
		answer_text = findViewById(R.id.answer_text);
		textview9 = findViewById(R.id.textview9);
		questions_set = getSharedPreferences("questions", Activity.MODE_PRIVATE);
		
		linear4.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		answer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					answer1.setChecked(true);
					answer2.setChecked(false);
					amswer3.setChecked(false);
					amswer4.setChecked(false);
					answer_1_ = true;
					answer_2_ = false;
					answer_3_ = false;
					answer_4_ = false;
				}
			}
		});
		
		answer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					answer1.setChecked(false);
					answer2.setChecked(true);
					amswer3.setChecked(false);
					amswer4.setChecked(false);
					answer_1_ = false;
					answer_2_ = true;
					answer_3_ = false;
					answer_4_ = false;
				}
			}
		});
		
		amswer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					answer1.setChecked(false);
					answer2.setChecked(false);
					amswer3.setChecked(true);
					amswer4.setChecked(false);
					answer_1_ = false;
					answer_2_ = false;
					answer_3_ = true;
					answer_4_ = false;
				}
			}
		});
		
		amswer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					answer1.setChecked(false);
					answer2.setChecked(false);
					amswer3.setChecked(false);
					amswer4.setChecked(true);
					answer_1_ = false;
					answer_2_ = false;
					answer_3_ = false;
					answer_4_ = true;
				}
			}
		});
		
		return_try.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "أستغفر الله");
				intent.setClass(getApplicationContext(), QuestionsViewActivity.class);
				intent.putExtra("current", getIntent().getStringExtra("current"));
				startActivity(intent);
				finish();
			}
		});
		
		check_answer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (answer_1_) {
					answer11.setBackgroundColor(0xFF4CAF50);
					if (answer_text.getText().toString().equals(answer1_text.getText().toString())) {
						answered = true;
						if ((no_que - 1) > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), String.valueOf((long)(Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), "")) + 1))).commit();
						}
						else {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
							SketchwareUtil.showMessage(getApplicationContext(), "لقد أتمت المجموعة رقم ".concat(String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))));
							if (9 > Double.parseDouble(questions_set.getString("question_set_unlock", ""))) {
								questions_set.edit().putString("question_set_unlock", String.valueOf((long)(Double.parseDouble(questions_set.getString("question_set_unlock", "")) + 1))).commit();
								questions_set.edit().putString("current", String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))).commit();
							}
							else {
								setTitle("لقد أنهيت اختبارات التطبيق");
								intent.setClass(getApplicationContext(), QuizzesViewActivity.class);
								startActivity(intent);
								finish();
							}
						}
						check_answer.setVisibility(View.GONE);
						next.setVisibility(View.VISIBLE);
						answerlayer.setVisibility(View.VISIBLE);
					}
					else {
						answered = false;
					}
				}
				if (answer_2_) {
					if (answer_text.getText().toString().equals(answer2_text.getText().toString())) {
						answer22.setBackgroundColor(0xFF4CAF50);
						answered = true;
						if ((no_que - 1) > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), String.valueOf((long)(Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), "")) + 1))).commit();
						}
						else {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
							SketchwareUtil.showMessage(getApplicationContext(), "لقد أتمت المجموعة رقم ".concat(String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))));
							if (9 > Double.parseDouble(questions_set.getString("question_set_unlock", ""))) {
								questions_set.edit().putString("question_set_unlock", String.valueOf((long)(Double.parseDouble(questions_set.getString("question_set_unlock", "")) + 1))).commit();
								questions_set.edit().putString("current", String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))).commit();
							}
							else {
								setTitle("لقد أنهيت اختبارات التطبيق");
								intent.setClass(getApplicationContext(), QuizzesViewActivity.class);
								startActivity(intent);
								finish();
							}
						}
						check_answer.setVisibility(View.GONE);
						next.setVisibility(View.VISIBLE);
						answerlayer.setVisibility(View.VISIBLE);
					}
					else {
						answered = false;
					}
				}
				if (answer_3_) {
					answer33.setBackgroundColor(0xFF4CAF50);
					if (answer_text.getText().toString().equals(answer3_text.getText().toString())) {
						answered = true;
						if ((no_que - 1) > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), String.valueOf((long)(Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), "")) + 1))).commit();
						}
						else {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
							SketchwareUtil.showMessage(getApplicationContext(), "لقد أتمت المجموعة رقم ".concat(String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))));
							if (9 > Double.parseDouble(questions_set.getString("question_set_unlock", ""))) {
								questions_set.edit().putString("question_set_unlock", String.valueOf((long)(Double.parseDouble(questions_set.getString("question_set_unlock", "")) + 1))).commit();
								questions_set.edit().putString("current", String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))).commit();
							}
							else {
								setTitle("لقد أنهيت اختبارات التطبيق");
								intent.setClass(getApplicationContext(), QuizzesViewActivity.class);
								startActivity(intent);
								finish();
							}
						}
						check_answer.setVisibility(View.GONE);
						next.setVisibility(View.VISIBLE);
						answerlayer.setVisibility(View.VISIBLE);
					}
					else {
						answered = false;
					}
				}
				if (answer_4_) {
					if (answer_text.getText().toString().equals(answer4_text.getText().toString())) {
						answered = true;
						if ((no_que - 1) > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), String.valueOf((long)(Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), "")) + 1))).commit();
						}
						else {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
							SketchwareUtil.showMessage(getApplicationContext(), "لقد أتمت المجموعة رقم ".concat(String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))));
							if (9 > Double.parseDouble(questions_set.getString("question_set_unlock", ""))) {
								questions_set.edit().putString("question_set_unlock", String.valueOf((long)(Double.parseDouble(questions_set.getString("question_set_unlock", "")) + 1))).commit();
								questions_set.edit().putString("current", String.valueOf((long)(Double.parseDouble(getIntent().getStringExtra("current")) + 1))).commit();
							}
							else {
								setTitle("لقد أنهيت اختبارات التطبيق");
								intent.setClass(getApplicationContext(), QuizzesViewActivity.class);
								startActivity(intent);
								finish();
							}
						}
						check_answer.setVisibility(View.GONE);
						next.setVisibility(View.VISIBLE);
						answerlayer.setVisibility(View.VISIBLE);
					}
					else {
						answered = false;
					}
				}
				if (!answered) {
					next.setVisibility(View.GONE);
					check_answer.setVisibility(View.GONE);
					return_try.setVisibility(View.VISIBLE);
					if (answer1.isChecked()) {
						answer11.setBackgroundColor(0xFFF44336);
					}
					else {
						if (answer2.isChecked()) {
							answer22.setBackgroundColor(0xFFF44336);
						}
						else {
							if (amswer3.isChecked()) {
								answer33.setBackgroundColor(0xFFF44336);
							}
							else {
								if (amswer4.isChecked()) {
									answer44.setBackgroundColor(0xFFF44336);
								}
							}
						}
					}
				}
			}
		});
		
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), QuestionsViewActivity.class);
				intent.putExtra("current", questions_set.getString("current", ""));
				startActivity(intent);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		no_que = 10;
		_view_shadow(return_try, 57, "#00BCD4");
		_view_shadow(check_answer, 57, "#00BCD4");
		_view_shadow(next, 57, "#00BCD4");
		questions_set.edit().putString("current", getIntent().getStringExtra("current")).commit();
		check_answer.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		return_try.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFF44336));
		next.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFF4CAF50));
		question_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 1);
		question_no.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		answer1_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		answer2_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		answer3_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		answer4_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		check_answer.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 1);
		next.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 1);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		return_try.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 1);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		answer_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/asddd.ttf"), 0);
		next.setVisibility(View.GONE);
		check_answer.setVisibility(View.VISIBLE);
		answerlayer.setVisibility(View.GONE);
		return_try.setVisibility(View.GONE);
		answered = false;
		number_private = "0";
		for(int _repeat502 = 0; _repeat502 < (int)(10); _repeat502++) {
			if (getIntent().getStringExtra("current").equals(number_private)) {
				listmap.clear();
				try {
					java.io.InputStream inputstream1 = getAssets().open(String.valueOf((long)(Double.parseDouble(number_private) + 1)).concat(".json"));
					listmap = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					if (!questions_set.contains("question_".concat(getIntent().getStringExtra("current")))) {
						questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
					}
					question_no_ = Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""));
					question_text.setText(listmap.get((int)question_no_).get("text").toString());
					question_no.setText(listmap.get((int)question_no_).get("no").toString());
					answer1_text.setText(listmap.get((int)question_no_).get("answer_text_1").toString());
					answer2_text.setText(listmap.get((int)question_no_).get("answer_text_2").toString());
					answer3_text.setText(listmap.get((int)question_no_).get("answer_text_3").toString());
					answer4_text.setText(listmap.get((int)question_no_).get("answer_text_4").toString());
					answer_text.setText(listmap.get((int)question_no_).get("answer").toString());
					break;
				} catch (Exception e) {
				}
			}
			number_private = String.valueOf((long)(1 + Double.parseDouble(number_private)));
		}
		if (10 < Double.parseDouble(number_private)) {
			SketchwareUtil.showMessage(getApplicationContext(), "لقد أنهيت كل المراحل ! ، لكن بإمكانك تكملة العب استمتع و أشكر الله ");
		}
	}
	
	@Override
	public void onBackPressed() {
		intent.setClass(getApplicationContext(), QuizzesViewActivity.class);
		startActivity(intent);
		finish();
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