package ps.albreem.quizzes.app1;

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
						if (9 > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
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
						if (9 > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
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
						if (9 > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
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
						if (9 > Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""))) {
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
				if (10 > Double.parseDouble(questions_set.getString("question_set_unlock", ""))) {
					intent.setClass(getApplicationContext(), QuestionsViewActivity.class);
					intent.putExtra("current", questions_set.getString("current", ""));
					startActivity(intent);
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "لقد أنهيت التطبيق بنجاح ");
					intent.setClass(getApplicationContext(), StartViewActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
	}
	
	private void initializeLogic() {
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
		if (getIntent().getStringExtra("current").equals("0")) {
			listmap.clear();
			listmap = new Gson().fromJson("[\n    {\n      \"text\": \"ما هو أكبر قارة في العالم؟\",\n      \"no\": \"1\",\n      \"answer_text_1\": \"أفريقيا\",\n      \"answer_text_2\": \"آسيا\",\n      \"answer_text_3\": \"أوروبا\",\n      \"answer_text_4\": \"أمريكا الشمالية\",\n      \"answer\": \"آسيا\"\n    },\n    {\n      \"text\": \"ما هو أعلى قمة جبلية في العالم؟\",\n      \"no\": \"2\",\n      \"answer_text_1\": \"قمة إيفرست\",\n      \"answer_text_2\": \"قمة كيليمنجارو\",\n      \"answer_text_3\": \"قمة كوتوباكسي\",\n      \"answer_text_4\": \"قمة كليمانجارو\",\n      \"answer\": \"قمة إيفرست\"\n    },\n    {\n      \"text\": \"ما هي العاصمة الفرنسية؟\",\n      \"no\": \"3\",\n      \"answer_text_1\": \"لندن\",\n      \"answer_text_2\": \"باريس\",\n      \"answer_text_3\": \"برلين\",\n      \"answer_text_4\": \"روما\",\n      \"answer\": \"باريس\"\n    },\n    {\n      \"text\": \"ما هي عاصمة اليابان؟\",\n      \"no\": \"4\",\n      \"answer_text_1\": \"سول\",\n      \"answer_text_2\": \"طوكيو\",\n      \"answer_text_3\": \"بكين\",\n      \"answer_text_4\": \"هانوي\",\n      \"answer\": \"طوكيو\"\n    },\n    {\n      \"text\": \"ما هي عاصمة أستراليا؟\",\n      \"no\": \"5\",\n      \"answer_text_1\": \"سيدني\",\n      \"answer_text_2\": \"ملبورن\",\n      \"answer_text_3\": \"برلين\",\n      \"answer_text_4\": \"كانبرا\",\n      \"answer\": \"كانبرا\"\n    },\n    {\n      \"text\": \"ما هو أصغر كوكب في النظام الشمسي؟\",\n      \"no\": \"6\",\n      \"answer_text_1\": \"المريخ\",\n      \"answer_text_2\": \"الزهرة\",\n      \"answer_text_3\": \"الأرض\",\n      \"answer_text_4\": \"عطارد\",\n      \"answer\": \"عطارد\"\n    },\n    {\n      \"text\": \"ما هي أكبر دولة في العالم من حيث المساحة؟\",\n      \"no\": \"7\",\n      \"answer_text_1\": \"كندا\",\n      \"answer_text_2\": \"الصين\",\n      \"answer_text_3\": \"روسيا\",\n      \"answer_text_4\": \"الولايات المتحدة الأمريكية\",\n      \"answer\": \"روسيا\"\n    },\n    {\n      \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'O'؟\",\n      \"no\": \"8\",\n      \"answer_text_1\": \"الأكسجين\",\n      \"answer_text_2\": \"النيتروجين\",\n      \"answer_text_3\": \"الهيدروجين\",\n      \"answer_text_4\": \"الكربون\",\n      \"answer\": \"الأكسجين\"\n    },\n    {\n      \"text\": \"ما هي عاصمة كندا؟\",\n      \"no\": \"9\",\n      \"answer_text_1\": \"تورنتو\",\n      \"answer_text_2\": \"فانكوفر\",\n      \"answer_text_3\": \"أوتاوا\",\n      \"answer_text_4\": \"كالجاري\",\n      \"answer\": \"أوتاوا\"\n    },\n    {\n      \"text\": \"ما هو الحيوان الذي يُعرف بأنه 'ملك الغابة'؟\",\n      \"no\": \"10\",\n      \"answer_text_1\": \"الفهد\",\n      \"answer_text_2\": \"النمر\",\n      \"answer_text_3\": \"الأسد\",\n      \"answer_text_4\": \"النمر الأبيض\",\n      \"answer\": \"الأسد\"\n    }\n  ]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
		}
		else {
			if (getIntent().getStringExtra("current").equals("1")) {
				listmap.clear();
				listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هو العنصر الرئيسي المكون للماء؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"الهيدروجين\",\n    \"answer_text_2\": \"الأكسجين\",\n    \"answer_text_3\": \"النيتروجين\",\n    \"answer_text_4\": \"الكربون\",\n    \"answer\": \"الهيدروجين\"\n  },\n  {\n    \"text\": \"ما هي أكبر صحراء في العالم؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"صحراء الساحل الشمالي\",\n    \"answer_text_2\": \"صحراء الربع الخالي\",\n    \"answer_text_3\": \"صحراء كالاهاري\",\n    \"answer_text_4\": \"صحراء غوبي\",\n    \"answer\": \"صحراء الساحل الشمالي\"\n  },\n  {\n    \"text\": \"ما هي عاصمة روسيا؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"سانت بطرسبرغ\",\n    \"answer_text_2\": \"موسكو\",\n    \"answer_text_3\": \"كييف\",\n    \"answer_text_4\": \"نيويورك\",\n    \"answer\": \"موسكو\"\n  },\n  {\n    \"text\": \"ما هو العاصمة الألمانية؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"برلين\",\n    \"answer_text_2\": \"فرانكفورت\",\n    \"answer_text_3\": \"ميونيخ\",\n    \"answer_text_4\": \"هامبورغ\",\n    \"answer\": \"برلين\"\n  },\n  {\n    \"text\": \"ما هو أكبر نهر في العالم من حيث تدفق المياه؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"النيل\",\n    \"answer_text_2\": \"الأمازون\",\n    \"answer_text_3\": \"المسيسيبي\",\n    \"answer_text_4\": \"اليانغتسي\",\n    \"answer\": \"الأمازون\"\n  },\n  {\n    \"text\": \"ما هي العاصمة البرازيلية؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"ريو دي جانيرو\",\n    \"answer_text_2\": \"برازيليا\",\n    \"answer_text_3\": \"ساو باولو\",\n    \"answer_text_4\": \"سالفادور\",\n    \"answer\": \"برازيليا\"\n  },\n  {\n    \"text\": \"ما هو العاصمة الصينية؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"شنغهاي\",\n    \"answer_text_2\": \"هونج كونج\",\n    \"answer_text_3\": \"بكين\",\n    \"answer_text_4\": \"تشنغدو\",\n    \"answer\": \"بكين\"\n  },\n  {\n    \"text\": \"ما هي أكبر دولة عربية من حيث المساحة؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"العراق\",\n    \"answer_text_2\": \"السعودية\",\n    \"answer_text_3\": \"الجزائر\",\n    \"answer_text_4\": \"مصر\",\n    \"answer\": \"الجزائر\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'Na'؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"الصوديوم\",\n    \"answer_text_2\": \"الكالسيوم\",\n    \"answer_text_3\": \"الحديد\",\n    \"answer_text_4\": \"البوتاسيوم\",\n    \"answer\": \"الصوديوم\"\n  },\n  {\n    \"text\": \"ما هي عاصمة الهند؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"نيودلهي\",\n    \"answer_text_2\": \"مومباي\",\n    \"answer_text_3\": \"كولكاتا\",\n    \"answer_text_4\": \"بنغالور\",\n    \"answer\": \"نيودلهي\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
			}
			else {
				if (getIntent().getStringExtra("current").equals("2")) {
					listmap.clear();
					listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هو العاصمة الأمريكية؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"نيويورك\",\n    \"answer_text_2\": \"واشنطن العاصمة\",\n    \"answer_text_3\": \"لوس أنجلوس\",\n    \"answer_text_4\": \"شيكاغو\",\n    \"answer\": \"واشنطن العاصمة\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الوطني للولايات المتحدة الأمريكية؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"النسر الأمريكي\",\n    \"answer_text_2\": \"الدب الأمريكي\",\n    \"answer_text_3\": \"البومة الأمريكية\",\n    \"answer_text_4\": \"الجمل الأمريكي\",\n    \"answer\": \"النسر الأمريكي\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يطير بدون أجنحة؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"العقرب\",\n    \"answer_text_2\": \"الضفدع\",\n    \"answer_text_3\": \"السمكة\",\n    \"answer_text_4\": \"الخفاش\",\n    \"answer\": \"الخفاش\"\n  },\n  {\n    \"text\": \"ما هو أصغر عضو في جسم الإنسان؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"الأذن\",\n    \"answer_text_2\": \"الأنف\",\n    \"answer_text_3\": \"العين\",\n    \"answer_text_4\": \"الأصبع\",\n    \"answer\": \"الأذن\"\n  },\n  {\n    \"text\": \"ما هو أكثر الحيوانات سرعة على اليابسة؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"الفهد\",\n    \"answer_text_2\": \"الغزال\",\n    \"answer_text_3\": \"الفيل\",\n    \"answer_text_4\": \"القطة\",\n    \"answer\": \"الفهد\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'Fe'؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"الفضة\",\n    \"answer_text_2\": \"الحديد\",\n    \"answer_text_3\": \"الذهب\",\n    \"answer_text_4\": \"الرصاص\",\n    \"answer\": \"الحديد\"\n  },\n  {\n    \"text\": \"ما هو أكبر قارة من حيث عدد السكان؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"أفريقيا\",\n    \"answer_text_2\": \"آسيا\",\n    \"answer_text_3\": \"أوروبا\",\n    \"answer_text_4\": \"أمريكا الجنوبية\",\n    \"answer\": \"آسيا\"\n  },\n  {\n    \"text\": \"ما هي العاصمة الرومانية؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"بوخارست\",\n    \"answer_text_2\": \"سوفيا\",\n    \"answer_text_3\": \"بلغراد\",\n    \"answer_text_4\": \"زغرب\",\n    \"answer\": \"بوخارست\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'H'؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"الهيدروجين\",\n    \"answer_text_2\": \"الهليوم\",\n    \"answer_text_3\": \"الهندسيوم\",\n    \"answer_text_4\": \"الهاكيوم\",\n    \"answer\": \"الهيدروجين\"\n  },\n  {\n    \"text\": \"ما هو القارة التي لا يوجد بها دولة؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"أستراليا\",\n    \"answer_text_2\": \"أمريكا الجنوبية\",\n    \"answer_text_3\": \"أوروبا\",\n    \"answer_text_4\": \"أنتاركتيكا\",\n    \"answer\": \"أنتاركتيكا\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
				}
				else {
					if (getIntent().getStringExtra("current").equals("3")) {
						listmap.clear();
						if (!questions_set.contains("question_".concat(getIntent().getStringExtra("current")))) {
							questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
						}
						question_no_ = Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""));
						listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هي عاصمة فرنسا؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"لندن\",\n    \"answer_text_2\": \"برلين\",\n    \"answer_text_3\": \"باريس\",\n    \"answer_text_4\": \"روما\",\n    \"answer\": \"باريس\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يُعرف بـ 'سلطان الغابة'؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"النمر\",\n    \"answer_text_2\": \"الأسد\",\n    \"answer_text_3\": \"الفهد\",\n    \"answer_text_4\": \"الفيل\",\n    \"answer\": \"النمر\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'Ca'؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"الكالسيوم\",\n    \"answer_text_2\": \"الكلور\",\n    \"answer_text_3\": \"الكربون\",\n    \"answer_text_4\": \"الكروم\",\n    \"answer\": \"الكالسيوم\"\n  },\n  {\n    \"text\": \"ما هي عاصمة المملكة المتحدة؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"لندن\",\n    \"answer_text_2\": \"مانشستر\",\n    \"answer_text_3\": \"ليدز\",\n    \"answer_text_4\": \"بيرمنغهام\",\n    \"answer\": \"لندن\"\n  },\n  {\n    \"text\": \"ما هو أطول نهر في العالم؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"نهر الأمازون\",\n    \"answer_text_2\": \"نهر النيل\",\n    \"answer_text_3\": \"نهر اليانغتسي\",\n    \"answer_text_4\": \"نهر الغانج\",\n    \"answer\": \"نهر الأمازون\"\n  },\n  {\n    \"text\": \"ما هي العاصمة الأسترالية؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"ملبورن\",\n    \"answer_text_2\": \"كانبرا\",\n    \"answer_text_3\": \"سيدني\",\n    \"answer_text_4\": \"بريزبن\",\n    \"answer\": \"كانبرا\"\n  },\n  {\n    \"text\": \"ما هي أكبر دولة في العالم من حيث المساحة؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"الولايات المتحدة الأمريكية\",\n    \"answer_text_2\": \"روسيا\",\n    \"answer_text_3\": \"كندا\",\n    \"answer_text_4\": \"الصين\",\n    \"answer\": \"روسيا\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يسمى بـ 'ملك السمك'؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"السلمون\",\n    \"answer_text_2\": \"التونة\",\n    \"answer_text_3\": \"القرش\",\n    \"answer_text_4\": \"الحوت الأزرق\",\n    \"answer\": \"القرش\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'K'؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"الكالسيوم\",\n    \"answer_text_2\": \"الكربون\",\n    \"answer_text_3\": \"الكلور\",\n    \"answer_text_4\": \"البوتاسيوم\",\n    \"answer\": \"البوتاسيوم\"\n  },\n  {\n    \"text\": \"ما هو أكبر جزيرة في العالم؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"جزيرة مدغشقر\",\n    \"answer_text_2\": \"جزيرة كاليفورنيا\",\n    \"answer_text_3\": \"جزيرة العرب\",\n    \"answer_text_4\": \"جزيرة غرينلاند\",\n    \"answer\": \"جزيرة غرينلاند\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						question_text.setText(listmap.get((int)question_no_).get("text").toString());
						question_no.setText(listmap.get((int)question_no_).get("no").toString());
						answer1_text.setText(listmap.get((int)question_no_).get("answer_text_1").toString());
						answer2_text.setText(listmap.get((int)question_no_).get("answer_text_2").toString());
						answer3_text.setText(listmap.get((int)question_no_).get("answer_text_3").toString());
						answer4_text.setText(listmap.get((int)question_no_).get("answer_text_4").toString());
						answer_text.setText(listmap.get((int)question_no_).get("answer").toString());
					}
					else {
						if (getIntent().getStringExtra("current").equals("4")) {
							if (!questions_set.contains("question_".concat(getIntent().getStringExtra("current")))) {
								questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
							}
							question_no_ = Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""));
							listmap.clear();
							listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هو العاصمة الروسية؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"موسكو\",\n    \"answer_text_2\": \"سانت بطرسبرغ\",\n    \"answer_text_3\": \"نوفوسيبيرسك\",\n    \"answer_text_4\": \"كازان\",\n    \"answer\": \"موسكو\"\n  },\n  {\n    \"text\": \"ما هو أصغر دولة في العالم من حيث المساحة؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"موناكو\",\n    \"answer_text_2\": \"الفاتيكان\",\n    \"answer_text_3\": \"ناورو\",\n    \"answer_text_4\": \"توفالو\",\n    \"answer\": \"الفاتيكان\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يُعرف بـ 'جمل البحر'؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"الدولفين\",\n    \"answer_text_2\": \"الحوت\",\n    \"answer_text_3\": \"النجمي\",\n    \"answer_text_4\": \"السمكة البلطي\",\n    \"answer\": \"الدولفين\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'N'؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"الأكسجين\",\n    \"answer_text_2\": \"النيتروجين\",\n    \"answer_text_3\": \"النيوبيوم\",\n    \"answer_text_4\": \"النحاس\",\n    \"answer\": \"النيتروجين\"\n  },\n  {\n    \"text\": \"ما هو أكبر دولة في العالم من حيث عدد السكان؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"الهند\",\n    \"answer_text_2\": \"الصين\",\n    \"answer_text_3\": \"الولايات المتحدة الأمريكية\",\n    \"answer_text_4\": \"روسيا\",\n    \"answer\": \"الصين\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعيش في البيئة المائية والبرية؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"التمساح\",\n    \"answer_text_2\": \"السمكة\",\n    \"answer_text_3\": \"السلحفاة\",\n    \"answer_text_4\": \"السنجاب\",\n    \"answer\": \"التمساح\"\n  },\n  {\n    \"text\": \"ما هي عاصمة إيطاليا؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"ميلانو\",\n    \"answer_text_2\": \"فيرونا\",\n    \"answer_text_3\": \"روما\",\n    \"answer_text_4\": \"فلورنسا\",\n    \"answer\": \"روما\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'Si'؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"الفضة\",\n    \"answer_text_2\": \"السيليكون\",\n    \"answer_text_3\": \"الزنك\",\n    \"answer_text_4\": \"الصوديوم\",\n    \"answer\": \"السيليكون\"\n  },\n  {\n    \"text\": \"ما هو أكبر بحيرة في العالم من حيث المساحة؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"بحيرة فيكتوريا\",\n    \"answer_text_2\": \"بحيرة البايكال\",\n    \"answer_text_3\": \"بحيرة تيتيكاكا\",\n    \"answer_text_4\": \"بحيرة السويس\",\n    \"answer\": \"بحيرة البايكال\"\n  },\n  {\n    \"text\": \"ما هو أكثر الحيوانات قدرة على الطيران؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"العصفور\",\n    \"answer_text_2\": \"الخفاش\",\n    \"answer_text_3\": \"النسر\",\n    \"answer_text_4\": \"الطاووس\",\n    \"answer\": \"الخفاش\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							question_text.setText(listmap.get((int)question_no_).get("text").toString());
							question_no.setText(listmap.get((int)question_no_).get("no").toString());
							answer1_text.setText(listmap.get((int)question_no_).get("answer_text_1").toString());
							answer2_text.setText(listmap.get((int)question_no_).get("answer_text_2").toString());
							answer3_text.setText(listmap.get((int)question_no_).get("answer_text_3").toString());
							answer4_text.setText(listmap.get((int)question_no_).get("answer_text_4").toString());
							answer_text.setText(listmap.get((int)question_no_).get("answer").toString());
						}
						else {
							if (getIntent().getStringExtra("current").equals("5")) {
								listmap.clear();
								if (!questions_set.contains("question_".concat(getIntent().getStringExtra("current")))) {
									questions_set.edit().putString("question_".concat(getIntent().getStringExtra("current")), "0").commit();
								}
								question_no_ = Double.parseDouble(questions_set.getString("question_".concat(getIntent().getStringExtra("current")), ""));
								listmap = new Gson().fromJson("[\n  {\n    \"text\": \"من هو الرسول الذي بنى الديانة الإسلامية؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"موسى\",\n    \"answer_text_2\": \"عيسى\",\n    \"answer_text_3\": \"محمد\",\n    \"answer_text_4\": \"إبراهيم\",\n    \"answer\": \"محمد\"\n  },\n  {\n    \"text\": \"ما هي اللغة الرسمية للصين؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"الإنجليزية\",\n    \"answer_text_2\": \"الفرنسية\",\n    \"answer_text_3\": \"الصينية\",\n    \"answer_text_4\": \"الإسبانية\",\n    \"answer\": \"الصينية\"\n  },\n  {\n    \"text\": \"ما هو أكبر كوكب في النظام الشمسي؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"المريخ\",\n    \"answer_text_2\": \"زحل\",\n    \"answer_text_3\": \"الزهرة\",\n    \"answer_text_4\": \"المشتري\",\n    \"answer\": \"المشتري\"\n  },\n  {\n    \"text\": \"ما هو العدد الذري للكربون؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"6\",\n    \"answer_text_2\": \"7\",\n    \"answer_text_3\": \"8\",\n    \"answer_text_4\": \"9\",\n    \"answer\": \"6\"\n  },\n  {\n    \"text\": \"ما هو عاصمة اليابان؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"سيول\",\n    \"answer_text_2\": \"طوكيو\",\n    \"answer_text_3\": \"بكين\",\n    \"answer_text_4\": \"هونغ كونغ\",\n    \"answer\": \"طوكيو\"\n  },\n  {\n    \"text\": \"من هو مؤسس شركة مايكروسوفت؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"بيل جيتس\",\n    \"answer_text_2\": \"ستيف جوبز\",\n    \"answer_text_3\": \"لاري بيج\",\n    \"answer_text_4\": \"مارك زوكربيرج\",\n    \"answer\": \"بيل جيتس\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الوطني للولايات المتحدة الأمريكية؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"النسر\",\n    \"answer_text_2\": \"الدب\",\n    \"answer_text_3\": \"الثعلب\",\n    \"answer_text_4\": \"الغزال\",\n    \"answer\": \"النسر\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'O'؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"الأوكسجين\",\n    \"answer_text_2\": \"النيتروجين\",\n    \"answer_text_3\": \"الهيدروجين\",\n    \"answer_text_4\": \"الكربون\",\n    \"answer\": \"الأوكسجين\"\n  },\n  {\n    \"text\": \"ما هو أكثر نوع من الحيوانات شعبية كحيوانات أليفة؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"القطط\",\n    \"answer_text_2\": \"الكلاب\",\n    \"answer_text_3\": \"الطيور\",\n    \"answer_text_4\": \"الأسماك\",\n    \"answer\": \"القطط\"\n  },\n  {\n    \"text\": \"ما هو الرقم الذري للهيدروجين؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"1\",\n    \"answer_text_2\": \"2\",\n    \"answer_text_3\": \"3\",\n    \"answer_text_4\": \"4\",\n    \"answer\": \"1\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
								question_text.setText(listmap.get((int)question_no_).get("text").toString());
								question_no.setText(listmap.get((int)question_no_).get("no").toString());
								answer1_text.setText(listmap.get((int)question_no_).get("answer_text_1").toString());
								answer2_text.setText(listmap.get((int)question_no_).get("answer_text_2").toString());
								answer3_text.setText(listmap.get((int)question_no_).get("answer_text_3").toString());
								answer4_text.setText(listmap.get((int)question_no_).get("answer_text_4").toString());
								answer_text.setText(listmap.get((int)question_no_).get("answer").toString());
							}
							else {
								if (getIntent().getStringExtra("current").equals("6")) {
									listmap.clear();
									listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هو العنصر الرئيسي في الهواء؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"الأكسجين\",\n    \"answer_text_2\": \"النيتروجين\",\n    \"answer_text_3\": \"الهيليوم\",\n    \"answer_text_4\": \"الكربون\",\n    \"answer\": \"النيتروجين\"\n  },\n  {\n    \"text\": \"ما هو أكبر قارة في العالم؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"أفريقيا\",\n    \"answer_text_2\": \"آسيا\",\n    \"answer_text_3\": \"أوروبا\",\n    \"answer_text_4\": \"أمريكا الشمالية\",\n    \"answer\": \"آسيا\"\n  },\n  {\n    \"text\": \"من هو مؤلف كتاب 'رباعيات الخيام'؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"المتنبي\",\n    \"answer_text_2\": \"جلال الدين الرومي\",\n    \"answer_text_3\": \"أبو نواس\",\n    \"answer_text_4\": \"عمر الخيام\",\n    \"answer\": \"عمر الخيام\"\n  },\n  {\n    \"text\": \"ما هو القارب الأكثر استخدامًا للتنقل في البندقية؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"الجيت سكي\",\n    \"answer_text_2\": \"القارب الصغير\",\n    \"answer_text_3\": \"الغوندولا\",\n    \"answer_text_4\": \"السفينة\",\n    \"answer\": \"الغوندولا\"\n  },\n  {\n    \"text\": \"ما هي الدولة التي تعتبر موطنًا للكانغارو؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"الولايات المتحدة الأمريكية\",\n    \"answer_text_2\": \"البرازيل\",\n    \"answer_text_3\": \"أستراليا\",\n    \"answer_text_4\": \"الصين\",\n    \"answer\": \"أستراليا\"\n  },\n  {\n    \"text\": \"من هو مؤسس شركة آبل؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"ستيف جوبز\",\n    \"answer_text_2\": \"بيل جيتس\",\n    \"answer_text_3\": \"لاري بيج\",\n    \"answer_text_4\": \"مارك زوكربيرج\",\n    \"answer\": \"ستيف جوبز\"\n  },\n  {\n    \"text\": \"ما هو الفيلم الذي حصل على جائزة الأوسكار لأفضل فيلم في عام 2020؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"1917\",\n    \"answer_text_2\": \"باراسايت\",\n    \"answer_text_3\": \"جوكر\",\n    \"answer_text_4\": \"بالاسواتر\",\n    \"answer\": \"باراسايت\"\n  },\n  {\n    \"text\": \"ما هو عاصمة المملكة المتحدة؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"لندن\",\n    \"answer_text_2\": \"مانشستر\",\n    \"answer_text_3\": \"ليدز\",\n    \"answer_text_4\": \"برمنغهام\",\n    \"answer\": \"لندن\"\n  },\n  {\n    \"text\": \"من هو رئيس فرنسا الحالي؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"فرانسوا هولاند\",\n    \"answer_text_2\": \"نيكولا ساركوزي\",\n    \"answer_text_3\": \"إيمانويل ماكرون\",\n    \"answer_text_4\": \"جاك شيراك\",\n    \"answer\": \"إيمانويل ماكرون\"\n  },\n  {\n    \"text\": \"من هو مؤسس مايكروسوفت؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"بيل جيتس\",\n    \"answer_text_2\": \"ستيف جوبز\",\n    \"answer_text_3\": \"لاري بيج\",\n    \"answer_text_4\": \"مارك زوكربيرج\",\n    \"answer\": \"بيل جيتس\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
								}
								else {
									if (getIntent().getStringExtra("current").equals("7")) {
										listmap.clear();
										listmap = new Gson().fromJson("[\n  {\n    \"text\": \"من هو الرئيس الأمريكي الذي ألغى قانون العبودية؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"أبراهام لنكولن\",\n    \"answer_text_2\": \"جورج واشنطن\",\n    \"answer_text_3\": \"توماس جيفرسون\",\n    \"answer_text_4\": \"فرانكلين روزفلت\",\n    \"answer\": \"أبراهام لنكولن\"\n  },\n  {\n    \"text\": \"ما هو أكثر الأعماق بحيرة في العالم؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"بحيرة فيكتوريا\",\n    \"answer_text_2\": \"بحيرة تيتيكاكا\",\n    \"answer_text_3\": \"بحيرة البايكال\",\n    \"answer_text_4\": \"بحيرة ميشيغان\",\n    \"answer\": \"بحيرة البايكال\"\n  },\n  {\n    \"text\": \"ما هو القارب الذي يتم التحكم فيه عن طريق قوة الرياح؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"الزورق\",\n    \"answer_text_2\": \"اليخت\",\n    \"answer_text_3\": \"المركب\",\n    \"answer_text_4\": \"الزورق الشراعي\",\n    \"answer\": \"الزورق الشراعي\"\n  },\n  {\n    \"text\": \"ما هي عاصمة البرازيل؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"برازيليا\",\n    \"answer_text_2\": \"ريو دي جانيرو\",\n    \"answer_text_3\": \"ساو باولو\",\n    \"answer_text_4\": \"بوينس آيرس\",\n    \"answer\": \"برازيليا\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'H'؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"الهيدروجين\",\n    \"answer_text_2\": \"الهيليوم\",\n    \"answer_text_3\": \"الهيدرات\",\n    \"answer_text_4\": \"الهرمون\",\n    \"answer\": \"الهيدروجين\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعيش في الجليد ويعتبره البعض أكبر حيوان على وجه الأرض؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"الدب القطبي\",\n    \"answer_text_2\": \"التمساح\",\n    \"answer_text_3\": \"البطريق\",\n    \"answer_text_4\": \"القرش الأبيض\",\n    \"answer\": \"الدب القطبي\"\n  },\n  {\n    \"text\": \"ما هو العملة الرسمية في الهند؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"الروبية الهندية\",\n    \"answer_text_2\": \"الدولار الهندي\",\n    \"answer_text_3\": \"الدينار الهندي\",\n    \"answer_text_4\": \"الروبل الهندي\",\n    \"answer\": \"الروبية الهندية\"\n  },\n  {\n    \"text\": \"من هو مؤلف رواية 'مئة عام من العزلة'؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"جابرييل غارسيا ماركيز\",\n    \"answer_text_2\": \"فرانس كافكا\",\n    \"answer_text_3\": \"إرنست همنغواي\",\n    \"answer_text_4\": \"فيكتور هوجو\",\n    \"answer\": \"جابرييل غارسيا ماركيز\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنفه الطويل؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"الزرافة\",\n    \"answer_text_2\": \"الفيل\",\n    \"answer_text_3\": \"الكلب\",\n    \"answer_text_4\": \"الإبل\",\n    \"answer\": \"الفيل\"\n  },\n  {\n    \"text\": \"ما هي عاصمة أستراليا؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"كانبرا\",\n    \"answer_text_2\": \"سيدني\",\n    \"answer_text_3\": \"ملبورن\",\n    \"answer_text_4\": \"بريزبين\",\n    \"answer\": \"كانبرا\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
									}
									else {
										if (getIntent().getStringExtra("current").equals("8")) {
											listmap.clear();
											listmap = new Gson().fromJson("[\n  {\n    \"text\": \"من هو مؤلف رواية 'عيناك'؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"جبران خليل جبران\",\n    \"answer_text_2\": \"طه حسين\",\n    \"answer_text_3\": \"نجيب محفوظ\",\n    \"answer_text_4\": \"غسان كنفاني\",\n    \"answer\": \"جبران خليل جبران\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'C'؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"الكالسيوم\",\n    \"answer_text_2\": \"الكلور\",\n    \"answer_text_3\": \"الكربون\",\n    \"answer_text_4\": \"الصوديوم\",\n    \"answer\": \"الكربون\"\n  },\n  {\n    \"text\": \"من هو أول رئيس لجمهورية مصر العربية؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"جمال عبد الناصر\",\n    \"answer_text_2\": \"أنور السادات\",\n    \"answer_text_3\": \"حسني مبارك\",\n    \"answer_text_4\": \"محمد نجيب\",\n    \"answer\": \"محمد نجيب\"\n  },\n  {\n    \"text\": \"ما هو الفيلم الذي فاز بجائزة الأوسكار لأفضل فيلم في عام 2019؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"ذا شيب أوف ووتر\",\n    \"answer_text_2\": \"ذا بوست\",\n    \"answer_text_3\": \"ذا سيفنث سنس\",\n    \"answer_text_4\": \"ذا غرين بوك\",\n    \"answer\": \"ذا غرين بوك\"\n  },\n  {\n    \"text\": \"ما هو الفيلم الذي فاز بجائزة الأوسكار لأفضل فيلم في عام 2018؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"ذا شيب أوف ووتر\",\n    \"answer_text_2\": \"ذا بوست\",\n    \"answer_text_3\": \"ذا سيفنث سنس\",\n    \"answer_text_4\": \"ذا شيب أوف ووتر\",\n    \"answer\": \"ذا شيب أوف ووتر\"\n  },\n  {\n    \"text\": \"ما هو العملة الرسمية في إيطاليا؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"اليورو\",\n    \"answer_text_2\": \"الدولار الأمريكي\",\n    \"answer_text_3\": \"الليرة الإيطالية\",\n    \"answer_text_4\": \"الجنيه الإسترليني\",\n    \"answer\": \"اليورو\"\n  },\n  {\n    \"text\": \"من هو مؤسس شركة فيسبوك؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"مارك زوكربيرج\",\n    \"answer_text_2\": \"بيل جيتس\",\n    \"answer_text_3\": \"ستيف جوبز\",\n    \"answer_text_4\": \"لاري بيج\",\n    \"answer\": \"مارك زوكربيرج\"\n  },\n  {\n    \"text\": \"من هو مؤلف رواية '1984'؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"جورج أورويل\",\n    \"answer_text_2\": \"آلبرت كامو\",\n    \"answer_text_3\": \"فرانز كافكا\",\n    \"answer_text_4\": \"راي برادبيري\",\n    \"answer\": \"جورج أورويل\"\n  },\n  {\n    \"text\": \"ما هو عدد الكواكب في النظام الشمسي؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"8\",\n    \"answer_text_2\": \"9\",\n    \"answer_text_3\": \"10\",\n    \"answer_text_4\": \"7\",\n    \"answer\": \"8\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنفه الطويل؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"الزرافة\",\n    \"answer_text_2\": \"الفيل\",\n    \"answer_text_3\": \"الكلب\",\n    \"answer_text_4\": \"الإبل\",\n    \"answer\": \"الفيل\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
										}
										else {
											if (getIntent().getStringExtra("current").equals("9")) {
												listmap.clear();
												listmap = new Gson().fromJson("[\n  {\n    \"text\": \"من هو مؤلف رواية 'حكاية زمان مضى'؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"نجيب محفوظ\",\n    \"answer_text_2\": \"غسان كنفاني\",\n    \"answer_text_3\": \"طه حسين\",\n    \"answer_text_4\": \"محمود تيمور\",\n    \"answer\": \"نجيب محفوظ\"\n  },\n  {\n    \"text\": \"ما هي العاصمة الرابعة للولايات المتحدة الأمريكية؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"هيوستن\",\n    \"answer_text_2\": \"لوس أنجلوس\",\n    \"answer_text_3\": \"سان فرانسيسكو\",\n    \"answer_text_4\": \"شيكاغو\",\n    \"answer\": \"هيوستن\"\n  },\n  {\n    \"text\": \"من هو مؤلف رواية 'ما وراء الطبيعة'؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"هربرت جورج ويلز\",\n    \"answer_text_2\": \"جول فيرن\",\n    \"answer_text_3\": \"جون ستاينبيك\",\n    \"answer_text_4\": \"هرمان ميلفيل\",\n    \"answer\": \"هربرت جورج ويلز\"\n  },\n  {\n    \"text\": \"ما هو العنصر الكيميائي الذي يرمز له بالرمز 'Fe'؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"الحديد\",\n    \"answer_text_2\": \"الفضة\",\n    \"answer_text_3\": \"الذهب\",\n    \"answer_text_4\": \"الزئبق\",\n    \"answer\": \"الحديد\"\n  },\n  {\n    \"text\": \"من هو مؤلف رواية 'ميلاد الحريم'؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"نجيب محفوظ\",\n    \"answer_text_2\": \"غسان كنفاني\",\n    \"answer_text_3\": \"طه حسين\",\n    \"answer_text_4\": \"بسام فتحي\",\n    \"answer\": \"نجيب محفوظ\"\n  },\n  {\n    \"text\": \"ما هي العاصمة الحالية للصين؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"بكين\",\n    \"answer_text_2\": \"شنغهاي\",\n    \"answer_text_3\": \"تشينغداو\",\n    \"answer_text_4\": \"هونج كونج\",\n    \"answer\": \"بكين\"\n  },\n  {\n    \"text\": \"من هو مؤلف رواية 'حرب وسلام'؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"ليو تولستوي\",\n    \"answer_text_2\": \"فيودور دوستويفسكي\",\n    \"answer_text_3\": \"نجيب محفوظ\",\n    \"answer_text_4\": \"غابرييل غارسيا ماركيز\",\n    \"answer\": \"ليو تولستوي\"\n  },\n  {\n    \"text\": \"ما هو أكبر كوكب في النظام الشمسي؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"المشتري\",\n    \"answer_text_2\": \"الزهرة\",\n    \"answer_text_3\": \"الأرض\",\n    \"answer_text_4\": \"عطارد\",\n    \"answer\": \"المشتري\"\n  },\n  {\n    \"text\": \"من هو مؤلف رواية 'مدينة الجسد'؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"جون ستاينبيك\",\n    \"answer_text_2\": \"جورج أورويل\",\n    \"answer_text_3\": \"نجيب محفوظ\",\n    \"answer_text_4\": \"بسام فتحي\",\n    \"answer\": \"جون ستاينبيك\"\n  },\n{\n  \"text\": \"من هو الفائز بجائزة نوبل في الكيمياء لعام 2021؟\",\n  \"no\": \"10\",\n  \"answer_text_1\": \"فرانك شاربنتنر\",\n  \"answer_text_2\": \"ستانلي ويتينجهام\",\n  \"answer_text_3\": \"ديفيد جول\",\n  \"answer_text_4\": \"جون موسو\",\n  \"answer\": \"فرانك شاربنتنر\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
											}
											else {
												intent.setClass(getApplicationContext(), StartViewActivity.class);
												startActivity(intent);
												finish();
											}
										}
									}
								}
							}
						}
					}
				}
			}
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