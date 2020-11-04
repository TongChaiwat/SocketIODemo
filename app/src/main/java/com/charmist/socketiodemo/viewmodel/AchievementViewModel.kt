package com.charmist.socketiodemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AchievementViewModel : ViewModel() {

    private val _getAchievement = MutableLiveData<MutableList<String>>()
    val getAchievement: LiveData<MutableList<String>>
        get() = _getAchievement

    fun getAchievement() {
        val list = emptyList<String>().toMutableList()
        for (i in 0..100) {
            list.add(i, "Achievement $i")
        }
        _getAchievement.postValue(list)
    }

}