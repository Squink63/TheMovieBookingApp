package com.abbc.mymoviebookingapp.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.abbc.mymoviebookingapp.R
import com.abbc.mymoviebookingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        const val EXTRA_REGION = "EXTRA_REGION"
        fun newIntent(context: Context,city: String): Intent{
            val intent = Intent(context,MainActivity::class.java)
            intent.putExtra(EXTRA_REGION,city)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        val bottomNavigationView = binding.bottomNavigation
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)
    }
}