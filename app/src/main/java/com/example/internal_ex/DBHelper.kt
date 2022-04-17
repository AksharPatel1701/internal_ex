package com.example.internal_ex

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.collections.ArrayList

class DBHelper(var context: Context):SQLiteOpenHelper(context, DB_NAME,null,DB_VERSION) {
    companion object{

        private var DB_NAME="fruitdb"
        private var DB_TABEL="fruit"
        private var DB_VERSION=1
        private var DB_PARSON="name"
        private var DB_FATHERNAME="fathername"
        private var DB_AGE="age"
        private var DB_ID="ID"



    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $DB_TABEL ($DB_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",$DB_PARSON TEXT,$DB_FATHERNAME TEXT,$DB_AGE INTEGER)"
        p0?.execSQL(query);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query="DROP TABLE $DB_TABEL IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)
    }
    fun insert(fruit: Fruit):Boolean {
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(DB_PARSON,fruit.fr_name)
        cv.put(DB_FATHERNAME,fruit.fr_fathername)
        cv.put(DB_AGE,fruit.fr_age)
        var flag= db.insert(DB_TABEL,null,cv)
        if (flag>0)
        {
            return true
        }
        else
        {
            return false
        }
    }
    fun retriveall():ArrayList<Fruit>
    {
        var db =readableDatabase
        var cursor=db.query(DB_TABEL,null,null,null,null,null,null)
        var arr:ArrayList<Fruit> = ArrayList()
        while (cursor.moveToNext())
        {
            var name=cursor.getString(1)
            var fathername=cursor.getString(2)
            var age=cursor.getInt(3)
            var id=cursor.getInt(0)
            var fruit=Fruit(id,name,fathername,age)
            arr.add(fruit)



        }
        return arr


    }
}