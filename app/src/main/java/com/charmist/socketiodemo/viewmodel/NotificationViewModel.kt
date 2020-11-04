package com.charmist.socketiodemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class NotificationViewModel : ViewModel() {

    private val _connectSocketIO = MutableLiveData<Boolean>()
    val connectSocketIO: LiveData<Boolean>
        get() = _connectSocketIO

    fun connectSocketIO() {
        _connectSocketIO.postValue(true)
    }

}