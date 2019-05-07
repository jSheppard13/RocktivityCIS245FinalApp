package edu.student.rock_tivityv4

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.getSystemService
import android.text.format.DateFormat
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main4.*
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.logging.SimpleFormatter


class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        var name = findViewById<EditText>(R.id.txtName)
        val city = findViewById<Spinner>(R.id.spinCity2)
        var location = findViewById<EditText>(R.id.txtLocation)
        var date = findViewById<EditText>(R.id.txtDate)
        var btnSubmitEvent = findViewById<Button>(R.id.btnSubmitEvent)
        var database = FirebaseDatabase.getInstance()
        var ref = FirebaseDatabase.getInstance().getReference("EventsFile")
        val btnGoEvents = findViewById<Button>(R.id.btnGoEvents)

        var citySelected = 0
        val list = arrayOf(
            "Beloit",
            "Belvidere",
            "Byron",
            "Cherry Valley",
            "Freeport",
            "Loves Park",
            "Machesney Park",
            "Pecatonica",
            "Rockford",
            "Rockton"
        )
        val adapter2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
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
            // hideKeyboard()

        }

        btnSubmitEvent.setOnClickListener {

        //Validate Data
            var dataValid = true

                if (name.text.toString() == "") {
                    Toast.makeText(this, "Name field can not be empty", Toast.LENGTH_SHORT).show()
                    txtName.hasFocus()
                    dataValid = false
                }
                if (location.text.toString() == "") {
                    Toast.makeText(this, "Location field can not be empty", Toast.LENGTH_SHORT).show()
                    txtLocation.hasFocus()
                    dataValid = false
                }
                if (date.text.toString() == "") {
                    Toast.makeText(this, "Date field can not be empty", Toast.LENGTH_SHORT).show()
                    txtDate.hasFocus()
                    dataValid = false
                }
            /*
            //validate date
            val today = java.util.Calendar.getInstance()
            val formatter = SimpleDateFormat("MM/dd/yyyy")
            var formatted = formatter.format(today)
            var formatted2 = formatter.format(date)
              if (formatted > formatted2) {
               Toast.makeText(this, "Date entered is in the past", Toast.LENGTH_SHORT).show()
               txtDate.selectAll()
               dataValid = false
               }
             */

            if (dataValid == true) {

                txtName.requestFocus()

                val eventID: String = ref.push().key.toString()

                var eventg = EventsFile(
                    eventID,
                    name.text.toString(),
                    city.selectedItem.toString(),
                    location.text.toString(),
                    date.text.toString()
                )

                hideKeyboard()
                name.setText("")

                location.setText("")
                date.setText("")
                txtName.requestFocus()
                ref.child(eventID).setValue(eventg).addOnCompleteListener {
                    Toast.makeText(this, "Event Added!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnGoEvents.setOnClickListener(View.OnClickListener {
            val intentView = Intent(this, Main3Activity::class.java)
            startActivity(intentView)
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

