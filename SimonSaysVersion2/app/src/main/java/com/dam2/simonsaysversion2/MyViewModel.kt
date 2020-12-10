package com.dam2.simonsaysversion2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MyViewModel : ViewModel() {
    private val TAG_LOG: String = "MyViewModel"

    val randomList = mutableListOf<Int>()
    val userList = mutableListOf<Int>()
    val roundList = MutableLiveData<MutableList<Int>>()
    val userSequence = MutableLiveData<MutableList<Int>>()
    var userInterctions = 0
    val msgButton = MutableLiveData<String>()

    init {
        roundList
        msgButton.value = "Start"
    }

    //Create the lists

    fun createRoundList(){
        randomList.removeAll(randomList)
        addRound()
        roundList.value = randomList
    }

    fun addRound(){
        randomList.add(Random.nextInt(0,4))
        roundList.postValue(randomList)
        userInterctions = 0
        Log.d(TAG_LOG, "List: " + randomList.toString())
    }


    //Add the color to the user´s list

    fun saveUserList(color: Int){
        userList.add(color)
        userSequence.postValue(userList)
        userInterctions++
    }


    // Now compare the lists to know if you have to continue the game or have to start again.

    fun compareList(): Boolean {
        if (randomList == userList) {
            addRound()
            userList.removeAll(userList)
            return true
        }
        else{
            userList.removeAll(userList)
            return false
        }
    }

    fun outLog(){
        CoroutineScope(Dispatchers.Main).launch {
            suspendFun("Start")
            delay(2000)
            suspendFun("Stop")
        }
    }

    private fun suspendFun(msg: String){
        msgButton.value = msg
        Log.d(TAG_LOG, msg)
    }
}