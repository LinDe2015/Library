package com.linde.library.interface_;

import com.linde.library.enum_.NetState;

/**
 * Created by LinDe on 2015/11/9.
 * Listening when Net is Changed
 */
public interface NetChangeListener
{
    void netChange(NetState state);
}
