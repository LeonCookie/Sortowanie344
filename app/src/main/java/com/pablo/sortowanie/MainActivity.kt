package com.pablo.sortowanie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.processNextEventInCurrentThread
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var BtnStart: Button
    lateinit var EditTxt: EditText
    lateinit var ListaPrzed: ListView
    lateinit var ListaPo: ListView
    lateinit var ProgressBar1: ProgressBar
    var ArraySize = 0
    var Progress1 = 0

    val max = 1000
    val min = 0

    fun bubbleSort(arr: IntArray): IntArray {
        var swapped: Boolean
        do {
            swapped = false
            for (i in 0 until arr.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    swapped = true
                  //  Progress1++
                    //ProgressBar1.progress = Progress1

                }
            }
        } while (swapped)
        return arr
    }
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnStart= findViewById(R.id.button)
        EditTxt = findViewById(R.id.editTextNumber)
        ListaPrzed = findViewById(R.id.listViewPrzed)
        ListaPo = findViewById(R.id.listViewPo)
        BtnStart.setOnClickListener {
            if(EditTxt.text.isNotEmpty()){
                ArraySize = EditTxt.text.toString().toInt()
                Log.d("dane","wielkoć tablicy: "+ArraySize)

                var Tablica = IntArray(ArraySize)



                for(i in 0..ArraySize-1){
                      Tablica[i]=(0..1000).random()
                       Log.d("dane","Elementy Tablicy"+i+":"+Tablica[i].toString())

                   }

                val ListBe = Tablica.toList()
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListBe)
                ListaPrzed.adapter = adapter



                var PoTablica = IntArray(ArraySize)
                PoTablica = Tablica


               //ProgressBar1.max= ArraySize
               // Progress1 = 0



                bubbleSort(PoTablica)

              val ListAf = PoTablica.toList()
                val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListAf)
               ListaPo.adapter = adapter1







            }else{
                Log.d("dane","niekliknieto")
                Toast.makeText(this,"Prosze uzupełnić dane",Toast.LENGTH_SHORT)

            }
        }
    }

}