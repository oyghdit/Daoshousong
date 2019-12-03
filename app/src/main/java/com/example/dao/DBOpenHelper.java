package com.example.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;   //定义数据库版本号
    private static final String DBNAME = "daoshou.db";    //定义数据库名
    public DBOpenHelper(Context context){
        super(context,DBNAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){    //创建顾客表
        db.execSQL("create table tb_customersinfo(cname varchar(20) primary key,cpwd varchar(20)" +
                ",csex varchar(2),ctele varchar(20),cschool varchar(40),cbuilding varchar(10)" +
                ",cdormitory varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
