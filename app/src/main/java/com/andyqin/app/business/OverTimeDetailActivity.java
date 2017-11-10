package com.andyqin.app.business;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.andy.base.component.TitleBarActivity;
import com.andy.datasource.UrlInfo;
import com.andy.datasource.request.GetOverTimeDetailRequest;
import com.andy.datasource.response.OverTimeDetailResponse;
import com.andyqin.app.R;
import com.andyqin.framework.network.OnServiceListener;
import com.andyqin.framework.network.ServiceOps;
import com.andyqin.framework.network.ServiceReqModel;
import com.othershe.calendarview.bean.DateBean;
import com.othershe.calendarview.listener.OnMultiChooseListener;
import com.othershe.calendarview.listener.OnSingleChooseListener;
import com.othershe.calendarview.weiget.CalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qinbaoyuan on 2017/11/6.
 * 加班详情页
 */
public class OverTimeDetailActivity extends TitleBarActivity {
    private CalendarView calendarView;
    private TextView showDataTxt;
    private TextView calendarTitle;

    private int year = 0;
    private int month = 0;
    private List<String> dayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calendarView = findViewById(R.id.calendar_view_over_time_detail);
        showDataTxt = findViewById(R.id.txt_show_data);
        calendarTitle = findViewById(R.id.txt_calendar_title);
        initCalendarView();
        fun();
        startService();
    }

    private void startService() {
        ServiceReqModel.Builder builder = new ServiceReqModel.Builder<>();
        GetOverTimeDetailRequest request = new GetOverTimeDetailRequest();
        request.setPhoneNum("18662524216");
        builder.setRequest(request)
                .setResponseClass(OverTimeDetailResponse.class)
                .setUrlInfo(UrlInfo.getInstance())
                .setServiceListener(new OnServiceListener<OverTimeDetailResponse>() {
                    @Override
                    public void OnServerSuccess(OverTimeDetailResponse response, String token) {
                        if (response != null) {
                            Log.e("andy", "response = " + response.toString());
                        }
                    }
                });
        ServiceOps.loadData(builder.build());
    }

    @Override
    protected View getContentLayout() {
        return View.inflate(OverTimeDetailActivity.this, R.layout.activity_over_time, null);
    }

    private void initCalendarView() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String titleSrc = String.valueOf(year) + "年" + String.valueOf(month) + "月";
        calendarTitle.setText(titleSrc);

        String yearSrc = String.valueOf(year) + "." + month;

        String daySrc = String.valueOf(year) + "." + month + "." + day;
        readSaveData();
        calendarView.setStartEndDate(yearSrc, yearSrc)
                .setInitDate(daySrc)
                .setSingleDate(daySrc)
                .setMultiDate(dayList)
                .init();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void readSaveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("date", MODE_PRIVATE);
        Set<String> sets = new HashSet<>();
        sets = sharedPreferences.getStringSet("dateSave", sets);
        dayList.addAll(sets);
        calendarView.setMultiDate(dayList);
    }

    private void fun() {
        calendarView.setOnMultiChooseListener(new OnMultiChooseListener() {
            @Override
            public void onMultiChoose(View view, DateBean dateBean, boolean b) {
                int[] day = dateBean.getSolar();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < day.length; i++) {
                    builder.append(day[i]).append(".");
                }
                String daySrc = "";
                if (builder.toString().endsWith(".")) {
                    daySrc = builder.toString().substring(0, builder.toString().length() - 1);
                }
                if (dayList.indexOf(daySrc) == -1) {
                    dayList.add(daySrc);
                } else {
                    dayList.remove(daySrc);
                }
                SharedPreferences sharedPreferences = getSharedPreferences("date", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                Set<String> sets = new HashSet<>();
                sets.addAll(dayList);
                editor.putStringSet("dateSave", sets);
                editor.apply();
            }
        });

        calendarView.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean dateBean) {
                Log.e("andy", "single choose");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    String days = "";

    private void addDay(String dayOfMonth) {
        if (!days.contains(dayOfMonth)) {
            if (days.isEmpty()) {
                days = days.concat(dayOfMonth);
            } else {
                days = days.concat("、").concat(dayOfMonth);
            }
        }
        showDataTxt.setText(month + "月份加班日期为：" + days);
    }
}
