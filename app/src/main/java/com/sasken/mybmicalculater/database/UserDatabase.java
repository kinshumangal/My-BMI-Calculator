package com.sasken.mybmicalculater.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    static final String DB_NAME = "User-Database";

    public abstract UserDao userDao();

    private static UserDatabase userDatabase;
    public static synchronized UserDatabase getUserDatabase(Context context){
        if(userDatabase == null){
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, DB_NAME).build();
        }

        return userDatabase;
    }

}
