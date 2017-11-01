package com.andyqin.framework.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qinbaoyuan on 2017/10/25.
 *
 */
public class RecyclerViewItemModel<T> {
    public T model;
    public Class itemViewClass;
    public Class viewHolder;
    public int viewType;
    private View itemView = null;
    private Context context;

    public RecyclerView.ViewHolder generateViewHolder() {
        View view = new View(context);
        return new BaseViewHolder(view);
    }

    public void onBind(){
        if(itemView!=null){
            //
        }
    }
}
