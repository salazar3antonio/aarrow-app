package com.example.aarrowapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository

class EmployeeProfileViewModelFactory(val employeeRepository: EmployeeRepository, val employeeUid: Int) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmployeeProfileViewModel(employeeRepository, employeeUid) as T
    }
}