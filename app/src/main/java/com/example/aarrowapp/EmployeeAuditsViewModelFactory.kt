package com.example.aarrowapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.database.AuditRepository

class EmployeeAuditsViewModelFactory(
    val auditRepository: AuditRepository,
    val employeeId: Int
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmployeeAuditsViewModel(auditRepository, employeeId) as T
    }
}