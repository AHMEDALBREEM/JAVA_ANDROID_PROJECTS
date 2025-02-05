package com.albreem.solve.alrass;

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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class ViewActivity extends Activity {
	
	private double temp = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear8;
	private ImageView imageview1;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private TextView textview1;
	private LinearLayout linear3;
	private LinearLayout linear7;
	private TextView textview2;
	private LinearLayout linear5;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear8 = findViewById(R.id.linear8);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		linear6 = findViewById(R.id.linear6);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		linear7 = findViewById(R.id.linear7);
		textview2 = findViewById(R.id.textview2);
		linear5 = findViewById(R.id.linear5);
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bkm_1.ttf"), 1);
		temp = 0;
		if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
			imageview1.setImageResource(getResources().getIdentifier("img_1", "drawable", getPackageName()));
			textview1.setText(getIntent().getStringExtra("head"));
			textview2.setText("الرأس هو جزء من الجسم البشري والكائنات الحية الأخرى، يحتوي على العديد من الهياكل والأعضاء الهامة. إليك بعض المعلومات العامة عن الرأس:\n\n1. التركيب العام: الرأس يتألف من الجمجمة (العظمة التي تحمي الدماغ) والوجه. الجمجمة تتكون من عدة عظام متماسكة تحمي الدماغ من الإصابة. الوجه يحتوي على العديد من العظام والهياكل الأخرى مثل العينين والأنف والفم.\n\n2. الدماغ: يعتبر الدماغ أحد أهم أعضاء الرأس. وهو الجزء الرئيسي من الجهاز العصبي المركزي ويتحكم في معظم وظائف الجسم والعقل. يتألف الدماغ من مجموعة معقدة من الأعصاب والمراكز العصبية التي تتفاعل مع بقية الجسم والبيئة الخارجية.\n\n3. الوجه: يتضمن الوجه العديد من الأعضاء المهمة مثل العينين والأذنين والأنف والفم. يعمل الوجه على تعبير المشاعر والتواصل البصري والسمعي. وتحتوي العينان على العديد من الهياكل مثل القرنية والعدسة والشبكية التي تساعد في رؤية العالم من حولنا.\n\n4. الفم والأسنان: يوجد الفم في الجزء الأمامي من الرأس ويستخدم للتنفس والتغذية والتواصل اللفظي. يحتوي الفم على اللسان والأسنان التي تساعد في عملية الهضم والتكلم والمضغ.\n\n5. الأذنين: تقع الأذنين على جانبي الرأس وتستخدم للسمع والتوازن. تتألف الأذن الخارجية من الصوتيات التي تلتقط الموجات الصوتية، بينما تحول الأذن الوسطى ال\n\nأصوات إلى اهتزازات تنتقل إلى الأذن الداخلية التي تحتوي على القوقعة والاستريوكيليا، وهي المسؤولة عن إرسال الإشارات العصبية للدماغ.\n\nهذه معلومات عامة حول الرأس. يمكن أن تختلف الهياكل والأعضاء المحددة داخل الرأس بين الكائنات الحية المختلفة.");
		}
		else {
			temp++;
			if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
				imageview1.setImageResource(getResources().getIdentifier("img_2", "drawable", getPackageName()));
				textview1.setText(getIntent().getStringExtra("head"));
				textview2.setText("هناك عدة أنواع مختلفة من الصداع الرأس، وفيما يلي أشهر الأنواع المعروفة:\n\n1. صداع التوتر: يُعد صداع التوتر الأنوع الأكثر شيوعًا ويتسبب عادةً بالتوتر النفسي والعصبي والتوتر العضلي. يصفه الأشخاص عادةً بشعور بضغط معتدل إلى معتدل الشدة حول الجبهة والجوانب والرقبة.\n\n2. صداع العنقود: يعتبر صداع العنقود صداعًا نادرًا وشديد الشدة، ويصيب عادةً جانب واحد من الرأس وخاصةً حول العين. يتميز بنوبات حادة ومؤلمة تستمر لمدة قصيرة (من دقائق إلى ساعات) ويمكن أن يتكرر عدة مرات في اليوم.\n\n3. الصداع النصفي: يُعتبر الصداع النصفي نوعًا آخر من الصداع شديد الشدة وشائع. يمكن أن يصيب جانب واحد من الرأس ويصاحبه غالبًا أعراض أخرى مثل الغثيان والقيء والحساسية للضوء والأصوات. قد يستمر الصداع النصفي لعدة ساعات أو حتى أيام.\n\n4. صداع الجيوب الأنفية: يحدث نتيجة لالتهاب الجيوب الأنفية ويتسبب في ألم وضغط حول الوجه والجبهة والعينين. يمكن أن يرافقه احتقان الأنف وتدفق الأفرازات الزلالية.\n\n5. صداع التهاب الشرايين الصدغية: يعد صداعًا نادرًا يصاحب التهاب الشرايين في الجسم، ويصيب عادة الأشخاص الأكبر سنًا. يتميز بألم حاد ومستمر في منطقة الرأس وفروة الرأس وقد يرافقه احمرار وحساسية في فروة الرأس.\n\nهذه بعض الأنواع الشائعة للصداع الرأس. يجب ملاحظة أنه قد يكون هناك أنواع أخرى من الصداع غير المذكورة هنا، وفي حالة تكرار الصداع أو حدوث أعراض خاصة، ينصح بالتشاور مع الطبيب للتشخيص الدقيق والعلاج المناسب.");
			}
			else {
				temp++;
				if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
					imageview1.setImageResource(getResources().getIdentifier("img_3", "drawable", getPackageName()));
					textview1.setText(getIntent().getStringExtra("head"));
					textview2.setText("يوجد العديد من الطرق المختلفة لعلاج الصداع. ومن الجدير بالذكر أن العلاج المناسب يعتمد على نوع الصداع وأسبابه المحتملة. فيما يلي بعض الخطوات العامة التي يمكن اتباعها لتخفيف الصداع:\n\n1. الراحة والاسترخاء: قد يساعد التوقف عن القيام بالأنشطة المجهدة والاسترخاء في غرفة هادئة ومظلمة على تخفيف الصداع.\n\n2. تطبيق البرودة أو الحرارة: يمكن وضع قطعة قماش باردة على الجبين أو تطبيق حزمة ثلج ملفوفة في منشفة على منطقة الألم لمدة 15 دقيقة لتخفيف الصداع. بالنسبة لبعض الأشخاص، قد يكون تطبيق الحرارة اللطيفة أكثر فائدة.\n\n3. تناول الأدوية: يمكن استخدام الأدوية الموصوفة أو غير الموصوفة لتخفيف الصداع. ومن بين الأدوية الشائعة تلك التي تحتوي على الباراسيتامول، الإيبوبروفين، أو الأسبرين. ينبغي استشارة الطبيب أو الصيدلي للحصول على توجيهات حول الجرعة المناسبة والتحذيرات المحتملة.\n\n4. الابتعاد عن المحفزات: قد يكون بعض المحفزات مثل الأطعمة المحددة أو العوامل البيئية مسببة للصداع. من المفيد تجنب تناول الأطعمة المسببة للصداع المعروفة والابتعاد عن الروائح القوية والإضاءة الساطعة إذا كانت تزيد من حدة الصداع.\n\n5. الوقاية والتغييرات النمطية: يمكن الحد من الصداع عن طريق اتباع نمط حياة صحي، بما في ذلك الحصول على قسط كافٍ من النوم، وتجنب التوتر والضغط النفسي، وممارسة الرياضة بانتظام، والتغذية المتوازنة.\n\nإذا كان الصداع مستمرًا أو يزداد سوءًا، أو إذا كان هناك أعراض أخرى مصاحبة مثل غثيان، دوخة، أو تغيرات في الرؤية، فمن الأفضل استشارة الطبيب لتقييم الحالة وتوجيه العلاج المناسب.");
				}
				else {
					temp++;
					if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
						imageview1.setImageResource(getResources().getIdentifier("img_4", "drawable", getPackageName()));
						textview1.setText(getIntent().getStringExtra("head"));
						textview2.setText("يعتبر الصداع النصفي من أنواع الصداع الشائعة ويمكن أن يصيب الجانب الأيمن أو الأيسر من الرأس. هناك عدة عوامل قد تساهم في حدوث الصداع النصفي الأيمن، بما في ذلك:\n\n1. توسع الأوعية الدموية: يعتقد أن توسع الأوعية الدموية في الدماغ يلعب دورًا في حدوث الصداع النصفي. وقد يكون للأوعية الدموية المتوسعة تأثير أكبر على جانب الرأس الأيمن في حالة الصداع النصفي الأيمن.\n\n2. العوامل الوراثية: قد تكون هناك عوامل وراثية تسهم في تعرض الشخص للصداع النصفي الأيمن أو أي نوع آخر من الصداع النصفي.\n\n3. التوتر والإجهاد: يمكن أن يؤدي التوتر النفسي والإجهاد إلى حدوث الصداع النصفي. وقد يكون لهذه العوامل تأثير أكبر على جانب الرأس الأيمن في بعض الأشخاص.\n\n4. الأطعمة والمشروبات المحددة: بعض الأطعمة والمشروبات قد تكون مسببة للصداع النصفي عند بعض الأشخاص، ومن الممكن أن يتأثر جانب الرأس الأيمن بشكل خاص. من الأمثلة على هذه العناصر الغذائية المحتملة: الشوكولاتة، الجبن، المواد المحفزة مثل الكافيين والتوابل، والأطعمة المعلبة والمعالجة بالنيتريت.\n\n5. التغيرات الهرمونية: يمكن للتغيرات الهرمونية خلال دورة الحيض أو أثناء فترة الحمل أن تؤدي إلى حدوث الصداع النصفي، ومن الممكن أن يؤثر جانب الرأس الأيمن.\n\nمن المهم العمل على تحديد العوامل المحتملة التي تسبب الصداع النصفي لك شخصيًا، ويمكن للمحافظة على سجل للصداع ومراقبة العوامل المؤثرة أن تساعد في ذلك. كما ينصح بالتشاور مع الطبيب للحصول على تشخيص دقيق وخطة علاج مناسبة لحالتك.");
					}
					else {
						temp++;
						if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
							imageview1.setImageResource(getResources().getIdentifier("img_5", "drawable", getPackageName()));
							textview1.setText(getIntent().getStringExtra("head"));
							textview2.setText("الصداع النصفي الأيسر يشير إلى الصداع النصفي الذي يحدث على جانب الرأس الأيسر. هناك عدة عوامل قد تساهم في حدوث الصداع النصفي الأيسر، وتشمل:\n\n1. توسع الأوعية الدموية: يُعتقد أن توسع الأوعية الدموية في الدماغ يلعب دورًا في حدوث الصداع النصفي. وقد يؤدي توسع الأوعية الدموية في جانب الرأس الأيسر إلى حدوث الصداع النصفي الأيسر.\n\n2. العوامل الوراثية: قد تكون هناك عوامل وراثية تؤثر على احتمالية تعرض الشخص للصداع النصفي الأيسر أو أي نوع آخر من الصداع النصفي.\n\n3. التوتر والإجهاد: يُمكن أن يؤدي التوتر النفسي والإجهاد إلى حدوث الصداع النصفي. وقد يكون لهذه العوامل تأثير أكبر على جانب الرأس الأيسر في بعض الأشخاص.\n\n4. الأطعمة والمشروبات المحددة: بعض الأطعمة والمشروبات قد تكون مسببة للصداع النصفي لدى بعض الأشخاص، ومن الممكن أن يتأثر جانب الرأس الأيسر بشكل خاص. من الأمثلة على هذه العناصر الغذائية المحتملة: الشوكولاتة، الجبن، المنتجات المحتوية على الغلوتين، المواد المحفزة مثل الكافيين والتوابل.\n\n5. التغيرات الهرمونية: قد تؤدي التغيرات الهرمونية في الجسم، مثل الهرمونات النسائية، إلى حدوث الصداع النصفي. وقد يؤثر جانب الرأس الأيسر بشكل ملحوظ.\n\nمن المهم التوجه إلى الطبيب للحصول على تشخيص دقيق وخطة علاج مناسبة لحالتك، وذلك\n\n لتحديد العوامل المسببة وتقديم المشورة الملائمة للتخفيف من حدة الصداع ومنع حدوثه في المستقبل.");
						}
						else {
							temp++;
							if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
								imageview1.setImageResource(getResources().getIdentifier("img_6", "drawable", getPackageName()));
								textview1.setText(getIntent().getStringExtra("head"));
								textview2.setText("يمكن تجربة الخطوات التالية لتخفيف ألم الرأس:\n\n1. الراحة والاسترخاء: قم بالاسترخاء في مكان هادئ ومظلم، وحاول تخفيف التوتر والضغط النفسي.\n\n2. تطبيق البرودة أو الحرارة: قم بوضع قطعة قماش باردة على الجبين أو تطبيق حزمة ثلج ملفوفة في منشفة على منطقة الألم، أو جرب وضع منشفة دافئة على الرقبة والكتفين للحصول على تأثير مريح.\n\n3. الاسترخاء العضلي: قم بتمارين الاسترخاء العضلي، مثل تمدد العضلات والتنفس العميق، والتأكيد على التوتر وتخفيفه من الجسم.\n\n4. تناول الأدوية: يمكن استخدام الأدوية الموصوفة أو غير الموصوفة لتخفيف ألم الرأس. ينبغي استشارة الطبيب أو الصيدلي لتحديد الأدوية المناسبة وجرعاتها.\n\n5. الابتعاد عن المحفزات: قد يسبب بعض العوامل مثل الأطعمة المحددة والروائح القوية والإضاءة الساطعة زيادة في الألم. حاول تجنب هذه المحفزات قدر الإمكان.\n\n6. ممارسة الرياضة: قد يساعد ممارسة التمارين الرياضية الخفيفة بانتظام في تخفيف الصداع وتحسين الدورة الدموية.\n\n7. العلاجات البديلة: يمكن أن تكون بعض العلاجات البديلة مفيدة في تخفيف ألم الرأس، مثل العلاج بالتدليك، العلاج بالأعشاب، العلاج بالزنجبيل، أو العلاج بالأعشاب العطرية.\n\nومن الأهمية بمكان الاهتمام بأنماط الحياة الصحية بشكل عام، بما في ذلك الحصول على قسط كافٍ من النوم، وممارسة التمارين الرياضية بانتظام، وتجنب الإجهاد الزائد، والتغذية المتوازنة. إذا استمر الصداع أو تفاقم الأعراض، فمن الأفضل استشارة الطبيب لتقييم الحالة وتوجيه العلاج المناسب.");
							}
							else {
								temp++;
								if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
									imageview1.setImageResource(getResources().getIdentifier("img_7", "drawable", getPackageName()));
									textview1.setText(getIntent().getStringExtra("head"));
									textview2.setText("يتوفر العديد من المشروبات التي يمكن أن تساهم في تخفيف الصداع والتخلص منه. ومع ذلك، يجب دائمًا استشارة الطبيب قبل استخدام أي منها للتأكد من سلامتها وتداخلها مع أي أدوية أخرى قد تتناولها. فيما يلي بعض المشروبات والأعشاب التي قد تساعد في التخفيف من الصداع:\n\n1. الماء: ينصح بشرب كميات كافية من الماء يوميًا لتجنب الإصابة بصداع الجفاف، وتعتمد الكمية الموصى بها على الحالة الصحية الفردية.\n\n2. المشروبات المحتوية على الكافيين: تعتبر بعض المشروبات التي تحتوي على الكافيين مفيدة في تخفيف صداع التوتر والشقيقة، وقد تساعد أيضًا في تعزيز فعالية الأدوية المستخدمة لعلاج الصداع. ومع ذلك، يجب تجنب استهلاك الكافيين بكميات كبيرة لتجنب الآثار الجانبية المحتملة.\n\n3. النعناع: يحتوي النعناع على مركبات تعمل كمهدئ للأعصاب وترخي عضلات القناة الهضمية التي تسبب الصداع. يعتبر شاي النعناع خيارًا جيدًا لتخفيف الصداع.\n\n4. البابونج: يحتوي البابونج على مركبات مضادة للالتهابات وقد تساعد في تخفيف نوبات الشقيقة والصداع بشكل عام.\n\n5. الزنجبيل: يمتلك الزنجبيل خصائص مضادة للالتهابات ومضادات الهيستامين، ويمكن أن يساعد في تخفيف الصداع والشقيقة. يمكن تناول مسحوق الزنجبيل مع الماء أو تناول جذور الزنجبيل لتقليل حدة نوبات الشقيقة.\n\n6. القرفة: تحتوي القرفة على خصائص مضادة للالتهابات ويمكن أن تساعد في تقليل عدد مرات وحدة نوبات الشقيقة.\n\nبالنسبة للمشروبات التي يجب تجنبها لتخفيف الصداع، ينصح بعدم شرب المشروبات الساخنة المحتوية على الشوكولاتة والتي قد تحتوي على كميات كبيرة من الكافيين والمركبات الأخرى التي قد تزيد من خطر الإصابة بنوبات الصداع. أيضًا، يجب تجنب المشروبات التي تحتوي على مادة الأسبارتام، والتي يشتبه في أنها تحفز نوبات الصداع.\n\nيجب أن يتم اتخاذ قرار استخدام أي مادة عشبية أو مشروب بناءً على استشارة الطبيب وتوصياته، حيث يمكن أن تختلف استجابة الأفراد وتفضيلاتهم.");
								}
								else {
									temp++;
									if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
										imageview1.setImageResource(getResources().getIdentifier("img_8", "drawable", getPackageName()));
										textview1.setText(getIntent().getStringExtra("head"));
										textview2.setText("هناك عدة أسباب محتملة لوجع الرأس من الخلف. قد تشمل بعض هذه الأسباب:\n\n1. التوتر والتوتر العضلي: قد يتسبب التوتر النفسي والعصبي والتوتر العضلي في تشنجات العضلات في الرقبة والعنق والأكتاف، مما يؤدي إلى وجع الرأس من الخلف.\n\n2. صداع العنق: قد ينتج الوجع في منطقة الرأس الخلفية بسبب التهيج أو التوتر في الأعصاب أو العضلات في العنق.\n\n3. مشاكل في العمود الفقري: يمكن أن تؤدي مشاكل في العمود الفقري مثل انزلاق القرص الفقري أو انضغاط العصب إلى آلام في الرأس من الخلف.\n\n4. التهاب الجيوب الأنفية: يمكن أن يؤدي التهاب الجيوب الأنفية إلى تجمع السوائل في الجيوب الأنفية والتسبب في وجع الرأس من الخلف.\n\n5. مشاكل العين: قد تسبب بعض المشاكل العينية مثل النظر السيء أو التوتر في العضلات المحيطة بالعينين وجع الرأس من الخلف.\n\n6. اضطرابات النوم: قد ينتج النوم السيئ أو قلة النوم عن وجع الرأس من الخلف.\n\n7. الشقيقة: قد يشعر الأشخاص المصابون بالشقيقة بوجع الرأس من الخلف، حيث يصاحبه غالبًا ألم في جزء واحد من الرأس.\n\nهذه أمثلة فقط عن الأسباب الشائعة لوجع الرأس من الخلف، وقد يكون هناك أسباب أخرى. إذا استمر الألم أو كان شديدًا أو مصحوبًا بأعراض أخرى مزعجة، فمن الأفضل استشارة الطبيب لتقييم الحالة وتوجيه العلاج المناسب.");
									}
									else {
										temp++;
										if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
											imageview1.setImageResource(getResources().getIdentifier("img_9", "drawable", getPackageName()));
											textview1.setText(getIntent().getStringExtra("head"));
											textview2.setText("إليك بعض الوصفات التقليدية المستخدمة لعلاج الصداع الشديد:\n\n1. أكياس الثلج: ضع أكياس الثلج على منطقة الجبين، حيث تساعد على تحسين الدورة الدموية وتخفيف الصداع الناتج عن ألم الجيوب الأنفية والإجهاد.\n\n2. الاسترخاء: قم بالاسترخاء في مكان هادئ واستنشق ببطء وعميقة. يمكن استخدام تقنيات الصلاة والتأمل واليوغا والاستماع إلى موسيقى هادئة للمساعدة في تخفيف الصداع.\n\n3. الماء الساخن: ضع الماء الساخن على المنطقة السفلية من الرقبة، وذلك بوضعه في كيس، حيث يقلل من الإجهاد ويساعد في تخفيف التوتر العضلي وتحسين الدورة الدموية.\n\n4. الليمون: تناول كوباً من الشاي بالليمون ثلاث مرات في اليوم، ويمكن أيضًا استخدام قشور الليمون المجروشة لعمل عجينة وتطبيقها على الرأس.\n\n5. الروائح: قم بمزج خمس قطرات من زيت الروزماري، وخمس قطرات من زيت جوزة الطيب، وخمس قطرات من زيت اللافندر، وقم بتدليك الزيوت على منطقة الرقبة والظهر العلوي.\n\n6. الزنجبيل: يعتبر الزنجبيل فعالًا في تخفيف الصداع، حيث يحتوي على مواد مضادة للالتهابات ويعزز الدورة الدموية في الدماغ.\n\n7. التفاح: تناول قطعة من التفاح يوميًا، خاصة عند الاستيقاظ من النوم.\n\n8. خل التفاح: ضع ثلاث ملاعق من خل التفاح في وعاء به ماء ساخن، واغمس منشفة في الخليط وضعها على الرأس. يعتقد أنه يقلل من التوتر ويهدئ الصداع.\n\n9. اللوز: تناول اللوز يوميًا، حيث يعتبر بديلاً طبيعيًا لعلاج الصداع ويحتوي على مواد كيميائية تساعد في ذلك.\n\n10. الفلفل الحريف: يعتبر من الوسائل الفعالة للتخلص من الصداع الشديد.\n\n11. النعناع: أضف ملعقة من النعناع الأخضر الجاف إلى كوب من الماء المغلي الساخن، واتركه حتى يبرد لمدة عشر دقائق، ثم أضف ملعقة من العسل، وقم بتدليك منطقة الرقبة بهذا المزيج، حيث يعتبر النعناع مادة مهدئة للأعصاب.\n\n12. زيت الكافور: قم بتدليك الجبين باستخدام زيت الكافور لمدة خمس عشرة دقيقة، حيث يهدئ الألم ويخفف من توتر عضلات الرأس. يمكن إضافة زيوت أخرى مثل زيت اللوز وزيت جوز الهند.\n\nيرجى ملاحظة أنه قد يكون للصداع أسباب مختلفة وأن هذه الوصفات قد تعمل بشكل مختلف على كل شخص. إذا استمر الصداع أو كان شديدًا، يُنصح بالتوجه للطبيب لتقييم الحالة والحصول على العلاج المناسب.");
										}
										else {
											temp++;
											if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
												imageview1.setImageResource(getResources().getIdentifier("img_10", "drawable", getPackageName()));
												textview1.setText(getIntent().getStringExtra("head"));
												textview2.setText("يمكن علاج الصداع بطرق طبيعية في متناول الجميع، ومن هذه الطرق ما يلي:\n1. تناول كميات كافية من الماء لعلاج الجفاف الذي قد يكون سببًا للصداع.\n2. اتخاذ حمام دافئ أو وضع كمادات دافئة عند مؤخرة الرأس، كما يمكن الاعتماد على الحمام البارد أو الكمادات الباردة.\n3. الابتعاد عن التعرض للأشعة الصادرة من الأجهزة الكهربائية مثل الحاسوب والهواتف الذكية.\n4. الابتعاد عن الأطعمة السكرية التي تحتوي على السكر الاصطناعي.\n5. استخدام محلول من بودرة الفلفل الأحمر في الماء، ووضعه على مداخل الأنف بواسطة قطنة مبللة.\n6. استنشاق خل التفاح عن طريق إضافة ثلاث ملاعق منه إلى قدر يحتوي على الماء وتسخينه، ومن ثم استنشاق البخار المتصاعد.\n7. وضع كمادات مبللة بالمحلول المغلي على الجبين والصدغين لمدة ثلث ساعة.\n8. تناول كوب من منقوع الزنجبيل الطازج أو الزنجبيل المجفف.\n9. تناول المشروبات الدافئة مثل شاي النعناع أو اليانسون، وإضافة بضع قطرات من عصير الليمون.\n10. الابتعاد عن مضغ العلكة وتناول العصائر والمثلجات والآيس كريم، والأطعمة الغنية بالملح أو عالية السعرات الحرارية، حيث تزيد من الصداع.\n\nيرجى ملاحظة أن هذه الوصفات هي توصيات عامة وقد تختلف النتائج من شخص لآخر. إذا استمر الصداع أو تفاقمت الأعراض، يُنصح بالتشاور مع الطبيب لتقييم الحالة والحصول على العلاج المناسب.");
											}
											else {
												temp++;
												if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
													imageview1.setImageResource(getResources().getIdentifier("img_11", "drawable", getPackageName()));
													textview1.setText(getIntent().getStringExtra("head"));
													textview2.setText("يُعتبر العلاج الدوائيّ كلٌّ من الراحة ومُسكِّنات الألم من أفضل الطُّرُق لعلاج الصُّداع. ومن الأدوية المُسكِّنة التي يمكن استخدامها لعلاج الصُّداع ما يأتي:\n\n1. الأدوية التي تُصرَف بوصفة طبِّية من الطبيب:\n   - مُضادَات الاكتئاب ثلاثيّة الحلقات (بالإنجليزيّة: Tricyclic antidepressants).\n   - مستقبلات السيروتونين (بالإنجليزيّة: Serotonin receptor agonists).\n   - حاصرات مستقبلات بيتا (بالإنجليزيّة: Beta blockers).\n   - الأدوية المُضادَّة للصرع (بالإنجليزيّة: Anti-epileptic drugs).\n\n2. الأدوية التي لا تحتاج إلى وصفة طبِّية، مثل:\n   - الأسيتامينوفين (بالإنجليزيّة: Acetaminophen).\n   - الإيبوبروفين (بالإنجليزيّة: Ibuprofen).\n\nمن الجدير بالذكر أنَّه يُفضَّل الالتزام بتعليمات الطبيب؛ لتجنُّب الإفراط في استخدام المُسكِّنات التي قد تُؤدِّي إلى الصُّداع الارتداديّ. يتضمَّن علاج الصُّداع الارتداديّ وقف الأدوية المُسكِّنة أو تخفيفها. في بعض الحالات، قد يتَطلب الأمر دخول المستشفى لفترة قصيرة لعلاج انسحاب الدواء من الجسم بفعاليّة وبشكل آمن.\n\nالعلاج المنزليّ يشمل الطُّرُق التالية لتخفيف ألم الصُّداع:\n\n1. استخدام الكمادات الدافئة: يوضع الكمادة على الرقبة أو مؤخرة الرأس لتخفيف صداع التوتر.\n2. الاسترخاء: يشمل التمدُّد، والتأمُّل، واليوغا، أو استرخاء العضلات التدري\n\nجيّ. يُساعد ذلك على تخفيف الصُّداع، خاصة إذا كان هناك تشنجات عضليّة في الرقبة. في حالة وجود تشنجات عضليّة مستمرة، يجب مراجعة الطبيب.\n3. التدليك: يُدلَّك الرقبة لتخفيف صُداع التوتُّر الناتج عن الإجهاد.\n4. تناول بعض الكافيين: تناول الشاي، أو القهوة، أو غيرها من المنتجات التي تحتوي على القليل من الكافيين في بداية الألم يجعل ألم الصُّداع أقل، ولكن يجب تجنُّب الإكثار من الكافيين.\n\nالوقاية من الصُّداع تتضمَّن اتِّباع نظام حياة صحِّي، والحصول على قسطٍ كافٍ من النوم. بعض النصائح والإجراءات للتقليل من فرص الإصابة بالصُّداع تشمل:\n\n1. تجنُّب الأطعمة التي تُؤدِّي إلى إثارة الصُّداع. هذا الأمر يختلف من شخص إلى آخر، فهناك بعض الأطعمة التي تُؤدِّي إلى الصُّداع مثل الشوكولاتة والجبن والبصل وبعض إضافات الطعام ومُشتقَّات الألبان وغيرها.\n2. تجنُّب الإكثار من الكافيين.\n3. الحصول على قسطٍ كافٍ من النوم.\n4. ممارسة التمارين الرياضيّة بشكل منتظم.\n\nيرجى العلم بأنه ينبغي استشارة الطبيب قبل تناول أي دواء أو تجربة أي نصيحة لعلاج الصُّداع، خاصة إذا كان الصُّداع مستمرًا أو مصاحبًا لأعراض شديدة.");
												}
												else {
													temp++;
													if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
														imageview1.setImageResource(getResources().getIdentifier("img_12", "drawable", getPackageName()));
														textview1.setText(getIntent().getStringExtra("head"));
														textview2.setText("هناك عدة إرشادات وعلاجات منزلية طبيعية يمكن اتباعها للتغلب على الصداع دون الحاجة لتناول الأدوية. وفيما يلي توضيح لأبرز هذه الإرشادات والعلاجات:\n\n1. شرب كميات كبيرة من الماء: الجفاف المزمن يمكن أن يكون سببًا شائعًا للصداع، وتناول الماء يمكن أن يساهم في تخفيف أعراض الصداع خلال فترة زمنية قصيرة. لذلك، يُنصح بشرب كميات كافية من الماء وتناول الأطعمة الغنية بالماء للوقاية من الصداع.\n\n2. تجنب تناول الكحول: تناول الكحول يمكن أن يثير الصداع النصفي لدى بعض الأشخاص، حيث يؤدي إلى توسع الأوعية الدموية وزيادة تدفق الدم، مما يسبب الصداع. كما أنه يسبب فقدان السوائل والجفاف، مما يزيد من فرص حدوث الصداع أو تفاقمه.\n\n3. الحصول على قسط كافٍ من النوم: ينصح بالحصول على نوم كافٍ ومنتظم، حيث إن عدم الحصول على نوم كافٍ قد يكون سببًا في حدوث الصداع.\n\n4. تجنب الأطعمة الغنية بالهستامين: بعض الدراسات تشير إلى أن تناول الأطعمة الغنية بالهستامين يمكن أن يسبب الصداع النصفي لدى بعض الأشخاص. من الأمثلة على هذه الأطعمة: الأجبان المعتقة، والأطعمة المخمرة، والأسماك المدخنة، واللحوم المعالجة.\n\n5. استخدام الزيوت العطرية: بعض الزيوت العطرية مثل زيت النعناع وزيت اللافندر يمكن أن تساعد في تخفيف أعراض الصداع.\n\n6. استخدام الكمادات");
													}
													else {
														temp++;
														if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
															imageview1.setImageResource(getResources().getIdentifier("img_13", "drawable", getPackageName()));
															textview1.setText(getIntent().getStringExtra("head"));
															textview2.setText("بعض طرق علاج الصداع تشمل:\n\n1. تناول الأغذية الغنية بالمعادن والفيتامينات والألياف.\n2. تحقيق التوازن في تناول الأطعمة المحتوية على اللحوم الحمراء.\n3. شرب كمية كافية من الماء والعصائر الطبيعية خلال اليوم.\n4. تجنب التعرض لأشعة الشمس لفترة طويلة.\n5. الحصول على قسط كافٍ من الراحة والهدوء بعد يوم شاق ومتعب.\n6. تجنب الجلوس لفترات طويلة أمام شاشات الحاسوب والحصول على قسط من الراحة بين الحين والآخر إذا كان العمل يتطلب ذلك.\n7. تناول عصير الحمضيات البارد.\n8. تناول كمية صغيرة من أوراق النعناع الطازج، حيث تساعد في تخفيف الصداع وتطهير الفم من الروائح الكريهة.\n9. الابتعاد عن المشروبات التي تحتوي على الكافيين.\n10. وضع أكياس الثلج على منطقة الجبين والرقبة للتخلص السريع من الصداع.\n11. محاولة الاسترخاء لمدة قصيرة لا تقل عن عشرين دقيقة في مكان مظلم وهادئ.\n12. التنفس بشكل عميق للتخلص من التوتر والقلق وتخفيف الصداع.\n13. تناول شرائح الليمون بقشرتها، حيث تعتبر مادة فعالة وقوية في علاج الصداع.\n14. تناول كأس من اليانسون الساخن.\n15. استنشاق باقة صغيرة من النعناع عدة مرات، ويمكن أيضًا استنشاق قشور الليمون والبرتقال.\n16. تدليك منطقة الرأس بقليل من زيت البابونج بحركات دائرية لمدة خمس دقائق.\n17. الضغط على المنطقة بين العينين وأعلى الأنف.\n18. الضغط على المنطقة بين الإبهام والسبابة.\n\nمن الأهمية أن يتم استشارة الطبيب قبل تجربة أي طرق علاج للصداع لضمان السلامة والفعالية المناسبة.");
														}
														else {
															temp++;
															if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
																imageview1.setImageResource(getResources().getIdentifier("img_14", "drawable", getPackageName()));
																textview1.setText(getIntent().getStringExtra("head"));
																textview2.setText("تُعَدّ الشَقيقة أو الصداع النصفي اضطرابًا معقّدًا يتميز بتكرار نوبات صداع مؤلمة، تحدث عادةً في جانب واحد من الرأس. يمكن أن ترافق هذه النوبات عدة أعراض، مثل الغثيان والتقيؤ واضطرابات الرؤية، بالإضافة إلى الحساسية المفرطة للأصوات والضوء. قد تستمر هذه النوبات لفترة تتراوح بين 4 ساعات و3 أيام، وقد تتكرر عدة مرات في الأسبوع لبعض الأشخاص، في حين يمكن أن تحدث مرة كل بضع سنوات لدى آخرين. يُعتبر الشقيقة أكثر شيوعًا لدى النساء ويمكن التحكم فيها عادةً من خلال العلاج المناسب.\n\nبعض المصابين بالشقيقة يلاحظون ظهور علامات مبكرة قبل حدوث النوبة أو أثناء حدوثها، وتُعرف هذه العلامات بالهالة. قد تتمثل الهالة في اضطرابات بصرية مثل رؤية بقع معتمة أو ومضات ضوئية، وقد تشمل أيضًا اضطرابات أخرى مثل صعوبة التحدث أو الشعور بالوخز أو التنميل في جهة واحدة من الوجه أو اليد أو الساق. \n\nوفقًا لمنظمة الصحة العالمية، يعاني حوالي 10% من سكان العالم من اضطراب الشقيقة. يحدث الصداع النصفي عادةً في الصباح عندما يستيقظ الشخص، ويمكن لبعض الأشخاص توقع الأوقات التي قد تحدث فيها نوبات الشقيقة، مثل قبل الدورة الشهرية أو بعد مجهود بدني. ");
															}
															else {
																temp++;
																if (getIntent().getStringExtra("number").equals(String.valueOf((long)(temp)))) {
																	imageview1.setImageResource(getResources().getIdentifier("img_15", "drawable", getPackageName()));
																	textview1.setText(getIntent().getStringExtra("head"));
																	textview2.setText("يهدف علاج الشقيقة إلى إيقاف أعراض المرض ومنع تكرار حدوث نوباته في المستقبل، ويعتمد اختيار العلاج المناسب على عدة عوامل تتضمن:\n\n1. الأدوية المسكنة للألم: تصمم لإيقاف أعراض الشقيقة، ويمكن تناول أدوية تسكين الألم خلال نوبة الصداع.\n\n2. الأدوية الوقائية: تستخدم للتقليل من عدد النوبات أو شدتها، وغالبًا ما يتم استخدامها بشكل يومي.\n\nالأدوية المسكنة للنوبة تستخدم لتخفيف آلام الشقيقة والأعراض المرافقة لها، ويتضمن العلاج الدوائي للشقيقة:\n\n- مسكنات الألم: مثل الآيبوبروفين (Ibuprofen) والباراسيتامول (Paracetamol)، وينصح بتناولها في بداية التعرض للنوبة.\n\n- التريبتانات (Triptans): تستخدم في حالة عدم فعالية مسكنات الألم في تخفيف أعراض الشقيقة. تعتبر التريبتانات أدوية خاصة تخفف وتسكن ألم الشقيقة.\n\n- مضادات القيء (Anti-emetics): يمكن أن يصف الطبيب مضادات القيء إلى جانب مسكنات الألم أو التريبتانات في الحالات التي تكون نوبات الشقيقة مصحوبة بالشعور بالغثيان.\n\n- أدوية أخرى: تشمل الأدوية الأفيونية (Opioid medication) وثنائي هيدروإرغوتامين (Dihydroergotamines) ولاسميتيدان (Lasmiditan). تُصف عادةً في حال عدم فعالية الأدوية الأخرى أو عدم قدرة المريض على تناولها.\n\nيجب استشارة الطبيب قبل تناول أي علاج للشقيقة، ومن الأهمية بمكان اتباع توجيهات الطبيب وتعديل الجرعات وفقًا لتوصياته.");
																}
																else {
																	imageview1.setImageResource(getResources().getIdentifier("img_16", "drawable", getPackageName()));
																	textview1.setText(getIntent().getStringExtra("head"));
																	textview2.setText("نصائح خاصة بالنساء خلال فترة الحمل والرضاعة:\n1. استشارة الطبيب: يُنصح النساء المرضعات والحوامل واللواتي يخططن للحمل بمراجعة الطبيب في حالة معاناتهن من الشقيقة. يمكن للطبيب وصف الدواء الآمن والمناسب لكل حالة، حيث يمكن أن تتسبب بعض الأدوية المستخدمة في علاج الشقيقة مثل الأسبرين والآيبوبروفين في حدوث مشاكل وعيوب خلقية للجنين خلال فترة الحمل. كما يمكن أن تصل بعض الأدوية عبر حليب الأم المرضع إلى الرضيع وتسبب مشاكل له.\n2. الاسترخاء والكمادات الباردة: يُنصح الحوامل بممارسة تمارين الاسترخاء واستخدام الكمادات الباردة التي قد تساهم في تخفيف ألم الصداع. قد يحدث تحسن أعراض الشقيقة لدى السيدات الحوامل أو تتوقف تقريبًا ابتداءً من الشهر الثالث من الحمل.\n3. حبوب منع الحمل: يمكن أن يلاحظ بعض النساء اللاتي يستخدمن حبوب منع الحمل زيادة في شدة نوبة الشقيقة. في هذه الحالات، تحدث نوبة الصداع خلال الأسبوع الأخير من الدورة الشهرية. ينصح السيدات بهذه الحالة بمراجعة الطبيب لاتخاذ الإجراء المناسب.\n4. تغيير نمط الحياة: يمكن أن يُحسن تناول غذاء صحي والحصول على ساعات كافية من النوم من الشقيقة. قد يشعر بعض السيدات بانخفاض عدد وشدة النوبات بينما قد لا يتأثر الصداع لدى البعض الآخر بهذه الحبوب على الإطلاق.\n \nمهم جداً أن تتذكري أنه من الضروري استشارة الطبيب قبل تطبيق أي نصائح أو تغيير في العلاج أو النظام الغذائي أثناء فترة الحمل أو الرضاعة.");
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
					}
				}
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setClass(getApplicationContext(), StartActivity.class);
		startActivity(intent);
		finish();
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