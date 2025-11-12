package com.example.midtermapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.midtermapp.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val price = 120 // Example price

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewPrice.text = "$${price}"
        binding.originalPriceTextView.paintFlags = binding.originalPriceTextView.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG

        binding.btnAddToCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            intent.putExtra("price", price)
            startActivity(intent)
        }

        binding.btnHome.setOnClickListener {
            // Load and start the animation
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)
            it.startAnimation(animation)

            // Navigate to the home activity
            val intent = Intent(this, CartActivity::class.java)
            // Add flags to clear the back stack and start a new task
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}