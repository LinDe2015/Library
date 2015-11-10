package com.linde.library.utils;

import android.content.Context;
import android.support.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by LinDe on 2015/11/6.
 * 读写文件工具类
 */
public class FileUtils
{
    private FileUtils() {}

    public static boolean writeCache(Context context, String fileName, String writeString)
    {return writeCache(context, fileName, writeString, false);}

    public static boolean writeCache(Context context, String fileName, String writeString, boolean append)
    {return write(new File(context.getCacheDir(), fileName), writeString, append);}

    public static String readCache(Context context, String fileName)
    {return read(new File(context.getCacheDir(), fileName));}

    public static boolean writeFile(Context context, String fileName, String writeString)
    {return writeFile(context, fileName, writeString, false);}

    public static boolean writeFile(Context context, String fileName, String writeString, boolean append)
    {return write(new File(context.getFilesDir(), fileName), writeString, append);}

    public static String readFile(Context context, String fileName)
    {return read(new File(context.getFilesDir(), fileName));}

    @Nullable
    public static String read(File file)
    {
        final LogUtils logUtils = new LogUtils(FileUtils.class);
        logUtils.i("Read File Name: " + file.getName());
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
            logUtils.i("Read from File Success");
            final String result = new String(baos.toByteArray());
            logUtils.i(result);
            return result;
        }
        catch (Exception e) {e.printStackTrace();}
        logUtils.e("Read from File Failed");
        return null;
    }

    public static boolean write(File file, String writeString, boolean append)
    {
        final LogUtils logUtils = new LogUtils(FileUtils.class);
        logUtils.i("Write File Name: " + file.getName());
        try
        {
            FileOutputStream fos = new FileOutputStream(file, append);
            byte[] b = writeString.getBytes();
            fos.write(b);
            fos.close();
            logUtils.i("Write to File Success");
            logUtils.i(fos.toString());
            return true;
        }
        catch (Exception e) {e.printStackTrace();}
        logUtils.e("Write to File Failed");
        return false;
    }
}