package com.example.upi_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.upi_manager.databinding.ActivityPayBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Pay : AppCompatActivity() {

        lateinit var binding: ActivityPayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val db = FirebaseFirestore.getInstance()
        binding.payButton.setOnClickListener(){

            val payToName = binding.payTo.text.toString().trim()
            val money = binding.payAmount.text.toString().trim()
            val paidByName = binding.by.text.toString().trim()

            val info = hashMapOf(
                "payTo" to payToName,
                "paidBy" to paidByName,
                "amount" to money
            )

            db.collection("UPI")
                .add(info)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{exception ->
                    Toast.makeText(applicationContext,"Failure",Toast.LENGTH_SHORT).show()
                }
        }
    }
}