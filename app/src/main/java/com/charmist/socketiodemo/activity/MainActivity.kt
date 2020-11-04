package com.charmist.socketiodemo.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.base.BaseActivity
import com.charmist.socketiodemo.fragment.AchievementFragment
import com.charmist.socketiodemo.fragment.BlankFragment
import com.charmist.socketiodemo.fragment.HomeFragment
import com.charmist.socketiodemo.fragment.NotificationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var fm: FragmentManager
    private lateinit var active: Fragment
    private lateinit var homeFragment: Fragment
    private lateinit var blankFragment: Fragment
    private lateinit var achievementFragment: Fragment
    private lateinit var notificationFragment: Fragment

    override fun layout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        fm = supportFragmentManager
        homeFragment = HomeFragment.newInstance()
        blankFragment = BlankFragment.newInstance()
        achievementFragment = AchievementFragment.newInstance()
        notificationFragment = NotificationFragment.newInstance()
        fm.beginTransaction().add(R.id.container, homeFragment, HomeFragment.TAG).commit()
        fm.beginTransaction().add(R.id.container, blankFragment, BlankFragment.TAG)
            .hide(blankFragment).commit()
        fm.beginTransaction().add(R.id.container, achievementFragment, AchievementFragment.TAG)
            .hide(achievementFragment).commit()
        fm.beginTransaction().add(R.id.container, notificationFragment, NotificationFragment.TAG)
            .hide(notificationFragment).commit()
        active = homeFragment
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    fm.beginTransaction().hide(active).commit()
                    fm.beginTransaction().show(homeFragment).commit()
                    active = homeFragment
                }
                R.id.navigation_blank -> {
                    fm.beginTransaction().hide(active).commit()
                    fm.beginTransaction().show(blankFragment).commit()
                    active = blankFragment
                }

                R.id.navigation_achievement -> {
                    fm.beginTransaction().hide(active).commit()
                    fm.beginTransaction().show(achievementFragment).commit()
                    active = achievementFragment
                }

                R.id.navigation_notification -> {
                    fm.beginTransaction().hide(active).commit()
                    fm.beginTransaction().show(notificationFragment).commit()
                    active = notificationFragment
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}