package com.example.logica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val answers = arrayOf(etAnswer1.text.toString(),
                              etAnswer2.text.toString(),
                              etAnswer3.text.toString(),
                              etAnswer4.text.toString())
        val validInputTrue = getString(R.string.t)
        val validInputFalse = getString(R.string.f)
        val correctAnswers = arrayOf(validInputTrue,
                                     validInputFalse,
                                     validInputFalse,
                                     validInputFalse)

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
