package com.example.logica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener{
            checkAnswers()
        }
    }

    //Checks if answers are valid input and correct and gives Toast message with result
    private fun checkAnswers(){
        val answers = arrayOf(etAnswer1.text.toString().toLowerCase(),
                              etAnswer2.text.toString().toLowerCase(),
                              etAnswer3.text.toString().toLowerCase(),
                              etAnswer4.text.toString().toLowerCase())
        val validInputTrue = getString(R.string.t).toLowerCase()
        val validInputFalse = getString(R.string.f).toLowerCase()
        val correctAnswers = arrayOf(validInputTrue.toLowerCase(),
                                     validInputFalse.toLowerCase(),
                                     validInputFalse.toLowerCase(),
                                     validInputFalse.toLowerCase())

        for((i, answer) in answers.withIndex()){

            if(answer != validInputTrue && answer != validInputFalse){
                Toast.makeText(this, getString(R.string.invalid_input, validInputFalse, validInputTrue), Toast.LENGTH_LONG).show()
                return
            }
            else if(answer != correctAnswers[i]){
                Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
                return
            }
        }
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()

    }
}
