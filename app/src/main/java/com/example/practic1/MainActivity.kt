package com.example.practic1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private fun getSortedWords (str:String):List<String>{
        return str.split(" ")
            .map { it to it.sortWords() }
            .sortedBy { (_, proportion) -> proportion }
            .map { (word, _) -> word }
    }

    private fun String.sortWords ():Float{
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val count = this.count { it.toLowerCase() in vowels }
        return count.toFloat() / length.toFloat()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button_Click)
        val txt = findViewById<TextView>(R.id.textViewMessage)

        btn.setOnClickListener {
            val temps = "This is a sample text to demonstrate sorting of words based on the proportion of vowels"
            txt.text = getSortedWords(temps).joinToString(" ")
        }
    }
}