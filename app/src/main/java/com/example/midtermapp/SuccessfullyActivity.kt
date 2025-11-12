package com.example.midtermapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.midtermapp.databinding.ActivitySuccessfullyBinding

class SuccessfullyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuccessfullyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessfullyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Automatically close the app after a delay
        Handler(Looper.getMainLooper()).postDelayed({
            finishAffinity() // Closes all activities and exits the app
        }, 2000) // 2000 milliseconds = 2 seconds
    }
}
