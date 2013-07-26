android_tabView
===============

like ios UITabView，you can add your item;



your can use it easy.




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
  
2.use adapter mode


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
