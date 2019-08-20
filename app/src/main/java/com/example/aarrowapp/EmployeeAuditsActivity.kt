package com.example.aarrowapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
This class holds all of the Audits associated with the specified Employee
 */
class EmployeeAuditsActivity : AppCompatActivity() {

    private lateinit var mNewAuditFab: FloatingActionButton
    private var mEmployeeUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main_audits)

        mEmployeeUid = intent.getIntExtra(EmployeeListAdapter.EMP_UID, 0)

        mNewAuditFab = findViewById(R.id.fab_new_audit)
        mNewAuditFab.setOnClickListener {
            val intent = Intent(this, NewAuditActivity::class.java)
            intent.putExtra(EMP_UID, mEmployeeUid)
            startActivity(intent)
        }

    }
}