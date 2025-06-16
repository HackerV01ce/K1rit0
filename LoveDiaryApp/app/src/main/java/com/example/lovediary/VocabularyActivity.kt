package com.example.lovediary

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.lovediary.databinding.ActivityVocabularyBinding

class VocabularyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVocabularyBinding
    private val words = mutableListOf(
        "abandon", "ability", "able", "about", "above", "accept", "according", "account", "across", "act"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVocabularyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, words)
        binding.listView.adapter = adapter
    }
}
