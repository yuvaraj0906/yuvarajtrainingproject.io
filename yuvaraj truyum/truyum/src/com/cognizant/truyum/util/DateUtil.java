package com.cognizant.truyum.util;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

public class DateUtil {

	public Date convertToDate(String input) {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		try {
			java.util.Date dateofLaunch = format.parse(input);
			return dateofLaunch;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static java.sql.Date convertToSqlDate(java.util.Date utilDate){
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	
	public String convertToString(Date input) {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		String date = format.format(input);
		return date;
	}
    }
