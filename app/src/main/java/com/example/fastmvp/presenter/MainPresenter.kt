package com.example.fastmvp.presenter

import com.example.fastmvp.contract.MainContract

//추상화는
class MainPresenter : MainContract.Presenter {

    var number1: String = ""
    var number2: String = ""
    var operator: String = ""
    var result: String = ""

    override fun performCalculate() {
        val num1 = number1.toDoubleOrNull()
        val num2 = number2.toDoubleOrNull()

        if (num1 != null && num2 != null) {
            when (operator) {
                "+" -> {
                    result = (num1 + num2).toString()
                }
            }
        }
    }

    override fun saveLastResult() {
        TODO("Not yet implemented")
    }

    override fun readLastResult() {
        TODO("Not yet implemented")
    }

    override fun updateView(): String = result

    // 추가로 작성하는 함수들은 여기다가 추가로 적기.
}