package com.example.aarrowapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.database.models.AuditEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuditDetailViewModel(
    val auditRepository: AuditRepository,
    val auditUid: Int,
    val audit: LiveData<AuditEntity> = auditRepository.getAuditByUid(auditUid)
) : ViewModel() {

    fun deleteAudit(audit: AuditEntity) = viewModelScope.launch(Dispatchers.IO) {
        auditRepository.deleteAudit(audit)
    }

}