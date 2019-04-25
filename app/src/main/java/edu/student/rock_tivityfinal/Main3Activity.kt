package edu.student.rock_tivityfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView;
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference







class Main3Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //val database = FirebaseDatabase.getInstance()
        /* val ref = database.getReference("Events")
        //var ref = FirebaseDatabase.getInstance().getReference("EventsFile")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var events = findViewById<TextView>(R.id.txtAllEvents)


                events.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    if (events.text.toString() != "") {
                        events.text = events.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + " " + "City: " + it.child("Events").value.toString() + "Location: " + it.child("Events").value.toString() + "Date: " + it.child("Events").value.toString()
                    }else{
                        events.text = "My Events"
                        events.text = events.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + " " + "City: " + it.child("Events").value.toString() + "Location: " + it.child("Events").value.toString() + "Date: " + it.child("Events").value.toString()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("EventsFile", "Failed to read value.", error.toException())
            }
        })

    }*/

/*
// Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d( "Value is: " + value!!)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w( "Failed to read value.", error.toException())
            }
        })
*/
    }
}
