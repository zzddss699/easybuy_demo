package com.zds.easybuy_demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName StringUtil
 * @Description 生成随机数的工具类
 * @Author 157
 * @Date 2021/5/17 12:55
 * @Version 1.0
 **/
public class StringUtils {
    private static String[] binaryArray =
        {"0000","0001","0010","0011",
        "0100","0101","0110","0111",
        "1000","1001","1010","1011",
        "1100","1101","1110","1111"};
    /*  {"0000","0001","0011","0111",
        "0101","0010","1001","1011",
        "1010","0100","0110","1101",
        "1111","1000","1100","1110"};*/
//    private static String[] chineseDigits = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static String[] chineseDigits = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    private static final char[] charBytes = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' ,
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static final char[] numberBytes = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /*
     * @Author 157
     * @Description //生成指定位数的随机数字
     * @MethodName randomNumbers
     * @Date 13:14 2021/5/17
     * @Param [number]
     * @return java.lang.String
     **/
    public static String randomNumbers(int number){
        int count = 0; //生成的密码的长度
        int i; //生成的随机数
        final int maxNum = numberBytes.length;
        StringBuffer randomStr = new StringBuffer("");
        Random r = new Random();
        while (count < number){
            //生成随机数,取绝对值,防止生成负数
            i = Math.abs(r.nextInt(maxNum));//生成的数最大为36-1
            if (i >= 0 && i < numberBytes.length){
                randomStr.append(numberBytes[i]);
                count ++;
            }
        }
        return randomStr.toString();
    }

    public static String randomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").toUpperCase();
    }

    /**
     * @Description //获取当前时间 精确到毫秒
     **/
    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sdf.format(new Date());
        return currentTime;
    }

    public static void main(String[] args) {
        //String age=getCurrentTime();
        String age = randomUUID();
        //Integer sex=calculateSexByIdNumber("133022198201242396");
        System.out.println(age);
    }
}
