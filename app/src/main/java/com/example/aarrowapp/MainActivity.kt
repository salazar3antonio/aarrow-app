package com.example.aarrowapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.aarrowapp.ui.main.MainSectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainSectionTitles = this.resources.getStringArray(R.array.sa_main_tabs)
        val sectionsPagerAdapter = MainSectionsPagerAdapter(supportFragmentManager, mainSectionTitles)
        val mainViewPager: ViewPager = findViewById(R.id.vp_main)
        mainViewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tl_main_tabs)
        tabs.setupWithViewPager(mainViewPager)

        val fab: FloatingActionButton = findViewById(R.id.fab_new_employee)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewEmployeeActivity::class.java)
            startActivityForResult(intent, newEmployeeRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        for (fragment: Fragment in supportFragmentManager.fragments) {
            fragment.onActivityResult(requestCode, resultCode, data)
        }

    }

    companion object {
        const val newEmployeeRequestCode = 1
    }

}