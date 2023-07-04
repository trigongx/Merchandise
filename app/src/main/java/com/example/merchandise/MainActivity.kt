package com.example.merchandise

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.merchandise.databinding.ActivityMainBinding
import com.example.merchandise.local.ProductDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            nvLeft.setNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.item_notifications -> {
                        val intent = Intent(this@MainActivity, NotificationActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.item_settings -> {
                        val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.item_help -> {
                        val intent = Intent(this@MainActivity, SupportActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.item_about_app -> {
                        val intent = Intent(this@MainActivity, AboutAppActivity::class.java)
                        startActivity(intent)
                    }
                }
                true
            }
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        /*val appBarConfiguration = AppBarConfiguration(
            setOf(

                R.id.navigation_product, R.id.navigation_diagram, R.id.navigation_profile

            )
        )*/

        /*setupActionBarWithNavController(navController, appBarConfiguration)*/
        navView.setupWithNavController(navController)
    }
    fun openNavigationView(){
        binding.container.openDrawer(GravityCompat.START)
    }


}

