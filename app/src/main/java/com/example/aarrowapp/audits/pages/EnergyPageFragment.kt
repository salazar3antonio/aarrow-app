package com.example.aarrowapp.audits.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aarrowapp.R

class EnergyPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_audit_page_energy, container, false)
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "audit_energy_fragment_section_number"

        fun newInstance(sectionNumber: Int): EnergyPageFragment {
            return EnergyPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }

}
