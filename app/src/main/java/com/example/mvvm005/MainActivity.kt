package com.example.mvvm005

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    //texts
    val tvResult:TextView by lazy { findViewById(R.id.tv_result) }
    val expression:TextView by lazy { findViewById(R.id.tv_expression) }
    //numbers
    val tvZero:TextView by lazy { findViewById(R.id.tv_zero) }
    val tvOne:TextView by lazy { findViewById(R.id.tv_one) }
    val tvTwo:TextView by lazy { findViewById(R.id.tv_two) }
    val tvThree:TextView by lazy { findViewById(R.id.tv_three) }
    val tvFour:TextView by lazy { findViewById(R.id.tv_four) }
    val tvFive:TextView by lazy { findViewById(R.id.tv_five) }
    val tvSix:TextView by lazy { findViewById(R.id.tv_six) }
    val tvSeven:TextView by lazy { findViewById(R.id.tv_seven) }
    val tvEight:TextView by lazy { findViewById(R.id.tv_eight) }
    val tvNine:TextView by lazy { findViewById(R.id.tv_nine) }
    val tvDot:TextView by lazy { findViewById(R.id.tv_dot) }

    //operation
    val tvClaer:TextView by lazy { findViewById(R.id.tv_clear) }
    val tvLeftParenthesis:TextView by lazy { findViewById(R.id.tv_left_parenthesis) }
    val tvRightParenthesis:TextView by lazy { findViewById(R.id.tv_right_parenthesis) }
    val tvDivision:TextView by lazy { findViewById(R.id.tv_division) }
    val tvMultiplication:TextView by lazy { findViewById(R.id.tv_multiplication) }
    val tvPlus:TextView by lazy { findViewById(R.id.tv_plus) }
    val tvSubtraction:TextView by lazy { findViewById(R.id.tv_subtraction) }
    val tvEqual:TextView by lazy { findViewById(R.id.tv_equal) }
    val ivDelet:ImageView by lazy { findViewById(R.id.iv_delet) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Numbers
        tvOne.setOnClickListener { appendOnExpression("1",true) }
        tvTwo.setOnClickListener { appendOnExpression("2",true) }
        tvThree.setOnClickListener { appendOnExpression("3",true) }
        tvFour.setOnClickListener { appendOnExpression("4",true) }
        tvFive.setOnClickListener { appendOnExpression("5",true) }
        tvSix.setOnClickListener { appendOnExpression("6",true) }
        tvSeven.setOnClickListener { appendOnExpression("7",true) }
        tvEight.setOnClickListener { appendOnExpression("8",true) }
        tvNine.setOnClickListener { appendOnExpression("9",true) }
        tvZero.setOnClickListener { appendOnExpression("0",true) }
        tvDot.setOnClickListener { appendOnExpression(".",true) }
        //Operations

        tvLeftParenthesis.setOnClickListener { appendOnExpression("(",false) }
        tvRightParenthesis.setOnClickListener { appendOnExpression(")",false )}
        tvPlus.setOnClickListener { appendOnExpression("+",false )}
        tvSubtraction.setOnClickListener { appendOnExpression("-",false) }
        tvMultiplication.setOnClickListener { appendOnExpression("*",false) }
        tvDivision.setOnClickListener {  appendOnExpression("/",false)}

        tvEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(expression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()){
                    tvResult.text = longResult.toString()
                }else{
                    tvResult.text = result.toString()
                }

            }catch (e: Exception){
                Log.d("Exception","message : ${e.message}")
            }
        }

        tvClaer.setOnClickListener {
            expression.text = ""
            tvResult.text = ""
        }
        ivDelet.setOnClickListener {
            val str:String =expression.text.toString()
            if (str.isNotEmpty()){
                expression.text = str.substring(0,str.length-1)
            }
            tvResult.text =""

        }

    }
    fun appendOnExpression(str:String,canClear: Boolean) {
        if (tvResult.text.isNotEmpty()){
            expression.text = ""
        }

        if(canClear){
            tvResult.text = ""
            expression.append(str)
        }else{
            expression.append(tvResult.text)
            expression.append(str)
            tvResult.text =""
        }

    }
}