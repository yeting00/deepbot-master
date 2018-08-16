package com.perspicace.ai.deepbot.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @program: deepbot
 * @description: 时间工具类
 * @author: Destiny
 * @create: 2018-07-03 11:45
 **/

@Slf4j
public class DateUtil {
    // ==格式到年==
    /**
     * 日期格式，年份，例如：2004，2008
     */
    public static final String DATE_FORMAT_YYYY = "yyyy";


    // ==格式到年月 ==
    /**
     * 日期格式，年份和月份，例如：200707，200808
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

    /**
     * 日期格式，年份和月份，例如：200707，2008-08
     */
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";


    // ==格式到年月日==
    /**
     * 日期格式，年月日，例如：050630，080808
     */
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：06-12-25，08-08-08
     */
    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";

    /**
     * 日期格式，年月日，例如：20050630，20080808
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式，年月日，例如：2016.10.05
     */
    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";

    /**
     * 日期格式，年月日，例如：2016年10月05日
     */
    public static final String DATE_TIME_FORMAT_YYYY年MM月DD日 = "yyyy年MM月dd日";


    // ==格式到年月日 时分 ==

    /**
     * 日期格式，年月日时分，例如：200506301210，200808081210
     */
    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";

    /**
     * 日期格式，年月日时分，例如：20001230 12:00，20080808 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";


    // ==格式到年月日 时分秒==
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    /**
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";


    // ==格式到年月日 时分秒 毫秒==
    /**
     * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";


    // ==特殊格式==
    /**
     * 日期格式，月日时分，例如：10-05 12:00
     */
    public static final String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";


    /* ************工具方法***************   */

