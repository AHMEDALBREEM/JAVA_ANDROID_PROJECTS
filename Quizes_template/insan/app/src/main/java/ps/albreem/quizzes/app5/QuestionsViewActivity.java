package ps.albreem.quizzes.app5;

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
			listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العضو الذي يعمل على تحلية الطعام وإفراز اللعاب؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"اللسان\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"المعدة\",\n\"answer_text_4\": \"الكبد\",\n\"answer\": \"اللسان\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تنظيم ضغط الدم وضخ الدم في الأوعية الدموية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"القلب\",\n\"answer_text_2\": \"الرئتين\",\n\"answer_text_3\": \"الكلية\",\n\"answer_text_4\": \"الكبد\",\n\"answer\": \"القلب\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتحويل الطعام إلى عصارة هضمية لتسهيل عملية الهضم؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"المعدة\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الأمعاء\",\n\"answer\": \"البنكرياس\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تنظيم مستويات السكر في الدم وتخزين الجلوكوز؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"الكلية\",\n\"answer_text_4\": \"المعدة\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تخزين وتفريغ البول؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الكلية\",\n\"answer_text_2\": \"المثانة\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"المثانة\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تثبيت العضلات وتحفيز الحركة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"العظام\",\n\"answer_text_2\": \"المفاصل\",\n\"answer_text_3\": \"الأعصاب\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"العظام\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتثبيت الأعضاء وحمايتها داخل الجسم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الجلد\",\n\"answer_text_2\": \"الأعصاب\",\n\"answer_text_3\": \"العظام\",\n\"answer_text_4\": \"المفاصل\",\n\"answer\": \"الجلد\"\n},\n{\n\"text\": \"ما هو العضو الذي يسمح بانتقال الطعام من المريء إلى المعدة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"المريء\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"الأمعاء الدقيقة\",\n\"answer_text_4\": \"الأمعاء الغليظة\",\n\"answer\": \"المريء\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بنقل الأكسجين إلى الأنسجة والأعضاء في الجسم؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"القلب\",\n\"answer_text_2\": \"الرئتين\",\n\"answer_text_3\": \"الأوعية الدموية\",\n\"answer_text_4\": \"الكبد\",\n\"answer\": \"الأوعية الدموية\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بإنتاج الكريات الحمراء والبيضاء في الدم؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الطحال\",\n\"answer_text_3\": \"العظام\",\n\"answer_text_4\": \"الكلية\",\n\"answer\": \"الطحال\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
				listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العضو الذي يقوم بتحلية الطعام وبدء عملية الهضم في الفم؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"اللسان\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الكبد\",\n\"answer\": \"اللسان\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تنظيم مستويات السكر في الدم وتخزين الجلوكوز؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"الكلية\",\n\"answer_text_4\": \"المعدة\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تخزين الطاقة في الجسم وتحويل الدهون إلى طاقة؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الأمعاء\",\n\"answer_text_3\": \"العضلات\",\n\"answer_text_4\": \"الدهون\",\n\"answer\": \"الدهون\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تصفية الدم وإزالة الفضلات والمواد الضارة منه؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"القلب\",\n\"answer_text_4\": \"المعدة\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتخزين وتفريغ البول؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الكلية\",\n\"answer_text_2\": \"المثانة\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"المثانة\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تثبيت العضلات وتحفيز الحركة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"العظام\",\n\"answer_text_2\": \"المفاصل\",\n\"answer_text_3\": \"الأعصاب\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"العظام\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتثبيت الأعضاء وحمايتها داخل الجسم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الجلد\",\n\"answer_text_2\": \"الأعصاب\",\n\"answer_text_3\": \"العظام\",\n\"answer_text_4\": \"المفاصل\",\n\"answer\": \"الجلد\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بنقل الأكسجين إلى الأنسجة والأعضاء في الجسم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"القلب\",\n\"answer_text_2\": \"الرئتين\",\n\"answer_text_3\": \"الأوعية الدموية\",\n\"answer_text_4\": \"الكبد\",\n\"answer\": \"الأوعية الدموية\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بإنتاج الكريات الحمراء والبيضاء في الدم؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الطحال\",\n\"answer_text_3\": \"العظام\",\n\"answer_text_4\": \"الكلية\",\n\"answer\": \"الطحال\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تحويل الطعام إلى عصارة هضمية لتسهيل عملية الهضم؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"المعدة\",\n\"answer_text_2\": \"البنكرياس\",                                     \"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الأمعاء الدقيقة\",\n\"answer\": \"المعدة\"\n        }\n    ]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
					listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الجزء الذي يعمل على نقل الإشارات الكهربائية بين الخلايا العصبية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الأعصاب\",\n\"answer_text_2\": \"العضلات\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الأعصاب\"\n},\n{\n\"text\": \"ما هو الجزء الذي يعمل على تكوين الهيكل الأساسي للجسم وحماية الأعضاء الداخلية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"العضلات\",\n\"answer_text_2\": \"العظام\",\n\"answer_text_3\": \"الأعصاب\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"العظام\"\n},\n{\n\"text\": \"ما هو الجزء الذي يتحكم في وظائف الجسم وينظم العمليات الحيوية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"القلب\",\n\"answer_text_3\": \"المخ\",\n\"answer_text_4\": \"الرئتين\",\n\"answer\": \"المخ\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تخزين الطاقة في الجسم وتحويل الدهون إلى طاقة؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الأمعاء\",\n\"answer_text_3\": \"العضلات\",\n\"answer_text_4\": \"الدهون\",\n\"answer\": \"الدهون\"\n},\n{\n\"text\": \"ما هو الجزء الذي يقوم بتوجيه الطعام من المريء إلى المعدة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"المعدة\",\n\"answer_text_2\": \"الكبد\",\n\"answer_text_3\": \"الأمعاء الدقيقة\",\n\"answer_text_4\": \"المريء\",\n\"answer\": \"المريء\"\n},\n{\n\"text\": \"ما هو الجزء الذي يقوم بتحويل الطعام إلى عصارة هضمية لتسهيل عملية الهضم؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"البنكرياس\",\n\"answer_text_2\": \"الكبد\",\n\"answer_text_3\": \"الأمعاء الدقيقة\",\n\"answer_text_4\": \"المعدة\",\n\"answer\": \"المعدة\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتنظيم ضغط الدم وتوزيع الدم في الجسم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"القلب\",\n\"answer_text_2\": \"الرئتين\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الكلية\",\n\"answer\": \"القلب\"\n},\n{\n\"text\": \"ما هو الجزء الذي يقوم بإنتاج الكريات الحمراء التي تحمل الأكسجين في الدم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"العظام\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"العظام\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تصفية الدم وإزالة الفضلات والمواد الضارة منه؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"الطحال\",\n\"answer_text_4\": \"المعدة\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هو الجزء الذي يقوم بتقليل فقدان الماء من الجسم عن طريق إفراز العرق؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الكلية\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الغدة النخامية\",\n\"answer\": \"الغدة النخامية\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
						listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العضو الذي يقوم بتحلية الطعام وتحويله إلى عصارة هضمية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"اللسان\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الكلية\",\n\"answer\": \"اللسان\"\n},\n{\n\"text\": \"ما هو النوع الأكثر شيوعًا من الأنسجة في الجسم؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"العضلية\",\n\"answer_text_2\": \"النسيج الضام\",\n\"answer_text_3\": \"النسيج الظاهر\",\n\"answer_text_4\": \"النسيج العصبي\",\n\"answer\": \"النسيج الضام\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تصفية الدم وإزالة الفضلات منه؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"الرئتين\",\n\"answer_text_4\": \"القلب\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تحفيز العضلات لتحريك العظام؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"العظام\",\n\"answer_text_2\": \"الجلد\",\n\"answer_text_3\": \"الأعصاب\",\n\"answer_text_4\": \"المفاصل\",\n\"answer\": \"الأعصاب\"\n},\n{\n\"text\": \"ما هو العضو الذي يؤدي دورًا مهمًا في عملية التنفس وتبادل الغازات؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"القلب\",\n\"answer_text_3\": \"الرئتين\",\n\"answer_text_4\": \"الكلية\",\n\"answer\": \"الرئتين\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بإفراز العصارة البنكرياسية لمساعدة في عملية الهضم؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"البنكرياس\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"البنكرياس\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تخزين الصفراء وتحويل السكر إلى طاقة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو العضو الذي يساعد في الحفاظ على توازن السوائل والأملاح في الجسم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الكلية\",\n\"answer_text_2\": \"البنكرياس\",\n\"answer_text_3\": \"الكبد\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تخزين وإطلاق العصارة المعوية لهضم الطعام؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"المعدة\",\n\"answer_text_2\": \"الكبد\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"المعدة\"\n},\n{\n\"text\": \"ما هو الجزء الذي يعمل على نقل الإشارات الكهربائية بين الخلايا العصبية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الأعصاب\",\n\"answer_text_2\": \"العضلات\",\n\"answer_text_3\":\"الكبد\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الأعصاب\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
							listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الجزء الذي يتكون من الأنسجة الرخوة التي تحمي الدماغ؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الجمجمة\",\n\"answer_text_2\": \"الحجاب الحاجز\",\n\"answer_text_3\": \"العظم الصدغي\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"الحجاب الحاجز\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على إزالة السموم من الجسم وتنظيم مستويات السوائل؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"المعدة\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هي الأنسجة التي تتكون من مجموعة من الخلايا المتخصصة في أداء وظيفة محددة؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الأعضاء\",\n\"answer_text_2\": \"الغدد\",\n\"answer_text_3\": \"الأعصاب\",\n\"answer_text_4\": \"الأنسجة\",\n\"answer\": \"الأنسجة\"\n},\n{\n\"text\": \"ما هو العضلة التي تعمل على فتح وإغلاق العين؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"عضلة المرارة\",\n\"answer_text_2\": \"عضلة الفم\",\n\"answer_text_3\": \"عضلة القلب\",\n\"answer_text_4\": \"عضلة الرباطة المثانية\",\n\"answer\": \"عضلة المرارة\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتخزين الصفراء وتحويل السكر إلى طاقة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تثبيت العضلات وتحفيز الحركة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"العظام\",\n\"answer_text_2\": \"الجلد\",\n\"answer_text_3\": \"الأعصاب\",\n\"answer_text_4\": \"المفاصل\",\n\"answer\": \"العظام\"\n},\n{\n\"text\": \"ما هو الأنبوب الذي ينقل الطعام من الحلق إلى المعدة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"المريء\",\n\"answer_text_2\": \"الأمعاء الدقيقة\",\n\"answer_text_3\": \"الأمعاء الغليظة\",\n\"answer_text_4\": \"المعدة\",\n\"answer\": \"المريء\"\n},\n{\n\"text\": \"ما هو العضو الذي يحتوي على الأنسجة التي تنتج الحليب؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الرئتين\",\n\"answer_text_3\": \"الثدي\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الثدي\"\n},\n{\n\"text\": \"ما هو النوع الأكثر شيوعًا من الأنسجة في الجسم؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"العضلية\",\n\"answer_text_2\": \"النسيج الضام\",\n\"answer_text_3\": \"النسيج الظاهر\",\n\"answer_text_4\": \"النسيج العصبي\",\n\"answer\": \"النسيج الضام\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تنظيم درجة حرارة الجسم والحفاظ على توازن السوائل؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"المخ\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"الجلد\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
								listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العضو الذي يعمل على تنقية الدم وإزالة الفضلات منه؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"الرئتين\",\n\"answer_text_4\": \"القلب\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هو اسم الجزء الذي يتميز بأنه مسؤول عن تنظيم مستويات السوائل والأملاح في الجسم؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"البنكرياس\",\n\"answer_text_2\": \"الغدة الكظرية\",\n\"answer_text_3\": \"الكلية\",\n\"answer_text_4\": \"الكبد\",\n\"answer\": \"الغدة الكظرية\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على تخزين الطاقة في شكل الجلوكوز والتحويل الفعال للسكر في الدم؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو اسم العضو الذي يعمل على إنتاج الصفراء والمواد الدهنية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"الطحال\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هي الغدد التي تفرز العرق للمساعدة في تبريد الجسم؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الغدد اللعابية\",\n\"answer_text_2\": \"الغدد اللبنية\",\n\"answer_text_3\": \"الغدد العرقية\",\n\"answer_text_4\": \"الغدد الدهنية\",\n\"answer\": \"الغدد العرقية\"\n},\n{\n\"text\": \"ما هو الهرمون الذي ينظم مستويات السكر في الدم؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الأدينوزين\",\n\"answer_text_2\": \"الإنسولين\",\n\"answer_text_3\": \"الغلوكاجون\",\n\"answer_text_4\": \"الهرمون النمو\",\n\"answer\": \"الإنسولين\"\n},\n{\n\"text\": \"ما هو الهرمون الذي يساعد في تحفيز نمو الأنسجة وتطورها؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الهرمون النمو\",\n\"answer_text_2\": \"الأدينوزين\",\n\"answer_text_3\": \"الإنسولين\",\n\"answer_text_4\": \"الغلوكاجون\",\n\"answer\": \"الهرمون النمو\"\n},\n{\n\"text\": \"ما هو الجزء الذي يتكون من مجموعة من الأنسجة التي تعمل معًا لأداء وظائف معينة في الجسم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الأعضاء\",\n\"answer_text_2\": \"الغدة\",\n\"answer_text_3\": \"الأعضاء الحيوية\",\n\"answer_text_4\": \"الأعضاء الداخلية\",\n\"answer\": \"الأعضاء\"\n},\n{\n\"text\": \"ما هو اسم الغشاء الذي يحيط بالقلب؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الجمجمة\",\n\"answer_text_2\": \"الحجاب الحاجز\",\n\"answer_text_3\": \"العظم الصدغي\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"الحجاب الحاجز\"\n},\n{\n\"text\": \"ما هو العضو الذي يعمل على إنتاج الصفراء والمواد الدهنية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"الطحال\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الكبد\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
									listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو اسم الجزء الذي يفصل بين البطن والحوض؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"العصار\",\n\"answer_text_2\": \"الغشاء الوتدي\",\n\"answer_text_3\": \"الحاجز العجزي\",\n\"answer_text_4\": \"الحاجز الحرقفي\",\n\"answer\": \"العصار\"\n},\n{\n\"text\": \"ما هو الهرمون الذي يساعد في تحفيز نمو الخلايا وتطورها؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الأدينوزين\",\n\"answer_text_2\": \"الهرمون النمو\",\n\"answer_text_3\": \"الإنسولين\",\n\"answer_text_4\": \"الأدرينالين\",\n\"answer\": \"الهرمون النمو\"\n},\n{\n\"text\": \"ما هي الغدة التي تفرز الهرمونات التي تساعد في التحكم في وظائف الجسم مثل معدل الأيض ومستويات السكر في الدم؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الغدة النخامية\",\n\"answer_text_2\": \"الغدة الكظرية\",\n\"answer_text_3\": \"الغدة الدرقية\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"البنكرياس\"\n},\n{\n\"text\": \"ما هو اسم العضو الذي يعمل على تصفية الدم وإزالة الفضلات منه وتنظيم مستوى السوائل في الجسم؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلى\",\n\"answer_text_3\": \"الرئتين\",\n\"answer_text_4\": \"القلب\",\n\"answer\": \"الكلى\"\n},\n{\n\"text\": \"ما هو العضو الذي يؤدي دورًا في تخزين الغذاء وتحويل السكر المخزن إلى طاقة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"المعدة\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الطحال\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو اسم الأوعية الدموية الكبيرة التي تنقل الدم من القلب إلى باقي أجزاء الجسم؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الوريد\",\n\"answer_text_2\": \"الشريان\",\n\"answer_text_3\": \"الأبهر\",\n\"answer_text_4\": \"المسار الوعائي\",\n\"answer\": \"الشريان\"\n},\n{\n\"text\": \"ما هو العضو الذي يتكون من مجموعة من الأنسجة التي تعمل معًا للقيام بوظائف معينة في الجسم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الغدة\",\n\"answer_text_2\": \"الأعضاء\",\n\"answer_text_3\": \"الأعضاء الحيوية\",\n\"answer_text_4\": \"الأعضاء الداخلية\",\n\"answer\": \"الأعضاء\"\n},\n{\n\"text\": \"ما هو الجزء الذي يتكون من الأنسجة اللينة التي تحمي الدماغ؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الجمجمة\",\n\"answer_text_2\": \"الحجاب الحاجز\",\n\"answer_text_3\": \"العظم الصدغي\",\n\"answer_text_4\": \"الجلد\",\n\"answer\": \"الحجاب الحاجز\"\n},\n{\n\"text\": \"ما هي العضلة التي تعتبر مسؤولة عن الحركة المستقرة للجسم والمشي؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"عضلة السمانة\",\n\"answer_text_2\": \"عضلة الظهر\",\n\"answer_text_3\": \"عضلة الساق\",\n\"answer_text_4\": \"عضلة الورك\",\n\"answer\": \"عضلة السمانة\"\n},\n{\n\"text\": \"ما هي العضلة التي تساعد في تثبيت الكتف وتثبيت الزاوية بين الركبة والفخذ؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"عضلة الفخذ\",\n\"answer_text_2\": \"عضلة السمانة\",\n\"answer_text_3\": \"عضلة الكتف\",\n\"answer_text_4\": \"عضلة الساق\",\n\"answer\": \"عضلة الفخذ\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
										listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الهرمون الذي ينظم مستويات السكر في الدم؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الإنسولين\",\n\"answer_text_2\": \"الأدينوزين\",\n\"answer_text_3\": \"الأدرينالين\",\n\"answer_text_4\": \"الغلوكاجون\",\n\"answer\": \"الإنسولين\"\n},\n{\n\"text\": \"ما هو العضو الذي يُنظر إليه عادةً على أنه المصدر الرئيسي للتسخين في الجسم؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"القلب\",\n\"answer_text_2\": \"الكبد\",\n\"answer_text_3\": \"الدماغ\",\n\"answer_text_4\": \"الكليتين\",\n\"answer\": \"الكبد\"\n},\n{\n\"text\": \"ما هو عدد العظام في جسم الإنسان البالغ؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"206 عظمة\",\n\"answer_text_2\": \"210 عظمة\",\n\"answer_text_3\": \"200 عظمة\",\n\"answer_text_4\": \"216 عظمة\",\n\"answer\": \"206 عظمة\"\n},\n{\n\"text\": \"ما هو اسم الغدة التي تنتج الهرمونات التي تنظم معدل الأيض؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الغدة النخامية\",\n\"answer_text_2\": \"الغدة الكظرية\",\n\"answer_text_3\": \"الغدة الدرقية\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الغدة الدرقية\"\n},\n{\n\"text\": \"ما هي العضلة التي تعتبر مسؤولة عن تحريك الفم والفك السفلي؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"عضلة الفم\",\n\"answer_text_2\": \"عضلة الفك\",\n\"answer_text_3\": \"عضلة اللسان\",\n\"answer_text_4\": \"عضلة الرقبة\",\n\"answer\": \"عضلة الفك\"\n},\n{\n\"text\": \"ما هو اسم العضلة التي تمتد على طول العمود الفقري وتساعد في تمديد الظهر؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"عضلة السمانة\",\n\"answer_text_2\": \"عضلة الظهر\",\n\"answer_text_3\": \"عضلة الفخذ\",\n\"answer_text_4\": \"عضلة الركبة\",\n\"answer\": \"عضلة الظهر\"\n},\n{\n\"text\": \"ما هو العضو الذي يقوم بتنقية الدم وإزالة الفضلات منه؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الكبد\",\n\"answer_text_2\": \"الكلية\",\n\"answer_text_3\": \"القلب\",\n\"answer_text_4\": \"البنكرياس\",\n\"answer\": \"الكلية\"\n},\n{\n\"text\": \"ما هو اسم الغشاء الذي يغطي القلب؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"البطينة\",\n\"answer_text_2\": \"الأذينين\",\n\"answer_text_3\": \"التاجي\",\n\"answer_text_4\": \"البطينات الأذينية\",\n\"answer\": \"التاجي\"\n},\n{\n\"text\": \"ما هو اسم العضلة التي تساعد في تحريك الكتف ورفعه؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"عضلة الكتف\",\n\"answer_text_2\": \"عضلة العجزية\",\n\"answer_text_3\": \"عضلة الكتف الكبرى\",\n\"answer_text_4\": \"عضلة الفخذ\",\n\"answer\": \"عضلة الكتف\"\n},\n{\n\"text\": \"ما هي الغدد التي تفرز العرق للتبريد والحفاظ على درجة حرارة الجسم؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الغدد اللعابية\",\n\"answer_text_2\": \"الغدد اللبنية\",\n\"answer_text_3\": \"الغدد العرقية\",\n\"answer_text_4\": \"الغدد الدهنية\",\n\"answer\": \"الغدد العرقية\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
											listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هي العضلة التي تعتبر أكبر عضلة في جسم الإنسان؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"عضلة السمانة\",\n\"answer_text_2\": \"عضلة القلب\",\n\"answer_text_3\": \"عضلة المؤخرة الكبيرة\",\n\"answer_text_4\": \"عضلة الفخذ\",\n\"answer\": \"عضلة السمانة\"\n},\n{\n\"text\": \"ما هي الغدد التي تفرز هرمون الأدينوزين ثلاثي الفوسفات، المعروف باسم ATP؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الغدة النخامية\",\n\"answer_text_2\": \"الغدة الكظرية\",\n\"answer_text_3\": \"البنكرياس\",\n\"answer_text_4\": \"الغدة الدرقية\",\n\"answer\": \"الغدة الكظرية\"\n},\n{\n\"text\": \"ما هو عدد العضلات التي يستخدمها الإنسان للابتسام؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"6 عضلات\",\n\"answer_text_2\": \"7 عضلات\",\n\"answer_text_3\": \"12 عضلة\",\n\"answer_text_4\": \"19 عضلة\",\n\"answer\": \"19 عضلة\"\n},\n{\n\"text\": \"ما هو اسم العضلة التي توجد في الركبة وتستخدم لتثبيت الساق؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"عضلة الفخذ الأمامية\",\n\"answer_text_2\": \"عضلة السمانة\",\n\"answer_text_3\": \"عضلة السمانة الصغيرة\",\n\"answer_text_4\": \"عضلة العجزية\",\n\"answer\": \"عضلة الفخذ الأمامية\"\n},\n{\n\"text\": \"ما هي العضلة التي تحترق بسرعة أكبر من الألياف العضلية البطيئة ولكنها تتعب بسرعة أيضًا؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"عضلة القلب\",\n\"answer_text_2\": \"عضلة السمانة\",\n\"answer_text_3\": \"عضلة السمانة الصغيرة\",\n\"answer_text_4\": \"عضلة العجزية\",\n\"answer\": \"عضلة السمانة\"\n},\n{\n\"text\": \"ما هو اسم الغدة التي تتحكم في مستويات الكالسيوم والفوسفات في الدم؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الغدة النخامية\",\n\"answer_text_2\": \"الغدة الكظرية\",\n\"answer_text_3\": \"الغدة الدرقية\",\n\"answer_text_4\": \"الغدة الجاردة\",\n\"answer\": \"الغدة الدرقية\"\n},\n{\n\"text\": \"ما هي العضلة التي تساعد في حركة العين على الأنظمة الرئيسية للجسم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"عضلة العجزية\",\n\"answer_text_2\": \"عضلة العين\",\n\"answer_text_3\": \"عضلة الحركة العصبية\",\n\"answer_text_4\": \"عضلة المخاط\",\n\"answer\": \"عضلة العين\"\n},\n{\n\"text\": \"ما هي العضلة التي تمتد عبر المفاصل وتعمل على تمديد الأطراف؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"عضلة السمانة\",\n\"answer_text_2\": \"عضلة السمانة الصغيرة\",\n\"answer_text_3\": \"عضلة العجزية\",\n\"answer_text_4\": \"عضلة السنانة\",\n\"answer\": \"عضلة السمانة\"\n},\n{\n\"text\": \"ما هو اسم العضلة التي تتواجد بين القفص الصدري والبطن؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"عضلة الصدر\",\n\"answer_text_2\": \"عضلة السمانة\",\n\"answer_text_3\": \"عضلة البطن\",\n\"answer_text_4\": \"عضلة الجنابية\",\n\"answer\": \"عضلة السمانة\"\n},\n{\n\"text\": \"ما هو الجزء الذي يشكل العضلة المخططة الهيكلية في العضلة الهيكلية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الخلية\",\n\"answer_text_2\": \"الألياف العضلية\",\n\"answer_text_3\": \"الميوفيلامنت\",\n\"answer_text_4\": \"النواة\",\n\"answer\": \"الألياف العضلية\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
												listmap = new Gson().fromJson("[\n    {\n      \"text\": \"ما هو العضو الأعلى في جسم الإنسان؟\",\n      \"no\": \"1\",\n      \"answer_text_1\": \"الدماغ\",\n      \"answer_text_2\": \"العين\",\n      \"answer_text_3\": \"القلب\",\n      \"answer_text_4\": \"الكبد\",\n      \"answer\": \"الدماغ\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب موقعه العالي في الجهاز الهضمي؟\",\n      \"no\": \"2\",\n      \"answer_text_1\": \"المريء\",\n      \"answer_text_2\": \"الكبد\",\n      \"answer_text_3\": \"المعدة\",\n      \"answer_text_4\": \"البنكرياس\",\n      \"answer\": \"المريء\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب وظيفته في التنفس وتنقية الهواء؟\",\n      \"no\": \"3\",\n      \"answer_text_1\": \"الأنف\",\n      \"answer_text_2\": \"الفم\",\n      \"answer_text_3\": \"القصبات الهوائية\",\n      \"answer_text_4\": \"الشعب الهوائية\",\n      \"answer\": \"الأنف\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب وظيفته في إرسال الإشارات العصبية؟\",\n      \"no\": \"4\",\n      \"answer_text_1\": \"الحبل الشوكي\",\n      \"answer_text_2\": \"الدماغ\",\n      \"answer_text_3\": \"الأعصاب الطرفية\",\n      \"answer_text_4\": \"النخاع الشوكي\",\n      \"answer\": \"الحبل الشوكي\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب دوره الرئيسي في تصفية الفضلات وإفراز البول؟\",\n      \"no\": \"5\",\n      \"answer_text_1\": \"الكبد\",\n      \"answer_text_2\": \"المثانة\",\n      \"answer_text_3\": \"الكلية\",\n      \"answer_text_4\": \"المعي\",\n      \"answer\": \"الكلية\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب موقعه العالي في الجهاز التنفسي ودوره في التبخير؟\",\n      \"no\": \"6\",\n      \"answer_text_1\": \"القصبات الهوائية\",\n      \"answer_text_2\": \"الحنجرة\",\n      \"answer_text_3\": \"الرئتين\",\n      \"answer_text_4\": \"البلعوم\",\n      \"answer\": \"القصبات الهوائية\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب وظيفته في إرسال الإشارات الكهربائية لتنظيم نبضات القلب؟\",\n      \"no\": \"7\",\n      \"answer_text_1\": \"العضلة البطينية اليمنى\",\n      \"answer_text_2\": \"العضلة البطينية اليسرى\",\n      \"answer_text_3\": \"العقدة القلبية الأذينية\",\n      \"answer_text_4\": \"العقدة القلبية البطينية\",\n      \"answer\": \"العقدة القلبية الأذينية\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب دوره في دعم هيكل الجسم وحماية الأعضاء الداخلية؟\",\n      \"no\": \"8\",\n      \"answer_text_1\": \"العمود الفقري\",\n      \"answer_text_2\": \"الأضلاع\",\n      \"answer_text_3\": \"الورك\",\n      \"answer_text_4\": \"الكتف\",\n      \"answer\": \"العمود الفقري\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يُعتبر الأعلى في الجسم بسبب دوره في تحمل وزن الجسم والمساهمة في الحركة؟\",\n      \"no\": \"9\",\n      \"answer_text_1\": \"الأقدام\",\n      \"answer_text_2\": \"الأرجل\",\n      \"answer_text_3\": \"الكاحل\",\n      \"answer_text_4\": \"الفخذ\",\n      \"answer\": \"الأقدام\"\n    },\n    {\n      \"text\": \"ما هو العضو الذي يجسم الإنسان؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الفم\",\n\"answer_text_2\": \"الأنف\",\n\"answer_text_3\": \"الأذن\",\n\"answer_text_4\": \"الحلق\",\n\"answer\": \"الفم\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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