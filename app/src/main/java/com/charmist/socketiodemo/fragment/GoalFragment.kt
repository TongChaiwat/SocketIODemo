package com.charmist.socketiodemo.fragment

import android.os.Bundle
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.base.BaseFragment

class GoalFragment : BaseFragment() {

    companion object {
        const val TAG = "GoalFragment"
        fun newInstance() = GoalFragment()
    }

    override fun layout(): Int {
        return R.layout.fragment_goal
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


