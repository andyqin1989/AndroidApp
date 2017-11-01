package com.andyqin.framework.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by qinbaoyuan on 2017/10/25.
 */
public class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private BaseAdapterModel adapterModel;

    public BaseRecyclerAdapter(BaseAdapterModel adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return adapterModel.generateViewHolder(viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        new RecyclerView.ViewHolder(adapterModel.)
    }

    @Override
    public int getItemCount() {
        return adapterModel.getItemCount();
    }
}
