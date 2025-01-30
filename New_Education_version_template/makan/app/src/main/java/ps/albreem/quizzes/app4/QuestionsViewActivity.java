package ps.albreem.quizzes.app4;

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
			listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو اسم الجبل الشهير في الولايات المتحدة الأمريكية الذي يعتبر أعلى قمة في قارة شمال أمريكا؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"جبل دينالي\",\n\"answer_text_2\": \"جبل راينيير\",\n\"answer_text_3\": \"جبل واشنطن\",\n\"answer_text_4\": \"جبل إلبروس\",\n\"answer\": \"جبل دينالي\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في اليونان التي تُعتبر موطنًا لإحدى أقدم الحضارات الإنسانية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"جزيرة رودس\",\n\"answer_text_2\": \"جزيرة كريت\",\n\"answer_text_3\": \"جزيرة كورفو\",\n\"answer_text_4\": \"جزيرة ميكونوس\",\n\"answer\": \"جزيرة كريت\"\n},\n{\n\"text\": \"ما هو اسم النهر الشهير في روسيا الذي يعتبر أطول نهر في أوروبا؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"نهر الفولجا\",\n\"answer_text_2\": \"نهر الدانوب\",\n\"answer_text_3\": \"نهر الراين\",\n\"answer_text_4\": \"نهر النيجر\",\n\"answer\": \"نهر الفولجا\"\n},\n{\n\"text\": \"ما هو اسم السلسلة الجبلية الشهيرة في جنوب شرق آسيا التي تمتد عبر عدة دول؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"جبال الهيمالايا\",\n\"answer_text_2\": \"جبال الألب\",\n\"answer_text_3\": \"جبال الأنديز\",\n\"answer_text_4\": \"جبال الروكي\",\n\"answer\": \"جبال الهيمالايا\"\n},\n{\n\"text\": \"ما هو اسم المتحف الشهير في روسيا الذي يضم أكبر مجموعة من الفن الروسي في العالم؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"متحف هيرميتاج\",\n\"answer_text_2\": \"متحف تريتياكوف\",\n\"answer_text_3\": \"متحف بوليتكنيك\",\n\"answer_text_4\": \"متحف كرملين\",\n\"answer\": \"متحف هيرميتاج\"\n},\n{\n\"text\": \"ما هو اسم القصر الشهير في المملكة المتحدة الذي يُعتبر مقرًا للعائلة المالكة البريطانية؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"قصر بركنجهام\",\n\"answer_text_2\": \"قصر ويندسور\",\n\"answer_text_3\": \"قصر بلينهايم\",\n\"answer_text_4\": \"قصر هامبتون كورت\",\n\"answer\": \"قصر بركنجهام\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في جنوب شرق آسيا التي تشتهر بشواطئها الرملية البيضاء ومياهها الزرقاء الصافية؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"جزيرة بورا بورا\",\n\"answer_text_2\": \"جزيرة كوه ساموي\",\n\"answer_text_3\": \"جزيرة بالي\",\n\"answer_text_4\": \"جزيرة كوه تاو\",\n\"answer\": \"جزيرة بورا بورا\"\n},\n{\n\"text\": \"ما هو اسم المتنزه الوطني الشهير في كينيا الذي يُعتبر واحدًا من أهم مواقع الحياة البرية في العالم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"متنزه نايروبي\",\n\"answer_text_2\": \"متنزه أمبوسيلي\",\n\"answer_text_3\": \"متنزه ماساي مارا\",\n\"answer_text_4\": \"متنزه تسافو\",\n\"answer\": \"متنزه ماساي مارا\"\n},\n{\n\"text\": \"ما هو اسم الجسر الشهير في الولايات المتحدة الأمريكية الذي يعبر خليج سان فرانسيسكو؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"جسر البوابة الذهبية\",\n\"answer_text_2\": \"جسر بروكلين\",\n\"answer_text_3\": \"جسر مانهاتن\",\n\"answer_text_4\": \"جسر هايدن\",\n\"answer\": \"جسر البوابة الذهبية\"\n},{\n\"text\": \"ما هو اسم الجبل الشهير في البرازيل الذي يُعتبر رمزًا لمدينة ريو دي جانيرو ويُعتبر واحدًا من عجائب العالم الجديد؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"جبل كوركوفادو\",\n\"answer_text_2\": \"جبل بيدرا بونيتا\",\n\"answer_text_3\": \"جبل تيجوكونشا\",\n\"answer_text_4\": \"جبل برينا دو سوكورو\",\n\"answer\": \"جبل كوركوفادو\"\n}]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
				listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو اسم القلعة الشهيرة في إسبانيا التي تُعتبر أحد أهم المعالم التاريخية في البلاد؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"قلعة الحمراء\",\n\"answer_text_2\": \"قلعة سيغوفيا\",\n\"answer_text_3\": \"قلعة توريت\",\n\"answer_text_4\": \"قلعة الحجر\",\n\"answer\": \"قلعة الحمراء\"\n},\n{\n\"text\": \"ما هو اسم الجبل الشهير في نيوزيلندا الذي يُعتبر أعلى قمة في الجزيرة الجنوبية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"جبل كوك\",\n\"answer_text_2\": \"جبل تاراناكي\",\n\"answer_text_3\": \"جبل كازبيك\",\n\"answer_text_4\": \"جبل كوتش\",\n\"answer\": \"جبل كوك\"\n},\n{\n\"text\": \"ما هو اسم النهر الشهير في البرازيل الذي يُعتبر أكبر نهر في العالم من حيث تدفق المياه؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"نهر الأمازون\",\n\"answer_text_2\": \"نهر النيل\",\n\"answer_text_3\": \"نهر الكونغو\",\n\"answer_text_4\": \"نهر اليانغتسي\",\n\"answer\": \"نهر الأمازون\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في اليونان التي تُعتبر موطنًا لإحدى أقدم الحضارات في العالم؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"جزيرة كريت\",\n\"answer_text_2\": \"جزيرة سانتوريني\",\n\"answer_text_3\": \"جزيرة رودس\",\n\"answer_text_4\": \"جزيرة ميكونوس\",\n\"answer\": \"جزيرة كريت\"\n},\n{\n\"text\": \"ما هو اسم القمة الشهيرة في سويسرا التي تُعتبر أعلى قمة في جبال الألب السويسرية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"قمة مونت بلانك\",\n\"answer_text_2\": \"قمة ماترهورن\",\n\"answer_text_3\": \"قمة يونغفراو\",\n\"answer_text_4\": \"قمة فيشرهورن\",\n\"answer\": \"قمة مونت بلانك\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في إندونيسيا التي تُعتبر أكبر مجموعة جزر في العالم؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"جزر المالديف\",\n\"answer_text_2\": \"جزر فيجي\",\n\"answer_text_3\": \"جزر البهاما\",\n\"answer_text_4\": \"جزر الأنتيل الهولندية\",\n\"answer\": \"جزر المالديف\"\n},\n{\n\"text\": \"ما هو اسم المنتجع الشهير في اليابان الذي يعتبر موطنًا للعديد من الينابيع الساخنة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"منتجع هوت سبرينج\",\n\"answer_text_2\": \"منتجع هاكوني\",\n\"answer_text_3\": \"منتجع أمامو\",\n\"answer_text_4\": \"منتجع نيكو\",\n\"answer\": \"منتجع هاكوني\"\n},\n{\n\"text\": \"ما هو اسم القارة الشهيرة التي تعتبر أصغر قارة في العالم من حيث المساحة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"أوروبا\",\n\"answer_text_2\": \"أستراليا\",\n\"answer_text_3\": \"أمريكا الشمالية\",\n\"answer_text_4\": \"أمريكا الجنوبية\",\n\"answer\": \"أستراليا\"\n},\n{\n\"text\": \"ما هو اسم النهر الشهير في أفريقيا الذي يعتبر أطول نهر في العالم؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"نهر الأمازون\",\n\"answer_text_2\": \"نهر النيل\",\n\"answer_text_3\": \"نهر الكونغو\",\n\"answer_text_4\": \"نهر اليانغتسي\",\n\"answer\": \"نهر النيل\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في المحيط الهندي التي تشتهر بمعابدها الهندوسية وشواطئها الرملية الذهبية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"جزيرة سيلانغور\",\n\"answer_text_2\": \"جزيرة بينانج\",\n\"answer_text_3\": \"جزيرة بالي\",\n\"answer_text_4\": \"جزيرة كوه ساموي\",\n\"answer\": \"جزيرة بالي\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
					listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هي الجزيرة الشهيرة في المحيط الهندي التي تعتبر واحدة من أكبر المواقع لتكاثر الحيتان في العالم؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"جزيرة سيرلانكا\",\n\"answer_text_2\": \"جزيرة ماوريتيوس\",\n\"answer_text_3\": \"جزيرة مدغشقر\",\n\"answer_text_4\": \"جزيرة ريونيون\",\n\"answer\": \"جزيرة ماوريتيوس\"\n},\n{\n\"text\": \"ما هو اسم المعلم الشهير في تركيا الذي يعتبر من أهم المسارح القديمة في العالم؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"مسرح آسبنديس\",\n\"answer_text_2\": \"مسرح بيرغامون\",\n\"answer_text_3\": \"مسرح هاليكارناسوس\",\n\"answer_text_4\": \"مسرح إفسس\",\n\"answer\": \"مسرح هاليكارناسوس\"\n},\n{\n\"text\": \"ما هو اسم المدينة الفرنسية الشهيرة التي تُعتبر عاصمة العطاء والأناقة وموطنًا للموضة العالمية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"مرسيليا\",\n\"answer_text_2\": \"نيس\",\n\"answer_text_3\": \"ليون\",\n\"answer_text_4\": \"باريس\",\n\"answer\": \"باريس\"\n},\n{\n\"text\": \"ما هو اسم المدينة الإيطالية الشهيرة التي تشتهر بمعالمها التاريخية وفنونها الجميلة؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"ميلان\",\n\"answer_text_2\": \"فيرونا\",\n\"answer_text_3\": \"فلورنسا\",\n\"answer_text_4\": \"بيزا\",\n\"answer\": \"فلورنسا\"\n},\n{\n\"text\": \"ما هو اسم الحديقة الشهيرة في الولايات المتحدة الأمريكية التي تضم مجموعة متنوعة من الحيوانات البرية والمعالم الطبيعية الخلابة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"حديقة يلوستون\",\n\"answer_text_2\": \"حديقة غراند كانيون\",\n\"answer_text_3\": \"حديقة أكاديا\",\n\"answer_text_4\": \"حديقة زيو\",\n\"answer\": \"حديقة يلوستون\"\n},\n{\n\"text\": \"ما هو اسم المدينة الكندية الشهيرة التي تعتبر عاصمة الثقافة الفرنكوفونية في البلاد؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"تورونتو\",\n\"answer_text_2\": \"فانكوفر\",\n\"answer_text_3\": \"مونتريال\",\n\"answer_text_4\": \"كيبيك\",\n\"answer\": \"مونتريال\"\n},\n{\n\"text\": \"ما هو اسم المدينة اليونانية الشهيرة التي تعتبر مركزًا حضاريًا وتاريخيًا مهمًا في العصور القديمة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"أولمبيا\",\n\"answer_text_2\": \"ديلفوس\",\n\"answer_text_3\": \"سبارتا\",\n\"answer_text_4\": \"أثينا\",\n\"answer\": \"أثينا\"\n},\n{\n\"text\": \"ما هو اسم النهر الشهير الذي يعبر مدينة القاهرة في مصر ويُعتبر أحد أطول الأنهار في العالم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"نهر اليانغتسي\",\n\"answer_text_2\": \"نهر الأمازون\",\n\"answer_text_3\": \"نهر الفولجا\",\n\"answer_text_4\": \"نهر النيل\",\n\"answer\": \"نهر النيل\"\n},\n{\n\"text\": \"ما هو اسم الواحة الشهيرة في مصر التي تُعتبر واحدة من أكبر الواحات في العالم؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"واحة الفرافرة\",\n\"answer_text_2\": \"واحة سيوة\",\n\"answer_text_3\": \"واحة القارة\",\n\"answer_text_4\": \"واحة الخارجة\",\n\"answer\": \"واحة سيوة\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في جنوب آسيا التي تتميز بشواطئها الرملية البيضاء ومياهها الزرقاء الصافية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"جزيرة بورا بورا\",\n\"answer_text_2\": \"جزيرة كوه ساموي\",\n\"answer_text_3\": \"جزيرة بالي\",\n\"answer_text_4\": \"جزيرة كوه تاو\",\n\"answer\": \"جزيرة بالي\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
						listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو اسم القرية الشهيرة في سويسرا التي تشتهر بمناظرها الطبيعية الخلابة ومنتجعاتها الجبلية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"زيرمات\",\n\"answer_text_2\": \"وينترثور\",\n\"answer_text_3\": \"غريندلفالد\",\n\"answer_text_4\": \"لوتسرن\",\n\"answer\": \"زيرمات\"\n},\n{\n\"text\": \"ما هو اسم القصر الشهير الذي يقع في فرنسا ويُعتبر أحد أهم المعالم السياحية في البلاد؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"قصر فرساي\",\n\"answer_text_2\": \"قصر شينغهام\",\n\"answer_text_3\": \"قصر براج\",\n\"answer_text_4\": \"قصر سانت مايكل\",\n\"answer\": \"قصر فرساي\"\n},\n{\n\"text\": \"ما هو اسم المعبد الشهير في الهند الذي يعتبر من أهم المواقع الدينية للهندوس؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"معبد بودناث\",\n\"answer_text_2\": \"معبد كونارك\",\n\"answer_text_3\": \"معبد غولوك\",\n\"answer_text_4\": \"معبد كالاهاتيا\",\n\"answer\": \"معبد كونارك\"\n},\n{\n\"text\": \"ما هو اسم المنتجع الشهير في الولايات المتحدة الأمريكية الذي يعتبر وجهة شهيرة لعشاق التزلج؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"فال ديسيرت\",\n\"answer_text_2\": \"جاكسون هول\",\n\"answer_text_3\": \"أسبن\",\n\"answer_text_4\": \"فيربير\",\n\"answer\": \"فال ديسيرت\"\n},\n{\n\"text\": \"ما هو اسم الجبل الشهير الذي يقع في إفريقيا ويُعتبر أعلى قمة في القارة السمراء؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"جبل كليمنجارو\",\n\"answer_text_2\": \"جبل إلبروس\",\n\"answer_text_3\": \"جبل كينيا\",\n\"answer_text_4\": \"جبل رونجاي\",\n\"answer\": \"جبل كليمنجارو\"\n},\n{\n\"text\": \"ما هو اسم القلعة الشهيرة في إيطاليا التي تعتبر أحد أهم المعالم التاريخية في البلاد؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"قلعة سانت أنجلو\",\n\"answer_text_2\": \"قلعة سانتا باربارا\",\n\"answer_text_3\": \"قلعة سان مارينو\",\n\"answer_text_4\": \"قلعة فيرونا\",\n\"answer\": \"قلعة سانت أنجلو\"\n},\n{\n\"text\": \"ما هو اسم الجبل الشهير الذي يقع في كندا ويُعتبر واحدًا من أهم المواقع الطبيعية في العالم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"جبل روبسون\",\n\"answer_text_2\": \"جبل رينيه\",\n\"answer_text_3\": \"جبل واشنطن\",\n\"answer_text_4\": \"جبل نوركواي\",\n\"answer\": \"جبل روبسون\"\n},\n{\n\"text\": \"ما هو اسم العاصمة الأوكرانية الشهيرة بمعالمها التاريخية وأسواقها الحية؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"كييف\",\n\"answer_text_2\": \"لفيف\",\n\"answer_text_3\": \"أوديسا\",\n\"answer_text_4\": \"خاركيف\",\n\"answer\": \"كييف\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في البحر الأحمر التي تُعتبر موطنًا لأحد أكبر الشعاب المرجانية في العالم؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"جزيرة الحمراء\",\n\"answer_text_2\": \"جزيرة تيران\",\n\"answer_text_3\": \"جزيرة جزيران\",\n\"answer_text_4\": \"جزيرة الدهب\",\n\"answer\": \"جزيرة تيران\"\n},\n{\n\"text\": \"ما هو اسم السلسلة الجبلية الشهيرة في جنوب أمريكا التي تمتد عبر سبع دول وتشمل بعض أعلى قمم العالم؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"جبال الأنديز\",\n\"answer_text_2\": \"جبال الهيمالايا\",\n\"answer_text_3\": \"جبال الألب\",\n\"answer_text_4\": \"جبال الروكي\",\n\"answer\": \"جبال الأنديز\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
							listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو اسم المدينة البرازيلية الشهيرة بشواطئها الرملية الذهبية واحتفالاتها الكرنفالية الضخمة؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"ريو دي جانيرو\",\n\"answer_text_2\": \"ساو باولو\",\n\"answer_text_3\": \"سلفادور\",\n\"answer_text_4\": \"فلوريانوبوليس\",\n\"answer\": \"ريو دي جانيرو\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الشهيرة في شمال أمريكا التي تُعتبر موطنًا للدببة القطبية وتتميز بمناظرها الطبيعية الساحرة؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"جزيرة فينلاند\",\n\"answer_text_2\": \"جزيرة بفين\",\n\"answer_text_3\": \"جزيرة غرينلاند\",\n\"answer_text_4\": \"جزيرة برونو\",\n\"answer\": \"جزيرة فينلاند\"\n},\n{\n\"text\": \"ما هو اسم العاصمة الهولندية الشهيرة بقنواتها المائية ومبانيها التاريخية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"أمستردام\",\n\"answer_text_2\": \"لاهاي\",\n\"answer_text_3\": \"روتردام\",\n\"answer_text_4\": \"أوتريخت\",\n\"answer\": \"أمستردام\"\n},\n{\n\"text\": \"ما هو اسم القارة الواقعة جنوب القطب الشمالي والمعروفة بطبيعتها القاسية ومناظرها الطبيعية الخلابة؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"قارة أنتاركتيكا\",\n\"answer_text_2\": \"قارة آسيا\",\n\"answer_text_3\": \"قارة أفريقيا\",\n\"answer_text_4\": \"قارة أوروبا\",\n\"answer\": \"قارة أنتاركتيكا\"\n},\n{\n\"text\": \"ما هو اسم العاصمة الهندية الشهيرة بتضاريسها الجبلية ومعالمها الثقافية الغنية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"نيودلهي\",\n\"answer_text_2\": \"مومباي\",\n\"answer_text_3\": \"بنغالور\",\n\"answer_text_4\": \"جايبور\",\n\"answer\": \"نيودلهي\"\n},\n{\n\"text\": \"ما هو اسم المنطقة الشهيرة في تركيا المعروفة بمعابدها الأثرية والمباني القديمة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"كابادوكيا\",\n\"answer_text_2\": \"أنطاليا\",\n\"answer_text_3\": \"إزمير\",\n\"answer_text_4\": \"بودروم\",\n\"answer\": \"كابادوكيا\"\n},\n{\n\"text\": \"ما هو اسم البحيرة الشهيرة في أفريقيا الوسطى التي تعتبر أكبر بحيرة عذبة في العالم؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"بحيرة تانغانيقا\",\n\"answer_text_2\": \"بحيرة فيكتوريا\",\n\"answer_text_3\": \"بحيرة مالاوي\",\n\"answer_text_4\": \"بحيرة تشاد\",\n\"answer\": \"بحيرة تانغانيقا\"\n},\n{\n\"text\": \"ما هو اسم الشلال الشهير الذي يقع في جنوب شرق آسيا ويُعتبر واحدًا من أكبر الشلالات في العالم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"شلالات نياجرا\",\n\"answer_text_2\": \"شلالات إيجوازو\",\n\"answer_text_3\": \"شلالات فيكتوريا\",\n\"answer_text_4\": \"شلالات إنجيل\",\n\"answer\": \"شلالات إيجوازو\"\n},\n{\n\"text\": \"ما هو اسم العاصمة الأرجنتينية الشهيرة بتصميمها الهندسي الفريد وحياتها الليلية النابضة بالحياة؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"بوينس آيرس\",\n\"answer_text_2\": \"كوردوبا\",\n\"answer_text_3\": \"ميندوزا\",\n\"answer_text_4\": \"ريو غاليغوس\",\n\"answer\": \"بوينس آيرس\"\n},\n{\n\"text\": \"ما هو اسم العاصمة النرويجية الشهيرة بتصميمها المعماري الحديث ومواقعها السياحية الفريدة؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"أوسلو\",\n\"answer_text_2\": \"ستوكهولم\",\n\"answer_text_3\": \"هلسنكي\",\n\"answer_text_4\": \"كوبنهاجن\",\n\"answer\": \"أوسلو\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
								listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو اسم المدينة اليابانية المشهورة بمعابدها وحدائقها التقليدية وأسواقها الحيوية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"طوكيو\",\n\"answer_text_2\": \"كيوتو\",\n\"answer_text_3\": \"أوساكا\",\n\"answer_text_4\": \"هيروشيما\",\n\"answer\": \"طوكيو\"\n},\n{\n\"text\": \"ما هي العاصمة الروسية الشهيرة بساحاتها الكبيرة ومبانيها التاريخية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"موسكو\",\n\"answer_text_2\": \"سان بطرسبرغ\",\n\"answer_text_3\": \"نوفغورود\",\n\"answer_text_4\": \"كازان\",\n\"answer\": \"موسكو\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الواقعة في المحيط الهندي المعروفة بشواطئها الرملية البيضاء ومياهها الزرقاء الصافية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"سيشل\",\n\"answer_text_2\": \"موريشيوس\",\n\"answer_text_3\": \"المالديف\",\n\"answer_text_4\": \"البهاما\",\n\"answer\": \"موريشيوس\"\n},\n{\n\"text\": \"ما هي العاصمة الإسبانية المعروفة بمبانيها العريقة وحيويتها الليلية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"مدريد\",\n\"answer_text_2\": \"برشلونة\",\n\"answer_text_3\": \"فالنسيا\",\n\"answer_text_4\": \"سيفيلا\",\n\"answer\": \"مدريد\"\n},\n{\n\"text\": \"ما هو اسم النهر الطويل الذي يعبر مدينة باريس ويُعتبر أحد رموزها الرومانسية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"نهر التايمز\",\n\"answer_text_2\": \"نهر السين\",\n\"answer_text_3\": \"نهر الدانوب\",\n\"answer_text_4\": \"نهر النيل\",\n\"answer\": \"نهر السين\"\n},\n{\n\"text\": \"ما هو اسم البحر الذي يغسل سواحل إيطاليا ومشهور بجزره الجميلة ومدنه الساحرة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"البحر الأبيض المتوسط\",\n\"answer_text_2\": \"البحر الأحمر\",\n\"answer_text_3\": \"بحر أدرياتيك\",\n\"answer_text_4\": \"المحيط الأطلسي\",\n\"answer\": \"بحر أدرياتيك\"\n},\n{\n\"text\": \"ما هو اسم القلعة الشهيرة التي تقع في إسكتلندا وتعتبر من أهم المعالم السياحية في البلاد؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"قلعة براغ\",\n\"answer_text_2\": \"قلعة نويشفانشتاين\",\n\"answer_text_3\": \"قلعة إدنبره\",\n\"answer_text_4\": \"قلعة نوتنغهام\",\n\"answer\": \"قلعة إدنبره\"\n},\n{\n\"text\": \"ما هو اسم العمارة الشهيرة في الولايات المتحدة الأمريكية التي تعتبر رمزًا للحرية والديمقراطية؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"برج إيفل\",\n\"answer_text_2\": \"برج الساعة في لندن\",\n\"answer_text_3\": \"تمثال الحرية\",\n\"answer_text_4\": \"قوس النصر\",\n\"answer\": \"تمثال الحرية\"\n},\n{\n\"text\": \"ما هو اسم الشلال الشهير الذي يقع في الحدود بين الولايات المتحدة الأمريكية وكندا؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"شلالات فيكتوريا\",\n\"answer_text_2\": \"شلالات إيجوازو\",\n\"answer_text_3\": \"شلالات نياجرا\",\n\"answer_text_4\": \"شلالات آنجل\",\n\"answer\": \"شلالات نياجرا\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الواقعة في البحر الكاريبي المعروفة بشواطئها الرملية ومياهها الزرقاء الصافية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"بورا بورا\",\n\"answer_text_2\": \"جزر البهاما\",\n\"answer_text_3\": \"ماوي\",\n\"answer_text_4\": \"أروبا\",\n\"answer\": \"بورا بورا\"\n}]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
									listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هي المدينة البرتغالية المعروفة بأحيائها التقليدية ومبانيها الأثرية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"لشبونة\",\n\"answer_text_2\": \"بورتو\",\n\"answer_text_3\": \"فارو\",\n\"answer_text_4\": \"سيتوبال\",\n\"answer\": \"لشبونة\"\n},\n{\n\"text\": \"ما هو اسم الجبل الشهير الذي يعتبر أعلى قمة في العالم ويقع في سلسلة جبال الهمالايا؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"جبل فينسنت\",\n\"answer_text_2\": \"جبل ماكينلي\",\n\"answer_text_3\": \"جبل إيفرست\",\n\"answer_text_4\": \"جبل كليمنجارو\",\n\"answer\": \"جبل إيفرست\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الواقعة في جنوب شرق آسيا المعروفة بشواطئها الرملية البيضاء ومياهها الزرقاء الصافية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"جزر فيجي\",\n\"answer_text_2\": \"جزر البهاما\",\n\"answer_text_3\": \"جزر المالديف\",\n\"answer_text_4\": \"جزر سيشل\",\n\"answer\": \"جزر المالديف\"\n},\n{\n\"text\": \"ما هي المدينة الإيطالية الشهيرة بمياه قنواتها وجسورها الرومانسية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"فنيسيا\",\n\"answer_text_2\": \"روما\",\n\"answer_text_3\": \"ميلان\",\n\"answer_text_4\": \"فلورنسا\",\n\"answer\": \"فنيسيا\"\n},\n{\n\"text\": \"ما هو اسم السلسلة الجبلية الشهيرة التي تقع في غرب الولايات المتحدة الأمريكية وتعتبر واحدة من أهم الوجهات السياحية في العالم؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"جبال الألب\",\n\"answer_text_2\": \"جبال الأنديز\",\n\"answer_text_3\": \"جبال روكي\",\n\"answer_text_4\": \"جبال الهملايا\",\n\"answer\": \"جبال روكي\"\n},\n{\n\"text\": \"ما هو اسم القلعة الشهيرة التي تقع في العاصمة البريطانية لندن وتُعتبر أحد رموزها الثقافية؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"قلعة إدنبره\",\n\"answer_text_2\": \"قلعة ويندسور\",\n\"answer_text_3\": \"قلعة اللوفر\",\n\"answer_text_4\": \"قلعة تاور\",\n\"answer\": \"قلعة تاور\"\n},\n{\n\"text\": \"ما هو اسم الحديقة الوطنية الشهيرة في ولاية يوتا الأمريكية المعروفة بتضاريسها الجبلية الرائعة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"حديقة يلوستون\",\n\"answer_text_2\": \"حديقة جراند تيتون\",\n\"answer_text_3\": \"حديقة بلايسيا\",\n\"answer_text_4\": \"حديقة جوشوا تري\",\n\"answer\": \"حديقة جراند تيتون\"\n},\n{\n\"text\": \"ما هو اسم الشلال الشهير الذي يقع في شمال شرق الولايات المتحدة الأمريكية ويُعتبر واحدًا من أكبر الشلالات في العالم؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"شلالات إيجوازو\",\n\"answer_text_2\": \"شلالات نياجرا\",\n\"answer_text_3\": \"شلالات فيكتوريا\",\n\"answer_text_4\": \"شلالات أنجل\",\n\"answer\": \"شلالات نياجرا\"\n},\n{\n\"text\": \"ما هو اسم الموقع الأثري الشهير في مصر الذي يضم أهرامات وتماثيل الأبو الهول؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"وادي الملوك\",\n\"answer_text_2\": \"أبو سمبل\",\n\"answer_text_3\": \"هرم الجيزة\",\n\"answer_text_4\": \"هرم سقارة\",\n\"answer\": \"هرم الجيزة\"\n},\n{\n\"text\": \"ما هو اسم المنتزه الوطني الشهير في شمال تنزانيا المعروف بحيواناته البرية وجباله الخلابة؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"منتزه سيرينجيتي\",\n\"answer_text_2\": \"منتزه نايروبي\",\n\"answer_text_3\": \"منتزه كروغر\",\n\"answer_text_4\": \"منتزه إيتوشا\",\n\"answer\": \"منتزه سيرينجيتي\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
										listmap = new Gson().fromJson("[\n    {\n      \"text\": \"ما هو أحد أقذر الأماكن في العالم حيث تتراكم النفايات بشكل كبير وتعج الشوارع بالقمامة؟\",\n      \"no\": \"1\",\n      \"answer_text_1\": \"مونتريال، الفلبين\",\n      \"answer_text_2\": \"نابولي، إيطاليا\",\n      \"answer_text_3\": \"مانيلا، الفلبين\",\n      \"answer_text_4\": \"كاراكاس، فنزويلا\",\n      \"answer\": \"مانيلا، الفلبين\"\n    },\n    {\n      \"text\": \"ما هو مكان يُعتبر واحدًا من أقذر المدن في العالم بسبب تراكم النفايات والتلوث البيئي؟\",\n      \"no\": \"2\",\n      \"answer_text_1\": \"باغداد، العراق\",\n      \"answer_text_2\": \"مومباي، الهند\",\n      \"answer_text_3\": \"كالكتا، الهند\",\n      \"answer_text_4\": \"جاكرتا، إندونيسيا\",\n      \"answer\": \"مومباي، الهند\"\n    },\n    {\n      \"text\": \"ما هي المنطقة التي تُعرف بأنها واحدة من أقذر المناطق في العالم بسبب تلوث الهواء والتسمم البيئي؟\",\n      \"no\": \"3\",\n      \"answer_text_1\": \"الرياض، السعودية\",\n      \"answer_text_2\": \"بكين، الصين\",\n      \"answer_text_3\": \"موسكو، روسيا\",\n      \"answer_text_4\": \"لاغوس، نيجيريا\",\n      \"answer\": \"بكين، الصين\"\n    },\n    {\n      \"text\": \"ما هي المنطقة التي تشتهر بكونها واحدة من أقذر المناطق في العالم بسبب التلوث البيئي الناتج عن الصناعات؟\",\n      \"no\": \"4\",\n      \"answer_text_1\": \"داليان، الصين\",\n      \"answer_text_2\": \"لوس أنجلوس، الولايات المتحدة\",\n      \"answer_text_3\": \"كاراكاس، فنزويلا\",\n      \"answer_text_4\": \"بومباي، الهند\",\n      \"answer\": \"داليان، الصين\"\n    },\n    {\n      \"text\": \"ما هو مكان يُعتبر واحدًا من أكثر المدن تلوثًا في العالم بسبب التلوث الصناعي وتراكم النفايات؟\",\n      \"no\": \"5\",\n      \"answer_text_1\": \"جاكرتا، إندونيسيا\",\n      \"answer_text_2\": \"كاراكاس، فنزويلا\",\n      \"answer_text_3\": \"لاغوس، نيجيريا\",\n      \"answer_text_4\": \"مومباي، الهند\",\n      \"answer\": \"جاكرتا، إندونيسيا\"\n    },\n    {\n      \"text\": \"ما هو الحي الشهير الذي يعتبر أحد أكثر الأحياء تلوثًا في العالم بسبب النفايات الصناعية؟\",\n      \"no\": \"6\",\n      \"answer_text_1\": \"سلاح الجو، الهند\",\n      \"answer_text_2\": \"كاليفورنيا، الولايات المتحدة\",\n      \"answer_text_3\": \"أندونيسيا، جاكرتا\",\n      \"answer_text_4\": \"كيب تاون، جنوب أفريقيا\",\n      \"answer\": \"سلاح الجو، الهند\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي يُعتبر ميناؤها واحدًا من أكثر الموانئ تلوثًا في العالم بسبب نفايات الصناعات؟\",\n      \"no\": \"7\",\n      \"answer_text_1\": \"جاكرتا، إندونيسيا\",\n      \"answer_text_2\": \"نيويورك، الولايات المتحدة\",\n      \"answer_text_3\": \"مومباي، الهند\",\n      \"answer_text_4\": \"شنغهاي، الصين\",\n      \"answer\": \"شنغهاي، الصين\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تعتبر واحدة من أكثر المدن تلوثًا في الهواء بسبب التلوث الصناعي وحركة المرور؟\",\n      \"no\": \"8\",\n      \"answer_text_1\": \"بكين، الصين\",\n      \"answer_text_2\": \"مومباي، الهند\",\n      \"answer_text_3\": \"كالكتا، الهند\",\n      \"answer_text_4\": \"جاكرتا، إندونيسيا\",\n      \"answer\": \"كالكتا، الهند\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي يُعاني سكانها من تلوث شديد بسبب النفايايات والتسمم البيئي الناتج عن الصناعات؟\",\n      \"no\": \"9\",\n      \"answer_text_1\": \"نيودلهي، الهند\",\n      \"answer_text_2\": \"مانيلا، الفلبين\",\n      \"answer_text_3\": \"جاكرتا، إندونيسيا\",\n      \"answer_text_4\": \"كاراكاس، فنزويلا\",\n      \"answer\": \"نيودلهي، الهند\"\n    },\n    {\n      \"text\": \"ما هو الحي الذي يشتهر بكونه أحد أكثر الأحياء فقرًا وتلوثًا في العالم بسبب التراكم الكبير للنفايات وسوء الظروف الصحية؟\",\n      \"no\": \"10\",\n      \"answer_text_1\": \"كاليفورنيا، الولايات المتحدة\",\n      \"answer_text_2\": \"مومباي، الهند\",\n      \"answer_text_3\": \"نيويورك، الولايات المتحدة\",\n      \"answer_text_4\": \"كيب تاون، جنوب أفريقيا\",\n      \"answer\": \"كيب تاون، جنوب أفريقيا\"\n    }\n  ]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
											listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هي العاصمة الفرنسية المشهورة ببرجها الحديدي ومتاحفها الفنية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"برلين\",\n\"answer_text_2\": \"لندن\",\n\"answer_text_3\": \"روما\",\n\"answer_text_4\": \"باريس\",\n\"answer\": \"باريس\"\n},\n{\n\"text\": \"ما هي القارة التي تضم البرازيل، والمعروفة بغابات الأمازون الاستوائية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"أوروبا\",\n\"answer_text_2\": \"أمريكا الشمالية\",\n\"answer_text_3\": \"أمريكا الجنوبية\",\n\"answer_text_4\": \"أفريقيا\",\n\"answer\": \"أمريكا الجنوبية\"\n},\n{\n\"text\": \"ما هي الحديقة الوطنية الشهيرة في ولاية أريزونا الأمريكية المشهورة بمنظرها الطبيعي الرائع؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"حديقة يلوستون\",\n\"answer_text_2\": \"حديقة جراند كانيون\",\n\"answer_text_3\": \"حديقة كراتشي\",\n\"answer_text_4\": \"حديقة كروغر\",\n\"answer\": \"حديقة جراند كانيون\"\n},\n{\n\"text\": \"ما هي المدينة الإيطالية الشهيرة التي تتميز بمساحتها المائية الكبيرة وقنواتها الرومانسية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"فنيسيا\",\n\"answer_text_2\": \"روما\",\n\"answer_text_3\": \"ميلان\",\n\"answer_text_4\": \"فلورنسا\",\n\"answer\": \"فنيسيا\"\n},\n{\n\"text\": \"ما هو اسم الصحراء الواقعة في شمال أفريقيا المعروفة بتضاريسها الرملية الشاسعة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"صحراء غوبي\",\n\"answer_text_2\": \"صحراء الكبرى\",\n\"answer_text_3\": \"صحراء الساحل\",\n\"answer_text_4\": \"صحراء الصحراء\",\n\"answer\": \"صحراء الكبرى\"\n},\n{\n\"text\": \"ما هو اسم المدينة الأمريكية المشهورة بجسرها الشهير الذي يربط بين منهاتن وبروكلين؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"سان فرانسيسكو\",\n\"answer_text_2\": \"شيكاغو\",\n\"answer_text_3\": \"لوس أنجلوس\",\n\"answer_text_4\": \"نيويورك\",\n\"answer\": \"نيويورك\"\n},\n{\n\"text\": \"ما هي العاصمة اليابانية المعروفة بمعابدها وحدائقها التقليدية وأسواقها الحيوية؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"طوكيو\",\n\"answer_text_2\": \"كيوتو\",\n\"answer_text_3\": \"أوساكا\",\n\"answer_text_4\": \"هيروشيما\",\n\"answer\": \"طوكيو\"\n},\n{\n\"text\": \"ما هو اسم المعلم الشهير في الهند الذي يُعتبر واحدًا من عجائب الدنيا السبع؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"بيتساو\",\n\"answer_text_2\": \"الهندسة\",\n\"answer_text_3\": \"تاج محل\",\n\"answer_text_4\": \"باخوا\",\n\"answer\": \"تاج محل\"\n},\n{\n\"text\": \"ما هو اسم الجزيرة الواقعة في البحر الكاريبي المعروفة بشواطئها الرملية ومياهها الزرقاء الصافية؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"بورا بورا\",\n\"answer_text_2\": \"جزر البهاما\",\n\"answer_text_3\": \"ماوي\",\n\"answer_text_4\": \"أروبا\",\n\"answer\": \"بورا بورا\"\n},\n{\n\"text\": \"ما هو اسم المدينة الفرنسية المشهورة ببرجها الحديدي ومتاحفها الفنية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"برلين\",\n\"answer_text_2\": \"لندن\",\n\"answer_text_3\": \"روما\",\n\"answer_text_4\": \"باريس\",\n\"answer\": \"باريس\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
												listmap = new Gson().fromJson("[\n    {\n      \"text\": \"ما هو المدينة التي تُعتبر واحدة من أقذر المدن في أوروبا بسبب التلوث البيئي وتلوث الهواء؟\",\n      \"no\": \"1\",\n      \"answer_text_1\": \"نابولي، إيطاليا\",\n      \"answer_text_2\": \"بوخارست، رومانيا\",\n      \"answer_text_3\": \"كييف، أوكرانيا\",\n      \"answer_text_4\": \"أثينا، اليونان\",\n      \"answer\": \"نابولي، إيطاليا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تشتهر بكونها واحدة من أقذر المدن في أوروبا بسبب تراكم النفايات والتلوث البيئي؟\",\n      \"no\": \"2\",\n      \"answer_text_1\": \"بيلغراد، صربيا\",\n      \"answer_text_2\": \"باريس، فرنسا\",\n      \"answer_text_3\": \"روما، إيطاليا\",\n      \"answer_text_4\": \"أثينا، اليونان\",\n      \"answer\": \"بيلغراد، صربيا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تعتبر واحدة من أقذر المدن في أوروبا بسبب تلوث الهواء وتراكم النفايات؟\",\n      \"no\": \"3\",\n      \"answer_text_1\": \"موسكو، روسيا\",\n      \"answer_text_2\": \"بوخارست، رومانيا\",\n      \"answer_text_3\": \"كييف، أوكرانيا\",\n      \"answer_text_4\": \"نابولي، إيطاليا\",\n      \"answer\": \"موسكو، روسيا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تُعتبر واحدة من أقذر المدن في أوروبا بسبب الضغط البيئي والتلوث الصناعي؟\",\n      \"no\": \"4\",\n      \"answer_text_1\": \"إسطنبول، تركيا\",\n      \"answer_text_2\": \"بوخارست، رومانيا\",\n      \"answer_text_3\": \"موسكو، روسيا\",\n      \"answer_text_4\": \"باريس، فرنسا\",\n      \"answer\": \"إسطنبول، تركيا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تُعتبر واحدة من أقذر المدن في أوروبا بسبب التلوث الصناعي وتراكم النفايات؟\",\n      \"no\": \"5\",\n      \"answer_text_1\": \"باريس، فرنسا\",\n      \"answer_text_2\": \"ميلان، إيطاليا\",\n      \"answer_text_3\": \"لندن، المملكة المتحدة\",\n      \"answer_text_4\": \"برلين، ألمانيا\",\n      \"answer\": \"ميلان، إيطاليا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تشتهر بكونها واحدة من أقذر المدن في أوروبا بسبب تلوث الهواء وتلوث المياه؟\",\n      \"no\": \"6\",\n      \"answer_text_1\": \"برلين، ألمانيا\",\n      \"answer_text_2\": \"مدريد، إسبانيا\",\n      \"answer_text_3\": \"روما، إيطاليا\",\n      \"answer_text_4\": \"أثينا، اليونان\",\n      \"answer\": \"مدريد، إسبانيا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تُعتبر واحدة من أقذر المدن في أوروبا بسبب التلوث البيئي الناجم عن حرق النفايات وتلوث المياه الناتج عن الصناعات؟\",\n      \"no\": \"7\",\n      \"answer_text_1\": \"فيينا، النمسا\",\n      \"answer_text_2\": \"روما، إيطاليا\",\n      \"answer_text_3\": \"برلين، ألمانيا\",\n      \"answer_text_4\": \"باريس، فرنسا\",\n      \"answer\": \"فيينا، النمسا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تُعتبر واحدة من أقذر المدن في أوروبا بسبب الضغط البيئي وتلوث الهواء؟\",\n      \"no\": \"8\",\n      \"answer_text_1\": \"ميلان، إيطاليا\",\n      \"answer_text_2\": \"برلين، ألمانيا\",\n      \"answer_text_3\": \"بوخارست، رومانيا\",\n      \"answer_text_4\": \"كييف، أوكرانيا\",\n      \"answer\": \"ميلان، إيطاليا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تشتهر بكونها واحدة من أقذر المدن في أوروبا بسبب تلوث الهواء وتراكم النفايات؟\",\n      \"no\": \"9\",\n      \"answer_text_1\": \"برلين، ألمانيا\",\n      \"answer_text_2\": \"مدريد، إسبانيا\",\n      \"answer_text_3\": \"فيينا، النمسا\",\n      \"answer_text_4\": \"باريس، فرنسا\",\n      \"answer\": \"مدريد، إسبانيا\"\n    },\n    {\n      \"text\": \"ما هي المدينة التي تُعتبر واحدة من أقذر المدن في أوروبا بسبب التلوث الصناعي وتلوث الهواء؟\",\n      \"no\": \"10\",\n      \"answer_text_1\": \"موناكو، فرنسا\",\n      \"answer_text_2\": \"ميلان، إيطاليا\",\n      \"answer_text_3\": \"فيينا، النمسا\",\n      \"answer_text_4\": \"برلين، ألمانيا\",\n      \"answer\": \"موناكو، فرنسا\"\n    }\n  ]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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