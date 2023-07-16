package com.sasken.mybmicalculater.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface UserDao {

    @Insert
    public void insertUserRecord(UserEntity userEntity);

    @Delete
    public void deleteUserRecord(UserEntity userEntity);

}
