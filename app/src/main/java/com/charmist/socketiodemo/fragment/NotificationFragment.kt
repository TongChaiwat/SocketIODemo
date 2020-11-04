package com.charmist.socketiodemo.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.charmist.socketiodemo.R
import com.charmist.socketiodemo.base.BaseFragment
import com.charmist.socketiodemo.utils.Constant.SOCKET_EVENT_NAME
import com.charmist.socketiodemo.utils.Constant.SOCKET_URL
import com.charmist.socketiodemo.viewmodel.NotificationViewModel
import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import kotlinx.android.synthetic.main.fragment_notification.*
import java.net.URISyntaxException

class NotificationFragment : BaseFragment() {

    private var viewModel: NotificationViewModel? = null
    private val socket: Socket? by lazy {
        try {
            IO.socket(SOCKET_URL)
        } catch (e: URISyntaxException) {
            null
        }
    }
    private var count = 0

    companion object {
        const val TAG = "NotificationFragment"
        fun newInstance() = NotificationFragment()
    }

    override fun layout(): Int {
        return R.layout.fragment_notification
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        observerViewModel()
        viewModel?.connectSocketIO()
    }

    private fun initView() {

    }

    private fun observerViewModel() {
        viewModel = ViewModelProviders.of(this).get(NotificationViewModel::class.java)
        viewModel?.connectSocketIO?.observe(viewLifecycleOwner, {
            socket?.on(Socket.EVENT_CONNECT, onConnect)
            socket?.on(Socket.EVENT_DISCONNECT, onDisconnect)
            socket?.on(Socket.EVENT_CONNECT_ERROR, onConnectError)
            socket?.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError)
            socket?.on(SOCKET_EVENT_NAME, onNewNotification)
            socket?.connect()
        })
    }

    private val onNewNotification = Emitter.Listener {
        activity?.runOnUiThread {
            count++
            cart_badge.text = count.toString()
        }
    }

    private val onConnect = Emitter.Listener { Log.d(TAG, "connected") }

    private val onConnectError = Emitter.Listener { Log.d(TAG, "error connecting...") }

    private val onDisconnect = Emitter.Listener { Log.d(TAG, "disconnect") }

    override fun onDestroy() {
        super.onDestroy()
        socket?.disconnect()
    }

}


