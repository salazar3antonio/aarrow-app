package com.example.aarrowapp

import android.content.ClipData
import android.view.View
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.EmployeeEntity
import com.example.aarrowapp.databinding.ListitemMainEmployeeBinding

class EmployeeViewHolder(private val binding: ListitemMainEmployeeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(employee: EmployeeEntity) {
        binding.dataEmployeeName = employee.employeeName
    }

}