package com.example.aarrowapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.EmployeeRepository
import com.example.aarrowapp.database.models.EmployeeEntity


class EmployeeProfileActivity : AppCompatActivity() {

    private lateinit var mEmployeeEntity: EmployeeEntity
    private lateinit var mEmployeeViewModel: EmployeeProfileViewModel
    private lateinit var mEmployeeNameTextView: TextView
    private var mEmployeeUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_profile)

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)
        mEmployeeNameTextView = findViewById(R.id.tv_employee_name)
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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_employee_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.mi_delete_employee_profile -> {
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                mEmployeeViewModel.delete(mEmployeeEntity)
                finish()
                return true
            }
            R.id.mi_edit_employee_profile -> {
                val editIntent = Intent(this, EmployeeEditProfile::class.java)
                editIntent.putExtra(EMP_UID, mEmployeeUid)
                startActivity(editIntent)
                return true
            }
        }

        return false

    }

    fun updateUI(employeeEntity: EmployeeEntity) {
        if (employeeEntity == null) {
            return
        }
        mEmployeeNameTextView.text = employeeEntity.employeeName

    }
}
