package com.linde.library.broadcast_receiver.net;

/**
 * Created by LinDe on 2015/11/9.
 * Listening when Net is Changed
 */
public interface NetChangeListener
{
    void netChange(NetState state);
}
