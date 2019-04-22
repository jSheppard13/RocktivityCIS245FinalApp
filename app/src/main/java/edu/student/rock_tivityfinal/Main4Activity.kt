package edu.student.rock_tivityfinal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main4.*
import edu.student.rock_tivityfinal.R

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        var name = findViewById<EditText>(R.id.txtName)
        val city = findViewById<Spinner>(R.id.spinCity2)
        var location = findViewById<EditText>(R.id.txtLocation)
        var date = findViewById<EditText>(R.id.txtDate)
        var btnSubmitEvent = findViewById<Button>(R.id.btnSubmitEvent)
        var events = findViewById<TextView>(R.id.AllEvents)
        var ref = FirebaseDatabase.getInstance().getReference("EventsFile")

        var citySelected = 8
        val list = arrayOf ("Beloit", "Belvidere", "Byron", "Cherry Valley", "Freeport", "Loves Park", "Machesney Park", "Pecatonica", "Rockford", "Rockton")
        val adapter2 = ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, list)
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        city.adapter = adapter2
        btnSubmitEvent.setOnClickListener {
            when (city.selectedItem.toString()) {
                "Beloit" -> citySelected = 0
                "Belvidere" -> citySelected = 1
                "Byron" -> citySelected = 2
                "Cherry Valley" -> citySelected = 3
                "Freeport" -> citySelected = 4
                "Loves Park" -> citySelected = 5
                "Machesney Park" -> citySelected = 6
                "Pecatonica" -> citySelected = 7
                "Rockford" -> citySelected = 8
                "Rockton" -> citySelected = 9
            }
            hideKeyboard()

        }

        btnSubmitEvent.setOnClickListener{

            txtName.requestFocus()

            var eventid: String = ref.push().key.toString()

            var eventg = EventsFile(eventid, name.text.toString(), city.selectedItem.toString(), location.text.toString(), date.text.toString())

                hideKeyboard()
                name.setText("")

                location.setText("")
                date.setText("")
                txtName.requestFocus()
                ref.child(eventid).setValue(eventg).addOnCompleteListener{
                    Toast.makeText(this, "Event Added!", Toast.LENGTH_SHORT).show()
                }

            val intentViewAll = Intent(this, Main3Activity::class.java)
            startActivity(intentViewAll)

        }

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
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
                Log.w("Message", "Failed to read value.", error.toException())
            }
        })
    }

        fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            println("An error has occurred.")
        }

    }

}
