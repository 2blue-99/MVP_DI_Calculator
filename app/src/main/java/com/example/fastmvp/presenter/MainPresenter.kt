package com.example.fastmvp.presenter

import android.content.SharedPreferences
import com.example.fastmvp.Module.MainModule
import com.example.fastmvp.contract.MainContract

//추상화는
class MainPresenter : MainContract.Presenter {

    var number1: String = ""
    var number2: String = ""
    var operator: String = ""
    var result: String = ""
    private lateinit var module: MainModule

    override fun performCalculate(): String {
        val num1 = number1.toDoubleOrNull()
        val num2 = number2.toDoubleOrNull()

        if (num1 != null && num2 != null) {
            when (operator) {
                "+" -> {
                    result = ((num1 + num2).toInt()).toString()
                }
                "-" -> {
                    result = ((num1 - num2).toInt()).toString()
                }
                "x" -> {
                    result = ((num1 * num2).toInt()).toString()
                }
                "/" -> {
                    result = (num1 / num2).toString()
                }
                "%" -> {
                    result = ((num1 % num2).toInt()).toString()
                }
            }
            number1 = result
            return result
        }
        else return ""
    }

    override fun saveLastResult() {
        module.save(result)
    }

    override fun readLastResult() {

    }

    override fun updateView(): String {
        return number1 + operator + number2
    }

    override fun init() {
        number1 = ""
        number2 = ""
        operator = ""
    }

    // 추가로 작성하는 함수들은 여기다가 추가로 적기.
}