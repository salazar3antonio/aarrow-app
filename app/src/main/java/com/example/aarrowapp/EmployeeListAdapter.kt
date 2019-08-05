package com.example.aarrowapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.EmployeeEntity

class EmployeeListAdapter internal constructor(val context: Context) :
    RecyclerView.Adapter<EmployeeViewHolder>() {

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
        holder.listItem.setOnClickListener {
            Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()
            //todo when you click on listItem open up detailed activity of the EmployeeEntity
        }

    }

    internal fun setEmployees(employees: List<EmployeeEntity>) {
        this.employees = employees
        notifyDataSetChanged()
    }

}