package com.skh.appsghor.studentdemotest.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.skh.appsghor.studentdemotest.db.entity.User;

import java.util.List;

@Dao
public interface IUserDao {

    @Query("SELECT * FROM user WHERE _name_ =:name  AND _password =:passWord  LIMIT 1")
    User findTrainByName(String name,String passWord);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(User user);


    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(User user);

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT COUNT(*) from user")
    int countAction();

    @Query("SELECT * FROM user")
    List<User> getAllTrains();


}
