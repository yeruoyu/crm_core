 
package com.lodge.crm.core.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author A2FXTZZ
 *
 */
public class DateUtils {
	public static long MONTH_TIME= 60*60*24*30*1000l;
	
	/**
	 *Converts the date type object to a string according to the specified format，eg：yyyy-MM-dd,yyyy/MM/dd,yyyy/MM/dd hh:mm:ss
	 * @param date
	 * @param pattern  
	 * @return
	 */
	public static String formatDate(Date date,String pattern){
		if(date==null){
			return null;
		}
		SimpleDateFormat formater=new SimpleDateFormat(pattern);
		return formater.format(date);
	}
	
 
	public static String formatDate(Date date){
		if(date==null){
			return "";
		}
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(date);
	}
	 
	public static String formatDateByDet(Date date){
		if(date==null){
			return "";
		}
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formater.format(date);
	}
	 
	public static String formatDateType(Date date){
		if(date==null){
			return "";
		}
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM");
		return formater.format(date);
	}
	
	 
	public static String formatDate(Timestamp timestamp){
		
		if(timestamp==null){
			return "";
		}
		
		return DateUtils.formatDate(new Date(timestamp.getTime()));
		
	}
	 
	public static String formatDateByDeatail(Timestamp timestamp){
		
		if(timestamp==null){
			return "";
		}
		
		return DateUtils.formatDateByDet(new Date(timestamp.getTime()));
		
	}
	 
	public static Date parseDate(String dateStr,String pattern){
		SimpleDateFormat formater=new SimpleDateFormat(pattern);
		try {
			return formater.parse(dateStr);
		} catch (ParseException e) {
		}
		return null;
	}
	
	 
	public static Date parseDate(String dateStr){
		return parseDate(dateStr,"yyyy-MM-dd");
	}
	 
	public static int compareDatas(String d1,String d2){
		Date _d1= parseDate(d1,"yyyy-MM-dd");
		Date _d2= parseDate(d2,"yyyy-MM-dd");
		if(_d1.after(_d2)) return -1 ;
		else return 1;
	}
	
	 
	public static Timestamp parseTimestamp(String timeStampStr){
		Date date = parseDate(timeStampStr,"yyyy-MM-dd");
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		if(date != null){
			
			return Timestamp.valueOf(formater.format(date));
		}
		
		return null;
	}
	
	public static Timestamp parseTimestampHour(String timeStampStr){
		Date date = parseDate(timeStampStr,"yyyy-MM-dd HH:mm");
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		if(date != null){
			
			return Timestamp.valueOf(formater.format(date));
		}
		
		return null;
	}


	public static Timestamp parseTimestamp(Date date){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		if(date != null){
			
			return Timestamp.valueOf(formater.format(date));
		}
		
		return null;
	}
	
	public static Timestamp addOneDay(String date){
		 
		 Date d = DateUtils.parseDate(date);
		 Calendar ca = Calendar.getInstance();
		 ca.setTime(d);
		 ca.add(Calendar.DAY_OF_MONTH, 1);
		 
		 return parseTimestamp(ca.getTime());
	}
	
	public static Timestamp addDay(String date,int addDay){
		 
		 Date d = DateUtils.parseDate(date);
		 Calendar ca = Calendar.getInstance();
		 ca.setTime(d);
		 ca.add(Calendar.DAY_OF_MONTH, addDay);
		 
		 return parseTimestamp(ca.getTime());
	}
	
	public static Date addDay(Date date,int addDay){
		 
		 Calendar ca = Calendar.getInstance();
		 ca.setTime(date);
		 ca.add(Calendar.DAY_OF_MONTH, addDay);
		 
		 return ca.getTime();
	}
	
	public static Date addMonth(Date date,int addMonth){
		 
		 Calendar ca = Calendar.getInstance();
		 ca.setTime(date);
		 ca.add(Calendar.MONTH, addMonth);
		 
		 return ca.getTime();
	}
	

	public static String getWorkDate(Date date, int workDay) {
		  Calendar cal = Calendar.getInstance();
		  String pattern = "yyyy-MM-dd";
		  SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		  int days = workDay % 5 + workDay / 5 * 7; 
		  cal.setTime(date);
		  cal.add(Calendar.DATE, days);
		  return sdf.format(cal.getTime());
	 }

	public static int getIntervalDaysByDate(Date startday,Date endday){        
        if(startday.after(endday)){
            Date cal=startday;
            startday=endday;
            endday=cal;
        }        
        long sl=startday.getTime();
        long el=endday.getTime();       
        long ei=el-sl;           
        return (int)(ei/(1000*60*60*24));
    }
	
