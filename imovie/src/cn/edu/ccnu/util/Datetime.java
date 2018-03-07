package cn.edu.ccnu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datetime {
	public static Date addDateSec(Date day, int sec) {
		if (day != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(day);
			cal.add(Calendar.SECOND, sec);
			return cal.getTime();
		} else {
			return null;
		}

	}

	public static String formatDate(Date day, String format) {
		SimpleDateFormat df;
		if (format.equals("") || format == null) {
			df = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			df = new SimpleDateFormat(format);
		}
		return df.format(day);
	}
}
