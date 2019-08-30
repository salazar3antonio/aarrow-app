package com.example.aarrowapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.database.models.EmployeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeProfileViewModel(
    val employeeRepository: EmployeeRepository,
    val employeeUid: Int,
    val employee: LiveData<EmployeeEntity> = employeeRepository.getEmployeeByUid(employeeUid)
) : ViewModel() {

    fun deleteEmployee(employee: EmployeeEntity) = viewModelScope.launch(Dispatchers.IO) {
        employeeRepository.deleteEmployee(employee)
    }

    fun updateEmployee(employee: EmployeeEntity) = viewModelScope.launch(Dispatchers.IO) {
        employeeRepository.updateEmployee(employee)
    }

}