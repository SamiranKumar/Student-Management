package com.skh.appsghor.studentmanagement.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.skh.appsghor.studentmanagement.db.entity.User;

import static com.skh.appsghor.studentmanagement.db.StudentManagementDB.DB_VERSION;

@Database(entities = {User.class},
        version = DB_VERSION)
public abstract class StudentManagementDB extends RoomDatabase {


    private static StudentManagementDB INSTANCE;
    private static final String DB_NAME = "_sm_app.db";
    public static final int DB_VERSION = 1;

    
}
