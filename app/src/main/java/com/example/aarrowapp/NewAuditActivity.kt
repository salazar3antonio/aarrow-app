package com.example.aarrowapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class NewAuditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_audit)

        val auditSectionTitles = this.resources.getStringArray(R.array.sa_audit_tabs)
        val auditSectionsPagerAdapter = AuditSectionsPagerAdapter(supportFragmentManager, auditSectionTitles)
        val newAuditViewPager: ViewPager = findViewById(R.id.vp_new_audit)
        newAuditViewPager.adapter = auditSectionsPagerAdapter

        val auditTabs: TabLayout = findViewById(R.id.tl_new_audit_tabs)
        auditTabs.setupWithViewPager(newAuditViewPager)

    }
}

