package com.example.lovediary

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.lovediary.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotesBinding
    private val notes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        binding.listView.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val text = binding.editText.text.toString()
            if (text.isNotBlank()) {
                notes.add(text)
                adapter.notifyDataSetChanged()
                binding.editText.text.clear()
            }
        }
    }
}
