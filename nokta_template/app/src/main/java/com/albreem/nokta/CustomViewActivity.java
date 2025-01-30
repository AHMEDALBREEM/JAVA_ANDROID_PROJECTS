package com.albreem.nokta;

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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class CustomViewActivity extends Activity {
	
	private String b = "";
	
	private ArrayList<HashMap<String, Object>> ns = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear5;
	private TextView textview2;
	private ListView text;
	private ListView photo;
	private ListView video;
	
	private Intent jch = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.custom_view);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		textview2 = findViewById(R.id.textview2);
		text = findViewById(R.id.text);
		photo = findViewById(R.id.photo);
		video = findViewById(R.id.video);
	}
	
	private void initializeLogic() {
		textview2.setText(getIntent().getStringExtra("text"));
		if (Build.VERSION.SDK_INT >= 21) { Window
			w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor("#FB8C00")); }
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
		_effect(text, 40, 40, "#FB8C00");
		_effect(photo, 40, 40, "#FB8C00");
		_effect(video, 40, 40, "#FB8C00");
		photo.setVisibility(View.GONE);
		text.setVisibility(View.GONE);
		video.setVisibility(View.GONE);
		if (getIntent().getStringExtra("text").equals("نكت فلسطينية 🇵🇸")) {
			ns.clear();
			
			if (getIntent().getStringExtra("a").equals("a")) {
				try{
					java.io.InputStream inputstream1 = getAssets().open("8_text.json");
					ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					text.setVisibility(View.VISIBLE);
					text.setAdapter(new TextAdapter(ns));
					((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
				} catch (Exception e) {
					    
				}
			}
			else {
				if (getIntent().getStringExtra("a").equals("b")) {
					try{
						java.io.InputStream inputstream1 = getAssets().open("8_photo.json");
						ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						photo.setVisibility(View.VISIBLE);
						photo.setAdapter(new PhotoAdapter(ns));
						((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
					} catch (Exception e) {
						    
					}
				}
				else {
					try {
						java.io.InputStream inputstream1 = getAssets().open("8_video.json");
						ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						video.setVisibility(View.VISIBLE);
						video.setAdapter(new VideoAdapter(ns));
						((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
					} catch (Exception e) {
						    
					}
				}
			}
		}
		else {
			if (getIntent().getStringExtra("text").equals("نكت مصرية 🇪🇬")) {
				ns.clear();
				
				if (getIntent().getStringExtra("a").equals("a")) {
					try{
						text.setVisibility(View.VISIBLE);
						java.io.InputStream inputstream1 = getAssets().open("9_text.json");
						ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						text.setAdapter(new TextAdapter(ns));
						((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
					} catch (Exception e) {
						    
					}
				}
				else {
					if (getIntent().getStringExtra("a").equals("b")) {
						try {
							java.io.InputStream inputstream1 = getAssets().open("9_photo.json");
							photo.setVisibility(View.VISIBLE);
							ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							photo.setAdapter(new PhotoAdapter(ns));
							((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
						} catch (Exception e) {
							    
						}
					}
					else {
						try{
							java.io.InputStream inputstream1 = getAssets().open("9_video.json");
							ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							video.setVisibility(View.VISIBLE);
							video.setAdapter(new VideoAdapter(ns));
							((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
						} catch (Exception e) {
							    
						}
					}
				}
			}
			else {
				if (getIntent().getStringExtra("text").equals("نكت ليبية 🇱🇾")) {
					ns.clear();
					
					if (getIntent().getStringExtra("a").equals("a")) {
						try{
							java.io.InputStream inputstream1 = getAssets().open("5_text.json");
							ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							text.setAdapter(new TextAdapter(ns));
							text.setVisibility(View.VISIBLE);
							((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
						} catch (Exception e) {
							    
						}
					}
					else {
						if (getIntent().getStringExtra("a").equals("b")) {
							try{
								java.io.InputStream inputstream1 = getAssets().open("5_photo.json");
								ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
								photo.setAdapter(new PhotoAdapter(ns));
								photo.setVisibility(View.VISIBLE);
								((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
							} catch (Exception e) {
								    
							}
						}
						else {
							try{
								java.io.InputStream inputstream1 = getAssets().open("5_video.json");
								ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
								video.setVisibility(View.VISIBLE);
								video.setAdapter(new VideoAdapter(ns));
								((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
							} catch (Exception e) {
								    
							}
						}
					}
				}
				else {
					if (getIntent().getStringExtra("text").equals("نكت جزائرية 🇩🇿")) {
						ns.clear();
						
						if (getIntent().getStringExtra("a").equals("a")) {
							try{
								java.io.InputStream inputstream1 = getAssets().open("7_text.json");
								ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
								text.setVisibility(View.VISIBLE);
								text.setAdapter(new TextAdapter(ns));
								((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
							} catch (Exception e) {
								    
							}
						}
						else {
							if (getIntent().getStringExtra("a").equals("b")) {
								try{
									java.io.InputStream inputstream1 = getAssets().open("7_photo.json");
									ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
									photo.setVisibility(View.VISIBLE);
									photo.setAdapter(new PhotoAdapter(ns));
									((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
								} catch (Exception e) {
									    
								}
							}
							else {
								try{
									java.io.InputStream inputstream1 = getAssets().open("7_video.json");
									ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
									video.setVisibility(View.VISIBLE);
									video.setAdapter(new VideoAdapter(ns));
									((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
								} catch (Exception e) {
									    
								}
							}
						}
					}
					else {
						if (getIntent().getStringExtra("text").equals("نكت خليجية 🇰🇼🇶🇦")) {
							ns.clear();
							
							if (getIntent().getStringExtra("a").equals("a")) {
								try{
									java.io.InputStream inputstream1 = getAssets().open("6_text.json");
									ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
									text.setVisibility(View.VISIBLE);
									text.setAdapter(new TextAdapter(ns));
									((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
								} catch (Exception e) {
									    
								}
							}
							else {
								if (getIntent().getStringExtra("a").equals("b")) {
									try{
										java.io.InputStream inputstream1 = getAssets().open("6_photo.json");
										ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
										photo.setVisibility(View.VISIBLE);
										photo.setAdapter(new PhotoAdapter(ns));
										((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
									} catch (Exception e) {
										    
									}
								}
								else {
									try{
										java.io.InputStream inputstream1 = getAssets().open("6_video.json");
										ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
										video.setVisibility(View.VISIBLE);
										video.setAdapter(new VideoAdapter(ns));
										((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
									} catch (Exception e) {
										    
									}
								}
							}
						}
						else {
							if (getIntent().getStringExtra("text").equals("نكت مغربية 🇲🇦")) {
								ns.clear();
								
								if (getIntent().getStringExtra("a").equals("a")) {
									try{
										java.io.InputStream inputstream1 = getAssets().open("1_text.json");
										ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
										text.setVisibility(View.VISIBLE);
										text.setAdapter(new TextAdapter(ns));
										((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
									} catch (Exception e) {
										    
									}
								}
								else {
									if (getIntent().getStringExtra("a").equals("b")) {
										try{
											java.io.InputStream inputstream1 = getAssets().open("1_photo.json");
											photo.setVisibility(View.VISIBLE);
											ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
											photo.setAdapter(new PhotoAdapter(ns));
											((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
										} catch (Exception e) {
											    
										}
									}
									else {
										try{
											java.io.InputStream inputstream1 = getAssets().open("1_video.json");
											ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
											video.setVisibility(View.VISIBLE);
											video.setAdapter(new VideoAdapter(ns));
											((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
										} catch (Exception e) {
											    
										}
									}
								}
							}
							else {
								if (getIntent().getStringExtra("text").equals("نكت  الأردنية 🇯🇴")) {
									ns.clear();
									
									if (getIntent().getStringExtra("a").equals("a")) {
										try{
											java.io.InputStream inputstream1 = getAssets().open("2_text.json");
											ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
											text.setVisibility(View.VISIBLE);
											text.setAdapter(new TextAdapter(ns));
											((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
										} catch (Exception e) {
											    
										}
									}
									else {
										if (getIntent().getStringExtra("a").equals("b")) {
											try{
												java.io.InputStream inputstream1 = getAssets().open("2_photo.json");
												ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
												photo.setVisibility(View.VISIBLE);
												photo.setAdapter(new PhotoAdapter(ns));
												((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
											} catch (Exception e) {
												    
											}
										}
										else {
											try{
												java.io.InputStream inputstream1 = getAssets().open("2_video.json");
												ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
												video.setVisibility(View.VISIBLE);
												video.setAdapter(new VideoAdapter(ns));
												((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
											} catch (Exception e) {
												    
											}
										}
									}
								}
								else {
									if (getIntent().getStringExtra("text").equals("نكت سورية 🇸🇾")) {
										ns.clear();
										
										if (getIntent().getStringExtra("a").equals("a")) {
											try{
												java.io.InputStream inputstream1 = getAssets().open("3_text.json");
												ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
												text.setVisibility(View.VISIBLE);
												text.setAdapter(new TextAdapter(ns));
												((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
											} catch (Exception e) {
												    
											}
										}
										else {
											if (getIntent().getStringExtra("a").equals("b")) {
												try{
													java.io.InputStream inputstream1 = getAssets().open("3_photo.json");
													ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
													photo.setVisibility(View.VISIBLE);
													photo.setAdapter(new PhotoAdapter(ns));
													((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
												} catch (Exception e) {
													    
												}
											}
											else {
												try{
													java.io.InputStream inputstream1 = getAssets().open("3_video.json");
													ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
													video.setVisibility(View.VISIBLE);
													video.setAdapter(new VideoAdapter(ns));
													((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
												} catch (Exception e) {
													    
												}
											}
										}
									}
									else {
										ns.clear();
										
										if (getIntent().getStringExtra("a").equals("a")) {
											try{
												java.io.InputStream inputstream1 = getAssets().open("4_text.json");
												text.setVisibility(View.VISIBLE);
												ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
												text.setAdapter(new TextAdapter(ns));
												((BaseAdapter)text.getAdapter()).notifyDataSetChanged();
											} catch (Exception e) {
												    
											}
										}
										else {
											if (getIntent().getStringExtra("a").equals("b")) {
												try{
													java.io.InputStream inputstream1 = getAssets().open("4_photo.json");
													ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
													photo.setVisibility(View.VISIBLE);
													photo.setAdapter(new PhotoAdapter(ns));
													((BaseAdapter)photo.getAdapter()).notifyDataSetChanged();
												} catch (Exception e) {
													    
												}
											}
											else {
												try{
													java.io.InputStream inputstream1 = getAssets().open("4_video.json");
													ns = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
													video.setVisibility(View.VISIBLE);
													video.setAdapter(new VideoAdapter(ns));
													((BaseAdapter)video.getAdapter()).notifyDataSetChanged();
												} catch (Exception e) {
													    
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
		jch.setClass(getApplicationContext(), OptionaActivity.class);
		jch.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		jch.putExtra("a", getIntent().getStringExtra("a"));
		startActivity(jch);
		finish();
	}
	public void _effect(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		
		
		ab.setColor(Color.parseColor(_color));
		
		ab.setCornerRadius((float) _radius);
		
		_view.setElevation((float) _shadow);
		
		_view.setBackground(ab);
	}
	
	public class TextAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public TextAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.text, null);
			}
			
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView share_text = _view.findViewById(R.id.share_text);
			final TextView text = _view.findViewById(R.id.text);
			
			Animation animation;
			        animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
			        animation.setDuration(500);
			        linear5.startAnimation(animation);
			        animation = null;
			share_text.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					b = ns.get((int)_position).get("text").toString();
					Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND); sendIntent.putExtra(Intent.EXTRA_TEXT,b); sendIntent.setType("text/plain"); Intent shareIntent = Intent.createChooser(sendIntent,null); startActivity(shareIntent);
				}
			});
			text.setText(ns.get((int)_position).get("text").toString());
			text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
			
			return _view;
		}
	}
	
	public class PhotoAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public PhotoAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.text_photo, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView imageview = _view.findViewById(R.id.imageview);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			Animation animation;
			        animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
			        animation.setDuration(500);
			        linear1.startAnimation(animation);
			        animation = null;
			Glide.with(getApplicationContext()).load(Uri.parse(ns.get((int)_position).get("link").toString())).into(imageview);
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					b = ns.get((int)_position).get("link").toString();
					Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND); sendIntent.putExtra(Intent.EXTRA_TEXT,b); sendIntent.setType("text/plain"); Intent shareIntent = Intent.createChooser(sendIntent,null); startActivity(shareIntent);
				}
			});
			
			return _view;
		}
	}
	
	public class VideoAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public VideoAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.text_video, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final ImageView share_video = _view.findViewById(R.id.share_video);
			final ImageView view_videi = _view.findViewById(R.id.view_videi);
			final TextView key = _view.findViewById(R.id.key);
			
			Animation animation;
			        animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
			        animation.setDuration(500);
			        linear1.startAnimation(animation);
			        animation = null;
			key.setText(ns.get((int)_position).get("key").toString());
			key.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ggg.ttf"), 1);
			view_videi.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					jch.setAction(Intent.ACTION_VIEW);
					jch.setData(Uri.parse(ns.get((int)_position).get("link").toString()));
					startActivity(jch);
				}
			});
			share_video.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					b = ns.get((int)_position).get("link").toString();
					Intent sendIntent = new Intent(); sendIntent.setAction(Intent.ACTION_SEND); sendIntent.putExtra(Intent.EXTRA_TEXT,b); sendIntent.setType("text/plain"); Intent shareIntent = Intent.createChooser(sendIntent,null); startActivity(shareIntent);
				}
			});
			
			return _view;
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