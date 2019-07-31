package com.example.aarrowapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.EmployeeListAdapter
import com.example.aarrowapp.R
import com.example.aarrowapp.database.EmployeeViewModel

public class MainEmployeeFragment : androidx.fragment.app.Fragment() {

    //newInstance w/ bundle for this Fragment
    //RecyclerView of EmployeeEntity list items
    //Adapter of Employees List. Should be from Room DB
    private lateinit var employeeViewModel: EmployeeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main_employees, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main_employees)
        val adapter = EmployeeListAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        employeeViewModel.allEmployees.observe(this, Observer { employees ->
            employees?.let { adapter.setEmployees(it) }
        })

        return view
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