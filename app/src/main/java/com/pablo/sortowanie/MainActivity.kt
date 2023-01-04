package com.pablo.sortowanie

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var BtnStart: Button
    lateinit var EditTxt: EditText
    var ArraySize = 0
    var ProgressBar = 0
    var amplititudes : ArrayList<Int> = ArrayList()

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnStart= findViewById(R.id.button)
        EditTxt = findViewById(R.id.editTextNumber)
        BtnStart.setOnClickListener {
            if(EditTxt.text.isNotEmpty()){
                ArraySize = EditTxt.text.toString().toInt()
                Log.d("dane","wielkoć tablicy: "+ArraySize)
                BtnStart.isEnabled==false

                amplititudes = (1..ArraySize).map { (0..100).random() } as ArrayList<Int>
                for (element in amplititudes.indices) {
                    Log.d("dane","Elementy Tablicy:"+amplititudes[element]
                }

            }else{

            }
        }
    }

}