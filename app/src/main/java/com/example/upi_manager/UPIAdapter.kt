package com.example.upi_manager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UPIAdapter (val list : ArrayList<UPI>) : RecyclerView.Adapter<UPIAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UPIAdapter.ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UPIAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(upi: UPI){
            val payer = itemView.findViewById<TextView>(R.id.payer_tv)
            val receiver = itemView.findViewById<TextView>(R.id.receiver_tv)
            val money = itemView.findViewById<TextView>(R.id.money_tv)

            payer.text = upi.payer
            receiver.text = upi.receiver
            money.text = upi.money
        }
    }
}