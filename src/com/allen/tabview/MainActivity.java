package com.allen.tabview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.tabview.TabView.TabItemClickListener;

public class MainActivity extends Activity {

	TabView tabView;
	TabView tabView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabView = (TabView) findViewById(R.id.tabview);
		List<String> list = new ArrayList<String>();
		list.add("关于我们");
		list.add("意见反馈");
		list.add("应用推荐");
		list.add("清除缓存");
		list.add("版本更新");
		tabView.setAdapter(new MyTabAdapter(this, list));
		tabView.setOnItemClickListener(new TabItemClickListener() {

			@Override
			public void onClick(int position, View v) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					Toast.makeText(MainActivity.this, "关于我们_item" + position, 0)
							.show();
					break;
				case 1:
					Toast.makeText(MainActivity.this, "意见反馈_item" + position, 0)
							.show();
					break;
				case 2:
					Toast.makeText(MainActivity.this, "应用推荐_item" + position, 0)
							.show();
					break;
				case 3:
					Toast.makeText(MainActivity.this, "清除缓存_item" + position, 0)
							.show();
					break;
				case 4:
					Toast.makeText(MainActivity.this, "版本更新_item" + position, 0)
							.show();
					break;
				}
			}
		});
		init2();
	}

	void init2() {
		tabView2 = (TabView) findViewById(R.id.tabview2);
		View view = LayoutInflater.from(this).inflate(R.layout.item, null);
		TextView tv = (TextView) view.findViewById(R.id.tv);
		tv.setText("中国上海");
		tabView2.addView(view);

		final View view2 = LayoutInflater.from(this).inflate(R.layout.item2,
				null);
		view2.findViewById(R.id.imageView1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(
								MainActivity.this,
								((TextView) view2.findViewById(R.id.tv))
										.getText(), 0).show();
					}
				});
		tabView2.addView(view2);
		tabView2.commit();// 必须调用，否则没有点击效果
	}

	class MyTabAdapter extends TabAdapter {

		Context context;
		List<String> list;

		public MyTabAdapter(Context context, List<String> list) {
			// TODO Auto-generated constructor stub
			this.context = context;
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public View getView(int position) {
			// TODO Auto-generated method stub
			View view = LayoutInflater.from(context).inflate(R.layout.item,
					null);
			TextView tv = (TextView) view.findViewById(R.id.tv);
			tv.setText(list.get(position));
			return view;
		}

	}

}
