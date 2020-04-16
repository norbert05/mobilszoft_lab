package com.example.mobsofthw.models.util

enum class NetworkStatus(val value: String) {

    NETWORK_NO_CONNECTION("NETWORK_NO_CONNECTION"),
    NETWORK_WIFI("NETWORK_WIFI"),
    NETWORK_MOBILE("NETWORK_MOBILE");

    companion object {
        fun from(s: String): NetworkStatus = NetworkStatus.values().find { it.value == s }!!
    }

}