package com.example.aarrowapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aarrowapp.database.models.EmployeeEntity

@Dao
interface EmployeeDao {

    @Query ("SELECT * FROM employee_table ORDER BY employeeName ASC")
    fun getAllEmployeesByName(): LiveData<List<EmployeeEntity>>

    @Insert
    suspend fun insert(employee: EmployeeEntity)


}