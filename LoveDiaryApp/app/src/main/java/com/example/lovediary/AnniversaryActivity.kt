package com.example.lovediary

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovediary.databinding.ActivityAnniversaryBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AnniversaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnniversaryBinding
    private var selectedTime: Long = System.currentTimeMillis()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnniversaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateCountdown()

        binding.btnPickDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(this,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    selectedTime = calendar.timeInMillis
                    updateCountdown()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateCountdown() {
        val now = System.currentTimeMillis()
        val days = ((selectedTime - now) / (1000 * 60 * 60 * 24)).toInt()
        binding.tvDate.text = dateFormat.format(selectedTime)
        binding.tvCountdown.text = "$days days left"
    }
}
