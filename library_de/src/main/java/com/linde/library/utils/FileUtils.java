package com.linde.library.utils;

import android.content.Context;
import android.support.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by LinDe on 2015/11/6.
 * 保存文件工具类
 */
public class FileUtils
{
    private FileUtils() {}

    /**
     * 保存数据到缓存区（替换）
     *
     * @param context     The application of context
     * @param fileName    文件名（含后缀）
     * @param writeString 写入缓存文件的字符串
     * @return 保存成功
     */
    public static boolean writeCache(Context context, String fileName, String writeString)
    {return writeCache(context, fileName, writeString, false);}

    /**
     * 保存数据到缓存区
     *
     * @param context     The application of context
     * @param fileName    文件名（含后缀）
     * @param writeString 写入缓存文件的字符串
     * @param append      true 添加字符串 false 替换字符串
     * @return 保存成功
     */
    public static boolean writeCache(Context context, String fileName, String writeString, boolean append)
    {return write(new File(context.getCacheDir(), fileName), writeString, append);}

    @Nullable
    /**
     * 读取缓存
     *
     * @param context  The application of context
     * @param fileName 文件名（含后缀）
     * @return 读取的字符串 may be null
     */
    public static String readCache(Context context, String fileName) {return read(new File(context.getCacheDir(), fileName));}

    public static String read(File file)
    {
        final LogUtils logUtils = new LogUtils(FileUtils.class);
        try
        {
            new LogUtils(FileUtils.class).i("文件最后修改时间：" + file.lastModified());
            FileInputStream fis = new FileInputStream(file);
            //new一个缓冲区
            byte[] buffer = new byte[256];
            //使用ByteArrayOutputStream类来处理输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            //写入数据
            while ((len = fis.read(buffer)) != -1) {baos.write(buffer, 0, len);}
            logUtils.i("Read from File \"" + file.toString() + "\" Success");
            final String result = new String(baos.toByteArray());
            logUtils.i("The Data is : " + result);
            return result;
        }
        catch (Exception e) {e.printStackTrace();}
        return null;
    }

    public static boolean write(File file, String writeString, boolean append)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(file, append);
            byte[] b = writeString.getBytes();
            fos.write(b);
            fos.close();
            new LogUtils(FileUtils.class).i("Write File \"" + file.toString() + "\" Success");
            return true;
        }
        catch (Exception e) {e.printStackTrace();}
        return false;
    }
}