package com.andy.base.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by qinbaoyuan on 2017/10/26.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private BaseItemModel itemModel;

    public BaseViewHolder(View itemView, BaseItemModel model) {
        super(itemView);
        this.itemModel = model;
    }

    public void bindData() {
        if (itemModel != null) {
            itemModel.onBind(itemView);
        }
    }
}
