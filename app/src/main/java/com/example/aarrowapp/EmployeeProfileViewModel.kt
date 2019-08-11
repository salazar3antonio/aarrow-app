package com.example.aarrowapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.database.models.EmployeeEntity

class EmployeeProfileViewModel(
    employeeRepository: EmployeeRepository,
    employeeUid: Int,
    val employee: LiveData<EmployeeEntity> = employeeRepository.getEmployeeByUid(employeeUid)
) : ViewModel() {


}