package com.example.aarrowapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.viewmodels.EmployeeDetailViewModel

class EmployeeDetailViewModelFactory(
    val employeeRepository: EmployeeRepository,
    val employeeUid: Int
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmployeeDetailViewModel(
            employeeRepository,
            employeeUid
        ) as T
    }
}