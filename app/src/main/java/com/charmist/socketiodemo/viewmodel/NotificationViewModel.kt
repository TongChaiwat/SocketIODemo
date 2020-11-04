package com.charmist.socketiodemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class NotificationViewModel : ViewModel() {

    private val _connectSocketIO = MutableLiveData<Boolean>()
    val connectSocketIO: LiveData<Boolean>
        get() = _connectSocketIO

    private var notificationBadge = 0
    val counterNotification = MutableLiveData<Int>()

    fun connectSocketIO() {
        _connectSocketIO.postValue(true)
    }

    fun countNotification() {
        notificationBadge++
        counterNotification.postValue(notificationBadge)
    }

}