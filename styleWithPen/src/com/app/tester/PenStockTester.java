package com.app.tester;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

import com.app.core.Pen;
import com.app.utils.PenUtils;
import com.app.utils.penValidationRules;

public class PenStockTester {

	public static void main(String[] args) {
   
		try(Scanner sc=new Scanner(System.in)){
			//init phase
			boolean exit=false;
			//init data structure
			
			List<Pen> penList=PenUtils.populatePen(); //created populated arraylist
		
			while(!exit){
				System.out.println("Options: "
						+ " 1.Add new pen"
						+ " 2.Display "
						+ " 3.Update pen stock"
						+ " 4.Set discount for pens unsold from last three months"
						+ " 5.Remove pen which are not sold for last nine months"
						+ " 0.Exit");
			

			System.out.println("Enter your choice");
			try {
				switch(sc.nextInt()) 
				{
				case 1:
					//add new pen
					System.out.println("Enter Pen details to add a new pen:brand,color,inkColor"
							+ ",material,stock,price");
					Pen pen=penValidationRules.validatePenInputs(sc.next(),sc.next(),sc.next(),sc.next(),
							sc.nextInt(),sc.nextDouble());
					pen.setStockListingDate(LocalDate.now());
					penList.add(pen);
					System.out.println("new pen added....");
					break;
					
				case 2:
					//display
					for(Pen p:penList)
					{
						System.out.println(p);
					}
					break;
				case 3:
					//update pen stock
					System.out.println("Enter pen id: ");
					int id=sc.nextInt();
					System.out.println("Enter new stock quantity: ");
					int newStock=sc.nextInt();
					penValidationRules.updatePenStock(id,newStock, penList);
                    break;
                    
				case 4:
					//Set discount of 20% for all the pens which are not at all sold in last 3 months
                     penValidationRules.setDiscountForUnsoldPens(penList);
					break;
					
				case 5: 
					//Remove Pens which are never sold once listed in 9 months
					penValidationRules.removePen(penList);
			
					break;
                    
				case 0:
					//Exit
					exit=true;
					break;
					
				}
			
			}catch(Exception e) {
				sc.nextLine();
				System.out.println(e);
			}
			}
		}
	}

}
   
