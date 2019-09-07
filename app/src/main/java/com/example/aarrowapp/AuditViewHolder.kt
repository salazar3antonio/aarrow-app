package com.example.aarrowapp

import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.AuditEntity
import com.example.aarrowapp.databinding.ListitemMainEmployeeAuditBinding

class AuditViewHolder(private val auditBinding: ListitemMainEmployeeAuditBinding) : RecyclerView.ViewHolder(auditBinding.root) {

    fun bind(auditEntity: AuditEntity) {
        auditBinding.dataAuditEmployeeName = auditEntity.employeeName
        auditBinding.dataAuditEmployeeId = auditEntity.employeeId
    }
}