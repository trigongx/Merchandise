package com.example.merchandise

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.merchandise.databinding.ActivityEditBinding


class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding

    private var imageUrl: String? = null

    private var productId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productId = intent.getIntExtra(ARG_PRODUCT_ID, 0)
        initButtons()
        init()
    }

    private fun init() {
        if(productId != 0) {
            val product = App.instance?.getDatabase()?.getDao()?.getProductId(productId)
            Glide.with(this)
                .load(product?.imageId)
                .placeholder(R.drawable.img_null)
                .into(binding.imageProduct)
            binding.apply {
                etNameProduct.text.toString()
                etDescriptionProduct.text.toString()
                etAmountProduct.text.toString().toInt()
                etStartPriceProduct.text.toString().toInt()
                etEndPriceProduct.text.toString().toInt()
            }

        }
    }

    private val getContent: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()) { imageUri: Uri? ->
            imageUrl = imageUri.toString()
            Glide.with(this)
                .load(imageUri.toString())
                .placeholder(R.drawable.img_null)
                .into(binding.imageProduct)
        }


    private fun initButtons() = with(binding) {
        btnSetImage.setOnClickListener {
            getContent.launch("image/*")
        }
        btnBack.setOnClickListener{
            finish()
        }
        btnSave.setOnClickListener {
            val product = Product(null,
                imageUrl!!,
                etNameProduct.text.toString(),
                etDescriptionProduct.text.toString(),
                etAmountProduct.text.toString().toInt(),
                etStartPriceProduct.text.toString().toInt(),
                etEndPriceProduct.text.toString().toInt()

            )
            App.instance?.getDatabase()?.getDao()?.createProduct(product)
            finish()
        }
    }

    companion object {
        const val ARG_PRODUCT_ID = "ARG_PRODUCT_ID"
        fun getIntent(context: Context, productId: Int) : Intent {
            val intent = Intent(context, EditActivity::class.java)
            intent.putExtra(ARG_PRODUCT_ID, productId)
            return intent
        }
    }
}