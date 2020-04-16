package com.example.mobsofthw.models.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkHelper {

    private fun getNetworkStatus(context: Context): NetworkStatus {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return if (isConnected) {
            if (activeNetwork?.type == ConnectivityManager.TYPE_WIFI) NetworkStatus.NETWORK_WIFI else NetworkStatus.NETWORK_MOBILE
        } else NetworkStatus.NETWORK_NO_CONNECTION
    }

    fun checkNetworkConnection(context: Context): Boolean {
        return getNetworkStatus(context) != NetworkStatus.NETWORK_NO_CONNECTION
    }
}