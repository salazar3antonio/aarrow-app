package com.example.aarrowapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AuditViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
This class holds all of the Audits associated with the specified Employee
 */
class EmployeeAuditsActivity : AppCompatActivity() {

    private lateinit var mNewAuditFab: FloatingActionButton
    private lateinit var mAuditViewModel: AuditViewModel
    private var mEmployeeUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main_audits)

        val recyclerView: RecyclerView = findViewById(R.id.rv_employee_main_audits)
        val auditAdapter = AuditListAdapter(this)
        recyclerView.adapter = auditAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mEmployeeUid = intent.getIntExtra(EmployeeListAdapter.EMP_UID, 0)

        mAuditViewModel = ViewModelProvider(this).get(AuditViewModel::class.java)
        mAuditViewModel.allAudits.observe(this, Observer {
            it -> it.let { auditAdapter.setAudits(it) }
        })

        mNewAuditFab = findViewById(R.id.fab_new_audit)
        mNewAuditFab.setOnClickListener {
            val intent = Intent(this, NewAuditActivity::class.java)
            intent.putExtra(EMP_UID, mEmployeeUid)
            startActivity(intent)
        }

    }
}