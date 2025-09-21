package com.example.csc371week4homework

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        val gpa1 : Double = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toDouble()
        val gpa2 : Double = findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString().toDouble()
        val gpa3 : Double = findViewById<EditText>(R.id.editTextNumberDecimal3).text.toString().toDouble()
        val gpa4 : Double = findViewById<EditText>(R.id.editTextNumberDecimal4).text.toString().toDouble()
        val gpa5 : Double = findViewById<EditText>(R.id.editTextNumberDecimal5).text.toString().toDouble()

        val computedGPA : Double = (gpa1 + gpa2  + gpa3 + gpa4 + gpa5) / 5.0

        val output = findViewById<TextView>(R.id.textView5)
        output.text = computedGPA.toString()

    }
}