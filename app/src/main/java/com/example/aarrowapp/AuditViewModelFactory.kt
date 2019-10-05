package com.example.aarrowapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.viewmodels.AuditDetailViewModel

class AuditViewModelFactory(val auditRepository: AuditRepository, val auditUid: Int) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuditDetailViewModel(auditRepository, auditUid) as T
    }
}