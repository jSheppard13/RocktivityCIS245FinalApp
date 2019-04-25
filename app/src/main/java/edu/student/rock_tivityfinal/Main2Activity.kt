package edu.student.rock_tivityfinal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //binding objects
        val spin = findViewById<Spinner>(R.id.spinCity)
        val btnSub = findViewById<Button>(R.id.btnSubmit)
        val btnViewAll = findViewById<Button>(R.id.btnViewAll)
        var citySelected = 8
        val list = arrayOf ("Beloit", "Belvidere", "Byron", "Cherry Valley", "Freeport", "Loves Park", "Machesney Park", "Pecatonica", "Rockford", "Rockton")
        val adapter1 = ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, list)
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        spin.adapter = adapter1
        btnSub.setOnClickListener{
            when (spin.selectedItem.toString()){
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

            val intentCity = Intent(this, Main5Activity::class.java)
            intentCity.putExtra("SendStuff",citySelected)
            startActivity(intentCity)
        }
        btnViewAll.setOnClickListener(View.OnClickListener {
            val intentViewAll = Intent(this, Main3Activity::class.java)
            startActivity(intentViewAll)
        })



        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }
    // function to hide keyboard goes right before the last right bracket of Class MainActivity
//import android.content.Context
//import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
