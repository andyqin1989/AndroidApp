package com.andyqin.app.home.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andyqin.app.business.OverTimeDetailActivity;
import com.andyqin.app.home.view.HomeItemView;
import com.andy.base.recycler.BaseItemModel;
import com.andy.base.recycler.BaseViewHolder;
import com.andyqin.app.model.User;
import com.andyqin.framework.network.OnServiceListener;
import com.andyqin.framework.network.volley.ServiceManagerImpl;

import java.util.List;

/**
 * Created by qinbaoyuan on 2017/11/6.
 * 首页列表ItemModel
 */

public class HomeItemModel<T> extends BaseItemModel implements View.OnClickListener {
    public HomeItemModel(Context context) {
        super(context);
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder generateViewHolder() {
        HomeItemView itemView = new HomeItemView(context);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new BaseViewHolder(itemView, this);
    }

    @Override
    public void onBind(View itemView) {
        ((HomeItemView) itemView).setClickListener(this);
        ((HomeItemView) itemView).update((String) data);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "打开加班记录页", Toast.LENGTH_LONG).show();
        context.startActivity(new Intent(context, OverTimeDetailActivity.class));
        //getUserList();

    }

    @SuppressWarnings("unchecked")
    private void getUserList() {
//        ServiceManagerImpl.getInstance().load("http://123.57.242.138:8080/userserver/api/getUsers",
//                User.AllUser.class, new OnServiceListener<User.AllUser>() {
//                    @Override
//                    public void OnServerSuccess(User.AllUser response, String token) {
//                        if (response != null) {
//                            List<User> userList = response.allUser;
//
//                        }
//                    }
//                });
    }
}
