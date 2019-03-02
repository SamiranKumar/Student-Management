package com.skh.appsghor.studentmanagement;

import android.app.Application;
import android.content.Context;

public class SMApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        SMApp.context = this;
    }

    public static Context getContext() {
        return context;
    }