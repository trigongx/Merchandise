package com.example.merchandise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.merchandise.databinding.ActivityDetailBinding
import com.example.merchandise.ext.loadImage


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getIntExtra("productId", 0)
        App.instance?.getDatabase()?.getDao()?.getProductId(item)?.let { product ->
            binding.apply {
                Glide.with(this@DetailActivity)
                    .load(product.imageId)
                    .placeholder(R.drawable.img_null)
                    .into(binding.imageProduct)
                tvNameProduct.text = product.title
                tvDescriptionProduct.text = product.desc
                tvAmountProduct.text = product.amount.toString()
                tvStartPriceProduct.text = product.start_price.toString()
                tvEndPriceProduct.text = product.end_price.toString()

                btnBack.setOnClickListener {
                    finish()
                }

                btnDelete.setOnClickListener {
                    App.instance?.getDatabase()?.getDao()?.deleteProduct(product)
                    Toast.makeText(this@DetailActivity, "Продукт удален", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}