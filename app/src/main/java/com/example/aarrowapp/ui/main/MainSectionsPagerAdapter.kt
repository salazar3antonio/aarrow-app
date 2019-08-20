package com.example.aarrowapp.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/mSectionTitles/pages.
 */
open class MainSectionsPagerAdapter(
    fm: FragmentManager,
    private val mSectionTitles: Array<String>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        return when (position) {
            0 -> MainEmployeeFragment.newInstance(position)
            1 -> MainScheduleFragment.newInstance(position)
            else -> MainEmployeeFragment.newInstance(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mSectionTitles[position]
    }

    override fun getCount(): Int {
        return mSectionTitles.size
    }
}