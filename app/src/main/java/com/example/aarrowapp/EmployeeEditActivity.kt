package com.example.aarrowapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.database.models.EmployeeEntity
import com.google.android.material.textfield.TextInputEditText

class EmployeeEditActivity : AppCompatActivity() {

    private var mEmployeeUid: Int = 0
    private lateinit var mEmployeeEntity: EmployeeEntity
    private lateinit var mEmployeeViewModel: EmployeeProfileViewModel
    private lateinit var mEmployeeNameEditText: TextInputEditText
    private lateinit var mSaveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_edit)

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)
        mEmployeeNameEditText = findViewById(R.id.et_employee_name)
        mSaveButton = findViewById(R.id.btn_save_employee_edits)

        val employeeDao = AArrowRoomDatabase.getDatabase(application).employeeDao()
        val repository = EmployeeRepository(employeeDao)
        val factory = EmployeeProfileViewModelFactory(repository, mEmployeeUid)

        mEmployeeViewModel = ViewModelProviders.of(this, factory).get(EmployeeProfileViewModel::class.java)
        mEmployeeViewModel.employee.observe(this, Observer {
            if (it != null) {
                mEmployeeEntity = it
                updateUI(it)
            }
        })

        mSaveButton.setOnClickListener({
            mEmployeeEntity.employeeName = mEmployeeNameEditText.text.toString()
            mEmployeeViewModel.updateEmployee(mEmployeeEntity)
            finish()
        })

    }

    fun updateUI(employeeEntity: EmployeeEntity) {
        if (employeeEntity == null) {
            return
        }
        mEmployeeNameEditText.setText(employeeEntity.employeeName)

    }
}