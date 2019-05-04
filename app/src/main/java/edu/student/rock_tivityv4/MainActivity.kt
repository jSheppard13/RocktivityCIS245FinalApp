package edu.student.rock_tivityv4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

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

        btnList.setOnClickListener(View.OnClickListener {
            val intentList = Intent(this, Main4Activity::class.java)
            startActivity(intentList)
        })
    }
}
