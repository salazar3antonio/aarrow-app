package com.example.aarrowapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.aarrowapp.audit_ui.AuditPagesAdapter
import com.example.aarrowapp.database.AArrowRoomDatabase
import com.example.aarrowapp.database.AuditRepository
import com.example.aarrowapp.database.models.AuditEntity
import com.example.aarrowapp.viewmodels.AuditDetailViewModel
import com.google.android.material.tabs.TabLayout

open class AuditActivity : AppCompatActivity() {

    private lateinit var mAuditDetailViewModel: AuditDetailViewModel
    private lateinit var mAuditEntity: AuditEntity
    var mAuditUid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audit)

        mAuditUid = intent.getIntExtra(AuditListAdapter.AUDIT_UID, 0)

        val auditDao = AArrowRoomDatabase.getDatabase(application).auditDao()
        val auditRepository = AuditRepository(auditDao)
        val auditFactory = AuditViewModelFactory(auditRepository, mAuditUid)

        mAuditDetailViewModel = ViewModelProvider(this, auditFactory).get(AuditDetailViewModel::class.java)
        mAuditDetailViewModel.audit.observe(this, Observer {
            if (it != null) {
                mAuditEntity = it
            }
        })

        val auditSectionTitles = this.resources.getStringArray(R.array.sa_audit_tabs)
        val auditSectionsPagerAdapter =
            AuditPagesAdapter(
                supportFragmentManager,
                auditSectionTitles
            )
        val auditViewPager: ViewPager = findViewById(R.id.vp_audit)
        auditViewPager.adapter = auditSectionsPagerAdapter

        val auditTabs: TabLayout = findViewById(R.id.tl_new_audit_tabs)
        auditTabs.setupWithViewPager(auditViewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_audit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.mi_delete_audit -> {
                mAuditDetailViewModel.deleteAudit(mAuditEntity)
                Toast.makeText(this, "Audit UID: $mAuditUid deleted", Toast.LENGTH_LONG).show()
                finish()
                return true
            }
        }

        return false

    }

}