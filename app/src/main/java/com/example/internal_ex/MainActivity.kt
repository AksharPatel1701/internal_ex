package com.example.internal_ex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var save: Button =findViewById(R.id.btnsave)
        save.setOnClickListener {
            var name: EditText =findViewById(R.id.edtname)
            var fathername: EditText =findViewById(R.id.edtfathername)
            var age: EditText =findViewById(R.id.edtage)
            var Name=name.text.toString()
            var Fathername=fathername.text.toString()
            var Age=age.text.toString().toInt()
            var fruit=Fruit(Name,Fathername,Age)
            var db= DBHelper(this)
            var falg=db.insert(fruit)
            if(falg)
            {
                Toast.makeText(this,"record inerted", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"record not inserted", Toast.LENGTH_LONG).show()
            }
        }
        btnveiw.setOnClickListener {
            var intent=Intent(this,ViewAllActivity::class.java)
            startActivity(intent)
        }
    }
}