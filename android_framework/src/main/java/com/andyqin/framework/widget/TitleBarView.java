package com.andyqin.framework.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andyqin.framework.R;


/**
 * Created by qinbaoyuan on 2017/11/6.
 * ...
 */
public class TitleBarView extends LinearLayout implements View.OnClickListener {
    private int backTheme = 1;//默认带返回按钮
    private String centerText = "";

    private FrameLayout leftLayout;
    private ImageView backImg;
    private TextView centerTxt;


    public TitleBarView(Context context) {
        this(context, null);
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes(context, attrs);
        initViews();
        updateViews();
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitleBarView);
            backTheme = array.getInt(R.styleable.TitleBarView_title_bar_back_theme, 1);
            centerText = array.getString(R.styleable.TitleBarView_title_center_text);
            array.recycle();
        } else {
            backTheme = 1;
        }
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.view_title_bar, this);
        leftLayout = findViewById(R.id.flayout_title_bar_left);
        backImg = findViewById(R.id.img_title_bar_left);
        centerTxt = findViewById(R.id.txt_title_bar_center);

        leftLayout.setOnClickListener(this);
    }

    private void updateViews() {
        leftLayout.setVisibility(backTheme == 1 ? VISIBLE : INVISIBLE);
        centerTxt.setText(centerText);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.flayout_title_bar_left) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).onBackPressed();
            }
        }
    }
}
