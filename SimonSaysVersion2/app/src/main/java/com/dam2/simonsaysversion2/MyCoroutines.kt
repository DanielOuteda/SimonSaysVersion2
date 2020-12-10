package com.dam2.simonsaysversion2

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object MyCoroutines {
    fun outLog() {
        CoroutineScope(Dispatchers.Main).launch {
            suspendFun("Start")
            delay(5000)
            suspendFun("Stop")
        }
    }

    private fun suspendFun(msg: String) {
        Log.d("coroutineMSG", msg)
    }

}