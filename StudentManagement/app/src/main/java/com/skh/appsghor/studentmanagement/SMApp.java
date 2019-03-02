package com.skh.appsghor.studentmanagement;

import android.app.Application;
import android.content.Context;

import com.skh.appsghor.studentmanagement.db.StudentManagementDB;

public class SMApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        SMApp.context = this;
        initializeDb();
    }

    public static Context getContext() {
        return context;
    }

    private void initializeDb() {
        StudentManagementDB studentManagementDB = StudentManagementDB.getDatabase();
        studentManagementDB.iUserDao().countUsers();
    }


}