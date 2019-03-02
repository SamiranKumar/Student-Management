package com.skh.appsghor.studentmanagement.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public long id;

    @NonNull
    @ColumnInfo(name = "_name_")
    public String name;

    @NonNull
    @ColumnInfo(name = "_password")
    public String password;


    @NonNull
    @ColumnInfo(name = "_type")
    public String type;


    @ColumnInfo(name = "_full_name_")
    public String fullName;


    @ColumnInfo(name = "_roll_no")
    public String rollNo;


    public User(@NonNull String name, @NonNull String password, @NonNull String type) {
        this.name = name;
        this.password = password;
        this.type = type;
    }



}
