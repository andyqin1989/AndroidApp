package com.andy.base.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qinbaoyuan on 2017/10/25.
 * 列表Item数据基类
 */
public abstract class BaseItemModel<T> {
    public final static int TYPE_DEFAULT = 0x00;
    public T data;
    public int viewType = TYPE_DEFAULT;
    protected Context context;

    public BaseItemModel(Context context) {
        this.context = context;
    }

    public abstract RecyclerView.ViewHolder generateViewHolder();

    public abstract void onBind(View itemView);
}
