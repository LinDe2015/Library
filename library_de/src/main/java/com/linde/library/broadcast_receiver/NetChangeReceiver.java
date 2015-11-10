package com.linde.library.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.linde.library.broadcast_receiver.net.NetChangeListener;
import com.linde.library.broadcast_receiver.net.NetState;
import com.linde.library.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class NetChangeReceiver extends BroadcastReceiver
{
    protected final LogUtils mLogUtils;
    private NetState currentNetState;

    public NetChangeReceiver()
    {
        mLogUtils = new LogUtils(getClass());
    }

    private static List<NetChangeListener> list = new ArrayList<>();

    @Override
    public void onReceive(Context context, Intent intent)
    {
        final String ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
        final String ACTION2 = "android.net.ethernet.ETHERNET_STATE_CHANGED";
        if (ACTION.equals(intent.getAction()) || ACTION2.equals(intent.getAction()))
        {refreshNetState(context);}
    }

    private void refreshNetState(Context context)
    {
        //获取手机的连接服务管理器，这里是连接管理器类
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        final NetState netState;
        if (info != null && info.isAvailable())
        {
            final String name = info.getTypeName();
            switch (name)
            {
            case "mobile":
                netState = NetState.NET_MOBILE;
                mLogUtils.i("当前网络：2G/3G/4G网络");
                break;
            case "WIFI":
                netState = NetState.NET_WIFI;
                mLogUtils.i("当前网络：WIFI网络");
                break;
            default:
                netState = NetState.NET_NO;
                mLogUtils.i("没有可用网络");
                break;
            }
        } else
        {
            netState = NetState.NET_NO;
            mLogUtils.i("没有可用网络");
        }
        if (currentNetState != null && currentNetState != netState)
        {
            for (NetChangeListener change : list)
            {
                try {change.netChange(netState);}
                catch (Exception e) {e.printStackTrace();}
            }
            currentNetState = netState;
        }
    }

    public static void addNetChangeListener(NetChangeListener change)
    {
        if (change == null) return;
        list.add(change);
    }

    public static void removeNetChangeListener(NetChangeListener change)
    {
        final int size = list.size();
        for (int i = 0; i < size; i++)
        {
            if (list.get(i) == change)
            {
                list.remove(i);
                break;
            }
        }
    }

    public static void clearNetChangeListener() {list.clear();}
}
