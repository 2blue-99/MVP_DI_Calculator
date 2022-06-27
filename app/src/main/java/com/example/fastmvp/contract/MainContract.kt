package com.example.fastmvp.contract

interface MainContract {


    //상속

    // 다른 개발자가 해당 인터페이스로 전체적 흐름 파악
    interface View {
        fun init()
        fun numberButtonClick(number: String)
        fun operationButtonClick(symbol: String)
    }

    //View 를 통해서 Presenter 가 해야 할 일
    interface Presenter {
        fun performCalculate()
        fun saveLastResult()
        fun readLastResult()
        fun updateView(): String
    }
}