package com.tamuvii.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;

public class VelocityUtils {

	public static String shorten(int len,String msg) { 
		return ((msg!=null) && (msg.length()>len)?msg.substring(0,len):msg);
	}
	
	public static String quoteEntities(String str) {
		return StringEscapeUtils.escapeXml(str);
	}
	
	public static boolean longZero(Float value) {
		return ((value==null) || (value.equals(0F)));
	}
	
	public static String today(String format) {
		Format formatter;
		formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	
}