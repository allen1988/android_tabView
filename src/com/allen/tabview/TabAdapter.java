package com.allen.tabview;

import android.view.View;

/**
 * @package��com.allen.tabview
 * @author��Allen
 * @email��jaylong1302@163.com
 * @data��2013-7-26 ����2:49:51
 * @description��������
 */
public abstract class TabAdapter {
      public abstract int getCount();
      public abstract Object getItem(int position);
      public abstract View getView(int position);
}
