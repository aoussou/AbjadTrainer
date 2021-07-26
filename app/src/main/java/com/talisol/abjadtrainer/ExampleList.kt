package com.talisol.abjadtrainer

object ExampleList {
    val map = AbjadMapping.map

    fun getAbjadValue(ArabicWord:String):Int{
        var abjadValue = 0
        var LetterList = ArabicWord.toString()
        for (letter in LetterList){
            abjadValue += map.get(letter.toString())!!
        }

        return abjadValue
    }

    fun getWordList() : List<String>{

        var wordList = listOf<String>(
            "نور",
            "کلب",
            "نار",
            "شجر",
            "برج"
        )

        return wordList
    }



}