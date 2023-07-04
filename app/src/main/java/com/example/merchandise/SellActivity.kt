package com.example.merchandise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.merchandise.databinding.ActivitySellBinding

class SellActivity : AppCompatActivity() {
    lateinit var binding: ActivitySellBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySellBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val productId = intent.getIntExtra("productID",0)


        }

    private fun initButtons(){
        binding.apply {
            btnBack.setOnClickListener {
                finish()
            }
        }
    }

}