package com.andyqin.framework.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qinbaoyuan on 2017/10/26.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private RecyclerViewItemModel itemModel;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData() {

    }
}
