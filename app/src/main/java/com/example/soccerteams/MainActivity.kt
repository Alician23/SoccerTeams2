package com.example.soccerteams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    private lateinit var selectRandomButton: Button
    private lateinit var teamName1: EditText
    private lateinit var teamName2: EditText
    private lateinit var showTeam: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables use to store id
        selectRandomButton = findViewById(R.id.select_button)
        teamName1 = findViewById(R.id.search_team_1)
        teamName2 = findViewById(R.id.search_team_2)
        showTeam = findViewById(R.id.show_result_text)

        teamName1.doAfterTextChanged {
            val text = teamName1.text
            if (text.isNotBlank()) { // Checking for empty text
                showTeam.text = getString(R.string.read_display_text, text) // Get text from EditText and display on show result
            } else {
                showTeam.text = getString(R.string.read_display_text, "...")
            }
        }
        teamName2.doAfterTextChanged {
            val text = teamName2.text
            if (text.isNotBlank()) {
                showTeam.text = getString(R.string.read_display_text, text)
            } else {
                showTeam.text = getString(R.string.read_display_text,  "...")
            }
        }
        // Button displays pop up message for empty space
       selectRandomButton.setOnClickListener {
           val text = teamName1.text
           if (text.isBlank()) {
               Toast.makeText( this, getString(R.string.no_text_error_message), Toast.LENGTH_LONG).show()
           }else {
               Toast.makeText( this, getString(R.string.show_result_message, text), Toast.LENGTH_SHORT).show()
           }


       }

    }

}




