package edu.student.rock_tivityfinal


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

/*
Author: Jason Sheppard
CIS 245
Final Project
Rock-Tivity
Prof. Chuck Konkol
 */


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding objects
        val btnView = findViewById<Button>(R.id.btnView)
        val btnList = findViewById<Button>(R.id.btnCreateEvent)

        btnView.setOnClickListener(View.OnClickListener {
            val intentView = Intent(this, Main2Activity::class.java)
            startActivity(intentView)
        })

        /* btnList.setOnClickListener(View.OnClickListener {
             val intentList = Intent(this, Main6Activity::class.java)
             startActivity(intentList)
         })*/
    }
}

