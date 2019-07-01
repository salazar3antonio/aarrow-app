package com.example.aarrowapp.data.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Query ("SELECT * FROM employee_table ORDER BY employeeName ASC")
    fun getAllEmployeesByName(): LiveData<List<Employee>>

    @Insert
    suspend fun insert(employee: Employee)


}