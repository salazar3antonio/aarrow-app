package com.example.aarrowapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.aarrowapp.ui.main.SectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewEmployeeActivity::class.java)
            startActivityForResult(intent, newEmployeeRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newEmployeeRequestCode && resultCode == Activity.RESULT_OK) {
            //todo: get the new employee name from the Intent Extra and insert it into the DB by using View Model
            Toast.makeText(applicationContext, "Employee saved.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "Employee not saved.", Toast.LENGTH_LONG).show()
        }

    }

    companion object {
        const val newEmployeeRequestCode = 1
    }

}