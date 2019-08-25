package com.example.aarrowapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.aarrowapp.EmployeeListAdapter.Companion.EMP_UID
import com.example.aarrowapp.database.AuditViewModel
import com.example.aarrowapp.database.models.AuditEntity
import com.google.android.material.tabs.TabLayout

class NewAuditActivity : AppCompatActivity() {

    lateinit var mAuditViewModel: AuditViewModel
    var mEmployeeUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_audit)

        mEmployeeUid = intent.getIntExtra(EMP_UID, 0)
        mAuditViewModel = ViewModelProvider(this).get(AuditViewModel::class.java)

        val audit = AuditEntity(
            null, mEmployeeUid, null, null, null, null, null,
            null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null,
            null, null
        )

        mAuditViewModel.insert(audit)

        val auditSectionTitles = this.resources.getStringArray(R.array.sa_audit_tabs)
        val auditSectionsPagerAdapter =
            AuditSectionsPagerAdapter(
                supportFragmentManager,
                auditSectionTitles
            )
        val newAuditViewPager: ViewPager = findViewById(R.id.vp_new_audit)
        newAuditViewPager.adapter = auditSectionsPagerAdapter

        val auditTabs: TabLayout = findViewById(R.id.tl_new_audit_tabs)
        auditTabs.setupWithViewPager(newAuditViewPager)

    }
}

