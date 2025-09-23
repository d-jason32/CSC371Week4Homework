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

        /**
         * Controls the button.
         */
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            resetTextboxColor()
            checkType()
            clearForm()
            calculateGPA()
        }

        val form1 = findViewById<EditText>(R.id.editTextNumberDecimal)
        val form2 =  findViewById<EditText>(R.id.editTextNumberDecimal2)
        val form3 =  findViewById<EditText>(R.id.editTextNumberDecimal3)
        val form4 =  findViewById<EditText>(R.id.editTextNumberDecimal4)
        val form5 =  findViewById<EditText>(R.id.editTextNumberDecimal5)

        /*
        If the button says clear form and you click on an EditText,
        all the boxes will clear.
         */
        form1.setOnClickListener {
            clearForm()
        }
        form2.setOnClickListener {
            clearForm()
        }
        form3.setOnClickListener {
            clearForm()
        }
        form4.setOnClickListener {
            clearForm()
        }
        form5.setOnClickListener {
            clearForm()
        }
    }

    /**
     * Method to clear the form.
     * This clears all the EditText fields.
     * Changes the button to say compute GPA.
     * And the text at the bottom to enter your grades and
     * press calculate.
     */
    fun clearForm() {
        val color = findViewById<ConstraintLayout>(R.id.main)
        val output = findViewById<TextView>(R.id.textView5)

        if (findViewById<Button>(R.id.button).text.toString() == "Clear Form"){
            findViewById<EditText>(R.id.editTextNumberDecimal).setText("");
            findViewById<EditText>(R.id.editTextNumberDecimal2).setText("");
            findViewById<EditText>(R.id.editTextNumberDecimal3).setText("");
            findViewById<EditText>(R.id.editTextNumberDecimal4).setText("");
            findViewById<EditText>(R.id.editTextNumberDecimal5).setText("");
            findViewById<Button>(R.id.button).setText("Compute GPA")
            color.setBackgroundColor(Color.WHITE)
            output.text = "Enter your grades and press calculate!"
        }
    }

    /**
     * Method to calculate the gpa.
     * Also sets the button to say clear form.
     * This method also changes the background color
     * based on the computed gpa.
     */
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

        findViewById<Button>(R.id.button).setText("Clear Form")
    }

    /**
     * Method to change the color of the app back to white.
     */
    fun resetTextboxColor(){
        findViewById<EditText>(R.id.editTextNumberDecimal).setBackgroundColor(Color.TRANSPARENT)
        findViewById<EditText>(R.id.editTextNumberDecimal2).setBackgroundColor(Color.TRANSPARENT)
        findViewById<EditText>(R.id.editTextNumberDecimal3).setBackgroundColor(Color.TRANSPARENT)
        findViewById<EditText>(R.id.editTextNumberDecimal4).setBackgroundColor(Color.TRANSPARENT)
        findViewById<EditText>(R.id.editTextNumberDecimal5).setBackgroundColor(Color.TRANSPARENT)
    }

    /**
     * Method to check the type of the input.
     * If it is a number it will be an integer.
     * If it is a string it will be null.
     * Any entered string will change the text box to red.
     */
    fun checkType() {
        val gpa1 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toDoubleOrNull()
        val gpa2 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal2).text.toString().toDoubleOrNull()
        val gpa3 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal3).text.toString().toDoubleOrNull()
        val gpa4 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal4).text.toString().toDoubleOrNull()
        val gpa5 : Double? = findViewById<EditText>(R.id.editTextNumberDecimal5).text.toString().toDoubleOrNull()

        if (gpa1 == null) findViewById<EditText>(R.id.editTextNumberDecimal).setBackgroundColor(Color.RED)
        if (gpa2 == null) findViewById<EditText>(R.id.editTextNumberDecimal2).setBackgroundColor(Color.RED)
        if (gpa3 == null) findViewById<EditText>(R.id.editTextNumberDecimal3).setBackgroundColor(Color.RED)
        if (gpa4 == null) findViewById<EditText>(R.id.editTextNumberDecimal4).setBackgroundColor(Color.RED)
        if (gpa5 == null) findViewById<EditText>(R.id.editTextNumberDecimal5).setBackgroundColor(Color.RED)

    }


}