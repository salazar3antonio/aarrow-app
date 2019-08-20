package com.example.aarrowapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_new_audit.*

class AuditSectionsPagerAdapter(
    fm: FragmentManager,
    private val mSectionTitles: Array<String>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AuditInformationFragment.newInstance(position)
            //todo: create all Audit Fragment pages for the entire Audit report
            else -> AuditInformationFragment.newInstance(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mSectionTitles[position]
    }

    override fun getCount(): Int {
        return mSectionTitles.size
    }


}