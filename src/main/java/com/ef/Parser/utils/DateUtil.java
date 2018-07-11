package com.ef.Parser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ef.Parser.enums.DateFormatEnum;
/**
 * Class responsible for handling dates
 * @author ramonsantos
 *
 */
public class DateUtil {

	private static SimpleDateFormat format = new SimpleDateFormat(DateFormatEnum.csvDateFormat.value);
	
	public static Date formatStringToDate(String dateStr) throws ParseException {
		Date date = format.parse(dateStr);
		return date;
	}

	public static Date formatStringToDate(String dateStr, String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = format.parse(dateStr);
		return date;
	}
	
	public static Date getNextHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, 1);	
		return calendar.getTime();
	}

	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);	
		return calendar.getTime();
	}
	
	public static Date getTimeByMilisseconds(long milisseconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milisseconds);
		return calendar.getTime();
	}
}
