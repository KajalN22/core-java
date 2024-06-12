package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Pen;
import com.app.exceptions.CustomException;

public class PenUtility {

	public static List<Pen> populatepens() {
		
		Pen p1=new Pen("cello","blue","Black","plastic",50,LocalDate.of(2024, 05,12),LocalDate.of(2024, 02, 05),10,2);
		Pen p2=new Pen("flair","grey","Blue","plastic",20,LocalDate.of(2024, 06,12),LocalDate.of(2024, 05, 10),25,5);
		Pen p3=new Pen("reynolds","red","red","steel",0,LocalDate.of(2024, 03,30),LocalDate.of(2024, 02,14),50,2);
		Pen p4=new Pen("Parker","black","blue","alloy_Steel",25,LocalDate.of(2024, 04,12),LocalDate.of(2024, 03, 05),100,4);
		Pen p5=new Pen("cello","black","Blue","metal",10,LocalDate.of(2024, 02,15),LocalDate.of(2024,01,30),30,0);
		Pen p6=new Pen("Gripper","blue","black","alloy_steel",45,LocalDate.of(2023, 03, 20),LocalDate.of(2023, 03, 10),50,2);
		
		Pen[] pens= {p1,p2,p3,p4,p5,p6};
		List<Pen> penList=new ArrayList<>();
		for(Pen p:pens) 
			penList.add(p);
		
		return penList;
	}

	public static Pen addNewPen(String brand, String color, String inkColor, String material, int stock, double price,
			double discount) {
		LocalDate stockUpdateDate=LocalDate.now();
		LocalDate stockListingDate=LocalDate.now();

		return new Pen(brand,color,inkColor,material,stock,stockUpdateDate,stockListingDate,price,discount);
	}

	public static void updatePenStock(int id, int newstock, List<Pen> penList)throws CustomException {
		for(Pen p:penList) {
			if(p.getId()==id) {
				int oldStock=p.getStock();
				p.setStock(oldStock+newstock);
			}
		}
	}

	public static void setDiscount(List<Pen> penList) {
		for(Pen p:penList) {
			int months=Period.between(p.getStockpdateDate(), LocalDate.now()).getMonths();
			if(months>2) {
			p.setDiscount(20);
			System.out.println("Discount has been set to 20% for "+ p);
			}
		}
		
}

	public static void removePen(List<Pen> penList) {

		for(Pen p:penList) {
			int months=Period.between(p.getStockpdateDate() ,LocalDate.now()).getMonths();
			System.out.println(months);
			if(months>2){
				System.out.println("in if....");
			    penList.remove(p);
			    System.out.println("Pen removed successfully!!"+ p);

			}
	}
}
}
