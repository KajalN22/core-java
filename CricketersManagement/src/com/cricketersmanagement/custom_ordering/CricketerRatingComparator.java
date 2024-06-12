package com.cricketersmanagement.custom_ordering;

import java.util.Comparator;

import com.cricketersmanagement.core.Cricketer;

public class CricketerRatingComparator implements Comparator<Cricketer> {

	@Override
	public int compare(Cricketer c1, Cricketer c2) {
		System.out.println("in cricketer rating compare...");
		if(c1.getRating()>c2.getRating())
		return 1;
		else if(c1.getRating()<c2.getRating())
		return -1;
		return 0;
	
	}
    
}
