package com.example.aarrowapp.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.aarrowapp.database.daos.AuditDao
import com.example.aarrowapp.database.models.AuditEntity

class AuditRepository(private val auditDao: AuditDao) {

    val allAudits: LiveData<List<AuditEntity>> = auditDao.allAudits()

    @WorkerThread
    suspend fun insertAudit(auditEntity: AuditEntity) {
        auditDao.insertAudit(auditEntity)
    }

    fun getAuditsByEmployeeId(uid: Int?): LiveData<List<AuditEntity>> {
        return auditDao.loadAuditsByEmployeeId(uid)
    }

    companion object {
        private val TAG = AuditRepository::class.simpleName
    }

}