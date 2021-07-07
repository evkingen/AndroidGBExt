package com.example.alohagoha.androidgbexthomework.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.alohagoha.androidgbexthomework.App;

public class NetworkStatus {
    public static Status getStatus() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            switch (activeNetwork.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    return Status.WIFI;
                case ConnectivityManager.TYPE_ETHERNET:
                    return Status.ETHERNET;
                case ConnectivityManager.TYPE_MOBILE:
                    return Status.MOBILE;
            }
            return Status.OTHER;
        }
        return Status.OFFLINE;
    }

    public static boolean isOnline() {
        return !getStatus().equals(Status.OFFLINE);
    }

    public static boolean isMobile() {
        return getStatus().equals(Status.MOBILE);
    }

    public static boolean isWifi() {
        return getStatus().equals(Status.WIFI);
    }

    public static boolean isEthernet() {
        return getStatus().equals(Status.ETHERNET);
    }

    public static boolean isOffline() {
        return getStatus().equals(Status.OFFLINE);
    }

    public enum Status {
        WIFI,
        MOBILE,
        ETHERNET,
        OTHER,
        OFFLINE
    }
}
