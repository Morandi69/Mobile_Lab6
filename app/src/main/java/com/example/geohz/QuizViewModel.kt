package com.example.geohz

import android.util.Log
import androidx.lifecycle.ViewModel
import java.lang.Math.abs

private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {

    val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    var currentIndex = 0
    var resultPoint=0
    var isCheater = false
    private var promptCounter=3

    val currentQuestionEnableButton: Boolean
        get() = questionBank[currentIndex].enableButton
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
    val currentPromptCount:Int
        get()=promptCounter

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
    fun moveToBack() {
        currentIndex = abs(currentIndex - 1) % questionBank.size
    }
    fun promtUsed(){
        promptCounter=promptCounter-1
    }
    fun FalsedEnableButton(){
        questionBank[currentIndex].enableButton=false
    }
}