package com.tamuvii.util;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	
	public static List<String> getYears(int year) {
		List<String> anni = new ArrayList<String>();
		
		for(int i=0; i<TamuviiConstants.YEARS_RANGE; i++) {
			String anno = String.valueOf(year);
			anni.add(anno);
			year--;
		}
		
		return anni;
	}

}