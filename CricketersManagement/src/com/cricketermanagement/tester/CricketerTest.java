package com.cricketermanagement.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.cricketersmanagement.core.Cricketer;
import com.cricketersmanagement.utils.CricketersManagementUtils;
import com.cricketersmanagement.custom_ordering.*;

public class CricketerTest {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
			 
			    boolean exit=false;
			 
				List<Cricketer> list=CricketersManagementUtils.populateCricketer();

			 while(!exit)
			 {
				 System.out.println("Options:"
							+ " 1.Add new cricketers(min 5)"
							+ " 2.Modify cricketer's rating"
							+ " 3.Search cricketer by Name"
							+ " 4.Display all cricketers"
							+ " 5.Display all cricketers sorted by rating "
							+ " 0. Exit ");
					System.out.println("Choose an option");
				 try {
					 switch(sc.nextInt()) {
					 case 1:
						 //add min 5 cricketers
						 System.out.println(sc.nextLine());
						 System.out.println("Enter cricketer details: name");
						 String name=sc.nextLine();
						 System.out.println("Enter cricketer details: age,email,phone,ratings");
						 list.add(new Cricketer(name,sc.nextInt(),sc.next(),sc.next(),sc.nextInt()));
				         System.out.println("Cricketer added successfully");
						 break;
						 
					 case 2:
						 //modify cricketers rating
						 System.out.println(sc.nextLine());
						 System.out.println("Enter cricketer's email: ");
						 String  email=sc.nextLine();
						 System.out.println("Enter ratings for the cricketer");
						int  rating=sc.nextInt();
						 com.cricketersmanagement.utils.CricketersManagementUtils.modifyRatings(email,rating,list);
				
						 System.out.println("Ratings upated succcessfully");
						 break;
						 
					 case 3:
						 //search cricketer by name
						 System.out.println(sc.nextLine());
						 System.out.println("Enter cricketer's name: ");
						 String nm=sc.nextLine();
						 com.cricketersmanagement.utils.CricketersManagementUtils.searchCricketerByName(nm,list);
						
						 break;
						 
					 case 4:
						 //display all cricketers
						 
						 for(Cricketer c:list) {
							 System.out.println(c);
						 }
						 break;
						 
					 case 5:
						 //display all criceketer sorted by ratings
                        Collections.sort(list, new Comparator<Cricketer>() {
                                                        
							@Override
							public int compare(Cricketer c1, Cricketer c2) {
								
								if(c1.getRating()>c2.getRating())
								return 1;
								else if(c1.getRating()<c2.getRating())
									return -1;
								return 0;
							}
                        	
                        });
                        
						 break;
						 
					 case 0:
						 exit=true;
						 break;
					 }
			         }
				 catch(Exception e)
				 {
				 System.out.println(e.getMessage());
			     }
			
			}
		}

	}

}
