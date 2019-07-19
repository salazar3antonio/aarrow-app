package com.example.aarrowapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.EmployeeEntity

class EmployeeListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var employees = emptyList<EmployeeEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = inflater.inflate(R.layout.listitem_main_employee, parent, false)
        return EmployeeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val current = employees[position]
        holder.employeeItemView.text = current.employeeName
    }

    internal fun setEmployees(employees: List<EmployeeEntity>) {
        this.employees = employees
        notifyDataSetChanged()
    }

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val employeeItemView: TextView = itemView.findViewById(R.id.tv_employee_name)
    }


}