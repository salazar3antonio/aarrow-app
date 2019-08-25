package com.example.aarrowapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.EmployeeEntity

class EmployeeListAdapter(private val context: Context) :
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
        val employee = employees[position]
        val uid = employee.uid
        holder.employeeName.text = employee.employeeName
        holder.itemView.setOnClickListener {
            val intent = Intent(context, EmployeeProfileActivity::class.java)
            intent.putExtra(EMP_UID, uid)
            context.startActivity(intent)
        }

    }

    internal fun setEmployees(employees: List<EmployeeEntity>) {
        this.employees = employees
        notifyDataSetChanged()
    }

    companion object {
        const val EMP_UID = "employeeUid"
    }


}