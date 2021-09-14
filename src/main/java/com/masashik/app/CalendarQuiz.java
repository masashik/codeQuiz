package com.masashik.app;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.GregorianCalendar;

public class CalendarQuiz {

	public static String findDay(int month, int day, int year) {

		String currentYear = String.valueOf(year);
		String currentMonth = String.valueOf(month);
		String currentDay = String.valueOf(day);

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setLenient(false);

		GregorianCalendar gCalendar = new GregorianCalendar(year, month, day);

		try {
			if (gCalendar.isLeapYear(year)) {
				gCalendar.setTime(simpleDateFormat.parse(currentYear + "-" + currentMonth + "-" + currentDay));
				gCalendar.add(GregorianCalendar.DATE, -1);
			} else {
				gCalendar.setTime(simpleDateFormat.parse(currentYear + "-" + currentMonth + "-" + currentDay));
				gCalendar.add(GregorianCalendar.DATE, -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Date date = gCalendar.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		return DayOfWeek.of(dayOfWeek).toString();
	}

	public static void main(String[] args) throws IOException {

		/**
		 * 02 29 2004
		 * SUNDAY
		 *
		 * 08 05 2015
		 * WEDNESDAY
		 */

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int month = Integer.parseInt(firstMultipleInput[0]);

		int day = Integer.parseInt(firstMultipleInput[1]);

		int year = Integer.parseInt(firstMultipleInput[2]);

		String res = CalendarQuiz.findDay(month, day, year);

		bufferedWriter.write(res);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();  
	}

}
