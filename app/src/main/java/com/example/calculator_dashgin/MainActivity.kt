package com.example.calculator_dashgin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator_dashgin.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn0.setOnClickListener { setTextFields("0") }
        binding.btn1.setOnClickListener { setTextFields("1") }
        binding.btn2.setOnClickListener { setTextFields("2") }
        binding.btn3.setOnClickListener { setTextFields("3") }
        binding.btn4.setOnClickListener { setTextFields("4") }
        binding.btn5.setOnClickListener { setTextFields("5") }
        binding.btn6.setOnClickListener { setTextFields("6") }
        binding.btn7.setOnClickListener { setTextFields("7") }
        binding.btn8.setOnClickListener { setTextFields("8") }
        binding.btn9.setOnClickListener { setTextFields("9") }
        binding.btnDot.setOnClickListener { setTextFields(".") }
        binding.btnAdd.setOnClickListener { setTextFields("+") }
        binding.btnSubtract.setOnClickListener { setTextFields("-") }
        binding.btnMultiply.setOnClickListener { setTextFields("*") }
        binding.btnDivide.setOnClickListener { setTextFields("/") }
        binding.btnOpenBracket.setOnClickListener { setTextFields("(") }
        binding.btnCloseBracket.setOnClickListener { setTextFields(")") }

        binding.btnClear.setOnClickListener {
            binding.inputText.text = ""
            binding.resultText.text = ""
        }

        binding.btnBackspace.setOnClickListener {
            val text = binding.inputText.text.toString()
            if (text.isNotEmpty()) {
                binding.inputText.text = text.substring(0, text.length - 1)
            }
        }

        binding.btnEquals.setOnClickListener {
            try {
                val text = binding.inputText.text.toString()
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.resultText.text = longResult.toString()
                } else {
                    binding.resultText.text = result.toString()
                }
            } catch (e: Exception) {
                binding.resultText.text = e.message
            }
        }
    }

    private fun setTextFields(str: String) {
        binding.inputText.append(str)
    }
}
