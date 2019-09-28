package com.example.aarrowapp.database

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.aarrowapp.database.daos.EmployeeDao
import com.example.aarrowapp.database.models.EmployeeEntity

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    val allEmployees: LiveData<List<EmployeeEntity>> = employeeDao.getAllEmployeesByName()

    @WorkerThread
    suspend fun insertEmployee(employeeEntity: EmployeeEntity) {
        Log.v(TAG, "Employee " + employeeEntity.employeeName + " inserted to DB")
        employeeDao.insertEmployee(employeeEntity)
    }

    fun getEmployeeByUid(uid: Int?): LiveData<EmployeeEntity> {
        Log.v(TAG, "Employee Id: " + uid.toString())
        return employeeDao.getEmployeeByUid(uid)
    }

    @WorkerThread
    fun deleteEmployee(employeeEntity: EmployeeEntity) {
        Log.v(TAG, "Employee " + employeeEntity.employeeName + " deleted from DB")
        employeeDao.deleteEmployee(employeeEntity)
    }

    @WorkerThread
    fun updateEmployee(employeeEntity: EmployeeEntity) {
        Log.v(TAG, employeeEntity.employeeName + " has been updated")
        employeeDao.updateEmployeeProfile(employeeEntity)
    }

    companion object {
        private val TAG = EmployeeRepository::class.simpleName
    }


}