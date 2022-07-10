package com.example.fastmvp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fastmvp.Module.MainModule
import com.example.fastmvp.contract.MainContract
import com.example.fastmvp.databinding.ActivityMainBinding
import com.example.fastmvp.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    private var mainBinding: ActivityMainBinding? = null
    private val b get() = mainBinding!!

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        init()
    }

    override fun init() {
        println("   mainActivity init   ")
        b.textView3.text = presenter.updateView()
    }

    @SuppressLint("SetTextI18n")
    override fun numberButtonClick(buttonId: String) {
        Log.e(javaClass.simpleName, "numberButtonClick: $presenter" )
        if (presenter.operator == "") { // number1 은 끝난 단 소리
            when (buttonId) {
                b.nine.id.toString() -> {
                    presenter.number1 = presenter.number1 + "9"
                    b.textView3.text = presenter.updateView()
                }
                b.eight.id.toString() -> {
                    presenter.number1 = presenter.number1 + "8"
                    b.textView3.text = presenter.updateView()
                }
                b.seven.id.toString() -> {
                    presenter.number1 = presenter.number1 + "7"
                    b.textView3.text = presenter.updateView()
                }
                b.six.id.toString() -> {
                    presenter.number1 = presenter.number1 + "6"
                    b.textView3.text = presenter.updateView()
                }
                b.five.id.toString() -> {
                    presenter.number1 = presenter.number1 + "5"
                    b.textView3.text = presenter.updateView()
                }
                b.four.id.toString() -> {
                    presenter.number1 = presenter.number1 + "4"
                    b.textView3.text = presenter.updateView()
                }
                b.three.id.toString() -> {
                    presenter.number1 = presenter.number1 + "3"
                    b.textView3.text = presenter.updateView()
                }
                b.two.id.toString() -> {
                    presenter.number1 = presenter.number1 + "2"
                    b.textView3.text = presenter.updateView()
                }
                b.one.id.toString() -> {
                    presenter.number1 = presenter.number1 + "1"
                    b.textView3.text = presenter.updateView()
                }
                b.zero.id.toString() -> {
                    presenter.number1 = presenter.number1 + "0"
                    b.textView3.text = presenter.updateView()
                }
            }
        }
        else {
            when (buttonId) {
                b.nine.id.toString() -> {
                    presenter.number2 = presenter.number2 + "9"
                    b.textView3.text = presenter.updateView()
                }
                b.eight.id.toString() -> {
                    presenter.number2 = presenter.number2 + "8"
                    b.textView3.text = presenter.updateView()
                }
                b.seven.id.toString() -> {
                    presenter.number2 = presenter.number2 + "7"
                    b.textView3.text = presenter.updateView()
                }
                b.six.id.toString() -> {
                    presenter.number2 = presenter.number2 + "6"
                    b.textView3.text = presenter.updateView()
                }
                b.five.id.toString() -> {
                    presenter.number2 = presenter.number2 + "5"
                    b.textView3.text = presenter.updateView()
                }
                b.four.id.toString() -> {
                    presenter.number2 = presenter.number2 + "4"
                    b.textView3.text = presenter.updateView()
                }
                b.three.id.toString() -> {
                    presenter.number2 = presenter.number2 + "3"
                    b.textView3.text = presenter.updateView()
                }
                b.two.id.toString() -> {
                    presenter.number2 = presenter.number2 + "2"
                    b.textView3.text = presenter.updateView()
                }
                b.one.id.toString() -> {
                    presenter.number2 = presenter.number2 + "1"
                    b.textView3.text = presenter.updateView()
                }
                b.zero.id.toString() -> {
                    presenter.number2 = presenter.number2 + "0"
                    b.textView3.text = presenter.updateView()
                }
            }
        }


    }

    fun onClickData(view: View) {
        numberButtonClick(view.id.toString())
    }

    fun onClickOperation(view: View) {
        when (view.id) {
            b.result.id -> operationButtonClick(b.result.text.toString())
            b.plus.id -> operationButtonClick(b.plus.text.toString())
            b.minus.id -> operationButtonClick(b.minus.text.toString())
            b.multi.id -> operationButtonClick(b.multi.text.toString())
            b.devision.id -> operationButtonClick(b.devision.text.toString())
            b.mock.id -> operationButtonClick(b.mock.text.toString())
            b.removeAll.id -> operationButtonClick(b.removeAll.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    override fun operationButtonClick(symbol: String) {
        when (symbol) {
            "+" -> {
                presenter.operator = "+"
                b.textView3.text = presenter.updateView()
            }
            "-" -> {
                presenter.operator = "-"
                b.textView3.text = presenter.updateView()
            }
            "x" -> {
                presenter.operator = "x"
                b.textView3.text = presenter.updateView()
            }
            "/" -> {
                presenter.operator = "/"
                b.textView3.text = presenter.updateView()

            }
            "%" -> {
                presenter.operator = "%"
                b.textView3.text = presenter.updateView()

            }
            "=" -> {
                presenter.performCalculate()
                b.textView3.text = presenter.updateView()
                presenter.saveLastResult()
            }
            "C" -> {
                presenter.init()
                b.textView3.text = presenter.updateView()
            }
        }
    }
}