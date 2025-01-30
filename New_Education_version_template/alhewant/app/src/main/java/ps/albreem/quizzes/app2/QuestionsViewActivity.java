package ps.albreem.quizzes.app2;

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
			listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعيش في أعماق المحيطات حيث تعتبر ضغوط المياه هناك مرتفعة جداً؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"الكائن الأعمى\",\n    \"answer_text_2\": \"الحيوان الضوء\",\n    \"answer_text_3\": \"الأنقليس العميق\",\n    \"answer_text_4\": \"الأسماك العمياء\",\n    \"answer\": \"الأنقليس العميق\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعتبر من أكثر الحيوانات تنوعًا في البحار والمحيطات ويشمل فصائل مثل القرش والسمك والحيتان؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"البحر المفتوح\",\n    \"answer_text_2\": \"الحيوان المائي\",\n    \"answer_text_3\": \"البحرية الكبرى\",\n    \"answer_text_4\": \"الفوالة البحرية\",\n    \"answer\": \"البحرية الكبرى\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعتبر أحد أكبر المفترسين في المحيطات ويتغذى بشكل أساسي على الحيتان والفقمة؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"القرش الأبيض الكبير\",\n    \"answer_text_2\": \"التمساح البحري\",\n    \"answer_text_3\": \"الحوت الأزرق\",\n    \"answer_text_4\": \"القرش الحوت\",\n    \"answer\": \"القرش الأبيض الكبير\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعيش في البيئات القريبة من الشعاب المرجانية ويكون جسمه ملونًا بألوان زاهية؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"السلحفاة البحرية\",\n    \"answer_text_2\": \"القنديل البحري\",\n    \"answer_text_3\": \"الأنقليس المرجاني\",\n    \"answer_text_4\": \"الأسماك المرجانية\",\n    \"answer\": \"الأسماك المرجانية\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعيش في المناطق القريبة من السواحل ويتميز بأنه يمكنه التكيف مع تغيرات درجة حرارة الماء؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"السلحفاة البحرية\",\n    \"answer_text_2\": \"الفوكة البحرية\",\n    \"answer_text_3\": \"السمكة البحرية\",\n    \"answer_text_4\": \"الدلفين\",\n    \"answer\": \"الدلفين\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعتبر من أكثر الأسماك شهرة في المحيطات ويتميز بأنه يمتلك أسنان حادة وجسم مدبب؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"القرش الأبيض الكبير\",\n    \"answer_text_2\": \"التونة الزرقاء\",\n    \"answer_text_3\": \"السمكة الباراكودا\",\n    \"answer_text_4\": \"القرش الحوت\",\n    \"answer\": \"القرش الحوت\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعيش في المياه الساحلية ويمتلك قلبًا بثلاثة جوانب؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"القرش القاتل\",\n    \"answer_text_2\": \"الدلافين النهرية\",\n    \"answer_text_3\": \"السلحفاة البحرية\",\n    \"answer_text_4\": \"الفوكة البحرية\",\n    \"answer\": \"السلحفاة البحرية\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يتمتع بقدرة هائلة على السباحة ويعيش في المحيط الهادئ؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"الحوت الأزرق\",\n    \"answer_text_2\": \"الأنقليس العميق\",\n    \"answer_text_3\": \"السلحفاة البحرية\",\n    \"answer_text_4\": \"التمساح البحري\",\n    \"answer\": \"الحوت الأزرق\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يعيش في المياه العميقة ويتميز بأن لديه جسم مضغوط جانبياً وزعانف طويلة؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"التمساح البحري\",\n\"answer_text_2\": \"الأنقليس البحري\",\n\"answer_text_3\": \"القرش الأبيض الكبير\",\n\"answer_text_4\": \"الأسماك الكهفية\",\n\"answer\": \"التمساح البحري\"\n},{\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعيش في المياه العميقة ويتميز بأن لديه جسم مضغوط جانبياً وزعانف طويلة؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"التمساح البحري\",\n    \"answer_text_2\": \"الأنقليس البحري\",\n    \"answer_text_3\": \"القرش الأبيض الكبير\",\n    \"answer_text_4\": \"الأسماك الكهفية\",\n    \"answer\": \"التمساح البحري\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
				listmap = new Gson().fromJson("[\n  {\n    \"text\": \"ما هو الحيوان الذي يعتبر أحد أسرع الكائنات المعروفة في المحيطات ويتمتع بقدرة هائلة على السباحة؟\",\n    \"no\": \"1\",\n    \"answer_text_1\": \"الفينكسيا\",\n    \"answer_text_2\": \"التونة الزرقاء\",\n    \"answer_text_3\": \"السلحفاة البحرية\",\n    \"answer_text_4\": \"السرطان البحري\",\n    \"answer\": \"الفينكسيا\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه أكبر حيوان على وجه الأرض ويعيش في المحيط الهادئ؟\",\n    \"no\": \"2\",\n    \"answer_text_1\": \"الحوت الأزرق\",\n    \"answer_text_2\": \"الأخطبوط العملاق\",\n    \"answer_text_3\": \"القرش الحوت\",\n    \"answer_text_4\": \"التمساح البحري\",\n    \"answer\": \"الحوت الأزرق\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه لا يمتلك دماغًا ويعتمد على أنسجة عصبية لأداء وظائفه الحيوية؟\",\n    \"no\": \"3\",\n    \"answer_text_1\": \"المدينة\",\n    \"answer_text_2\": \"الأسفنج\",\n    \"answer_text_3\": \"الشوكة البحرية\",\n    \"answer_text_4\": \"النجمة البحرية\",\n    \"answer\": \"الأسفنج\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بوجود إطار عظمي خارجي يعرف باسم قشرة ويعيش في البيئات البحرية المرجانية؟\",\n    \"no\": \"4\",\n    \"answer_text_1\": \"الجمبري\",\n    \"answer_text_2\": \"السلطعون\",\n    \"answer_text_3\": \"القنفذ البحري\",\n    \"answer_text_4\": \"الروبيان\",\n    \"answer\": \"القنفذ البحري\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يتغذى على الحيوانات البحرية الصغيرة ويعيش في المياه العميقة للمحيطات؟\",\n    \"no\": \"5\",\n    \"answer_text_1\": \"القرش الأبيض الكبير\",\n    \"answer_text_2\": \"الأنقليس البحري\",\n    \"answer_text_3\": \"الحبار\",\n    \"answer_text_4\": \"القنديل البحري\",\n    \"answer\": \"الأنقليس البحري\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يمكنه تغيير لون بشكل سريع ويعتمد على التمويه للدفاع عن نفسه؟\",\n    \"no\": \"6\",\n    \"answer_text_1\": \"الحبار\",\n    \"answer_text_2\": \"البخاخ البحري\",\n    \"answer_text_3\": \"الأخطبوط\",\n    \"answer_text_4\": \"الحوت الأزرق\",\n    \"answer\": \"الأخطبوط\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعيش في الأعماق البحرية القريبة من البراكين البحرية ويعتمد على البكتيريا للحصول على طاقة؟\",\n    \"no\": \"7\",\n    \"answer_text_1\": \"الروبيان\",\n    \"answer_text_2\": \"الحبار\",\n    \"answer_text_3\": \"السلطعون\",\n    \"answer_text_4\": \"المدمر البحري\",\n    \"answer\": \"الروبيان\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعتبر من أقدم أشكال الحياة على الأرض ويعيش في المحيطات الباردة؟\",\n    \"no\": \"8\",\n    \"answer_text_1\": \"الأسماك العظمية\",\n    \"answer_text_2\": \"الديناصور البحري\",\n    \"answer_text_3\": \"السمكة النهرية\",\n    \"answer_text_4\": \"الأنقليس البحري\",\n    \"answer\": \"الديناصور البحري\"\n  },\n  {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يشبه السلحفاة ولكنه أكبر حجمًا ويعيش في المياه الباردة المتجمدة؟\",\n    \"no\": \"9\",\n    \"answer_text_1\": \"السمكة القرش\",\n    \"answer_text_2\": \"القرش القاتل\",\n    \"answer_text_3\": \"الحوت الأزرق\",\n    \"answer_text_4\": \"السلحفاة البحرية\",\n    \"answer\": \"الحوت الأزرق\"},\n {\n    \"text\": \"ما هو الحيوان الذي يتميز بأنه يعتبر من أكبر اللافقاريات المائية ويتميز بجسمه اللزج الذي يعيش على الأعشاب البحرية؟\",\n    \"no\": \"10\",\n    \"answer_text_1\": \"الأنقليس البحري\",\n    \"answer_text_2\": \"السمكة الفانوس\",\n    \"answer_text_3\": \"القنديل البحري\",\n    \"answer_text_4\": \"الأسماك الكهفية\",\n    \"answer\": \"الأنقليس البحري\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
					listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الثدييات ويعيش في البيئات القارية والصحاراوية؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الإبل\",\n\"answer_text_2\": \"الجمل\",\n\"answer_text_3\": \"الفهد\",\n\"answer_text_4\": \"النمر\",\n\"answer\": \"الفهد\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في الماء العذب ويتغذى على الأعشاب؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الدولفين\",\n\"answer_text_2\": \"التمساح\",\n\"answer_text_3\": \"السمكة\",\n\"answer_text_4\": \"الحوت\",\n\"answer\": \"السمكة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جسمه المدبب وذيله الطويل ويعيش في البيئات المائية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الدولفين\",\n\"answer_text_2\": \"السلحفاة\",\n\"answer_text_3\": \"التمساح\",\n\"answer_text_4\": \"الأسد البحري\",\n\"answer\": \"الأسد البحري\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جلده السميك الذي يحميه من البرد والأمطار؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الدب\",\n\"answer_text_2\": \"الأرنب\",\n\"answer_text_3\": \"النمر\",\n\"answer_text_4\": \"الفهد\",\n\"answer\": \"الدب\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود أذنيه الطويلتين ويعيش في البيئات القارية والغابات؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الخفاش\",\n\"answer_text_2\": \"القرد\",\n\"answer_text_3\": \"الفأر\",\n\"answer_text_4\": \"الأرنب\",\n\"answer\": \"القرد\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود فروة طويلة وكثيفة ويعيش في المناطق الباردة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الباندا\",\n\"answer_text_2\": \"اليتي\",\n\"answer_text_3\": \"الدب القطبي\",\n\"answer_text_4\": \"التنين\",\n\"answer\": \"الدب القطبي\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود فمه الواسع وقدرته على ابتلاع فريسته بالكامل؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الثعبان\",\n\"answer_text_2\": \"التمساح\",\n\"answer_text_3\": \"الأسد\",\n\"answer_text_4\": \"القرش\",\n\"answer\": \"الثعبان\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود زعانفه القوية وذيله الطويل ويعيش في المحيطات؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الحوت\",\n\"answer_text_2\": \"القرش\",\n\"answer_text_3\": \"التمساح\",\n\"answer_text_4\": \"السمكة\",\n\"answer\": \"الحوت\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود ريشه الجميل ويستخدمه للتزاوج والتخاطب؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"البطريق\",\n\"answer_text_2\": \"النعامة\",\n\"answer_text_3\": \"البجعة\",\n\"answer_text_4\": \"البومة\",\n\"answer\": \"البومة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الزواحف ويتميز بسرعته الفائقة وتسلقه الأشجار بسهولة؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الحية\",\n\"answer_text_2\": \"السلحفاة\",\n\"answer_text_3\": \"السحلية\",\n\"answer_text_4\": \"العقرب\",\n\"answer\": \"الحية\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
						listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جيوب في جلده يستخدمها لحمل صغاره؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الكنغر\",\n\"answer_text_2\": \"الكوالا\",\n\"answer_text_3\": \"الوعل\",\n\"answer_text_4\": \"الوالبين\",\n\"answer\": \"الكنغر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على التمويه بشكل مذهل في البيئات المائية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"القنديل\",\n\"answer_text_2\": \"السمكة القرش\",\n\"answer_text_3\": \"الأخطبوط\",\n\"answer_text_4\": \"القنفذ البحري\",\n\"answer\": \"الأخطبوط\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من أكبر الثدييات اللاحمة ويعيش في البيئات القارية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الأسد\",\n\"answer_text_2\": \"النمر\",\n\"answer_text_3\": \"الفيل\",\n\"answer_text_4\": \"الذئب\",\n\"answer\": \"الأسد\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بشكله البارز وأذنيه الكبيرتين ويعيش في البيئات القارية والمائية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الفهد\",\n\"answer_text_2\": \"الضبع\",\n\"answer_text_3\": \"النسر\",\n\"answer_text_4\": \"التمساح\",\n\"answer\": \"التمساح\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من أصغر الثدييات ويعيش في الأماكن العشبية ويتغذى على الحشرات؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الأرنب\",\n\"answer_text_2\": \"الفأر\",\n\"answer_text_3\": \"القطة\",\n\"answer_text_4\": \"الخفاش\",\n\"answer\": \"الفأر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الطيور ويتميز بقدرته على الطيران لمسافات طويلة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"النسر\",\n\"answer_text_2\": \"البطة\",\n\"answer_text_3\": \"الحمامة\",\n\"answer_text_4\": \"البومة\",\n\"answer\": \"النسر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على إمتصاص السموم بجلده ويعيش في البيئات الاستوائية؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"السحلية\",\n\"answer_text_2\": \"الضفدع\",\n\"answer_text_3\": \"الثعبان\",\n\"answer_text_4\": \"الكمأة\",\n\"answer\": \"الضفدع\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من أكبر الثدييات البحرية ويتغذى على الأسماك الكبيرة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الحوت الأزرق\",\n\"answer_text_2\": \"الحوت الأبيض\",\n\"answer_text_3\": \"الحوت الرمادي\",\n\"answer_text_4\": \"الحوت الأسود\",\n\"answer\": \"الحوت الأزرق\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في الجبال العالية ويتميز بشعره الكثيف الذي يساعده في مقاومة البرد؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الدب القطبي\",\n\"answer_text_2\": \"اليتي\",\n\"answer_text_3\": \"الأرنب القطبي\",\n\"answer_text_4\": \"القطة القطبية\",\n\"answer\": \"الدب القطبي\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على الصيد في الليل بفضل بصره القوي؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الضفدع\",\n\"answer_text_2\": \"القطة\",\n\"answer_text_3\": \"البومة\",\n\"answer_text_4\": \"الثعلب\",\n\"answer\": \"البومة\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
							listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جيوب في جلده يمكنها تخزين الهواء والسماح له بالعوم في المياه؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"السلحفاة\",\n\"answer_text_2\": \"السمكة\",\n\"answer_text_3\": \"الجرذ\",\n\"answer_text_4\": \"الكنغر\",\n\"answer\": \"السلحفاة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود ذيله الطويل الذي يستخدمه للتوازن أثناء القفزات الطويلة؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الكنغر\",\n\"answer_text_2\": \"القرد\",\n\"answer_text_3\": \"الحصان\",\n\"answer_text_4\": \"الفهد\",\n\"answer\": \"الكنغر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود فصوص في أذنيه يمكنها إغلاقها لحماية الأذنين أثناء السباحة؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الفيل\",\n\"answer_text_2\": \"الدولفين\",\n\"answer_text_3\": \"البطة\",\n\"answer_text_4\": \"الحوت\",\n\"answer\": \"الدولفين\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود فروة طويلة تغطي جسمه ويعيش في بيئات متنوعة من الصحاري إلى الغابات؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الأرنب\",\n\"answer_text_2\": \"السنجاب\",\n\"answer_text_3\": \"الفأر\",\n\"answer_text_4\": \"القطة\",\n\"answer\": \"السنجاب\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود رقبته الطويلة التي تمكنه من الوصول إلى أوراق الأشجار العالية؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الزرافة\",\n\"answer_text_2\": \"الفيل\",\n\"answer_text_3\": \"النعامة\",\n\"answer_text_4\": \"البومة\",\n\"answer\": \"الزرافة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جلده المشعث ويعتبر من الثدييات اللاحمة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الدب\",\n\"answer_text_2\": \"الذئب\",\n\"answer_text_3\": \"النمر\",\n\"answer_text_4\": \"الفهد\",\n\"answer\": \"الدب\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جناحين يساعده على الطيران ويعيش في الغابات والحدائق؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الطائر\",\n\"answer_text_2\": \"الفراشة\",\n\"answer_text_3\": \"العصفور\",\n\"answer_text_4\": \"البطريق\",\n\"answer\": \"الفراشة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود أنفه الحساس الذي يساعده في البحث عن الطعام في الأراضي الرطبة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الفيل\",\n\"answer_text_2\": \"الخفاش\",\n\"answer_text_3\": \"الغزال\",\n\"answer_text_4\": \"الفهد\",\n\"answer\": \"الخفاش\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود قرون على رأسه تستخدم للدفاع عن النفس؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الأسد\",\n\"answer_text_2\": \"الزرافة\",\n\"answer_text_3\": \"الفيل\",\n\"answer_text_4\": \"النعامة\",\n\"answer\": \"الأسد\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود فقاره المستطيل الشكل وجسمه الغزير ويعيش في البيئات المائية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"التمساح\",\n\"answer_text_2\": \"التنين\",\n\"answer_text_3\": \"الحوت\",\n\"answer_text_4\": \"الثعبان\",\n\"answer\": \"التمساح\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
								listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يُعتبر من الثدييات ويتميز بقدرته على السباحة والصيد في المياه؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الدلفين\",\n\"answer_text_2\": \"الحوت\",\n\"answer_text_3\": \"التمساح\",\n\"answer_text_4\": \"الأخطبوط\",\n\"answer\": \"الدلفين\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بجسمه المدبب وزعانفه الطويلة ويعيش في المحيطات؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"القرش\",\n\"answer_text_2\": \"الحوت\",\n\"answer_text_3\": \"التمساح\",\n\"answer_text_4\": \"الدولفين\",\n\"answer\": \"القرش\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود أجنحة يستخدمها للطيران ويعيش في الغابات؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الطاووس\",\n\"answer_text_2\": \"البجعة\",\n\"answer_text_3\": \"الطائر الطنان\",\n\"answer_text_4\": \"البومة\",\n\"answer\": \"البومة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بأسنانه الحادة ويعتبر من اللافقاريات؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"التمساح\",\n\"answer_text_2\": \"القرش\",\n\"answer_text_3\": \"الثعبان\",\n\"answer_text_4\": \"الدودة\",\n\"answer\": \"الثعبان\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود فقاره الصلبة ويعيش في الماء واليابسة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"السلحفاة\",\n\"answer_text_2\": \"التمساح\",\n\"answer_text_3\": \"السمكة\",\n\"answer_text_4\": \"الدولفين\",\n\"answer\": \"السلحفاة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جلده السميك الذي يحميه من البرد القارس؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الأسد\",\n\"answer_text_2\": \"الدب\",\n\"answer_text_3\": \"النمر\",\n\"answer_text_4\": \"الفهد\",\n\"answer\": \"الدب\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الثدييات ويتميز بطول رقبته الذي يمكنها الوصول إلى الأفق؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الزرافة\",\n\"answer_text_2\": \"النعامة\",\n\"answer_text_3\": \"البومة\",\n\"answer_text_4\": \"الفيل\",\n\"answer\": \"الزرافة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الطيور ويمتاز بصوته الجميل الذي يستخدمه للتواصل؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"البطة\",\n\"answer_text_2\": \"البومة\",\n\"answer_text_3\": \"الطائر الطنان\",\n\"answer_text_4\": \"البلشون\",\n\"answer\": \"البلشون\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في البيئات القارية ويتميز بأذنيه الحادتين وذيله الطويل؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الثعلب\",\n\"answer_text_2\": \"الذئب\",\n\"answer_text_3\": \"السنجاب\",\n\"answer_text_4\": \"النمر\",\n\"answer\": \"الثعلب\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الزواحف ويتميز بسرعته الكبيرة وقدرته على الزحف على الجدران؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"العقرب\",\n\"answer_text_2\": \"الحية\",\n\"answer_text_3\": \"السحلية\",\n\"answer_text_4\": \"العنكبوت\",\n\"answer\": \"العقرب\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
									listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على تغيير لون جلده بشكل كامل؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الكاميليون\",\n\"answer_text_2\": \"السحلية\",\n\"answer_text_3\": \"الأفعى\",\n\"answer_text_4\": \"السلحفاة\",\n\"answer\": \"الكاميليون\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بأنف طويل يستخدمه للشم والبحث عن الطعام في الأراضي المنخفضة؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الفيل\",\n\"answer_text_2\": \"الجرذ\",\n\"answer_text_3\": \"الكلب\",\n\"answer_text_4\": \"الفأر\",\n\"answer\": \"الفيل\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من اللافقاريات ويتمتع بقدرة على التجديف باستخدام أذرعه؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"السلطعون\",\n\"answer_text_2\": \"السمكة\",\n\"answer_text_3\": \"القراصنة\",\n\"answer_text_4\": \"الأفعى\",\n\"answer\": \"السلطعون\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على الطيران وهو من الثدييات؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الخفاش\",\n\"answer_text_2\": \"البطة\",\n\"answer_text_3\": \"النعامة\",\n\"answer_text_4\": \"البومة\",\n\"answer\": \"الخفاش\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعتبر من أكبر الثدييات البحرية ويعيش في المياه الباردة؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الحوت الأزرق\",\n\"answer_text_2\": \"الدلفين\",\n\"answer_text_3\": \"العقرب\",\n\"answer_text_4\": \"القرش\",\n\"answer\": \"الحوت الأزرق\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود لسانه الطويل الملتصق بقمم ثلاثية ويستخدمه لصيد النمل؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"النملة\",\n\"answer_text_2\": \"النملة الحمراء\",\n\"answer_text_3\": \"النمل\",\n\"answer_text_4\": \"النملة السوداء\",\n\"answer\": \"النمل\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعتبر من الزواحف ويتميز بأنه يعيش في الماء واليابسة؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"السلحفاة\",\n\"answer_text_2\": \"التمساح\",\n\"answer_text_3\": \"السحلية\",\n\"answer_text_4\": \"الثعبان\",\n\"answer\": \"التمساح\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بأسنانه الحادة ويعيش في المياه العذبة والمالحة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"التمساح\",\n\"answer_text_2\": \"القرش\",\n\"answer_text_3\": \"الحوت\",\n\"answer_text_4\": \"الدولفين\",\n\"answer\": \"القرش\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الطيور ويمتاز بقدرته على التكيف مع البيئات القاسية في الصحاري؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"النعامة\",\n\"answer_text_2\": \"البومة\",\n\"answer_text_3\": \"النسر\",\n\"answer_text_4\": \"الطاووس\",\n\"answer\": \"النعامة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الثدييات ويتميز بخصلات شعره الطويلة والكثيفة؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الأسد\",\n\"answer_text_2\": \"الفهد\",\n\"answer_text_3\": \"الحصان\",\n\"answer_text_4\": \"النمر\",\n\"answer\": \"الأسد\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
										listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جيوب في جسمه لحمل صغاره؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الكنغر\",\n\"answer_text_2\": \"الكوالا\",\n\"answer_text_3\": \"الوعل\",\n\"answer_text_4\": \"الوالبين\",\n\"answer\": \"الكنغر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على التمويه بشكل مذهل في البيئات المائية؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"القنديل\",\n\"answer_text_2\": \"السمكة القرش\",\n\"answer_text_3\": \"الأخطبوط\",\n\"answer_text_4\": \"القنفذ البحري\",\n\"answer\": \"الأخطبوط\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعتبر من أكبر الثدييات اللاحمة ويعيش في البيئات القارية؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الأسد\",\n\"answer_text_2\": \"النمر\",\n\"answer_text_3\": \"الفيل\",\n\"answer_text_4\": \"الذئب\",\n\"answer\": \"الأسد\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بشكله البارز وأذنيه الكبيرتين ويعيش في البيئات القارية والمائية؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الفهد\",\n\"answer_text_2\": \"الضبع\",\n\"answer_text_3\": \"النسر\",\n\"answer_text_4\": \"التمساح\",\n\"answer\": \"التمساح\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من أصغر الثدييات ويعيش في الأماكن العشبية ويتغذى على الحشرات؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الأرنب\",\n\"answer_text_2\": \"الفأر\",\n\"answer_text_3\": \"القطة\",\n\"answer_text_4\": \"الخفاش\",\n\"answer\": \"الفأر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من الطيور ويتميز بقدرته على الطيران لمسافات طويلة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"النسر\",\n\"answer_text_2\": \"البطة\",\n\"answer_text_3\": \"الحمامة\",\n\"answer_text_4\": \"البومة\",\n\"answer\": \"النسر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على إمتصاص السموم بجلده ويعيش في البيئات الاستوائية؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"السحلية\",\n\"answer_text_2\": \"الضفدع\",\n\"answer_text_3\": \"الثعبان\",\n\"answer_text_4\": \"الكمأة\",\n\"answer\": \"الضفدع\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر من أكبر الثدييات البحرية ويتغذى على الأسماك الكبيرة؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الحوت الأزرق\",\n\"answer_text_2\": \"الحوت الأبيض\",\n\"answer_text_3\": \"الحوت الرمادي\",\n\"answer_text_4\": \"الحوت الأسود\",\n\"answer\": \"الحوت الأزرق\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في الجبال العالية ويتميز بشعره الكثيف الذي يساعده في مقاومة البرد؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الدب القطبي\",\n\"answer_text_2\": \"اليتي\",\n\"answer_text_3\": \"الأرنب القطبي\",\n\"answer_text_4\": \"القطة القطبية\",\n\"answer\": \"الدب القطبي\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على الصيد في الليل بفضل بصره القوي؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الضفدع\",\n\"answer_text_2\": \"القطة\",\n\"answer_text_3\": \"البومة\",\n\"answer_text_4\": \"الثعلب\",\n\"answer\": \"البومة\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
											listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يعيش في البيئات القارية ويمتلك جسمه طبقة سميكة من الفراء للحماية من البرد؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الذئب\",\n\"answer_text_2\": \"النمر\",\n\"answer_text_3\": \"الدب\",\n\"answer_text_4\": \"الأسد\",\n\"answer\": \"الدب\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتغذى على الحشرات ويُعتبر أحد أسرع الحيوانات في العالم؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"الطائر الطنان\",\n\"answer_text_2\": \"الوزغ\",\n\"answer_text_3\": \"الجرادة\",\n\"answer_text_4\": \"الغزال\",\n\"answer\": \"الطائر الطنان\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بقدرته على السباحة بشكل استثنائي ويعيش في مياه المحيطات؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"التمساح\",\n\"answer_text_2\": \"الحوت\",\n\"answer_text_3\": \"الفقمة\",\n\"answer_text_4\": \"الدولفين\",\n\"answer\": \"الحوت\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود لسان طويل جدا يستخدمه لصيد النمل والنحل؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"الدبور\",\n\"answer_text_2\": \"الأفعى\",\n\"answer_text_3\": \"القرد\",\n\"answer_text_4\": \"التمساح\",\n\"answer\": \"الدبور\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعرف بأنه أحد الثدييات الكبيرة ويتغذى أساسًا على الأعشاب؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الزرافة\",\n\"answer_text_2\": \"البقرة\",\n\"answer_text_3\": \"الفيل\",\n\"answer_text_4\": \"الحصان\",\n\"answer\": \"الزرافة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعتبر من أكبر الزواحف ويتغذى على الفقمات والغزلان؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"التمساح\",\n\"answer_text_2\": \"البايثون\",\n\"answer_text_3\": \"الأفعى الكوبرا\",\n\"answer_text_4\": \"التمساح الأمريكي\",\n\"answer\": \"البايثون\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بأذنيه الكبيرتين وقدرته على سماع الأصوات على بعد أميال؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الفيل\",\n\"answer_text_2\": \"الضبع\",\n\"answer_text_3\": \"الأرنب\",\n\"answer_text_4\": \"الفهد\",\n\"answer\": \"الفيل\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بسرعته الهائلة ويُعتبر من أسرع الحيوانات على الأرض؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الفهد\",\n\"answer_text_2\": \"الغزال\",\n\"answer_text_3\": \"الأفعى\",\n\"answer_text_4\": \"الفيل\",\n\"answer\": \"الغزال\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في الماء ويتميز بقدرته على تغيير ألوان جلده؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"الأخطبوط\",\n\"answer_text_2\": \"السمكة\",\n\"answer_text_3\": \"القرش\",\n\"answer_text_4\": \"الدلفين\",\n\"answer\": \"الأخطبوط\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بشكله المميز وذيله الطويل ويعيش في الغابات الاستوائية؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"القرد\",\n\"answer_text_2\": \"النمر\",\n\"answer_text_3\": \"الفيل\",\n\"answer_text_4\": \"الكوالا\",\n\"answer\": \"القرد\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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
												listmap = new Gson().fromJson("[\n{\n\"text\": \"ما هو الحيوان الذي يتميز بوجود جيوب في جسمه لحمل صغاره؟\",\n\"no\": \"1\",\n\"answer_text_1\": \"الكنغر\",\n\"answer_text_2\": \"الكوالا\",\n\"answer_text_3\": \"الوعل\",\n\"answer_text_4\": \"الوالبين\",\n\"answer\": \"الكنغر\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في المياه وعلى اليابسة أيضًا؟\",\n\"no\": \"2\",\n\"answer_text_1\": \"السلحفاة\",\n\"answer_text_2\": \"الضفدع\",\n\"answer_text_3\": \"التمساح\",\n\"answer_text_4\": \"السمكة القط الصغيرة\",\n\"answer\": \"السلحفاة\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعتبر الثدييات الوحيدة التي تستطيع الطيران؟\",\n\"no\": \"3\",\n\"answer_text_1\": \"الطائر الليلي\",\n\"answer_text_2\": \"الخفاش\",\n\"answer_text_3\": \"النسر\",\n\"answer_text_4\": \"الطاووس\",\n\"answer\": \"الخفاش\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعرف بقدرته على تغيير لون جلده ليتناسب مع البيئة؟\",\n\"no\": \"4\",\n\"answer_text_1\": \"القنفذ\",\n\"answer_text_2\": \"التمساح\",\n\"answer_text_3\": \"الكاميليون\",\n\"answer_text_4\": \"التنين\",\n\"answer\": \"الكاميليون\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعرف بأنه يمتلك ذاكرة طويلة الأمد؟\",\n\"no\": \"5\",\n\"answer_text_1\": \"الفيل\",\n\"answer_text_2\": \"القرد\",\n\"answer_text_3\": \"الدولفين\",\n\"answer_text_4\": \"السلحفاة\",\n\"answer\": \"الفيل\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يعيش في مستعمرات تحت الأرض ويبني أنفاقًا معقدة؟\",\n\"no\": \"6\",\n\"answer_text_1\": \"الضفدع\",\n\"answer_text_2\": \"النمل\",\n\"answer_text_3\": \"الأرنب\",\n\"answer_text_4\": \"الخفاش\",\n\"answer\": \"النمل\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يمتلك سرعة فائقة ويعتبر من أسرع الثدييات على وجه الأرض؟\",\n\"no\": \"7\",\n\"answer_text_1\": \"الفهد\",\n\"answer_text_2\": \"الغزال\",\n\"answer_text_3\": \"الأفعى\",\n\"answer_text_4\": \"الفهد السوداء\",\n\"answer\": \"الغزال\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعتبر من أقوى الحيوانات المائية ويمكنه حمل فريسته بين فكيه؟\",\n\"no\": \"8\",\n\"answer_text_1\": \"الحوت الأزرق\",\n\"answer_text_2\": \"القرش الأبيض الكبير\",\n\"answer_text_3\": \"الأسد البحري\",\n\"answer_text_4\": \"الكركديه\",\n\"answer\": \"القرش الأبيض الكبير\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يُعرف بقدرته على إنتاج اللؤلؤ؟\",\n\"no\": \"9\",\n\"answer_text_1\": \"البطة\",\n\"answer_text_2\": \"الحصان البحري\",\n\"answer_text_3\": \"الأخطبوط\",\n\"answer_text_4\": \"السلحفاة\",\n\"answer\": \"الحصان البحري\"\n},\n{\n\"text\": \"ما هو الحيوان الذي يتميز بأنف طويل وقوي ويستخدمه للشم والبحث عن الطعام؟\",\n\"no\": \"10\",\n\"answer_text_1\": \"الجمل\",\n\"answer_text_2\": \"الفيل\",\n\"answer_text_3\": \"النمر\",\n\"answer_text_4\": \"الفيل الأفريقي\",\n\"answer\": \"الفيل\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
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