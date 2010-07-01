package com.tamuvii;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class AppTest extends TestCase
{
 
	/**
	 * Covertire date in formato UNIX
	 */
	public void testDate() {
		Calendar c = Calendar.getInstance();
		c.set(2008, 6, 2, 0, 0, 0);
		Date d = c.getTime();
		System.out.println("2009/07/02: "+ d.getTime()/1000);
		
		c.setTimeInMillis(1260290912L*1000);
		System.out.println("1246485600: "+c.getTime());
		
	}
	
	
}
