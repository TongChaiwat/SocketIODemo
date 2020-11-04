package com.charmist.socketiodemo.fragment

import android.os.Bundle
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.base.BaseFragment

class HomeFragment : BaseFragment() {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    override fun layout(): Int {
        return R.layout.fragment_home
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


