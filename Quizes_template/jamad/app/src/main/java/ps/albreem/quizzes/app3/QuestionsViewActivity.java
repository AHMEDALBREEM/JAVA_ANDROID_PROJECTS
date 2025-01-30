package ps.albreem.quizzes.app3;

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
			listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هي المادة الكيميائية التي تضاف إلى الدهانات لتسريع عملية الجفاف؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"المذيبات\",\n\"answer_text_2\": \"الراتنجات\",\n\"answer_text_3\": \"المواد الحافظة\",\n\"answer_text_4\": \"الكاتاليزر\",\n\"answer\": \"الكاتاليزر\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع الأكسجين السائل؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الهيدروجين\",\n\"answer_text_2\": \"الأكسجين\",\n\"answer_text_3\": \"النيتروجين\",\n\"answer_text_4\": \"الكربون\",\n\"answer\": \"الهيدروجين\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الصابون؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الصودا الكاوية\",\n\"answer_text_2\": \"الصودا الكاوية\",\n\"answer_text_3\": \"الجلسرين\",\n\"answer_text_4\": \"الكلور\",\n\"answer\": \"الجلسرين\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع الفوسفور؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الفلور\",\n\"answer_text_2\": \"السيليكون\",\n\"answer_text_3\": \"الكبريت\",\n\"answer_text_4\": \"الفوسفور\",\n\"answer\": \"الفوسفور\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الألياف البلاستيكية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"النايلون\",\n\"answer_text_2\": \"البولي يوريثان\",\n\"answer_text_3\": \"البولي إيثيلين\",\n\"answer_text_4\": \"البلاستيك\",\n\"answer\": \"البولي إيثيلين\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأدوات الزراعية مثل الشوك والفوكة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الحديد\",\n\"answer_text_2\": \"الألمنيوم\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"الصلب\",\n\"answer\": \"الصلب\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع البطاريات القابلة للشحن؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الرصاص\",\n\"answer_text_2\": \"النيكل\",\n\"answer_text_3\": \"الكادميوم\",\n\"answer_text_4\": \"الليثيوم\",\n\"answer\": \"الليثيوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الأطعمة كمادة حافظة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الملح\",\n\"answer_text_2\": \"السكر\",\n\"answer_text_3\": \"الألمنيوم\",\n\"answer_text_4\": \"البيكاربونات\",\n\"answer\": \"الملح\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الأسمدة لتحسين نمو النباتات؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"البوتاسيوم\",\n\"answer_text_2\": \"الكالسيوم\",\n\"answer_text_3\": \"الفوسفور\",\n\"answer_text_4\": \"النيتروجين\",\n\"answer\": \"البوتاسيوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الزجاج لإعطائه لونًا أخضر؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الحديد\",\n\"answer_text_2\": \"الكروم\",\n\"answer_text_3\": \"الباريوم\",\n\"answer_text_4\": \"السيليكون\",\n\"answer\": \"الحديد\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
				listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأطباق الكهربائية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الفولاذ المقاوم للصدأ\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"الألمنيوم\",\n\"answer\": \"الفولاذ المقاوم للصدأ\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الزجاج لتجعله عازلاً للحرارة؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"البورون\",\n\"answer_text_2\": \"الرصاص\",\n\"answer_text_3\": \"الزنك\",\n\"answer_text_4\": \"الألمنيوم\",\n\"answer\": \"البورون\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تضاف إلى الطلاء لتجعله مانعًا للتآكل؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الكروم\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"الألومنيوم\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"الكروم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الزجاج لتجعله شفافًا؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الزنك\",\n\"answer_text_2\": \"السيليكون\",\n\"answer_text_3\": \"الأكسجين\",\n\"answer_text_4\": \"الكروم\",\n\"answer\": \"الأكسجين\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الألعاب النارية للحصول على اللون الأخضر؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الباريوم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"السيليكون\",\n\"answer_text_4\": \"الصوديوم\",\n\"answer\": \"الباريوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع السيراميك؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الطين\",\n\"answer_text_2\": \"الرماد\",\n\"answer_text_3\": \"الزجاج\",\n\"answer_text_4\": \"الحديد\",\n\"answer\": \"الطين\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأسلاك الكهربائية الناعمة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الألمنيوم\",\n\"answer\": \"الفضة\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يضاف إلى الزجاج للحصول على اللون الأزرق؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الكوبالت\",\n\"answer_text_2\": \"الكروم\",\n\"answer_text_3\": \"الباريوم\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"الكوبالت\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع البلاستيك؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"البولي إيثيلين\",\n\"answer_text_2\": \"النايلون\",\n\"answer_text_3\": \"الصوف\",\n\"answer_text_4\": \"البولي يوريثان\",\n\"answer\": \"البولي إيثيلين\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع الأشعة السينية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"التنجستن\",\n\"answer_text_2\": \"الأسبستوس\",\n\"answer_text_3\": \"الرصاص\",\n\"answer_text_4\": \"الألومنيوم\",\n\"answer\": \"التنجستن\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
					listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأدوات الصحية مثل المقابض والحنفيات؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الفولاذ المقاوم للصدأ\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"الألومنيوم\",\n\"answer\": \"الفولاذ المقاوم للصدأ\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع البطاريات القابلة لإعادة الشحن؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الرصاص\",\n\"answer_text_2\": \"النيكل\",\n\"answer_text_3\": \"الكادميوم\",\n\"answer_text_4\": \"الليثيوم\",\n\"answer\": \"الليثيوم\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الأصباغ الزرقاء؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الأزرق الأنيلين\",\n\"answer_text_2\": \"الأزرق البنفسجي\",\n\"answer_text_3\": \"الأزرق اللامع\",\n\"answer_text_4\": \"الأزرق الداكن\",\n\"answer\": \"الأزرق الأنيلين\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأدوات الكهربائية مثل السكاكين والمقص؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الصلب\",\n\"answer_text_2\": \"الألومنيوم\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"النحاس\",\n\"answer\": \"الصلب\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأدوات الزراعية مثل المناجل والشوك؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الحديد\",\n\"answer_text_2\": \"الألمنيوم\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"الصلب\",\n\"answer\": \"الحديد\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الأصباغ الحمراء؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الكرمزين\",\n\"answer_text_2\": \"القرمزين\",\n\"answer_text_3\": \"البورجندي\",\n\"answer_text_4\": \"الماجنتا\",\n\"answer\": \"الكرمزين\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأدوات الكتابية مثل الأقلام؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"البلاستيك\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"الخشب\",\n\"answer_text_4\": \"الرصاص\",\n\"answer\": \"البلاستيك\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الأصباغ الصفراء؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الكروميل\",\n\"answer_text_2\": \"الأصفر الفلوري\",\n\"answer_text_3\": \"الكروميلون\",\n\"answer_text_4\": \"الصفر اللامع\",\n\"answer\": \"الكروميل\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الطلاء الأخضر لتحسين قدرته على مقاومة التآكل؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الكروم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الفضة\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"الكروم\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأدوات الخشبية مثل المطارق والمناشير؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الصلب\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"الألمنيوم\",\n\"answer\": \"الحديد\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
						listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأجهزة الإلكترونية لتوصيل التيار الكهربائي؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"النحاس\",\n\"answer_text_2\": \"الفضة\",\n\"answer_text_3\": \"الذهب\",\n\"answer_text_4\": \"الألمنيوم\",\n\"answer\": \"النحاس\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأسمدة لتحسين نمو النباتات وتطوير الأوراق؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الفوسفور\",\n\"answer_text_2\": \"النيتروجين\",\n\"answer_text_3\": \"الكالسيوم\",\n\"answer_text_4\": \"الكلور\",\n\"answer\": \"الفوسفور\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أجزاء المحركات الكهربائية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الألومنيوم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"الألومنيوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الطلاء الأبيض لتحسين قدرته على الانعكاس؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الباريوم\",\n\"answer_text_2\": \"الكالسيوم\",\n\"answer_text_3\": \"الزنك\",\n\"answer_text_4\": \"الفضة\",\n\"answer\": \"الباريوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأسلاك الكهربائية للسيارات؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الألمنيوم\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"الفولاذ\",\n\"answer\": \"النحاس\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الأسفنج الصناعي؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"البولي يوريثان\",\n\"answer_text_2\": \"النايلون\",\n\"answer_text_3\": \"الصوف\",\n\"answer_text_4\": \"البلاستيك\",\n\"answer\": \"البولي يوريثان\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع البطاريات القابلة للصدأ؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الزنك\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"الفضة\",\n\"answer_text_4\": \"النحاس\",\n\"answer\": \"الزنك\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الأدوات الزراعية الحديثة لقتل الحشرات؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"النيكوتين\",\n\"answer_text_2\": \"الفوسفور\",\n\"answer_text_3\": \"الكبريت\",\n\"answer_text_4\": \"النيتروجين\",\n\"answer\": \"النيكوتين\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع المطاط الصناعي؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"اللاتكس\",\n\"answer_text_2\": \"النايلون\",\n\"answer_text_3\": \"البولي يوريثان\",\n\"answer_text_4\": \"الصوف\",\n\"answer\": \"اللاتكس\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الطلاء الأسود لتحسين قدرته على امتصاص الحرارة؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الكربون\",\n\"answer_text_2\": \"الرصاص\",\n\"answer_text_3\": \"الزنك\",\n\"answer_text_4\": \"الحديد\",\n\"answer\": \"الكربون\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
								listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يضاف إلى الزجاج لجعله مقاومًا للكسر؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الألومينا\",\n\"answer_text_2\": \"السيليكا\",\n\"answer_text_3\": \"الصودا\",\n\"answer_text_4\": \"البورون\",\n\"answer\": \"الألومينا\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأطباق والأواني الخزفية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"السيراميك\",\n\"answer_text_2\": \"الفلز\",\n\"answer_text_3\": \"المعدن\",\n\"answer_text_4\": \"البلاستيك\",\n\"answer\": \"السيراميك\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع البطاريات القابلة لإعادة الشحن؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الرصاص\",\n\"answer_text_2\": \"النيكل\",\n\"answer_text_3\": \"الكادميوم\",\n\"answer_text_4\": \"الليثيوم\",\n\"answer\": \"الليثيوم\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تضاف إلى الأسمدة لتحسين نمو النباتات؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"النترات\",\n\"answer_text_2\": \"الفوسفات\",\n\"answer_text_3\": \"البوتاسيوم\",\n\"answer_text_4\": \"الزرنيخ\",\n\"answer\": \"النترات\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع السوائل الخاصة بالتبريد في المحركات السيارات؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الغاز الطبيعي\",\n\"answer_text_2\": \"النيتروجين\",\n\"answer_text_3\": \"الكيروسين\",\n\"answer_text_4\": \"الغاز الفلوري\",\n\"answer\": \"الغاز الفلوري\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تضاف إلى الماء لتعقيمه؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الكلور\",\n\"answer_text_2\": \"البيروكسيد\",\n\"answer_text_3\": \"الكحول\",\n\"answer_text_4\": \"الفورمالدهيد\",\n\"answer\": \"الكلور\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الفولاذ لجعله مقاومًا للصدأ؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الكروم\",\n\"answer_text_2\": \"الزنك\",\n\"answer_text_3\": \"الفضة\",\n\"answer_text_4\": \"الحديد\",\n\"answer\": \"الكروم\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع الألعاب النارية للحصول على اللون الأحمر؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الباريوم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"السيليكون\",\n\"answer_text_4\": \"الصوديوم\",\n\"answer\": \"الباريوم\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأسلاك الكهربائية الناعمة؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الذهب\",\n\"answer_text_2\": \"الفضة\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"النحاس\",\n\"answer\": \"الذهب\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يضاف إلى الزجاج لجعله شفافًا؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الأكسجين\",\n\"answer_text_2\": \"الهيدروجين\",\n\"answer_text_3\": \"الكالسيوم\",\n\"answer_text_4\": \"الفلور\",\n\"answer\": \"الأكسجين\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
									listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هي المادة الرئيسية التي تستخدم في تصنيع الأحذية الرياضية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الجلد\",\n\"answer_text_2\": \"النايلون\",\n\"answer_text_3\": \"المطاط\",\n\"answer_text_4\": \"البلاستيك\",\n\"answer\": \"النايلون\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع الألواح الشمسية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"السيليكون\",\n\"answer_text_2\": \"الفضة\",\n\"answer_text_3\": \"الكربون\",\n\"answer_text_4\": \"الباريوم\",\n\"answer\": \"السيليكون\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يضاف إلى الزجاج لجعله مقاومًا للحرارة؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الرصاص\",\n\"answer_text_2\": \"الألومنيوم\",\n\"answer_text_3\": \"الزنك\",\n\"answer_text_4\": \"البورون\",\n\"answer\": \"البورون\"\n},\n{\n\"text\": \"ما هو المادة الكيميائية التي تضاف إلى المياه لجعلها مقاومة للتجمد؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الملح\",\n\"answer_text_2\": \"السكر\",\n\"answer_text_3\": \"الكحول\",\n\"answer_text_4\": \"الأسيتون\",\n\"answer\": \"الملح\"\n},\n{\n\"text\": \"ما هي المادة الرئيسية التي تستخدم في تصنيع الأسفنج؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"البولي يوريثان\",\n\"answer_text_2\": \"الصوف\",\n\"answer_text_3\": \"القطن\",\n\"answer_text_4\": \"النايلون\",\n\"answer\": \"البولي يوريثان\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يضاف إلى الفضة لجعلها أكثر صلابة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"النحاس\",\n\"answer_text_2\": \"الزنك\",\n\"answer_text_3\": \"الألومنيوم\",\n\"answer_text_4\": \"الحديد\",\n\"answer\": \"النحاس\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أسلاك الكهرباء الناعمة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الذهب\",\n\"answer_text_2\": \"الفضة\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"النحاس\",\n\"answer\": \"الذهب\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يضاف إلى الزجاج لجعله عازلاً للحرارة والكهرباء؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"السيليكا\",\n\"answer_text_2\": \"الصودا\",\n\"answer_text_3\": \"الألومينا\",\n\"answer_text_4\": \"البورون\",\n\"answer\": \"السيليكا\"\n},{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أطباق الطعام والأواني الطبخ المغلفة بالتيفال؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الألومنيوم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الفولاذ المقاوم للصدأ\",\n\"answer\": \"الفولاذ المقاوم للصدأ\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أسلاك الفولاذ المجلفن؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الحديد\",\n\"answer_text_2\": \"الزنك\",\n\"answer_text_3\": \"الفضة\",\n\"answer_text_4\": \"النحاس\",\n\"answer\": \"الزنك\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
										listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع الأسلاك الكهربائية الفضية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الذهب\",\n\"answer_text_4\": \"البلاتين\",\n\"answer\": \"الفضة\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تنظيف البلاستيك؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الكحول\",\n\"answer_text_2\": \"الماء الساخن\",\n\"answer_text_3\": \"الأمونيا\",\n\"answer_text_4\": \"المذيبات العضوية\",\n\"answer\": \"الأمونيا\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع أغطية العلب المعدنية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الألومنيوم\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"القصدير\",\n\"answer\": \"القصدير\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأدوات المائية البلاستيكية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الصودا الكاوية\",\n\"answer_text_2\": \"البولي ايثيلين\",\n\"answer_text_3\": \"البولي بروبيلين\",\n\"answer_text_4\": \"النايلون\",\n\"answer\": \"البولي ايثيلين\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الألواح الخشبية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الصمغ\",\n\"answer_text_2\": \"البوليمر\",\n\"answer_text_3\": \"اللاتكس\",\n\"answer_text_4\": \"الفورمالدهيد\",\n\"answer\": \"الفورمالدهيد\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأطباق والأواني الخزفية؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"السيراميك\",\n\"answer_text_2\": \"الفلز\",\n\"answer_text_3\": \"المعدن\",\n\"answer_text_4\": \"البلاستيك\",\n\"answer\": \"السيراميك\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في صناعة الأطباق والأواني غير القابلة للصدأ؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"التيتانيوم\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"التيتانيوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في صناعة الشموع؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"البارافين\",\n\"answer_text_2\": \"السيراميك\",\n\"answer_text_3\": \"الكحول\",\n\"answer_text_4\": \"الصمغ\",\n\"answer\": \"البارافين\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تلوين البلاستيك باللون الأزرق؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الكروم\",\n\"answer_text_2\": \"الكوبالت\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الزئبق\",\n\"answer\": \"الكوبالت\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أجزاء المحركات الكهربائية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الألومنيوم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"النحاس\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
											listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو المادة الرئيسية التي يتم تصنيع الأكواب الورقية منها؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الكتان\",\n\"answer_text_2\": \"الخشب\",\n\"answer_text_3\": \"الورق\",\n\"answer_text_4\": \"النسيج\",\n\"answer\": \"الورق\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تنظيف الفولاذ المقاوم للصدأ؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"حمض الكلوريدريك\",\n\"answer_text_2\": \"حمض الخليك\",\n\"answer_text_3\": \"حمض الهيدروكلوريك\",\n\"answer_text_4\": \"حمض الكبريتيك\",\n\"answer\": \"حمض الهيدروكلوريك\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع أسلاك الكهرباء الفضية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الذهب\",\n\"answer_text_4\": \"البلاتين\",\n\"answer\": \"الفضة\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تنظيف البلاستيك؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الكحول\",\n\"answer_text_2\": \"الماء الساخن\",\n\"answer_text_3\": \"الأمونيا\",\n\"answer_text_4\": \"المذيبات العضوية\",\n\"answer\": \"الأمونيا\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في صناعة أغطية العلب المعدنية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الألومنيوم\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"النحاس\",\n\"answer_text_4\": \"القصدير\",\n\"answer\": \"القصدير\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأدوات المائية البلاستيكية؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الصودا الكاوية\",\n\"answer_text_2\": \"البولي ايثيلين\",\n\"answer_text_3\": \"البولي بروبيلين\",\n\"answer_text_4\": \"النايلون\",\n\"answer\": \"البولي ايثيلين\"\n},\n{\n\"text\": \"ما هي المادة الكيميائية التي تستخدم في تصنيع الألواح الخشبية؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الصمغ\",\n\"answer_text_2\": \"البوليمر\",\n\"answer_text_3\": \"اللاتكس\",\n\"answer_text_4\": \"الفورمالدهيد\",\n\"answer\": \"الفورمالدهيد\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الأطباق والأواني الخزفية؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"السيراميك\",\n\"answer_text_2\": \"الفلز\",\n\"answer_text_3\": \"المعدن\",\n\"answer_text_4\": \"البلاستيك\",\n\"answer\": \"السيراميك\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في صناعة الأطباق والأواني غير القابلة للصدأ؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"الحديد\",\n\"answer_text_3\": \"التيتانيوم\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"التيتانيوم\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في صناعة الشموع؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"البارافين\",\n\"answer_text_2\": \"السيراميك\",\n\"answer_text_3\": \"الكحول\",\n\"answer_text_4\": \"الصمغ\",\n\"answer\": \"البارافين\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
												listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى البلاستيك لجعله قابل للتشكيل بسهولة؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الصودا الكاوية\",\n\"answer_text_2\": \"البارافين\",\n\"answer_text_3\": \"البوتاسيوم\",\n\"answer_text_4\": \"البوليبروبيلين\",\n\"answer\": \"البارافين\"\n},\n{\n\"text\": \"ما هي المادة الرئيسية التي يتم تصنيع الأفلام البلاستيكية منها؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"البولي ايثيلين\",\n\"answer_text_2\": \"البولي بروبيلين\",\n\"answer_text_3\": \"النايلون\",\n\"answer_text_4\": \"البولي فينيل كلوريد\",\n\"answer\": \"البولي ايثيلين\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أدوات الطهي غير القابلة للصدأ؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الحديد\",\n\"answer_text_2\": \"الألمنيوم\",\n\"answer_text_3\": \"النيكل\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"الحديد\"\n},\n{\n\"text\": \"ما هو العنصر الكيميائي الذي يستخدم في تصنيع الأنابيب البلاستيكية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الباريوم\",\n\"answer_text_2\": \"البولي ايثيلين\",\n\"answer_text_3\": \"الكربون\",\n\"answer_text_4\": \"البوتاسيوم\",\n\"answer\": \"البولي ايثيلين\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تغليف الطعام لحفظه من التلوث البيئي؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"الألمنيوم\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الذهب\",\n\"answer\": \"الألمنيوم\"\n},\n{\n\"text\": \"ما هي المادة الرئيسية التي يتم تصنيع الأسلاك الكهربائية العازلة منها؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"البولي ايثيلين\",\n\"answer_text_2\": \"النايلون\",\n\"answer_text_3\": \"المطاط\",\n\"answer_text_4\": \"الورق\",\n\"answer\": \"البولي ايثيلين\"\n},\n{\n\"text\": \"ما هو العنصر الذي يضاف إلى الزجاج لجعله مقاومًا للصدمات؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الكالسيوم\",\n\"answer_text_2\": \"الصودا\",\n\"answer_text_3\": \"الألومنيوم\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"الألومنيوم\"\n},\n{\n\"text\": \"ما هي المادة الرئيسية التي يتم تصنيع البلاستيك الشفاف منها؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"البولي إيثيلين\",\n\"answer_text_2\": \"البولي بروبيلين\",\n\"answer_text_3\": \"البولي كلوريد الفينيل\",\n\"answer_text_4\": \"البولي ستايرين\",\n\"answer\": \"البولي إيثيلين\"\n},\n{\n\"text\": \"ما هو العنصر الذي يستخدم في تصنيع الألواح الشمسية؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الفضة\",\n\"answer_text_2\": \"السيليكون\",\n\"answer_text_3\": \"الكربون\",\n\"answer_text_4\": \"الباريوم\",\n\"answer\": \"السيليكون\"\n},\n{\n\"text\": \"ما هو المعدن الذي يستخدم في تصنيع أجزاء المحركات الكهربائية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الألومنيوم\",\n\"answer_text_2\": \"النحاس\",\n\"answer_text_3\": \"الحديد\",\n\"answer_text_4\": \"الزنك\",\n\"answer\": \"النحاس\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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