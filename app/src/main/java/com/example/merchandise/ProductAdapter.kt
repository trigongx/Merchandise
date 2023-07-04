package com.example.merchandise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.merchandise.databinding.ItemProductBinding
import com.example.merchandise.ext.loadImage

class ProductAdapter(val listener: Listener): RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    private var productList = ArrayList<Product>()

    class ProductHolder(item : View):RecyclerView.ViewHolder(item) {
        val binding = ItemProductBinding.bind(item)
        fun bind(product: Product,listener: Listener) = with(binding){
            img.loadImage(product.imageId)
            tvTitle.text = product.title
            tvPrice.text = product.end_price.toString()
            itemView.setOnClickListener {
                listener.onClick(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productList[position],listener)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    fun addProduct(products: ArrayList<Product>){
        productList = products
        notifyDataSetChanged()
    }
    interface Listener{
        fun onClick(product: Product)
    }
}