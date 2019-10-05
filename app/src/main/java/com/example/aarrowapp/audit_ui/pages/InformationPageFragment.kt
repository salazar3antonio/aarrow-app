package com.example.aarrowapp.audit_ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.aarrowapp.R
import com.example.aarrowapp.viewmodels.AuditViewModel

class InformationPageFragment : Fragment() {

    private lateinit var mAuditViewModel: AuditViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //this fragment needs access to the specified AuditEntity. This way it can bind and update the ViewModel
        //the Activity does have access to the AuditEntity since it loads it via UID

        return inflater.inflate(R.layout.fragment_audit_page_information, container, false)
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "audit_information_fragment_section_number"

        fun newInstance(sectionNumber: Int): InformationPageFragment {
            //we are returning a fragment
            return InformationPageFragment().apply {
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