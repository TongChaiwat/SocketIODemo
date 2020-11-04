package com.charmist.socketiodemo.fragment

import android.os.Bundle
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.base.BaseFragment

class AchievementFragment : BaseFragment() {

    companion object {
        const val TAG = "AchievementFragment"
        fun newInstance() = AchievementFragment()
    }

    override fun layout(): Int {
        return R.layout.fragment_achievement
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        observerViewModel()
    }

    private fun initView() {

    }

    private fun observerViewModel() {

    }

}


