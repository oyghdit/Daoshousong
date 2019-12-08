package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.modle.Tb_customerinfo;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private DBOpenHelper dbhelper;
    private SQLiteDatabase db;
    public CustomerDao(Context context){
        dbhelper = new DBOpenHelper(context);   //链接数据库
    }

    //添加顾客信息
    public void add(Tb_customerinfo tb_customerinfo){
        db = dbhelper.getWritableDatabase();
        db.execSQL("insert into tb_customerinfo values(?,?,?,?,?,?,?)",new Object[]{
                tb_customerinfo.getCname(),tb_customerinfo.getCpwd(),tb_customerinfo.getCsex(),
                tb_customerinfo.getCtele(),tb_customerinfo.getCschool(),tb_customerinfo.getCbuilding(),
                tb_customerinfo.getCdormitory()});
    }

    //修改顾客信息
    public void update(Tb_customerinfo tb_customerinfo){
        db = dbhelper.getWritableDatabase();
        db.execSQL("update tb_customerinfo set cname = ?,cpwd = ?,csex = ?,ctele = ?,cschool = ?," +
                "cbuilding = ?,cdormitory = ? where cname = ?",new Object[]{tb_customerinfo.getCname(),
                tb_customerinfo.getCpwd(),tb_customerinfo.getCsex(),tb_customerinfo.getCtele(),
                tb_customerinfo.getCschool(),tb_customerinfo.getCbuilding(),tb_customerinfo.getCdormitory(),
                tb_customerinfo.getCname()});
    }

    //查询顾客信息
    public Tb_customerinfo find(String cname){
        db = dbhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_customerinfo where cname = ?",
                                    new String[]{ String.valueOf(cname) }); //根据用户名查找信息并存入cursor
        if(cursor.moveToFirst()){    //将查询信息存入Tb_customerinfo类中
            return new Tb_customerinfo(cursor.getString(cursor.getColumnIndex("cname")),
                                       cursor.getString(cursor.getColumnIndex("cpwd")),
                                       cursor.getString(cursor.getColumnIndex("csex")),
                                       cursor.getString(cursor.getColumnIndex("ctele")),
                                       cursor.getString(cursor.getColumnIndex("cschool")),
                                       cursor.getString(cursor.getColumnIndex("cbuilding")),
                                       cursor.getString(cursor.getColumnIndex("cdormitory")));
        }
        return null;    //如果没有信息则返回空
    }

    //删除顾客信息
    public void detele(String... cnames) {
        if (cnames.length > 0)  // 判断是否存在要删除的id
        {
            StringBuffer sb = new StringBuffer();   // 创建StringBuffer对象
            for (int i = 0; i < cnames.length; i++) // 遍历要删除的id集合
            {
                sb.append('?').append(','); // 将删除条件添加到StringBuffer对象中
            }
            sb.deleteCharAt(sb.length() - 1);   // 去掉最后一个“,“字符
            db = dbhelper.getWritableDatabase();
            // 执行删除收入信息操作
            db.execSQL("delete from tb_customerinfo where cname in (" + sb + ")",
                    (Object[]) cnames);
        }
    }

    //获取顾客信息
    public List<Tb_customerinfo> getScrollData(int start, int count) {
        List<Tb_customerinfo> tb_customerinfo = new ArrayList<Tb_customerinfo>();// 创建集合对象

        //连接数据库
        db = dbhelper.getWritableDatabase();
        //定义SQL语句
        String sql="select * from tb_customerinfo limit ?,?";

        // 获取所有顾客信息
        Cursor cursor = db.rawQuery(sql, new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()) // 遍历所有的顾客信息
        {
            // 将遍历到的顾客信息添加到集合中
            tb_customerinfo.add(new Tb_customerinfo(cursor.getString(cursor.getColumnIndex("cname")),
                            cursor.getString(cursor.getColumnIndex("cpwd")),
                            cursor.getString(cursor.getColumnIndex("csex")),
                            cursor.getString(cursor.getColumnIndex("ctele")),
                            cursor.getString(cursor.getColumnIndex("cschool")),
                            cursor.getString(cursor.getColumnIndex("cbuilding")),
                            cursor.getString(cursor.getColumnIndex("cdormitory"))));
        }
        return tb_customerinfo;    // 返回集合
    }

    //获取总记录数
    public long getCount() {
        db = dbhelper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db
                .rawQuery("select count(cname) from tb_customerinfo", null);// 获取收入信息的记录数
        if (cursor.moveToNext())    // 判断Cursor中是否有数据
        {
            return cursor.getLong(0);   // 返回总记录数
        }
        return 0;   // 如果没有数据，则返回0
    }
}
