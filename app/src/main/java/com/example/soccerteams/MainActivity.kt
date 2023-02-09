package com.example.soccerteams

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    private lateinit var selectButton: Button
    private lateinit var teamName1: EditText
    private lateinit var teamName2: EditText
    private lateinit var showPickTeamLabel: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Assign variables with id
        selectButton = findViewById(R.id.btn_Select)
        teamName1 = findViewById(R.id.edFirstTeam)
        teamName2 = findViewById(R.id.edSecondTeam)
        showPickTeamLabel = findViewById(R.id.tvResult)

        teamName1.doAfterTextChanged {
            val text = teamName1.text
            if (text.isNotBlank()) { // Checking for empty text
                selectButton.text = getString(R.string.read_display_text, text) // Get text from EditText and display on show result
            } else {
                selectButton.text = getString(R.string.read_display_text, "...")
            }
        }
        teamName2.doAfterTextChanged {
            val text = teamName2.text
            if (text.isNotBlank()) {
             selectButton.text = getString(R.string.read_display_text, text)
            } else {
                selectButton.text = getString(R.string.read_display_text,  "...")
            }
        }
        // Button displays pop up message for empty space or strings
       selectButton.setOnClickListener {
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




