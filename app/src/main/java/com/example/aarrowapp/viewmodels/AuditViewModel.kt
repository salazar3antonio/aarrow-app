package com.example.aarrowapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.database.models.AuditEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuditViewModel(application: Application) : AndroidViewModel(application) {

    private val auditRepository: AuditRepository

    val allAudits: LiveData<List<AuditEntity>>

    init {
        val auditDao = AArrowRoomDatabase.getDatabase(
            application
        ).auditDao()
        auditRepository = AuditRepository(auditDao)
        allAudits = auditRepository.allAudits
    }

    //viewModelScope.launch makes sure the insertEmployee method is not launched on the main thread
    fun insertAudit(audit: AuditEntity) = viewModelScope.launch(Dispatchers.IO) {
        Log.v(TAG, "Audit ID: " + audit.uid + "inserted into DB")
        auditRepository.insertAudit(audit)
    }

    companion object {
        private val TAG = AuditViewModel::class.simpleName
    }


}