package com.example.lovediary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovediary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNotes.setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }

        binding.btnVocabulary.setOnClickListener {
            startActivity(Intent(this, VocabularyActivity::class.java))
        }

        binding.btnAnniversary.setOnClickListener {
            startActivity(Intent(this, AnniversaryActivity::class.java))
        }
    }
}
