package com.charmist.socketiodemo.fragment

import android.os.Bundle
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.base.BaseFragment

class BlankFragment : BaseFragment() {

    companion object {
        const val TAG = "BlankFragment"
        fun newInstance() = BlankFragment()
    }

    override fun layout(): Int {
        return R.layout.fragment_blank
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


