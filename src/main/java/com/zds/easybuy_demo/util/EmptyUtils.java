package com.zds.easybuy_demo.util;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName EmptyUtils
 * @Description 判断是否为空的类
 * @Author 157
 * @Date 2021/5/11 15:17
 * @Version 1.0
 **/
public class EmptyUtils {

    //判空
    public static boolean isEmpty(Object obj){
        if (obj == null)
            return true;
        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;
        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();
        if (obj instanceof Map)
            return ((Map) obj).isEmpty();
        if (obj instanceof Object[]){
            Object[] object = (Object[]) obj;
            if (object.length == 0){
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isEmpty(object[i])){
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj){
        return isEmpty(obj);
    }

}
