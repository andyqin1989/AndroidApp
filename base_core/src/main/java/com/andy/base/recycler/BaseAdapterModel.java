package com.andy.base.recycler;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbaoyuan on 2017/10/25.
 * xxx
 */
public class BaseAdapterModel {
    private List<BaseItemModel> viewItemModels = new ArrayList<>();

    public int getViewType(int position) {
        return viewItemModels.get(position).viewType;
    }

    public int getItemCount() {
        return viewItemModels.size();
    }

    public void addItem(BaseItemModel model) {
        viewItemModels.add(model);
    }

    public RecyclerView.ViewHolder generateViewHolder(int viewType) {
        BaseItemModel itemModel = null;
        for (BaseItemModel model : viewItemModels) {
            if (model.viewType == viewType) {
                itemModel = model;
            }
        }
        return itemModel == null ? null : itemModel.generateViewHolder();
    }
}
