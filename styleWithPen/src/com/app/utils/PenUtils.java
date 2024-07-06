package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Pen;

//int id, String brand, String color, String inkColor, String material, int stock,
//LocalDate stockUpdateDate, LocalDate stockListingDate, double price, double discount
public class PenUtils {

	public static List<Pen> populatePen(){
		Pen p1=new Pen("cello","blue","Black","plastic",50,LocalDate.of(2024, 05,12),LocalDate.of(2024, 02, 05),10,2);
		Pen p2=new Pen("flair","grey","Blue","plastic",20,LocalDate.of(2024, 06,12),LocalDate.of(2024, 05, 10),25,5);
		Pen p3=new Pen("reynolds","red","red","steel",0,LocalDate.of(2024, 03,30),LocalDate.of(2024, 02,14),50,2);
		Pen p4=new Pen("Parker","black","blue","alloy_Steel",25,LocalDate.of(2024, 04,12),LocalDate.of(2024, 03, 05),100,4);
		Pen p5=new Pen("cello","black","Blue","metal",10,LocalDate.of(2024, 02,15),LocalDate.of(2024,01,30),30,0);
		Pen p6=new Pen("Gripper","blue","black","alloy_steel",45,LocalDate.of(2023, 03, 20),LocalDate.of(2023, 03, 10),50,2);
		Pen[] pens= {p1,p2,p3,p4,p5,p6};
		ArrayList<Pen> penList= new ArrayList<>();
		for (Pen p:pens)
			penList.add(p);
		return penList;
	}
}
