package main;

import sun.util.calendar.LocalGregorianCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title : PACKAGE_NAME
 * Description :
 *  - 
 *  -  
 *
 * @author main.chile
 * @version 1.0
 * @date 2017/3/30 14:37
 */

public class Test {

    public static void main(String[] args) {

        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM");

        String date1 = "2017-8";
        String date2 = "2017-8-12";
        String date3 = "2017-8-12 10:0:0";


        Pattern p1 = Pattern.compile("[12][0-9]{3}-[0-9]{1,2}-[0-9]{2} [012]?[0-9]:[0-9]{1,2}:[0-9]{1,2}");
        Pattern p2 = Pattern.compile("[12][0-9]{3}-[0-9]{1,2}-[0-9]{2}");
        Pattern p3 = Pattern.compile("[12][0-9]{3}-[0-9]{1,2}");

        System.out.println(p1.matcher(date3).matches());

        System.out.println(10 >>> 2);

        System.out.println(new Date());

//        try {
//            Date d3 = f3.parse(date1);
//            Date d2 = f2.parse(date1);
//            Date d1 = f1.parse(date1);
//            System.out.println(d1);
//            System.out.println(d2);
//            System.out.println(d3);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }

}
