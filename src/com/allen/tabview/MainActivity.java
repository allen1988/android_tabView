package com.allen.tabview;

import java.util.ArrayList;
import java.util.List;

import com.allen.tabview.TabView.TabItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TabView tabView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabView = (TabView) findViewById(R.id.tabview);
		List<String> list = new ArrayList<String>();
		list.add("��������");
		list.add("�������");
		list.add("Ӧ���Ƽ�");
		list.add("�������");
		list.add("�汾����");
		tabView.setAdapter(new MyTabAdapter(this, list));
		tabView.setOnItemClickListener(new TabItemClickListener() {

			@Override
			public void onClick(int position, View v) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					Toast.makeText(MainActivity.this, "��������_item" + position, 0)
							.show();
					break;
				case 1:
					Toast.makeText(MainActivity.this, "�������_item" + position, 0)
							.show();
					break;
				case 2:
					Toast.makeText(MainActivity.this, "Ӧ���Ƽ�_item" + position, 0)
							.show();
					break;
				case 3:
					Toast.makeText(MainActivity.this, "�������_item" + position, 0)
							.show();
					break;
				case 4:
					Toast.makeText(MainActivity.this, "�汾����_item" + position, 0)
							.show();
					break;
				}
			}
		});
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
