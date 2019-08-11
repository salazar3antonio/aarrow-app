package com.example.aarrowapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository


class EmployeeProfileActivity: AppCompatActivity() {

    private lateinit var employeeViewModel: EmployeeProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_profile)

        val uid = intent.getIntExtra(EMP_UID, 0)
        val employeeNameTextView = findViewById<TextView>(R.id.tv_employee_name)
        val employeeDao = AArrowRoomDatabase.getDatabase(application).employeeDao()
        val repository = EmployeeRepository(employeeDao)
        val factory = EmployeeProfileViewModelFactory(repository, uid)

        employeeViewModel = ViewModelProviders.of(this, factory).get(EmployeeProfileViewModel::class.java)
        employeeViewModel.employee.observe(this, Observer {
            employeeNameTextView.text = it.employeeName
        })

    }
}
