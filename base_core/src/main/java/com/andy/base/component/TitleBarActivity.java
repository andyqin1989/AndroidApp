package com.andy.base.component;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.andy.base.R;

/**
 * Created by qinbaoyuan on 2017/11/6.
 * ...
 */

public abstract class TitleBarActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_title_bar);
        ((LinearLayout)findViewById(R.id.title_bar_activity_root_view)).addView(getContentLayout());
    }

    protected abstract View getContentLayout();
}
