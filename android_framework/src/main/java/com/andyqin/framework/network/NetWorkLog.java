/*
 *
 * Copyright 2015 TedXiong xiong-wei@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.andyqin.framework.network;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Qinbaoyuan on 2017/11/9.
 * NetWorkLog
 */
public class NetWorkLog {
  private final static String TAG = NetWorkLog.class.getSimpleName();

  public static void e(String message) {
    if (TextUtils.isEmpty(message)) return;
    Log.e(TAG, message);
  }

  public static void d(String message) {
    if (TextUtils.isEmpty(message)) return;
    Log.d(TAG, message);
  }

  public static void v(String message) {
    if (TextUtils.isEmpty(message)) return;
    Log.v(TAG, message);
  }

  public static void w(String message) {
    if (TextUtils.isEmpty(message)) return;
    Log.w(TAG, message);
  }

  /**
   * logger
   */
  public static void showJSON(String url, String tag, String message) {
    if (!TextUtils.isEmpty(url)) NetWorkLog.e("@@@@@@-url: " + url);
    if (TextUtils.isEmpty(tag)) tag = " ";
    NetWorkLog.e("@@@@@@- Begin " + tag + " Body -@@@@@@");
    NetWorkLog.e(message);
    NetWorkLog.e("@@@@@@- End " + tag + " Body -@@@@@@");
  }
}
