package com.example.aarrowapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.database.models.EmployeeEntity
import com.example.aarrowapp.databinding.ActivityEmployeeProfileBinding
import com.example.aarrowapp.viewmodels.EmployeeDetailViewModel


class EmployeeDetailActivity : AppCompatActivity() {

    private lateinit var mEmployeeEntity: EmployeeEntity
    private lateinit var mEmployeeDetailViewModel: EmployeeDetailViewModel
    private var mEmployeeUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityEmployeeProfileBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_employee_profile)

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)

        val employeeDao = AArrowRoomDatabase.getDatabase(application).employeeDao()
        val repository = EmployeeRepository(employeeDao)
        val factory = EmployeeDetailViewModelFactory(repository, mEmployeeUid)

        mEmployeeDetailViewModel =
            ViewModelProvider(this, factory).get(EmployeeDetailViewModel::class.java)
        mEmployeeDetailViewModel.employee.observe(this, Observer {
            if (it != null) {
                mEmployeeEntity = it
                binding.dataEmployeeName = mEmployeeEntity.employeeName
            }
        })

        binding.btnEmployeeAudits.setOnClickListener {
            val intent = Intent(this, EmployeeAuditsActivity::class.java)
            intent.putExtra(EMP_UID, mEmployeeUid)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_employee_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.mi_delete_employee_profile -> {
                Toast.makeText(this, "Deleted " + mEmployeeEntity.employeeName, Toast.LENGTH_SHORT)
                    .show()
                mEmployeeDetailViewModel.deleteEmployee(mEmployeeEntity)
                finish()
                return true
            }
            R.id.mi_edit_employee_profile -> {
                val editIntent = Intent(this, EmployeeEditActivity::class.java)
                editIntent.putExtra(EMP_UID, mEmployeeUid)
                startActivity(editIntent)
                return true
            }
        }

        return false

    }

}
