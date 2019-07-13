package com.example.aarrowapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aarrowapp.database.models.AuditEntity

@Dao
interface AuditDao {

    @Query ("SELECT * FROM audit_table ORDER BY date ASC")
    fun allAuditsOfEmployee(): LiveData<List<AuditEntity>>

    @Insert
    suspend fun insertAudit(audit: AuditEntity)

}