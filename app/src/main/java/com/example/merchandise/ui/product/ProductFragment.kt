package com.example.merchandise.ui.product

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.merchandise.App
import com.example.merchandise.DetailActivity
import com.example.merchandise.EditActivity
import com.example.merchandise.MainActivity
import com.example.merchandise.Product
import com.example.merchandise.ProductAdapter
import com.example.merchandise.databinding.FragmentProductBinding


class ProductFragment : Fragment(),ProductAdapter.Listener {

    private var _binding: FragmentProductBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var  drawerLayout: DrawerLayout
    private val binding get() = _binding!!
    private val adapter = ProductAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val productViewModel =
            ViewModelProvider(this).get(ProductViewModel::class.java)

        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val products =
                    App.instance?.getDatabase()?.getDao()?.getAllProduct() ?: ArrayList<Product>()
                //adapter.addProduct(it.data?.getSerializableExtra("product") as Product)
                adapter.addProduct(products as ArrayList<Product>)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        _binding?.apply {
            val products = App.instance?.getDatabase()?.getDao()?.getAllProduct() ?: ArrayList()
            rvProduct.layoutManager = GridLayoutManager(requireContext(), 2)
            rvProduct.adapter = adapter
            adapter.addProduct(products as ArrayList<Product>)
            btnAdd.setOnClickListener {
                editLauncher?.launch(Intent(EditActivity.getIntent(requireContext(), 0)))
            }
            btnGamburger.setOnClickListener {
                openNavView()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val products = App.instance?.getDatabase()?.getDao()?.getAllProduct() ?: ArrayList()
        adapter.addProduct(products as ArrayList<Product>)
    }
    private fun openNavView(){
        val activity = requireActivity()
        if (activity is MainActivity){
            activity.openNavigationView()
        }
    }

    override fun onClick(product: Product) {
        startActivity(Intent(requireContext(),DetailActivity::class.java).apply {
            putExtra("productId",product.id)
        })
    }
}