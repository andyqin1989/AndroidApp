package com.andyqin.app.home.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andyqin.app.R;

/**
 * Created by qinbaoyuan on 2017/11/6.
 * 首页列表视图
 */
public class HomeItemView extends LinearLayout {
    private TextView itemTxt;

    public HomeItemView(Context context) {
        this(context, null);
    }

    public HomeItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.view_home_item, this);
        itemTxt = findViewById(R.id.txt_home_item);
    }

    public void setClickListener(OnClickListener clickListener) {
        itemTxt.setOnClickListener(clickListener);
    }

    public void update(String text) {
        itemTxt.setText(text);
    }
}
