package com.geek.domain;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Wushiai
 * @date 2020/4/21 8:43
 * @content
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        System.out.println(new Demo().splitDemo("2020-04-20 09:53"));
//        System.out.println(new Demo().splitDemo("2020-04-20"));
    }

    public String splitDemo(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置当前时间的格式，为年-月-日
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置当前时间的格式，为年-月-日

        System.out.println("---------------------");
        String s = dateFormat.format(new Date());
        System.out.println("xz: "+s);
        System.out.println("cr: "+date);
        Date date5 = dateFormat.parse(s);

        Date date4 = dateFormat.parse(date);
        System.out.println(differentDaysByMillisecond(date4, date5));

        System.out.println("---------------------");


//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(new Date());
//            }
//        }, 0, 10000, TimeUnit.MILLISECONDS);


        return null;
    }

    public static int differentDays(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) (date2.getTime() - date1.getTime());
        return days;
    }

}
