package com.andyqin.app.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andyqin.app.R;
import com.andyqin.app.home.model.HomeItemModel;
import com.andy.base.recycler.BaseAdapterModel;
import com.andy.base.recycler.BaseRecyclerAdapter;

/**
 * Created by qinbaoyuan on 2017/10/24.
 * 首页
 */
public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BaseAdapterModel adapterModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initRecyclerView();
        addData();
    }

    private void initRecyclerView() {
        adapterModel = new BaseAdapterModel();
        recyclerView = findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        recyclerView.setAdapter(new BaseRecyclerAdapter(adapterModel));
    }

    private void addData() {
        HomeItemModel<String> model = new HomeItemModel(HomeActivity.this);
        model.setData("加班记录");
        adapterModel.addItem(model);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
