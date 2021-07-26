package com.talisol.abjadtrainer

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.talisol.abjadtrainer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val start_computation_test = binding.btnStartComputationTest

        start_computation_test.setOnClickListener {
            var intent = Intent(this, AbjadTestActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}