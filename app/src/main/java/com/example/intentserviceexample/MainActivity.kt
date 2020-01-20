package com.example.intentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_start.setOnClickListener {

            var i  = Intent(this,IntentServiceEx::class.java)
            i.putExtra("input",et_input.text.toString())
            ContextCompat.startForegroundService(this,i)

        }
    }
}
