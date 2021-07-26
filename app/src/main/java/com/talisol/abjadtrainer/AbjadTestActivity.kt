package com.talisol.abjadtrainer

import android.os.Bundle
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

        var current_position = 0

        var word = word_list[0]
        binding.tvArabicWord.text = word
        var totalAbjadValue = ExampleList.getAbjadValue(word)

        submit_btn.setOnClickListener{
            var inputNbr = binding.itInputArabic.text.toString().toInt()

            if (inputNbr != totalAbjadValue){

                val letterList = mutableListOf<Letter>()
                for (letter in word){

                    var letterAbjadValue =  ExampleList.map.get(letter.toString())
                    letterList.add(Letter(letter.toString(),letterAbjadValue.toString()))
                }

                val adapter = LetterAdapter(letterList)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL,false)

                binding.tvWrongRight.text = "WRONG!"

            }else{binding.tvWrongRight.text = "Correct:"}

            binding.tvAbjadValue.text = totalAbjadValue.toString()


        }



    }
}