package com.linde.library.activity;

import com.linde.library.broadcast_receiver.net.NetChangeListener;
import com.linde.library.broadcast_receiver.NetChangeReceiver;

/**
 * Created by LinDe on 2015/11/9.
 * Add Net Change Listener
 */
public abstract class NetChangeActivity extends BaseActivity implements NetChangeListener
{
    @Override
    protected void onStart()
    {
        super.onStart();
        NetChangeReceiver.addNetChangeListener(this);
        mLogUtils.i("Add Net Change Listener");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        NetChangeReceiver.removeNetChangeListener(this);
        mLogUtils.i("Remove Net Change Listener");
    }
}
