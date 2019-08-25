package com.example.aarrowapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.aarrowapp.database.models.AuditEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuditViewModel(application: Application) : AndroidViewModel(application) {

    private val auditRepository: AuditRepository

    val allAudits: LiveData<List<AuditEntity>>

    init {
        val auditDao = AArrowRoomDatabase.getDatabase(application).auditDao()
        auditRepository = AuditRepository(auditDao)
        allAudits = auditRepository.allAudits
    }

    //viewModelScope.launch makes sure the insertEmployee method is not launched on the main thread
    fun insert(audit: AuditEntity) = viewModelScope.launch(Dispatchers.IO) {
        auditRepository.insertAudit(audit)
    }

    //todo: create function that gets all Audits of one Employee. Pass in Employee Id

}