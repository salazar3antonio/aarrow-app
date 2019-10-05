package com.example.aarrowapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.aarrowapp.AuditListAdapter.Companion.AUDIT_UID
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.audit_ui.AuditPagesAdapter
import com.example.aarrowapp.database.models.AuditEntity
import com.example.aarrowapp.viewmodels.AuditViewModel
import com.google.android.material.tabs.TabLayout

class NewAuditActivity : AppCompatActivity() {

    lateinit var mAuditViewModel: AuditViewModel
    var mEmployeeUid: Int = 0
    var mAuditUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audit)

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)
        mAuditUid = intent.getIntExtra(AUDIT_UID, 0)

        mAuditViewModel = ViewModelProvider(this).get(AuditViewModel::class.java)

        if (mAuditUid == 0) {
            val audit = AuditEntity(
                null, mEmployeeUid, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null,
                null, null
            )
            mAuditViewModel.insertAudit(audit)
        } else {
            Toast.makeText(this, "Audit UID: $mAuditUid", Toast.LENGTH_LONG).show()
        }

        val auditSectionTitles = this.resources.getStringArray(R.array.sa_audit_tabs)
        val auditSectionsPagerAdapter =
            AuditPagesAdapter(
                supportFragmentManager,
                auditSectionTitles
            )
        val newAuditViewPager: ViewPager = findViewById(R.id.vp_audit)
        newAuditViewPager.adapter = auditSectionsPagerAdapter

        val auditTabs: TabLayout = findViewById(R.id.tl_new_audit_tabs)
        auditTabs.setupWithViewPager(newAuditViewPager)

    }
}

