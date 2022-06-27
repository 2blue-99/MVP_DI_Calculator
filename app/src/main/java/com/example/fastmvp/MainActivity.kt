package com.example.fastmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fastmvp.contract.MainContract
import com.example.fastmvp.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun init() {
        presenter.readLastResult()
    }

    override fun numberButtonClick(number: String) {
        if (presenter.operator.isNotBlank()) {

        } else {
            presenter.number1 = presenter.number1 + number
        }
    }

    override fun operationButtonClick(symbol: String) {
        when (symbol) {
            "+" -> {
                presenter.operator = "+"
            }

            "-" -> {
                presenter.operator = "-"
            }

            "x" -> {
                presenter.operator = "x"
            }

            "/" -> {
                presenter.operator = "/"
            }

            "=" -> {
                presenter.performCalculate()
                presenter.saveLastResult()
                presenter.updateView()
            }
        }
    }

}