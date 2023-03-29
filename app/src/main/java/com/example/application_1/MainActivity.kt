package com.example.application_1

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val dropdownlist1= arrayOf("Wood", "Rope")
    private val dropdownlist2= arrayOf("Stone", "Steel")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist1)
        val adapter2=ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist2)


        val b1= findViewById<Button>(R.id.button)


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

        val mDialog = Dialog(this)
        mDialog.setContentView(R.layout.modal)
        mDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


        Handler(Looper.getMainLooper()).postDelayed({
            mDialog.show()
            Handler(Looper.getMainLooper()).postDelayed({
                mDialog.hide()
            }, 4000) }
            ,250)

        elements1.adapter=adapter
        elements1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                if(elements1.selectedItemPosition==0)
                {
                    textView.text = " " + elements1.selectedItem

                }
                if(elements1.selectedItemPosition==1)
                {
                    textView.text = " " + elements1.selectedItem

                }
            }
        }

        elements2.adapter=adapter2
        elements2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                if(elements2.selectedItemPosition==0)
                {
                    textView2.text = " " + elements2.selectedItem

                }
                if(elements2.selectedItemPosition==1)
                {
                    textView2.text = " " + elements2.selectedItem

                }
            }
        }

        b1.setOnClickListener{
            if(elements1.selectedItemPosition==0 && elements2.selectedItemPosition==0)
            {
                textView3.text = "The result is: Stone Axe"
            }
            if(elements1.selectedItemPosition==0 && elements2.selectedItemPosition==1)
            {
                textView3.text = "The result is: Spear"
            }

            if(elements1.selectedItemPosition==1 && elements2.selectedItemPosition==0)
            {
                textView3.text = "The result is: Bolas"
            }

            if(elements1.selectedItemPosition==1 && elements2.selectedItemPosition==1)
            {
                textView3.text = "The result is: Kunai Rope"
            }

        }
    }
}
