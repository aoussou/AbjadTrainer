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
    private var _letterList = MutableLiveData< MutableList<Letter>>(mutableListOf())
    private var _abjadValueShown = MutableLiveData<Boolean>(false)
    private var _detailsShown = MutableLiveData<Boolean>(false)
    private var _answerRightWrong = MutableLiveData<String>("")

    fun numberWords(): Int {
        return _wordList.size
    }

    fun currentValues(){

        _currentWord.value = _wordList[_currentPosition.value!!.toInt()]
        _abjadValue.value = ExampleList.getAbjadValue(_currentWord.value!!)
        updateletterList()
    }

    fun nextQuestion() {
        _currentPosition.value = _currentPosition.value!! + 1
        currentValues()
        _abjadValueShown.value = false
        _detailsShown.value = false
    }

    fun currentWord(): LiveData<String> {
        return _currentWord
    }

    fun abjadValue(): LiveData<Int> {
        return _abjadValue
    }

    fun abjadValueShown(): LiveData<Boolean> {
        return _abjadValueShown
    }

    fun showAbjadValue(){
        _abjadValueShown.value = true
    }

    fun detailsShown(): LiveData<Boolean> {
        return _detailsShown
    }

    fun showDetails(){
        _detailsShown.value = true
    }

    fun setToRight(){
        _answerRightWrong.value = "Correct!"
    }

    fun setToWrong(){
        _answerRightWrong.value = "WRONG!"
    }

    fun rightOrWrong():LiveData<String>{
        return _answerRightWrong
    }


    fun currentPosition(): LiveData<Int> {
        return _currentPosition
    }

    fun letterList(): LiveData<MutableList<Letter>> {
        return _letterList
    }

    private fun updateletterList() {

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
