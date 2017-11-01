package com.andyqin.framework.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qinbaoyuan on 2017/10/25.
 * xxx
 */
public class BaseAdapterModel {
    private List<RecyclerViewItemModel> viewItemModels = new ArrayList<>();
    private Map<Integer, RecyclerView.ViewHolder> holderMap = new HashMap<>();

    public int getViewType(int position) {
        return viewItemModels.get(position).viewType;
    }

    public int getItemCount() {
        return viewItemModels.size();
    }

    public void addItem(RecyclerViewItemModel model) {
        viewItemModels.add(model);
        holderMap.put(model.viewType, model.viewHolder);
    }

    public RecyclerView.ViewHolder generateViewHolder(int viewType) {
        Class holderClass = holderMap.get(viewType);
        RecyclerView.ViewHolder holder = null;
        return holder;
    }
}
