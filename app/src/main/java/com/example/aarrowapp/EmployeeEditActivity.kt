package com.example.aarrowapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.database.models.EmployeeEntity
import com.example.aarrowapp.databinding.ActivityEmployeeEditBinding
import com.example.aarrowapp.viewmodels.EmployeeDetailViewModel

class EmployeeEditActivity : AppCompatActivity() {

    private var mEmployeeUid: Int = 0
    private lateinit var mEmployeeEntity: EmployeeEntity
    private lateinit var mEmployeeDetailViewModel: EmployeeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityEmployeeEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_employee_edit);

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)

        val employeeDao = AArrowRoomDatabase.getDatabase(application).employeeDao()
        val repository = EmployeeRepository(employeeDao)
        val factory = EmployeeDetailViewModelFactory(repository, mEmployeeUid)

        mEmployeeDetailViewModel =
            ViewModelProvider(this, factory).get(EmployeeDetailViewModel::class.java)
        mEmployeeDetailViewModel.employee.observe(this, Observer {
            if (it != null) {
                mEmployeeEntity = it
                binding.dataEditEmployeeName = mEmployeeEntity.employeeName
            }
        })

        //Access the Button via the Binding Class
        binding.btnSaveEmployeeEdits.setOnClickListener {
            //get the text from the EditText View that is in the Binding class and set it to the EmployeeName
            mEmployeeEntity.employeeName = binding.etEmployeeName.text.toString()
            //Update the EmployeeEntity
            mEmployeeDetailViewModel.updateEmployee(mEmployeeEntity)
            //close the Activity
            finish()
        }

    }

}