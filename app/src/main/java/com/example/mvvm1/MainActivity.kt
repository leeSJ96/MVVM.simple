package com.example.mvvm1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.mvvm1.databinding.ActivityMainBinding
import com.example.mvvm1.utill.Constans

class MainActivity : AppCompatActivity(), View.OnClickListener {





    lateinit var myNumberViewModel: MyNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Tv : TextView = findViewById(R.id.number_textview)
        val plus : Button = findViewById(R.id.plus_btn)
        val minus : Button = findViewById(R.id.minus_btn)
        val edit : EditText = findViewById(R.id.userinput_edittest)


        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)




        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(Constans.TAG, "MainActivity - myNuberViewModel - currentValue 라이브 데이터 값 변경 : $it: ")

            Tv.text = it.toString()


        })

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val plus : Button = findViewById(R.id.plus_btn)
        val minus : Button = findViewById(R.id.minus_btn)
        val edit : EditText = findViewById(R.id.userinput_edittest)
        val userInput = edit.text.toString().toInt()


        when(v){

            plus ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS,userInput)
            minus->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS,userInput)
        }

    }
}