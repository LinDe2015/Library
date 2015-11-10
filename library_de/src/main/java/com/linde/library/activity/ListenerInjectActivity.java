package com.linde.library.activity;

import android.os.Bundle;
import android.view.View;

import com.linde.library.utils.ListenerInjectUtils;

/**
 * Created by LinDe on 2015/11/10.
 * Inject {@link View#setOnClickListener(View.OnClickListener)}
 * and {@link View#setOnLongClickListener(View.OnLongClickListener)}
 */
public class ListenerInjectActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ListenerInjectUtils.setOnClickListener(this);
        ListenerInjectUtils.setOnLongClickListener(this);
    }
}
