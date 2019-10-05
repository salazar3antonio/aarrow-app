package com.example.aarrowapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.viewmodels.EmployeeAuditsViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
This class holds all of the Audits associated with the specified Employee
 */
class EmployeeAuditsActivity : AppCompatActivity() {

    private lateinit var mNewAuditFab: FloatingActionButton
    private lateinit var mAuditViewModel: EmployeeAuditsViewModel
    private var mEmployeeUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main_audits)

        val recyclerView: RecyclerView = findViewById(R.id.rv_employee_main_audits)
        val auditAdapter = AuditListAdapter(this)
        recyclerView.adapter = auditAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)

        val auditDao = AArrowRoomDatabase.getDatabase(applicationContext).auditDao()
        val auditRepository = AuditRepository(auditDao)
        val factory = EmployeeAuditsViewModelFactory(auditRepository, mEmployeeUid)

        mAuditViewModel = ViewModelProvider(this, factory).get(EmployeeAuditsViewModel::class.java)
        mAuditViewModel.employeeAudits.observe(this, Observer {
            auditAdapter.setAudits(it)
        })

        mNewAuditFab = findViewById(R.id.fab_new_audit)
        mNewAuditFab.setOnClickListener {
            val intent = Intent(this, NewAuditActivity::class.java)
            intent.putExtra(EMP_UID, mEmployeeUid)
            startActivity(intent)
        }

    }
}