package com.example.fastmvp.Module

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import com.example.fastmvp.contract.SharedpreferenceModule
import javax.inject.Inject

class MainModule @Inject constructor(
    private val context: Context
): SharedpreferenceModule {

    private val sharedPreferences = context.getSharedPreferences("file_key", Context.MODE_PRIVATE)

    @Synchronized
    override fun save(result : String) {
        Log.e(javaClass.simpleName, "save: $result", )
        sharedPreferences.edit(false) {
            putString("lastest_value", result)
        }
    }

    override fun get(): String {
        Log.e(javaClass.simpleName, "get:", )
        return sharedPreferences.getString("lastest_value", "") ?: ""
    }

}