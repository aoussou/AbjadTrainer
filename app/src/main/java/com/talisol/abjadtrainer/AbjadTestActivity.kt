package com.talisol.abjadtrainer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.talisol.abjadtrainer.databinding.ActivityAbjadTestBinding


class AbjadTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAbjadTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbjadTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var submit_btn = binding.btnCheckValue
        var word_list = ExampleList.getWordList()
        submit_btn.text = "CHECK"
        var next_btn = binding.btnNext
        var details_btn = binding.btnDetails
        var current_position = 0

        var word = word_list[current_position]
        binding.tvArabicWord.text = word
        var totalAbjadValue = ExampleList.getAbjadValue(word)
        var letterList = mutableListOf<Letter>()
        var adapter = LetterAdapter(letterList)
        var letterAbjadValue = 0

        submit_btn.setOnClickListener{





            if (binding.itInputArabic.text.toString().isEmpty()){
               Toast.makeText(this,"Enter a number of press DETAILS",Toast.LENGTH_SHORT).show()
            }else{
                var inputNbr = binding.itInputArabic.text.toString().toInt()
                if (inputNbr != totalAbjadValue){
                    binding.tvWrongRight.text = "WRONG!"
                }else{binding.tvWrongRight.text = "Correct:"}
                binding.tvAbjadValue.text = totalAbjadValue.toString()
            }




        }

        next_btn.setOnClickListener{

            if (current_position != word_list.size-1) {
                current_position++
                word = word_list[current_position]
                binding.tvArabicWord.text = word
                totalAbjadValue = ExampleList.getAbjadValue(word)
                binding.tvAbjadValue.text = ""
                binding.tvWrongRight.text = ""

                letterList = mutableListOf<Letter>()
                adapter = LetterAdapter(letterList)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.HORIZONTAL, false
                )

                binding.itInputArabic.getText().clear()
            }else{
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }





        }

        details_btn.setOnClickListener{

            for (letter in word){

                letterAbjadValue =  ExampleList.map.get(letter.toString())!!
                letterList.add(Letter(letter.toString(),letterAbjadValue.toString()))
            }

            adapter = LetterAdapter(letterList)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false)
        }


    }

    fun resetToDefault(){


    }
}