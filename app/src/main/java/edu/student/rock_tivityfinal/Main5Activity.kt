package edu.student.rock_tivityfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val txtCityView = findViewById<TextView>(R.id.txtCityView)
        var eventsByCity = findViewById<TextView>(R.id.AllEvents)
        var ref = FirebaseDatabase.getInstance().getReference("Events")
        var citySelected: String = intent.getStringExtra("SendStuff")


        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                eventsByCity.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    if (eventsByCity.text.toString() != "") {
                        eventsByCity.text = eventsByCity.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + " " + "City: " + it.child("Events").value.toString() + "Location: " + it.child("Events").value.toString() + "Date: " + it.child("Events").value.toString()
                    }else{
                        eventsByCity.text = "My Events"
                        eventsByCity.text = eventsByCity.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + " " + "City: " + it.child("Events").value.toString() + "Location: " + it.child("Events").value.toString() + "Date: " + it.child("Events").value.toString()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Message", "Failed to read value.", error.toException())
            }
        })

    }
}
