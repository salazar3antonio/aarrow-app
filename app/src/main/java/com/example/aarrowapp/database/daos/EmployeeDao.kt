package com.example.aarrowapp.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.aarrowapp.database.models.EmployeeEntity

@Dao
interface EmployeeDao {

    @Query ("SELECT * FROM employee_table ORDER BY employeeName ASC")
    fun getAllEmployeesByName(): LiveData<List<EmployeeEntity>>

    @Query ("SELECT * FROM employee_table WHERE uid LIKE :uid")
    fun getEmployeeByUid(uid: Int?): LiveData<EmployeeEntity>

    @Insert
    suspend fun insertEmployee(employee: EmployeeEntity)

    @Delete
    fun deleteEmployee(employeeEntity: EmployeeEntity)

    @Update
    fun updateEmployeeProfile(employeeEntity: EmployeeEntity)

}