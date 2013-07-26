package com.allen.tabview;

import android.view.View;

/**
 * @package£ºcom.allen.tabview
 * @author£ºAllen
 * @email£ºjaylong1302@163.com
 * @data£º2013-7-26 ÏÂÎç2:49:51
 * @description£ºÊÊÅäÆ÷
 */
public abstract class TabAdapter {
      public abstract int getCount();
      public abstract Object getItem(int position);
      public abstract View getView(int position);
}
