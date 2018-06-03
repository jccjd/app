package com.example.lenovo.t_sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lenovo.t_sqlite.Utils.Constant;
import com.example.lenovo.t_sqlite.Utils.DbManger;
import com.example.lenovo.t_sqlite.Utils.MySqliteHelper;

public class MainActivity extends AppCompatActivity {
    private MySqliteHelper mHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = DbManger.getIntance(this);
    }
    /*
    点击创建数据库
    * */
    public  void  createDb(View view) {
        /* getReadableDatabase() getWritableDatabase();
         *  如果数据库不存在则创建数据库，如果存在直接打开数据库
         *  默认情况下两个函数都表示或者创建可读可写的数据库对象，如果磁盘已满或者是数据库本身权限情况下
         *  getReadableDatabase()打开的是只读数据库
        * */
        SQLiteDatabase db = mHelper.getReadableDatabase();

    }
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                SQLiteDatabase db = mHelper.getWritableDatabase();
                String sql = "insert into "+ Constant.TABLE_NAME+" values(1,'zhanggsan',20";
                DbManger.execSQL(db,sql);
                String sql2 = "insert into "+ Constant.TABLE_NAME+" values(2,'lisi',23";
                DbManger.execSQL(db,sql2);
                db.close();
                break;
        }
    }
}
