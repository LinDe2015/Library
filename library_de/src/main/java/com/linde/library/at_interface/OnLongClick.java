package com.linde.library.at_interface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Created by LinDe on 2015/11/10.
 * OnLongClick
 */
public @interface OnLongClick
{
    int[] value();
}
