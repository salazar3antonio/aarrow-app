package com.example.aarrowapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.database.models.AuditEntity

class EmployeeAuditsViewModel(
    val auditRepository: AuditRepository,
    val employeeUid: Int?,
    val employeeAudits: LiveData<List<AuditEntity>> = auditRepository.getAuditsByEmployeeUid(employeeUid)
) : ViewModel()



