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
        Log.v(TAG, "INSERT -> Audit Id: " + auditEntity.uid + " " + " Employee Name: " + auditEntity.employeeName + " Employee Id: " + auditEntity.employeeId)
        auditDao.insertAudit(auditEntity)
    }

    companion object {
        private val TAG = AuditRepository::class.simpleName
    }

}