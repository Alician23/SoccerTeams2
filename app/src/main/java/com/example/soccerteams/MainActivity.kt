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
    private lateinit var showPickTeamLabel: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Assign variables with id
        selectRandomButton = findViewById(R.id.select_button)
        teamName1 = findViewById(R.id.search_team_1)
        teamName2 = findViewById(R.id.search_team_2)
        showPickTeamLabel = findViewById(R.id.show_result_text)

        teamName1.doAfterTextChanged {
            val text = teamName1.text
            if (text.isNotBlank()) { // Checking for empty text
                selectRandomButton.text = getString(R.string.read_display_text, text) // Get text from EditText and display on show result
            } else {
                selectRandomButton.text = getString(R.string.read_display_text, "...")
            }
        }
        teamName2.doAfterTextChanged {
            val text = teamName2.text
            if (text.isNotBlank()) {
             selectRandomButton.text = getString(R.string.read_display_text, text)
            } else {
                selectRandomButton.text = getString(R.string.read_display_text,  "...")
            }
        }
        // Button displays pop up message for empty space or strings
       selectRandomButton.setOnClickListener {
            val team1 = teamName1.text
            val team2 = teamName2.text
            if (team1.isBlank() || team2.isBlank()) { // checking team 1 and team 2 for blank space or empty string
               Toast.makeText( this, " Enter team 1 and team 2 names", Toast.LENGTH_LONG).show() // Pop up toast message text
           }else {
               val groups = listOf(team1, team2) // List of both teams
               val option = groups.random() // Random function determines which team is selected and stores in variable option
               showPickTeamLabel.text = option // displays text message
           }


       }

    }

}




