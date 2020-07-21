package com.example.upi_manager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class MainActivity : AppCompatActivity() {
    val upi = ArrayList<UPI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val payTv = findViewById<TextView>(R.id.pay_tv)
        val upiRv = findViewById<RecyclerView>(R.id.rv)
        upiRv.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        /*val adapter = UPIAdapter(upi)

        upiRv.adapter = adapter*/
        payTv.setOnClickListener{
            val intent = Intent(this,Pay::class.java)
            startActivity(intent)
        }
    //    firestore()
        val db = FirebaseFirestore.getInstance()
        db.collection("UPI")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAG", document.getString("amount"))
                    Log.d("TAG", document.getString("paidBy"))
                    Log.d("TAG", document.getString("payTo"))
                    val paidBy : String? = "Paid By : " + document.getString("paidBy")
                    val payTo : String? = "Paid To : " + document.getString("payTo")
                    val amount : String? ="Amount : " + document.getString("amount")
                    upi.add(UPI(paidBy,payTo,amount))
                    val adapter = UPIAdapter(upi)

                    upiRv.adapter = adapter
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }
        /*upi.add(UPI("abhay","myself","500"))
        upi.add(UPI("abhay","myself","500"))
        upi.add(UPI("abhay","myself","500"))
        upi.add(UPI("abhay","myself","500"))*/

        /*val adapter = UPIAdapter(upi)

        upiRv.adapter = adapter*/
    }
}