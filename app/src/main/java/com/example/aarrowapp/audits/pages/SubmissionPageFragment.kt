package com.example.aarrowapp.audits.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aarrowapp.R
import com.example.aarrowapp.database.AuditViewModel

class SubmissionPageFragment : Fragment() {

    lateinit var mSaveAuditButton: Button
    lateinit var mAuditViewModel: AuditViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mAuditViewModel = ViewModelProvider(this).get(AuditViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_audit_page_submission, container, false)

        mSaveAuditButton = view.findViewById(R.id.btn_save_audit)
        mSaveAuditButton.setOnClickListener {

        }


        return view
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "audit_submission_fragment_section_number"

        fun newInstance(sectionNumber: Int): SubmissionPageFragment {
            return SubmissionPageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }

}
