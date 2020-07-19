package com.example.upi_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var upiAdapter : UPIAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upiRv = findViewById<RecyclerView>(R.id.rv)
        upiRv.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        val upi = ArrayList<UPI>()

        upi.add(UPI("abhay","myself","500"))
        upi.add(UPI("abhay","myself","500"))
        upi.add(UPI("abhay","myself","500"))
        upi.add(UPI("abhay","myself","500"))

        val adapter = UPIAdapter(upi)

        upiRv.adapter = adapter
    }

    fun initRecyclerView(){

    }
}