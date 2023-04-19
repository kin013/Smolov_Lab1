package com.example.practic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private fun getSortedWords(str: String): List<String> {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        return str.split(" ")
            .map { word ->
                word to word.count { it.toLowerCase() in vowels }.toFloat() / word.length.toFloat()
            }
            .sortedBy { (_, proportion) -> proportion }
            .map { (word, _) -> word }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button_Click)
        val txt = findViewById<TextView>(R.id.textViewMessage)

        btn.setOnClickListener {
            val text = "This is a sample text to demonstrate sorting of words based on the proportion of vowels"
            txt.text = getSortedWords(text).joinToString(" ")
        }
    }
}