package com.example.lenovo.t_sqlite.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 主要是对数据库操作的工具类
 */
public class DbManger {
        private  static MySqliteHelper sMySqliteHelper;
        public static  MySqliteHelper getIntance(Context context) {
            if (sMySqliteHelper == null) {
                sMySqliteHelper = new MySqliteHelper(context);
            }
            return sMySqliteHelper;
        }

    /**
     * 根据sql语句在数据库中执行语句
     * @param db 数据库对象
     * @param sql sql语句
     */
        public static void execSQL(SQLiteDatabase db,String sql) {
            if (db != null) {
                if (sql !=null && !"".equals(sql)) {
                    db.execSQL(sql);
                }
            }
        }
}
