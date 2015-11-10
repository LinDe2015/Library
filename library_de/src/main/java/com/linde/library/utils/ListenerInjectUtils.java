package com.linde.library.utils;

import android.app.Activity;
import android.view.View;

import com.linde.library.at_interface.OnClick;
import com.linde.library.at_interface.OnLongClick;

import java.lang.reflect.Method;

/**
 * Created by LinDe on 2015/11/10.
 * Listener Inject Utils
 */
public class ListenerInjectUtils
{
    public static void setOnClickListener(final Activity activity)
    {
        final Class clazz = activity.getClass();
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods)
        {
            OnClick click = method.getAnnotation(OnClick.class);
            if (click != null)
            {
                int[] ids = click.value();
                for (int viewId : ids)
                {
                    if (viewId <= 0) continue;
                    final View view = activity.findViewById(viewId);
                    view.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            method.setAccessible(true);
                            try {method.invoke(activity, v);}
                            catch (Exception e) {e.printStackTrace();}
                            method.setAccessible(false);
                        }
                    });
                }
            }
        }
    }

    public static void setOnClickListener(final Object This, View rootView)
    {
        final Class clazz = This.getClass();
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods)
        {
            OnClick click = method.getAnnotation(OnClick.class);
            if (click != null)
            {
                int[] ids = click.value();
                for (int viewId : ids)
                {
                    if (viewId <= 0) continue;
                    final View view = rootView.findViewById(viewId);
                    view.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            method.setAccessible(true);
                            try {method.invoke(This, v);}
                            catch (Exception e) {e.printStackTrace();}
                            method.setAccessible(false);
                        }
                    });
                }
            }
        }
    }

    public static void setOnLongClickListener(final Activity activity)
    {
        final Class clazz = activity.getClass();
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods)
        {
            OnLongClick longClick = method.getAnnotation(OnLongClick.class);
            if (longClick != null)
            {
                int[] ids = longClick.value();
                for (int viewId : ids)
                {
                    if (viewId <= 0) continue;
                    final View view = activity.findViewById(viewId);
                    view.setOnLongClickListener(new View.OnLongClickListener()
                    {
                        @Override
                        public boolean onLongClick(View v)
                        {
                            method.setAccessible(true);
                            try {method.invoke(activity);}
                            catch (Exception e) {e.printStackTrace();}
                            method.setAccessible(false);
                            return true;
                        }
                    });
                }
            }
        }
    }

    public static void setOnLongClickListener(final Object This, View rootView)
    {
        final Class clazz = This.getClass();
        final Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods)
        {
            OnLongClick click = method.getAnnotation(OnLongClick.class);
            if (click != null)
            {
                int[] ids = click.value();
                for (int viewId : ids)
                {
                    if (viewId <= 0) continue;
                    final View view = rootView.findViewById(viewId);
                    view.setOnLongClickListener(new View.OnLongClickListener()
                    {
                        @Override
                        public boolean onLongClick(View v)
                        {
                            method.setAccessible(true);
                            try {method.invoke(This, v);}
                            catch (Exception e) {e.printStackTrace();}
                            method.setAccessible(false);
                            return true;
                        }
                    });
                }
            }
        }
    }
}