	public static Date setDateToOneDayFirstMilliSecond(Date date){
		 
		 Calendar ca = Calendar.getInstance();
		 ca.setTime(date);
		 ca.set(Calendar.HOUR_OF_DAY, ca.getActualMinimum(Calendar.HOUR_OF_DAY));
		 ca.set(Calendar.MINUTE, ca.getActualMinimum(Calendar.MINUTE));
		 ca.set(Calendar.SECOND, ca.getActualMinimum(Calendar.SECOND));
		 ca.set(Calendar.MILLISECOND, ca.getActualMinimum(Calendar.MILLISECOND));
		 
		 return ca.getTime();
	}
	
	public static Date setDateToOneDayLastMilliSecond(Date date){
		 
		 Calendar ca = Calendar.getInstance();
		 ca.setTime(date);
		 ca.set(Calendar.HOUR_OF_DAY, ca.getActualMaximum(Calendar.HOUR_OF_DAY));
		 ca.set(Calendar.MINUTE, ca.getActualMaximum(Calendar.MINUTE));
		 ca.set(Calendar.SECOND, ca.getActualMaximum(Calendar.SECOND));
		 ca.set(Calendar.MILLISECOND, ca.getActualMaximum(Calendar.MILLISECOND));
		 
		 return ca.getTime();
	}
	
	public static int compareCurrentDateReturnMonth(Timestamp date){
		Timestamp now=getCurrentSytemTimeForTimestamp();
		long longNow=getTimestampValueYYYYMMDD(now);
		long longDate=getTimestampValueYYYYMMDD(date);
		long diff=longDate-longNow;
		Double diffDouble=Double.valueOf(""+diff);
		Double monthDouble=Double.valueOf(""+MONTH_TIME);
		double de=diffDouble/monthDouble;
		int _month=0;
		if(de>0){
			_month=(int) Math.ceil(de);
		}else{
			_month=(int) Math.floor(de);
		}
		return _month;
	}


	public static long getTimestampValueYYYYMMDD(Timestamp date){
		long  t1=0l;
		try {
	        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd", new Locale("zh", "cn"));
	        t1 = timeformat.parse(m_format.format(date)).getTime();	
		} catch (Exception e) {
		}
		return t1;

	}
	
	public static long getTimestampValue(Timestamp date){
		long  t1=0l;
		try {
	        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	        SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", new Locale("zh", "cn"));
	        t1 = timeformat.parse(m_format.format(date)).getTime();	
		} catch (Exception e) {
		}
		return t1;

	}
	
	public static Integer getCurrentYear(){
		Calendar calendar = new GregorianCalendar(); 
		return calendar.get(Calendar.YEAR);
	}
	 
	public static String  getCurrentDateForStr(){
		Calendar c = new GregorianCalendar(); 
		String now=c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DATE)+"日";
		return now;
	}
	
 
	
	 
	public static String getCurrentSytemTimeForString(){
		Calendar calendar = new GregorianCalendar(); 
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String systemTime = format.format(calendar.getTime());
		return systemTime;
	}
	
	 
	public static Timestamp getCurrentSytemTimeForTimestamp(){
		return Timestamp.valueOf(getCurrentSytemTimeForString());
	}
 
	public static String checkOverCurrentOneYear(Date hireDate)
	{
		
		String returnValue=null;
		
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
  
       
        Calendar c = Calendar.getInstance();
        String currentDay=df.format(c.getTime());
       
        Date day_curDate=parseDate(currentDay);
        
        int year=getIntervalDaysByDate(day_curDate, hireDate);
        
        if(year>365)
        {
        	returnValue="overOneYears";
        }
		return returnValue;
		
	}
	
	 
	public static Date getCurrentDateTime() {
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = calendar.getTime();
		try {
			return format.parse(format.format(currentDate));
		} catch (Exception e) {
		}
		return null;
	}
	
	
 
	public static boolean checkCurrentDateTheTwoTimeBetween(Date currentDate,Date beginDate,Date endDate){
		
		Boolean flag = false;
		
		if(currentDate.getTime() >= beginDate.getTime() && currentDate.getTime() <= endDate.getTime()){
			flag = true;
		}
		return flag;		
	}
 
	public static String getCurrentMonthBeginDate(){
		Calendar calendar = new GregorianCalendar(); 
		String pattern = "yyyy-MM-01 00:00:00.000";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String systemTime = format.format(calendar.getTime());
		return systemTime;
	}
 
	public static String getCurrentMonthEndDate(){
		Calendar calendar = new GregorianCalendar(); 
		String pattern = "yyyy-MM-dd 23:59:59.999";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String systemTime = format.format(calendar.getTime());
		return systemTime;
	}
	public static Timestamp getCurrentTimeStamp(){
		return  new Timestamp(System.currentTimeMillis()); 
	}
	
	public static void main(String[] args) {
		getCurrentMonthEndDate();
	}
}
