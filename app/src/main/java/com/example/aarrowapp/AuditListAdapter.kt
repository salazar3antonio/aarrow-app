package com.example.aarrowapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.AuditEntity

class AuditListAdapter(private val context: Context) : RecyclerView.Adapter<AuditViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var audits = emptyList<AuditEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuditViewHolder {
        val itemView = inflater.inflate(R.layout.listitem_main_employee_audit, parent, false)
        return AuditViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return audits.size
    }

    override fun onBindViewHolder(holder: AuditViewHolder, position: Int) {

        val audit = audits[position]
        holder.employeeName.text = audit.employeeName
        holder.employeeId.text = audit.employeeId.toString()

    }

    fun setAudits(audits: List<AuditEntity>) {
        this.audits = audits
        notifyDataSetChanged()
    }


}