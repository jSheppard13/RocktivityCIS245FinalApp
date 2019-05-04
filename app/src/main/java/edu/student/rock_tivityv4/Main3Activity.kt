package edu.student.rock_tivityv4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var database = FirebaseDatabase.getInstance()
        var ref = FirebaseDatabase.getInstance().getReference("EventsFile")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var events = findViewById<TextView>(R.id.txtAllEvents)


                events.text = ""
                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    if (events.text.toString() != "") {
                        events.text =
                            events.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + "    " + "City: " + it.child(
                                "city"
                            ).value.toString() +"    " + "Location: " + it.child("location").value.toString() + "    " + "Date: " + it.child(
                                "date"
                            ).value.toString()+ "\n"
                    } else {

                        events.text =
                            events.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + "    " + "City: " + it.child(
                                "city"
                            ).value.toString() +"    " + "Location: " + it.child("location").value.toString() +"    "+ "Date: " + it.child(
                                "date"
                            ).value.toString()+ "\n"
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("EventsFile", "Failed to read value.", error.toException())
            }
        })

    }
}

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

    }
}*/
