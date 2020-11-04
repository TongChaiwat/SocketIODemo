package com.charmist.socketiodemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.charmist.socketiodemo.fragment.AchievementFragment
import com.charmist.socketiodemo.fragment.BlankFragment
import com.charmist.socketiodemo.fragment.HomeFragment
import com.charmist.socketiodemo.fragment.NotificationFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment.newInstance()
            2 -> AchievementFragment.newInstance()
            3 -> NotificationFragment.newInstance()
            else -> BlankFragment.newInstance()
        }
    }
}