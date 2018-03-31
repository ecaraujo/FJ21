package br.com.caelum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	
	
	
	public String format(Date date, String format){
	
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(date);
		
	}
	
	public String format(Calendar c, String format){
		
		return this.format(c.getTime(), format);
				
	}

	public Calendar format(String date, String format){
		
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		try {
			d = sdf.parse(date);
			
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(d);
			
			return cal;
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		

	}
	
}
