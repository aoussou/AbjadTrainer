package com.talisol.abjadtrainer

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager

class AbjadViewModel: ViewModel() {


    private var _wordList = ExampleList.getWordList()

    private var _currentPosition = MutableLiveData<Int>(0)
    private var _currentWord = MutableLiveData<String>(_wordList[_currentPosition.value!!])
    private var _abjadValue = MutableLiveData<Int>(ExampleList.getAbjadValue(_currentWord.value!!))
    private var _letterList = MutableLiveData< MutableList<Letter>>()
    fun numberWords(): Int {
        return _wordList.size
    }


    fun nextQuestion() {

        _currentPosition.value = _currentPosition.value!! + 1
        _currentWord.value = _wordList[_currentPosition.value!!.toInt()]
        _abjadValue.value = ExampleList.getAbjadValue(_currentWord.value!!)
        updateletterList()

    }

    fun currentWord(): LiveData<String> {
        return _currentWord
    }

    fun abjadValue(): LiveData<Int> {
        return _abjadValue
    }


    fun currentPosition(): LiveData<Int> {
        return _currentPosition
    }

    fun letterList(): LiveData<MutableList<Letter>> {
        return _letterList
    }

    fun updateletterList() {

        _letterList.value = mutableListOf<Letter>()

        for (letter in _currentWord.value!!) {

            _letterList.value!!.add(
                Letter(
                    letter.toString(),
                    ExampleList.map.get(letter.toString())!!.toString()
                )
            )


        }

    }
}
