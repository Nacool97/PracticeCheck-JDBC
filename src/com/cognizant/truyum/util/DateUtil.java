package com.cognizant.truyum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil 
{
	public static Date convertToDate(String date) throws Exception
	{
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = simpleDateFormat.parse(date);
		return date1;
	}
}