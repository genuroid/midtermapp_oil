package com.example.midtermapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midtermapp.databinding.ActivityMyCartBinding

class MyCartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyCartBinding
    private var quantity = 1
    private var basePrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Extract the base price from the TextView
        val priceString = binding.productPrice.text.toString().replace("$", "").trim()
        basePrice = priceString.toIntOrNull() ?: 0

        updateTotals()

        binding.btnPlus.setOnClickListener {
            quantity++
            updateTotals()
        }

        binding.btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateTotals()
            }
        }

        binding.btnPlaceOrder.setOnClickListener {
            val intent = Intent(this, SuccessfullyActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            finish() // go back to ProductActivity
        }
    }

    private fun updateTotals() {
        val total = quantity * basePrice
        binding.quantityText.text = quantity.toString()
        binding.subtotalLabel.text = "Subtotal (${quantity} items)"
        binding.totalPrice.text = "${total} $"
    }
}