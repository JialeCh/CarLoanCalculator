package com.example.carloancalculator

import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculation(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset(it)
        }
    }

    private fun calculation(view: View) {
        val editCarPrice = editTextCarPrice.text.toString()
        val editDownPayment = editTextDownPayment.text.toString()
        val editLoan = editTextLoanPeriod.text.toString()
        val editInterest = editTextInterestRate.text.toString()

        var loan = editCarPrice.toDouble() - editDownPayment.toDouble()
        var interest : Double = editLoan.toDouble() * loan * (editInterest.toDouble()/100)
        var monthRepay = (loan + interest) / editLoan.toDouble() / 12
       textViewLoan.text = "Loan : %.2f".format(loan)
        textViewInterest.text ="Interest : %.2f".format(interest)
        textViewMonthlyRepayment.text ="Monthly Repayment : %.2f".format(monthRepay)

        // Hide the keyboard.as


    }

    private fun reset(view: View) {
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
        textViewLoan.setText("Loan : ")
        textViewInterest.text ="Interest : "
        textViewMonthlyRepayment.text ="Monthly Repayment : "

        editTextCarPrice.requestFocus()


    }


}


