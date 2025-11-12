package com.example.midtermapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.midtermapp.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartShopping.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(this,
                R.anim.slide_in_right,
                R.anim.slide_out_left)
            startActivity(intent, options.toBundle())
        }
    }
}