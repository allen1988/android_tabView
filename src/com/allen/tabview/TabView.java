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
			if (size > 1) {// 多项内容
				for (int i = 0; i < size; i++) {
					View child = adapter.getView(i);
					if (i == 0) {// 顶部
						child.setBackgroundResource(R.drawable.background_view_rounded_top);
						this.addView(child);
					} else if (i > 0 && i < size - 1) {// 中间
						child.setBackgroundResource(R.drawable.background_view_rounded_middle);
						this.addView(child);
					} else if (i == size - 1) {// 底部
						child.setBackgroundResource(R.drawable.background_view_rounded_bottom);
						this.addView(child);
					}

				}
			} else if (size == 1) {// 一项内容
				View child = adapter.getView(0);
				child.setBackgroundResource(R.drawable.background_view_rounded_single);
				this.addView(child);
			}
		}

	}

	public interface TabItemClickListener {
		void onClick(int position,View v);
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
						itemClick.onClick(index,v);
					}
				}
			});
		}
	}
}
