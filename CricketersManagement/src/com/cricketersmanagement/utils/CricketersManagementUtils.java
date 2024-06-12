package com.cricketersmanagement.utils;

import java.util.ArrayList;
import java.util.List;

import com.cricketersmanagement.core.Cricketer;

public class CricketersManagementUtils {
 
	//String name, int age, String email_id, String phone, int rating
	public static List<Cricketer> populateCricketer(){
		Cricketer c1=new Cricketer("Virat Kohli", 33, "virat@example.com", "1234567890", 9);
        Cricketer c2=new Cricketer("Rohit Sharma", 35, "rohit@example.com", "9876543210", 8);
        Cricketer c3=new Cricketer("Kane Williamson", 30, "kane@example.com", "123456789", 9);
        Cricketer c4=new Cricketer("Steve Smith", 32, "steve@example.com", "987654321", 8);
        Cricketer c5=new Cricketer("Joe Root", 31, "joe@example.com", "123456789", 9);
        Cricketer[] cricketers= {c1,c2,c3,c4,c5};
		List<Cricketer> list=new ArrayList<>();
		for(Cricketer c:cricketers)
			list.add(c);
		return list;
	}

	public static int modifyRatings(String email, int ratings,List<Cricketer> list) {
		System.out.println("In modifyRatings....");
		
        for(Cricketer c:list) {
			
			if(c.getEmail_id().equals(email)) 
		    c.setRating(ratings);
          }      
		return ratings;
		
		}

	public static List<Cricketer> searchCricketerByName(String nm, List<Cricketer> list) {
		
		 int found=0;
		 for(Cricketer c:list) {
			 if(c.getName().equals(nm))
			 {
				 found=1;
				 System.out.println("Criketer with name "+nm+" found" + c);
			 }
		 }
		 if(found==0)
			 System.out.println("Cricketer NOT found!!");
		return list;
		 
	}
	
}
