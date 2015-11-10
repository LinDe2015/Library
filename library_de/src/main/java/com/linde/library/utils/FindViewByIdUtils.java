package com.linde.library.utils;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by LinDe on 2015/11/9.
 * 通过注解初始化所有控件，在执行方法
 * {@link FindViewByIdUtils#injectAllFields(Activity)} 或者
 * {@link FindViewByIdUtils#injectAllFields(Class, View)}之前，
 * 需要进行初始化操作{@link FindViewByIdUtils#init(Application)}，
 * 控件需申明为成员变量，变量名需与id名相同
 */
public class FindViewByIdUtils
{
    private static boolean hadInit = false;
    private static Application application;

    /**
     * 初始化FindViewById工具类
     *
     * @param application {@link Application}
     */
    public static void init(Application application)
    {
        if (hadInit) return;
        FindViewByIdUtils.application = application;
        hadInit = true;
    }

    /**
     * 一键注解
     *
     * @param activity {@link Activity}
     */
    public static void injectAllFields(Activity activity)
    {
        App_null();
        final Class clazz = activity.getClass();
        final Resources res = application.getResources();
        final String packageName = application.getPackageName();
        final Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields)
        {
            int viewId = res.getIdentifier(f.getName(), "id", packageName);
            if (viewId <= 0) continue;
            f.setAccessible(true);
            try
            {
                f.set(activity, activity.findViewById(viewId));
            }
            catch (Exception e) {e.printStackTrace();}
            f.setAccessible(false);
        }
    }

    /**
     * 一键注解
     *
     * @param clazz    {@link Class}
     * @param rootView {@link View}
     */
    public static void injectAllFields(Class clazz, View rootView)
    {
        App_null();
        final Resources res = application.getResources();
        final String packageName = application.getPackageName();
        final Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields)
        {
            int viewId = res.getIdentifier(f.getName(), "id", packageName);
            if (viewId <= 0) continue;
            f.setAccessible(true);
            try
            {
                f.set(rootView, rootView.findViewById(viewId));
            }
            catch (Exception e) {e.printStackTrace();}
            f.setAccessible(false);
        }
    }

    private static void App_null()
    {
        final String EX_S = "application is null, please init before inject";
        if (application == null) {throw new NullPointerException(EX_S);}
    }
}
