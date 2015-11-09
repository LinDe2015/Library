package com.linde.library.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linde.library.utils.LogUtils;

/**
 * Created by LinDe on 2015/11/6.
 * Wrap {@link Fragment}
 */
public class BaseFragment extends Fragment
{
    public final LogUtils mLogUtils;

    public BaseFragment()
    {
        super();
        this.mLogUtils = new LogUtils(this.getClass());
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        mLogUtils.i("1: onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mLogUtils.i("2: onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mLogUtils.i("3: onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mLogUtils.i("4: onActivityCreated");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        mLogUtils.i("5: onStart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mLogUtils.i("6: onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mLogUtils.i("7: onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        mLogUtils.i("8: onStop");
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        mLogUtils.i("9: onDestroyView");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mLogUtils.i("10: onDestroy");
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mLogUtils.i("11: onDetach");
    }
}
