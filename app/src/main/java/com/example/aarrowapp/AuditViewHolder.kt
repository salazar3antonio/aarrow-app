package com.example.aarrowapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AuditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val employeeName: TextView = itemView.findViewById(R.id.tv_audit_employee_name)
    val employeeId: TextView = itemView.findViewById(R.id.tv_audit_employee_id)
}