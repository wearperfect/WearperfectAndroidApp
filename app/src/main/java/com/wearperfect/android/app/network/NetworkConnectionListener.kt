package com.wearperfect.android.app.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.flow.MutableStateFlow

class NetworkConnectionListener: ConnectivityManager.NetworkCallback() {

    private val isNetworkAvailable = MutableStateFlow(false)

//    fun checkNetworkAvailability(context: Context): MutableStateFlow<Boolean> {
//        val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        connectivityManager.registerDefaultNetworkCallback(this)
//        val isConnected = false
//        connectivityManager.allNetworks
//    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
    }

    override fun onUnavailable() {
        super.onUnavailable()
    }
}