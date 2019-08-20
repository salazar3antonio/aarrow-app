package com.example.aarrowapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AuditInformationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_audit_information, container, false)
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "audit_information_fragment_section_number"

        fun newInstance(sectionNumber: Int): AuditInformationFragment {
            //we are returning a fragment
            return AuditInformationFragment().apply {
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