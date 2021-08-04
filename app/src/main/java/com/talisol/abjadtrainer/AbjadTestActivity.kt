package com.talisol.abjadtrainer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.talisol.abjadtrainer.databinding.ActivityAbjadTestBinding
import androidx.lifecycle.Observer

class AbjadTestActivity : AppCompatActivity() {


    lateinit var viewModel: AbjadViewModel
    private lateinit var binding: ActivityAbjadTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbjadTestBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(AbjadViewModel::class.java)




        setContentView(binding.root)

        viewModel.currentValues()
        viewModel.currentWord().observe(this, Observer {binding.tvArabicWord.text = it.toString() })

        viewModel.abjadValueShown().observe(this, Observer {

            if (it){
                binding.tvAbjadValue.text = viewModel.abjadValue().value.toString()
            }
        })

        viewModel.detailsShown().observe(this, Observer {

            if (it){
                binding.recyclerView.adapter = LetterAdapter(viewModel.letterList().value!!)
                binding.recyclerView.layoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL,false)
            }
        })


    binding.btnCheckValue.setOnClickListener{

        if (binding.itInputArabic.text.toString().isEmpty()){
           Toast.makeText(this,"Enter a number of press DETAILS",Toast.LENGTH_SHORT).show()
        }else{
            if (binding.itInputArabic.text.toString().toInt() != viewModel.abjadValue().value){
                binding.tvWrongRight.text = "WRONG!"
            }else{binding.tvWrongRight.text = "Correct:"}
            viewModel.showAbjadValue()
        }
    }

    binding.btnNext.setOnClickListener{
        if (viewModel.currentPosition().value != viewModel.numberWords() - 1) {

            viewModel.nextQuestion()
            binding.tvAbjadValue.text = ""
            binding.tvWrongRight.text = ""
            binding.recyclerView.adapter = LetterAdapter(mutableListOf())
            binding.recyclerView.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL, false
            )

            binding.itInputArabic.text.clear()
        }else{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    binding.btnDetails.setOnClickListener{
        viewModel.showDetails()
        binding.recyclerView.adapter = LetterAdapter(viewModel.letterList().value!!)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
    }

    }


}