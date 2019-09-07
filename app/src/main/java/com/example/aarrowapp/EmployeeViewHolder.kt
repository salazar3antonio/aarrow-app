package com.example.aarrowapp

import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.EmployeeEntity
import com.example.aarrowapp.databinding.ListitemMainEmployeeBinding

class EmployeeViewHolder(private val employeeBinding: ListitemMainEmployeeBinding) : RecyclerView.ViewHolder(employeeBinding.root) {

    fun bind(employeeEntity: EmployeeEntity) {
        employeeBinding.dataEmployeeName = employeeEntity.employeeName
    }

}