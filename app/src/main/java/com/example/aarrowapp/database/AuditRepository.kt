package com.example.aarrowapp.database

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.aarrowapp.database.daos.AuditDao
import com.example.aarrowapp.database.models.AuditEntity

class AuditRepository(private val auditDao: AuditDao) {

    val allAudits: LiveData<List<AuditEntity>> = auditDao.allAudits()

    @WorkerThread
    suspend fun insertAudit(auditEntity: AuditEntity) {
        Log.v(TAG, "Audit Number: " + auditEntity.uid + " inserted to DB")
        auditDao.insertAudit(auditEntity)
    }

    fun getAuditsByEmployeeUid(uid: Int?): LiveData<List<AuditEntity>> {
        return auditDao.getAuditsByEmployeeUid(uid)
    }

    fun getAuditByUid(uid: Int?): LiveData<AuditEntity> {
        return auditDao.getAuditByUid(uid)
    }

    @WorkerThread
    fun deleteAudit(audit: AuditEntity) {
        Log.v(TAG, "Audit ID: ${audit.uid} deleted from DB")
        auditDao.deleteAudit(audit)
    }

    companion object {
        private val TAG = AuditRepository::class.simpleName
    }

}