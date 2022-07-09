package com.example.fastmvp.Module

import android.content.SharedPreferences
import com.example.fastmvp.contract.MainContract
import java.util.prefs.Preferences
import kotlin.coroutines.coroutineContext
private lateinit var getPreferences: SharedPreferences
private lateinit var getSharedPreferences: SharedPreferences
private lateinit var editor: SharedPreferences.Editor

class MainModule : MainContract.Module {
    override fun save(result : String) {
//        SharedPreferences prefs = getPreference(context)
    }

    override fun get(): String {
        TODO("Not yet implemented")
    }

}