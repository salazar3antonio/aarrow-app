package com.example.aarrowapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aarrowapp.R

public class MainEmployeeFragment : androidx.fragment.app.Fragment() {

    //newInstance w/ bundle for this Fragment
    //RecyclerView of Employee list items
    //Adapter of Employees List. Should be from Room DB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_employees, container, false)
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