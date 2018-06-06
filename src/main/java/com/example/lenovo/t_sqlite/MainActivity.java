package com.example.lenovo.t_sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    /**
     * 点击创建数据库
     */
    public void createDb(View view) {
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
                String sql = "insert into " + Constant.TABLE_NAME + " values(1,'zhanggsan',20";
                DbManger.execSQL(db, sql);
                String sql2 = "insert into " + Constant.TABLE_NAME + " values(2,'lisi',23";
                DbManger.execSQL(db, sql2);
                db.close();
                break;
            case R.id.btn_updata:
                db = mHelper.getWritableDatabase();
                String updatasql = "updata " + Constant.TABLE_NAME + " set " + Constant.TABLE_NAME +
                        "='xiaoming' where " + Constant._ID + "=1";
                DbManger.execSQL(db, updatasql);
                db.close();
                break;
            case R.id.btn_delete:
                db = mHelper.getWritableDatabase();
                String deletesql = "delete from " + Constant.TABLE_NAME + " where "
                        + Constant._ID + "=2";
                DbManger.execSQL(db, deletesql);
                db.close();
                break;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_insertAPI:
                SQLiteDatabase db = mHelper.getWritableDatabase();
                /**
                 * insert(String table, String nullColumnHack, ContentValues values)
                 * String table 表示插入数据表的名称
                 * String nullColumnHack
                 * ContentValues vals 键为String类型 HashMap集合
                 * 返回值 long 表示插入的列数
                 */
                ContentValues values = new ContentValues();
                values.put(Constant._ID, 3);
                values.put(Constant.NAME, "张三");
                values.put(Constant.AGE, 30);

                long result = db.insert(Constant.TABLE_NAME, null, values);
                if (result > 0) {
                    Toast.makeText(MainActivity.this, "插入数据成功", Toast.LENGTH_LONG).show();
                } else {

                }
                db.close();
                break;
        }
    }
}
