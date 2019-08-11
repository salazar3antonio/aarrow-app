package com.example.aarrowapp.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.EmployeeListAdapter
import com.example.aarrowapp.MainActivity.Companion.newEmployeeRequestCode
import com.example.aarrowapp.NewEmployeeActivity.Companion.EXTRA_EMPLOYEE_NAME
import com.example.aarrowapp.R
import com.example.aarrowapp.MainEmployeesViewModel
import com.example.aarrowapp.database.models.EmployeeEntity

public class MainEmployeeFragment : androidx.fragment.app.Fragment() {

    //newInstance w/ bundle for this Fragment
    //RecyclerView of EmployeeEntity list items
    //Adapter of Employees List. Should be from Room DB
    private lateinit var mainEmployeesViewModel: MainEmployeesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main_employees, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main_employees)
        val adapter = EmployeeListAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mainEmployeesViewModel = ViewModelProviders.of(this).get(MainEmployeesViewModel::class.java)
        mainEmployeesViewModel.allEmployees.observe(this, Observer { employees ->
            employees?.let { adapter.setEmployees(it) }
        })
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == newEmployeeRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val employee = EmployeeEntity(
                    null, it.getStringExtra(EXTRA_EMPLOYEE_NAME),
                    null, null, null,
                    null, null, null,
                    null, null
                )
                mainEmployeesViewModel.insert(employee)
                Toast.makeText(this.context, "Employee " + employee.employeeName + " saved.", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this.context, "Employee not saved.", Toast.LENGTH_LONG).show()
        }

    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): MainEmployeeFragment {
            //we are returning a fragment
            return MainEmployeeFragment().apply {
                //applying our arguments as a bundle object to the fragment
                arguments = Bundle().apply {
                    //applying our key/value pair by invoking the putInt method and passing in the constant String value and section number
                    //this way the arguments from the bundle can ge passed when a new fragment is instantiated
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }


}