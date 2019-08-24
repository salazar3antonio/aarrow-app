package com.example.aarrowapp.audits.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aarrowapp.R

class AdvertisingPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_audit_page_advertising, container, false)
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "audit_advertising_fragment_section_number"

        fun newInstance(sectionNumber: Int): AdvertisingPageFragment {
            return AdvertisingPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }

}