package com.charmist.socketiodemo.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.adapter.AchievementAdapter
import com.charmist.socketiodemo.base.BaseFragment
import com.charmist.socketiodemo.utils.extension.toast
import com.charmist.socketiodemo.viewmodel.AchievementViewModel
import kotlinx.android.synthetic.main.fragment_achievement.*

class AchievementFragment : BaseFragment() {

    private var viewModel: AchievementViewModel? = null

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
        viewModel?.getAchievement()
    }

    private fun initView() {
        val adapter = AchievementAdapter().apply {
            onItemClick = {
                activity?.toast(it)
            }
        }
        rvAchievement.apply {
            layoutManager =
                GridLayoutManager(context, 3)
            this.adapter = adapter
        }
    }

    private fun observerViewModel() {
        viewModel = ViewModelProviders.of(this).get(AchievementViewModel::class.java)
        viewModel?.getAchievement?.observe(viewLifecycleOwner, {
            (rvAchievement.adapter as AchievementAdapter).values = it
        })
    }

}


