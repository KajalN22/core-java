package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;

import com.app.core.Pen;
import com.app.customexception.NewException;

public class penValidationRules {
	
	//id,brand,color,inkColor,material,stock,price
	public static Pen validatePenInputs( String brand , String Color, String inkColor, String material,
			int stock, double price) {
	
		return new Pen(brand,Color,inkColor,material,
			stock,price);
	}

	public static void  updatePenStock(int id, int newStock, List<Pen> penList) throws NewException{
		int flag=0;
	       for(Pen pen : penList)
	       {
	    	   if(pen.getId()==id)
	    	   {
	    		   flag=1;
	    		   continue;
	    	   }
	    		   
	       }
    	   if(flag==0) {
    		   throw new NewException("Pen with ID "+id+" not found");
    	   }
    	   
    	   
			for(Pen pen:penList)
		{
			if(pen.getId()==id) {
			int oldStock=pen.getStock();
			pen.setStock(oldStock+newStock);
            System.out.println("Stock updated successfully. New stock for Pen ID " + id + " is: " + pen.getStock());
			pen.setStockUpdateDate(LocalDate.now());
		    return;
			}
			//throw new NewException("Pen with ID "+id+" not found");

	    }
	}
	public static void setDiscountForUnsoldPens(List<Pen> penList) {
		for(Pen pen:penList)
		{
			int months=Period.between(LocalDate.now(), pen.getStockUpdateDate()).getMonths();
			if(months>3);
			{
			pen.setDiscount(20);
		
			System.out.println("Discount set to 20% for pens unsold from last three months"+ pen);
          return;
		}

	
	}
	}

	public static void removePen(List<Pen> penList) 
	{
		for(Pen pen : penList)
		{
			int months=Period.between(LocalDate.now(), pen.getStockUpdateDate()).getMonths();
			if(months>9)
			{
//				
          	penList.remove(pen);
				System.out.println("Pen with id= "+pen.getId()+"is removed");
			}
		}
		
	}
	Iterator itr=List.iterator
		
	
	
}