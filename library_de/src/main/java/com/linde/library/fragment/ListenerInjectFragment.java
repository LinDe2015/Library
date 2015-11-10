package com.linde.library.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linde.library.utils.ListenerInjectUtils;

/**
 * Created by LinDe on 2015/11/10.
 * ListenerInjectFragment
 */
public abstract class ListenerInjectFragment extends BaseFragment
{
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = initRootView(inflater, container, savedInstanceState);
        ListenerInjectUtils.setOnClickListener(this, rootView);
        ListenerInjectUtils.setOnLongClickListener(this, rootView);
        return rootView;
    }

    protected abstract View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
