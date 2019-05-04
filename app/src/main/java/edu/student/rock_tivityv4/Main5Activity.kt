package edu.student.rock_tivityv4

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

        var citySelected: Int = intent.getIntExtra("SendStuff", 0)
        var city: String = ""
        when (citySelected){
             0 -> city = "Beloit"
             1 -> city =  "Belvidere"
             2 -> city = "Byron"
             3 -> city =  "Cherry Valley"
             4 -> city =  "Freeport"
             5 -> city =  "Loves Park"
             6 -> city = "Machesney Park"
             7 -> city = "Pecatonica"
             8 -> city = "Rockford"
             9 -> city = "Rockton"
        }


        var database = FirebaseDatabase.getInstance()
        var ref = FirebaseDatabase.getInstance().getReference("EventsFile")

        val byCity = FirebaseDatabase.getInstance().getReference("EventsFile").orderByChild("city").equalTo(city)



        byCity.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var events = findViewById<TextView>(R.id.txtCityView)

                events.text = ""

                val children = dataSnapshot.children
                children.forEach {
                    println("data: " + it.toString())
                    //if (it.child("City").value.toString() == city) {
                        if (events.text.toString() != "") {
                            events.text =


                                events.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + "   " + "City: " + it.child(
                                    "city"
                                ).value.toString() + "   " + "Location: " + it.child("location").value.toString() + "   " + "Date: " + it.child(
                                    "date"
                                ).value.toString() + "\n"


                        } else {
                            events.text =
                                events.text.toString() + "\n" + "Event: " + it.child("name").value.toString() + "    " + "City: " + it.child(
                                    "city"
                                ).value.toString() + "    " + "Location: " + it.child("location").value.toString() + "    " + "Date: " + it.child(
                                    "date"
                                ).value.toString() + "\n"
                        }
                    //}
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("EventsFile", "Failed to read value.", error.toException())
            }
        })
    }
}
