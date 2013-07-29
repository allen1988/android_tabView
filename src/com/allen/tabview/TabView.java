package com.allen.tabview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @package：com.allen.tabview
 * @author：Allen
 * @email：jaylong1302@163.com
 * @data：2013-7-26 下午2:48:36
 * @description：圆角表格
 */
public class TabView extends LinearLayout {

	TabAdapter adapter;
	/** 子视图数量 */
	int size = 0;

	public TabView(Context context) {
		super(context);
		init();
	}

	public TabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	void init() {
		this.setOrientation(LinearLayout.VERTICAL);
		this.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
		this.setBackgroundResource(R.drawable.background_view_rounded_container);
	}

	/** 设置适配器 */
	public void setAdapter(TabAdapter adapter) {
		this.adapter = adapter;
		// 遍历当前的adapter
		if (adapter != null) {
			size = adapter.getCount();
			for (int i = 0; i < size; i++) {
				View child = adapter.getView(i);
				this.addView(child);
			}
			commit();
		}

	}

	@Override
	public void addView(View child) {
		// TODO Auto-generated method stub
		super.addView(child);
		child.setClickable(true);
	}

	/** 调用addView之后执行的方法 */
	public void commit() {
		int len = this.getChildCount();
		if (len > 1) {// 多项内容
			for (int i = 0; i < len; i++) {
				View child = this.getChildAt(i);
				if (i == 0) {// 顶部
					child.setBackgroundResource(R.drawable.background_view_rounded_top);
				} else if (i > 0 && i < len - 1) {// 中间
					child.setBackgroundResource(R.drawable.background_view_rounded_middle);
				} else if (i == len - 1) {// 底部
					child.setBackgroundResource(R.drawable.background_view_rounded_bottom);
				}
			}
		} else if (len == 1) {// 一项内容
			View child = this.getChildAt(0);
			child.setBackgroundResource(R.drawable.background_view_rounded_single);
		}
	}

	public interface TabItemClickListener {
		void onClick(int position, View v);
	}

	TabItemClickListener itemClick;

	public void setOnItemClickListener(final TabItemClickListener itemClick) {
		this.itemClick = itemClick;
		// 绑定监听事件
		for (int i = 0; i < size; i++) {
			final int index = i;
			View childView = this.getChildAt(i);
			childView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (itemClick != null) {
						itemClick.onClick(index, v);
					}
				}
			});
		}
	}
}
