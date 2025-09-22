package com.example.csc371week4homework

import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            calculateGPA()
        }
    }

    fun calculateGPA() {
        val gpa1 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toDoubleOrNull()
        val gpa2 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString().toDoubleOrNull()
        val gpa3 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal3).text.toString().toDoubleOrNull()
        val gpa4 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal4).text.toString().toDoubleOrNull()
        val gpa5 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal5).text.toString().toDoubleOrNull()
        val output = findViewById<TextView>(R.id.textView5)

        if (gpa1 == null || gpa2 == null || gpa3 == null || gpa4 == null || gpa5 == null) {
            output.text = "Must fill in all the values!"
            return
        }
        val computedGPA: Double =
            if (gpa1 != null && gpa2 != null && gpa4 != null && gpa5 != null) {
                (gpa1 + gpa2  + gpa3 + gpa4 + gpa5) / 5.0
            }
            else {
                0.0
            }

        output.text = computedGPA.toString()

        val color = findViewById<ConstraintLayout>(R.id.main)
        if (computedGPA < 60)  color.setBackgroundColor(Color.RED)
        else if (computedGPA >= 60 && computedGPA < 80) color.setBackgroundColor(Color.YELLOW)
        else if (computedGPA >= 80) color.setBackgroundColor(Color.GREEN)

    }


    fun clearForm() {

    }


}