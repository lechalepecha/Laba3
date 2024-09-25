package com.example.laba3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputText: EditText
    private lateinit var inputNum: EditText
    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputText = findViewById(R.id.editTextText)
        inputNum = findViewById(R.id.textNumber)
        output = findViewById(R.id.textView)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this::Solve)

    }
    fun Solve(view: View){
        var newtext = inputText.text.toString()
        val n = inputNum.text.toString().toInt()
        var outputtext = output.text.toString()

        if(n>=outputtext.length)
        {
            for(i in 0..outputtext.length-1 ) {
                val sb = StringBuilder(outputtext).also { it.setCharAt(i, newtext.toCharArray()[0]) }
                outputtext = sb.toString()
            }
        }
        else{
            for(i in 0..n-1 ) {
                val sb = StringBuilder(outputtext).also { it.setCharAt(i, newtext.toCharArray()[0]) }
                outputtext = sb.toString()
            }
        }
        output.text = outputtext
    }

}