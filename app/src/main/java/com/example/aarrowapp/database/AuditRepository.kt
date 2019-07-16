package com.example.aarrowapp.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.aarrowapp.database.daos.AuditDao
import com.example.aarrowapp.database.models.AuditEntity

class AuditRepository(private val auditDao: AuditDao) {

    val allAudits: LiveData<List<AuditEntity>> = auditDao.allAuditsOfEmployee()

    @WorkerThread
    suspend fun insertAudit(auditEntity: AuditEntity) {
        auditDao.insertAudit(auditEntity)
    }

}