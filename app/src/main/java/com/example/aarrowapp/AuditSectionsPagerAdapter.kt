package com.example.aarrowapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.aarrowapp.audits.pages.*

class AuditSectionsPagerAdapter(
    fm: FragmentManager,
    private val mSectionTitles: Array<String>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> InformationPageFragment.newInstance(position)
            1 -> AppearancePageFragment.newInstance(position)
            2 -> AdvertisingPageFragment.newInstance(position)
            3 -> EnergyPageFragment.newInstance(position)
            4 -> TechnicalPageFragment.newInstance(position)
            5 -> SubmissionPageFragment.newInstance(position)
            else -> InformationPageFragment.newInstance(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mSectionTitles[position]
    }

    override fun getCount(): Int {
        return mSectionTitles.size
    }


}