    /**
     * 获取某日期的年份
     *
     * @param date
     * @return
     */
    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance ( );
        cal.setTime ( date );
        return cal.get ( Calendar.YEAR );
    }

    /**
     * 获取某日期的月份
     *
     * @param date
     * @return
     */
    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance ( );
        cal.setTime ( date );
        return cal.get ( Calendar.MONTH ) + 1;
    }

    /**
     * 获取某日期的日数
     *
     * @param date
     * @return
     */
    public static Integer getDay(Date date) {
        Calendar cal = Calendar.getInstance ( );
        cal.setTime ( date );
        int day = cal.get ( Calendar.DATE );//获取日
        return day;
    }

    /**
     * 格式化Date时间
     *
     * @param time       Date类型时间
     * @param timeFromat String类型格式
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date time , String timeFromat) {
        DateFormat dateFormat = new SimpleDateFormat ( timeFromat );
        return dateFormat.format ( time );
    }

    /**
     * 格式化Timestamp时间
     *
     * @param timestamp  Timestamp类型时间
     * @param timeFromat
     * @return 格式化后的字符串
     */
    public static String parseTimestampToStr(Timestamp timestamp , String timeFromat) {
        SimpleDateFormat df = new SimpleDateFormat ( timeFromat );
        return df.format ( timestamp );
    }

    /**
     * 格式化Date时间
     *
     * @param time         Date类型时间
     * @param timeFromat   String类型格式
     * @param defaultValue 默认值为当前时间Date
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date time , String timeFromat , final Date defaultValue) {
        try {
            DateFormat dateFormat = new SimpleDateFormat ( timeFromat );
            return dateFormat.format ( time );
        } catch (Exception e) {
            if (defaultValue != null)
                return parseDateToStr ( defaultValue , timeFromat );
            else
                return parseDateToStr ( new Date ( ) , timeFromat );
        }
    }

    /**
     * 格式化Date时间
     *
     * @param time         Date类型时间
     * @param timeFromat   String类型格式
     * @param defaultValue 默认时间值String类型
     * @return 格式化后的字符串
     */
    public static String parseDateToStr(Date time , String timeFromat , final String defaultValue) {
        try {
            DateFormat dateFormat = new SimpleDateFormat ( timeFromat );
            return dateFormat.format ( time );
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 格式化String时间
     *
     * @param time       String类型时间
     * @param timeFromat String类型格式
     * @return 格式化后的Date日期
     */
    public static Date parseStrToDate(String time , String timeFromat) {
        if (time == null || time.equals ( "" )) {
            return null;
        }
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat ( timeFromat );
            date = dateFormat.parse ( time );
        } catch (Exception e) {

        }
        return date;
    }

    /**
     * 格式化String时间
     *
     * @param strTime      String类型时间
     * @param timeFromat   String类型格式
     * @param defaultValue 异常时返回的默认值
     * @return
     */
    public static Date parseStrToDate(String strTime , String timeFromat ,
                                      Date defaultValue) {
        try {
            DateFormat dateFormat = new SimpleDateFormat ( timeFromat );
            return dateFormat.parse ( strTime );
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 当strTime为2008-9时返回为2008-9-1 00:00格式日期时间，无法转换返回null.
     *
     * @param strTime
     * @return
     */
    public static Date strToDate(String strTime) {
        if (strTime == null || strTime.trim ( ).length ( ) <= 0)
            return null;

        Date date = null;
        List<String> list = new ArrayList<String> ( 0 );

        list.add ( DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS );
        list.add ( DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS );
        list.add ( DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI );
        list.add ( DATE_TIME_FORMAT_YYYYMMDD_HH_MI );
        list.add ( DATE_TIME_FORMAT_YYYYMMDDHHMISS );
        list.add ( DATE_FORMAT_YYYY_MM_DD );
        //list.add(DATE_FORMAT_YY_MM_DD);
        list.add ( DATE_FORMAT_YYYYMMDD );
        list.add ( DATE_FORMAT_YYYY_MM );
        list.add ( DATE_FORMAT_YYYYMM );
        list.add ( DATE_FORMAT_YYYY );


        for (Iterator iter = list.iterator ( ); iter.hasNext ( ); ) {
            String format = (String) iter.next ( );
            if (strTime.indexOf ( "-" ) > 0 && format.indexOf ( "-" ) < 0)
                continue;
            if (strTime.indexOf ( "-" ) < 0 && format.indexOf ( "-" ) > 0)
                continue;
            if (strTime.length ( ) > format.length ( ))
                continue;
            date = parseStrToDate ( strTime , format );
            if (date != null)
                break;
        }

        return date;
    }

    /**
     * 解析两个日期之间的所有月份
     *
     * @param beginDateStr 开始日期，至少精确到yyyy-MM
     * @param endDateStr   结束日期，至少精确到yyyy-MM
     * @return yyyy-MM日期集合
     */
    public static List<String> getMonthListOfDate(String beginDateStr , String endDateStr) {
        // 指定要解析的时间格式
        SimpleDateFormat f = new SimpleDateFormat ( "yyyy-MM" );
        // 返回的月份列表
        String sRet = "";

        // 定义一些变量
        Date beginDate = null;
        Date endDate = null;

        GregorianCalendar beginGC = null;
        GregorianCalendar endGC = null;
        List<String> list = new ArrayList<String> ( );

        try {
            // 将字符串parse成日期
            beginDate = f.parse ( beginDateStr );
            endDate = f.parse ( endDateStr );

            // 设置日历
            beginGC = new GregorianCalendar ( );
            beginGC.setTime ( beginDate );

            endGC = new GregorianCalendar ( );
            endGC.setTime ( endDate );

            // 直到两个时间相同
            while (beginGC.getTime ( ).compareTo ( endGC.getTime ( ) ) <= 0) {
                sRet = beginGC.get ( Calendar.YEAR ) + "-"
                        + (beginGC.get ( Calendar.MONTH ) + 1);
                list.add ( sRet );
                // 以月为单位，增加时间
                beginGC.add ( Calendar.MONTH , 1 );
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
            return null;
        }
    }

    /**
     * 解析两个日期段之间的所有日期
     *
     * @param beginDateStr 开始日期  ，至少精确到yyyy-MM-dd
     * @param endDateStr   结束日期  ，至少精确到yyyy-MM-dd
     * @return yyyy-MM-dd日期集合
     */
    public static List<String> getDayListOfDate(String beginDateStr , String endDateStr) {
        // 指定要解析的时间格式
        SimpleDateFormat f = new SimpleDateFormat ( "yyyy-MM-dd" );

        // 定义一些变量
        Date beginDate = null;
        Date endDate = null;

        Calendar beginGC = null;
        Calendar endGC = null;
        List<String> list = new ArrayList<String> ( );

        try {
            // 将字符串parse成日期
            beginDate = f.parse ( beginDateStr );
            endDate = f.parse ( endDateStr );

            // 设置日历
            beginGC = Calendar.getInstance ( );
            beginGC.setTime ( beginDate );

            endGC = Calendar.getInstance ( );
            endGC.setTime ( endDate );
            SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd" );

            // 直到两个时间相同
            while (beginGC.getTime ( ).compareTo ( endGC.getTime ( ) ) <= 0) {

                list.add ( sdf.format ( beginGC.getTime ( ) ) );
                // 以日为单位，增加时间
                beginGC.add ( Calendar.DAY_OF_MONTH , 1 );
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
            return null;
        }
    }

    /**
     * 获取当下年份指定前后数量的年份集合
     *
     * @param before 当下年份前年数
     * @param behind 当下年份后年数
     * @return 集合
     */
    public static List<Integer> getYearListOfYears(int before , int behind) {
        if (before < 0 || behind < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer> ( );
        Calendar c = null;
        c = Calendar.getInstance ( );
        c.setTime ( new Date ( ) );
        int currYear = Calendar.getInstance ( ).get ( Calendar.YEAR );

        int startYear = currYear - before;
        int endYear = currYear + behind;
        for (int i = startYear; i < endYear; i++) {
            list.add ( Integer.valueOf ( i ) );
        }
        return list;
    }

    /**
     * 获取当前日期是一年中第几周
     *
     * @param date
     * @return
     */
    public static Integer getWeekthOfYear(Date date) {
        Calendar c = new GregorianCalendar ( );
        c.setFirstDayOfWeek ( Calendar.MONDAY );
        c.setMinimalDaysInFirstWeek ( 7 );
        c.setTime ( date );

        return c.get ( Calendar.WEEK_OF_YEAR );
    }

    /**
     * 获取某一年各星期的始终时间
     * 实例：getWeekList(2016)，第52周(从2016-12-26至2017-01-01)
     *
     * @param year
     * @return
     */
    public static HashMap<Integer, String> getWeekTimeOfYear(int year) {
        HashMap<Integer, String> map = new LinkedHashMap<Integer, String> ( );
        Calendar c = new GregorianCalendar ( );
        c.set ( year , Calendar.DECEMBER , 31 , 23 , 59 , 59 );
        int count = getWeekthOfYear ( c.getTime ( ) );

        SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy-MM-dd" );
        String dayOfWeekStart = "";
        String dayOfWeekEnd = "";
        for (int i = 1; i <= count; i++) {
            dayOfWeekStart = sdf.format ( getFirstDayOfWeek ( year , i ) );
            dayOfWeekEnd = sdf.format ( getLastDayOfWeek ( year , i ) );
            map.put ( Integer.valueOf ( i ) , "第" + i + "周(从" + dayOfWeekStart + "至" + dayOfWeekEnd + ")" );
        }
        return map;

    }

    /**
     * 获取某一年的总周数
     *
     * @param year
     * @return
     */
    public static Integer getWeekCountOfYear(int year) {
        Calendar c = new GregorianCalendar ( );
        c.set ( year , Calendar.DECEMBER , 31 , 23 , 59 , 59 );
        int count = getWeekthOfYear ( c.getTime ( ) );
        return count;
    }

    /**
     * 获取指定日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar ( );
        c.setFirstDayOfWeek ( Calendar.MONDAY );
        c.setTime ( date );
        c.set ( Calendar.DAY_OF_WEEK , c.getFirstDayOfWeek ( ) ); // Monday
        return c.getTime ( );
    }

    /**
     * 获取指定日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar ( );
        c.setFirstDayOfWeek ( Calendar.MONDAY );
        c.setTime ( date );
        c.set ( Calendar.DAY_OF_WEEK , c.getFirstDayOfWeek ( ) + 6 ); // Sunday
        return c.getTime ( );
    }

    /**
     * 获取某年某周的第一天
     *
     * @param year 目标年份
     * @param week 目标周数
     * @return
     */
    public static Date getFirstDayOfWeek(int year , int week) {
        Calendar c = new GregorianCalendar ( );
        c.set ( Calendar.YEAR , year );
        c.set ( Calendar.MONTH , Calendar.JANUARY );
        c.set ( Calendar.DATE , 1 );

        Calendar cal = (GregorianCalendar) c.clone ( );
        cal.add ( Calendar.DATE , week * 7 );

        return getFirstDayOfWeek ( cal.getTime ( ) );
    }

    /**
     * 获取某年某周的最后一天
     *
     * @param year 目标年份
     * @param week 目标周数
     * @return
     */
    public static Date getLastDayOfWeek(int year , int week) {
        Calendar c = new GregorianCalendar ( );
        c.set ( Calendar.YEAR , year );
        c.set ( Calendar.MONTH , Calendar.JANUARY );
        c.set ( Calendar.DATE , 1 );

        Calendar cal = (GregorianCalendar) c.clone ( );
        cal.add ( Calendar.DATE , week * 7 );

        return getLastDayOfWeek ( cal.getTime ( ) );
    }

    /**
     * 获取某年某月的第一天
     *
     * @param year  目标年份
     * @param month 目标月份
     * @return
     */
    public static Date getFirstDayOfMonth(int year , int month) {
        month = month - 1;
        Calendar c = Calendar.getInstance ( );
        c.set ( Calendar.YEAR , year );
        c.set ( Calendar.MONTH , month );

        int day = c.getActualMinimum ( c.DAY_OF_MONTH );

        c.set ( Calendar.DAY_OF_MONTH , day );
        c.set ( Calendar.HOUR_OF_DAY , 0 );
        c.set ( Calendar.MINUTE , 0 );
        c.set ( Calendar.SECOND , 0 );
        c.set ( Calendar.MILLISECOND , 0 );
        return c.getTime ( );
    }

    /**
     * 获取某年某月的最后一天
     *
     * @param year  目标年份
     * @param month 目标月份
     * @return
     */
    public static Date getLastDayOfMonth(int year , int month) {
        month = month - 1;
        Calendar c = Calendar.getInstance ( );
        c.set ( Calendar.YEAR , year );
        c.set ( Calendar.MONTH , month );
        int day = c.getActualMaximum ( c.DAY_OF_MONTH );
        c.set ( Calendar.DAY_OF_MONTH , day );
        c.set ( Calendar.HOUR_OF_DAY , 23 );
        c.set ( Calendar.MINUTE , 59 );
        c.set ( Calendar.SECOND , 59 );
        c.set ( Calendar.MILLISECOND , 999 );
        return c.getTime ( );
    }

    /**
     * 获取某个日期为星期几
     *
     * @param date
     * @return String "星期*"
     */
    public static String getDayWeekOfDate1(Date date) {
        try {
            String[] weekDays = {"星期日" , "星期一" , "星期二" , "星期三" , "星期四" , "星期五" , "星期六"};
            Calendar cal = Calendar.getInstance ( );
            cal.setTime ( date );

            int w = cal.get ( Calendar.DAY_OF_WEEK ) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        } catch (Exception e) {
            log.error ( e.toString () );
        }
        return null;
    }

    /**
     * 获得指定日期的星期几数
     *
     * @param date
     * @return int
     */
    public static Integer getDayWeekOfDate2(Date date) {
        Calendar aCalendar = Calendar.getInstance ( );
        aCalendar.setTime ( date );
        int weekDay = aCalendar.get ( Calendar.DAY_OF_WEEK );
        return weekDay;
    }

    /**
     * 验证字符串是否为日期
     * 验证格式:YYYYMMDD、YYYY_MM_DD、YYYYMMDDHHMISS、YYYYMMDD_HH_MI、YYYY_MM_DD_HH_MI、YYYYMMDDHHMISSSSS、YYYY_MM_DD_HH_MI_SS
     *
     * @param strTime
     * @return null时返回false;true为日期，false不为日期
     */
    public static boolean validateIsDate(String strTime) {
        if (strTime == null || strTime.trim ( ).length ( ) <= 0)
            return false;

        Date date = null;
        List<String> list = new ArrayList<String> ( 0 );

        list.add ( DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS );
        list.add ( DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS );
        list.add ( DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI );
        list.add ( DATE_TIME_FORMAT_YYYYMMDD_HH_MI );
        list.add ( DATE_TIME_FORMAT_YYYYMMDDHHMISS );
        list.add ( DATE_FORMAT_YYYY_MM_DD );
        //list.add(DATE_FORMAT_YY_MM_DD);
        list.add ( DATE_FORMAT_YYYYMMDD );
        //list.add(DATE_FORMAT_YYYY_MM);
        //list.add(DATE_FORMAT_YYYYMM);
        //list.add(DATE_FORMAT_YYYY);

        for (Iterator iter = list.iterator ( ); iter.hasNext ( ); ) {
            String format = (String) iter.next ( );
            if (strTime.indexOf ( "-" ) > 0 && format.indexOf ( "-" ) < 0)
                continue;
            if (strTime.indexOf ( "-" ) < 0 && format.indexOf ( "-" ) > 0)
                continue;
            if (strTime.length ( ) > format.length ( ))
                continue;
            date = parseStrToDate ( strTime.trim ( ) , format );
            if (date != null)
                break;
        }

        if (date != null) {
            System.out.println ( "生成的日期:" + DateUtil.parseDateToStr ( date , DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS , "--null--" ) );
            return true;
        }
        return false;
    }

    /**
     * 将指定日期的时分秒格式为零
     *
     * @param date
     * @return
     */
    public static Date formatHhMmSsOfDate(Date date) {
        Calendar cal = Calendar.getInstance ( );
        cal.setTime ( date );
        cal.set ( Calendar.HOUR_OF_DAY , 0 );
        cal.set ( Calendar.MINUTE , 0 );
        cal.set ( Calendar.SECOND , 0 );
        cal.set ( Calendar.MILLISECOND , 0 );
        return cal.getTime ( );
    }

    /**
     * 获得指定时间加减参数后的日期(不计算则输入0)
     *
     * @param date        指定日期
     * @param year        年数，可正可负
     * @param month       月数，可正可负
     * @param day         天数，可正可负
     * @param hour        小时数，可正可负
     * @param minute      分钟数，可正可负
     * @param second      秒数，可正可负
     * @param millisecond 毫秒数，可正可负
     * @return 计算后的日期
     */
    public static Date addDate(Date date , int year , int month , int day , int hour , int minute , int second , int millisecond) {
        Calendar c = Calendar.getInstance ( );
        c.setTime ( date );
        c.add ( Calendar.YEAR , year );//加减年数
        c.add ( Calendar.MONTH , month );//加减月数
        c.add ( Calendar.DATE , day );//加减天数
        c.add ( Calendar.HOUR , hour );//加减小时数
        c.add ( Calendar.MINUTE , minute );//加减分钟数
        c.add ( Calendar.SECOND , second );//加减秒
        c.add ( Calendar.MILLISECOND , millisecond );//加减毫秒数

        return c.getTime ( );
    }

    /**
     * 获得两个日期的时间戳之差
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDistanceTimestamp(Date startDate , Date endDate) {
        long daysBetween = (endDate.getTime ( ) - startDate.getTime ( ) + 1000000) / (3600 * 24 * 1000);
        return daysBetween;
    }

    /**
     * 判断二个时间是否为同年同月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean compareIsSameMonth(Date date1 , Date date2) {
        boolean flag = false;
        int year1 = getYear ( date1 );
        int year2 = getYear ( date2 );
        if (year1 == year2) {
            int month1 = getMonth ( date1 );
            int month2 = getMonth ( date2 );
            if (month1 == month2) flag = true;
        }
        return flag;
    }

    /**
     * 获得两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param one 时间参数 1 格式：1990-01-01 12:00:00
     * @param two 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTime(Date one , Date two) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {

            long time1 = one.getTime ( );
            long time2 = two.getTime ( );
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        long[] times = {day , hour , min , sec};
        return times;
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return String 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTime(String str1 , String str2) {
        DateFormat df = new SimpleDateFormat ( DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS );
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse ( str1 );
            two = df.parse ( str2 );
            long time1 = one.getTime ( );
            long time2 = two.getTime ( );
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (ParseException e) {
            e.printStackTrace ( );
        }
        long[] times = {day , hour , min , sec};
        return times;
    }

    /**
     * 两个时间之间相差距离多少天
     *
     * @param str1 时间参数 1：
     * @param str1 时间参数 2：
     * @return 相差天数
     */
    public static Long getDistanceDays(String str1 , String str2) throws Exception {
        DateFormat df = new SimpleDateFormat ( DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS );
        Date one;
        Date two;
        long days = 0;
        try {
            one = df.parse ( str1 );
            two = df.parse ( str2 );
            long time1 = one.getTime ( );
            long time2 = two.getTime ( );
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace ( );
        }
        return days;
    }

    /**
     * 获取指定时间的那天 00:00:00.000 的时间
     *
     * @param date
     * @return
     */
    public static Date getDayBeginTime(final Date date) {
        Calendar c = Calendar.getInstance ( );
        c.setTime ( date );
        c.set ( Calendar.HOUR_OF_DAY , 0 );
        c.set ( Calendar.MINUTE , 0 );
        c.set ( Calendar.SECOND , 0 );
        c.set ( Calendar.MILLISECOND , 0 );
        return c.getTime ( );
    }

    /**
     * 获取指定时间的那天 23:59:59.999 的时间
     *
     * @param date
     * @return
     */
    public static Date getDayEndTime(final Date date) {
        Calendar c = Calendar.getInstance ( );
        c.setTime ( date );
        c.set ( Calendar.HOUR_OF_DAY , 23 );
        c.set ( Calendar.MINUTE , 59 );
        c.set ( Calendar.SECOND , 59 );
        c.set ( Calendar.MILLISECOND , 999 );
        return c.getTime ( );
    }

    /**
     * 22~6之间属于夜晚
     *
     * @return
     */
    public static boolean isNight() {
        Calendar calendar = Calendar.getInstance ( );
        int hour = calendar.get ( Calendar.HOUR_OF_DAY );

        if (hour >= 6 && hour <= 22) {
            return false;
        }

        return true;
    }

    public static int getHour() {
        Calendar calendar = Calendar.getInstance ( );
        int hour = calendar.get ( Calendar.HOUR_OF_DAY );
        return hour;
    }

    /**
     * 判断某一时间是否在一个区间内
     *
     * @param sourceTime 时间区间,半闭合,如[10:00-20:00)
     * @param curTime    需要判断的时间 如10:00
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isInTime(String sourceTime , String curTime) {
        if (sourceTime == null || !sourceTime.contains ( "-" ) || !sourceTime.contains ( ":" )) {
            throw new IllegalArgumentException ( "Illegal Argument arg:" + sourceTime );
        }
        if (curTime == null || !curTime.contains ( ":" )) {
            throw new IllegalArgumentException ( "Illegal Argument arg:" + curTime );
        }
        String[] args = sourceTime.split ( "-" );
        SimpleDateFormat sdf = new SimpleDateFormat ( "HH:mm" );
        try {
            long now = sdf.parse ( curTime ).getTime ( );
            long start = sdf.parse ( args[0] ).getTime ( );
            long end = sdf.parse ( args[1] ).getTime ( );
            if (args[1].equals ( "00:00" )) {
                args[1] = "24:00";
            }
            if (end < start) {
                if (now >= end && now < start) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (now >= start && now < end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace ( );
            throw new IllegalArgumentException ( "Illegal Argument arg:" + sourceTime );
        }

    }

    /**
     * 判断当前时间所属的时间段
     *
     * @param
     * @param
     * @return
     * @throws IllegalArgumentException
     */

    public static int getTimeQuantum() {
        final String[] dates = new String[8];
        dates[0] = "06:00-08:59";
        dates[1] = "09:00-10:59";
        dates[2] = "11:00-13:59";
        dates[3] = "14:00-16:59";
        dates[4] = "17:00-19:59";
        dates[5] = "20:00-21:59";
        dates[6] = "22:00-23:59";
        dates[7] = "01:00-06:00";

        int i = 0;


        for (; i < dates.length; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat ( "HH:mm" );
            String currentDate = sdf.format ( new Date ( ) );

            String dateStr = dates[i];
            String[] dateArr = dateStr.split ( "-" );
            try {
                Date currDate = sdf.parse ( currentDate );//当前时间
                Date startDate = sdf.parse ( dateArr[0] );//每节开始时间
                Date endDate = sdf.parse ( dateArr[1] );//每节结束时间
                if (currDate.after ( startDate ) && currDate.before ( endDate )) {
                    System.out.println ( "当前时间属于第" + (i + 1) + "节" );
                    break;
                }
            } catch (ParseException e) {
                e.printStackTrace ( );
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println ( DateUtil.isInTime ( "20:00-01:00" , "01:00" ) );
        System.out.println ( DateUtil.isInTime ( "20:00-01:00" , "00:00" ) );
        System.out.println ( DateUtil.isInTime ( "20:00-01:00" , "03:00" ) );
        System.out.println ( );
        System.out.println ( DateUtil.isInTime ( "20:00-23:00" , "03:00" ) );
        System.out.println ( DateUtil.isInTime ( "20:00-23:00" , "22:00" ) );
        System.out.println ( DateUtil.isInTime ( "20:00-23:00" , "18:00" ) );
        System.out.println ( DateUtil.isInTime ( "20:00-23:00" , "20:00" ) );
        System.out.println ( DateUtil.isInTime ( "20:00-23:00" , "23:00" ) );

        System.out.println ( DateUtil.getTimeQuantum ( ) );
    }


}
