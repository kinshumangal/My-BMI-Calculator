package com.sasken.mybmicalculater.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int userId;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo (name = "Gender")
    public String gender;

    @ColumnInfo (name = "Height")
    public int height;

    @ColumnInfo(name = "Weight")
    public int weight;

    @ColumnInfo(name = "Age")
    public int age;

    @ColumnInfo(name = "BMI")
    public float bmi;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}
