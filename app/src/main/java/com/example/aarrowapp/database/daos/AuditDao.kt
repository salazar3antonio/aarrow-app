package com.example.aarrowapp.database.daos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.database.models.AuditEntity

@Dao
interface AuditDao {

    @Query("SELECT * FROM audit_table ORDER BY date ASC")
    fun allAudits(): LiveData<List<AuditEntity>>

    @Query("SELECT * FROM audit_table WHERE employeeId LIKE :uid")
    fun getAuditsByEmployeeUid(uid: Int?): LiveData<List<AuditEntity>>

    @Query("SELECT * FROM audit_table WHERE uid LIKE :uid")
    fun getAuditByUid(uid: Int?): LiveData<AuditEntity>

    @Insert
    suspend fun insertAudit(audit: AuditEntity)

    @Delete
    fun deleteAudit(audit: AuditEntity)

}