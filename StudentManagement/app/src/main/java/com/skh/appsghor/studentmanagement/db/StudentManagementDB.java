package com.skh.appsghor.studentmanagement.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.skh.appsghor.studentmanagement.SMApp;
import com.skh.appsghor.studentmanagement.db.entity.User;

import static com.skh.appsghor.studentmanagement.db.StudentManagementDB.DB_VERSION;

@Database(entities = {User.class},
        version = DB_VERSION)
public abstract class StudentManagementDB extends RoomDatabase {

    private static StudentManagementDB INSTANCE;
    private static final String DB_NAME = "_sm_app.db";
    public static final int DB_VERSION = 1;


    public abstract IUserDao iUserDao();


    public static StudentManagementDB getDatabase() {
        if (INSTANCE == null) {
            synchronized (StudentManagementDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(SMApp.getContext(),
                            StudentManagementDB.class, DB_NAME)
                            .allowMainThreadQueries()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            })
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    
}
