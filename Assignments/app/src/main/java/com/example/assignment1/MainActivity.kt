package com.example.assignment1

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    var lScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_con)

        val incrementScore = findViewById<Button>(R.id.incrementScore)
        val decrementScore = findViewById<Button>(R.id.decrementScore)
        val resetScore = findViewById<Button>(R.id.resetScore)
        val score = findViewById<TextView>(R.id.score)
        val buttonSound = MediaPlayer.create(this, R.raw.button_press_pop)
        val winSound = MediaPlayer.create(this, R.raw.win_sound)

        if (savedInstanceState != null) {
            lScore = savedInstanceState.getInt("score", 0)
            Log.d("MainActivity", "Restoring score to $lScore")
            score.text = lScore.toString()
        } else {
            Log.d("MainActivity", "No saved state, starting with score $lScore")
        }

        Log.d("MainActivity", "App Started: Initial score is $lScore")

        incrementScore.setOnClickListener()
        {
            Log.d("MainActivity", "Increment Button Pressed: Score updated to $lScore")
            lScore++
            score.text = lScore.toString()
            if (lScore == 15) {
                Log.d("MainActivity", "Winning Condition Reached: Playing win sound")
                winSound.start()
            }
            buttonSound.start()
        }

        decrementScore.setOnClickListener()
        {
            lScore--
            Log.d("MainActivity", "Decrement Button Pressed: Score updated to $lScore")
            score.text = lScore.toString()
            buttonSound.start()
        }

        resetScore.setOnClickListener()
        {
            lScore = 0
            Log.d("MainActivity", "Reset Button Pressed: Score reset to $lScore")
            score.text = lScore.toString()
            buttonSound.start()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "Saving score: $lScore")
        outState.putInt("score", lScore) // Save the current score
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lScore = savedInstanceState.getInt("score", 0) // Restore the score
        Log.d("MainActivity", "Score restored: $lScore")
    }
}
