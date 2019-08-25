package com.example.aarrowapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val employeeName: TextView = itemView.findViewById(R.id.tv_employee_name)

}