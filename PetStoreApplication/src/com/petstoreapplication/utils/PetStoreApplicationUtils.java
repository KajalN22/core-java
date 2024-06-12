package com.petstoreapplication.utils;

import java.util.ArrayList;
import java.util.List;

import com.petstoreapplication.core.Category;
import com.petstoreapplication.core.Order;
import com.petstoreapplication.core.Pet;
import com.petstoreapplication.core.Status;

public class PetStoreApplicationUtils {

	public static List<Pet> populatePet(){
		Pet p1=new Pet(101, "Bull Dog", Category.DOG, 1000, 50);
		Pet p2=new Pet(102, "Persian Cat", Category.CAT, 800, 30);
		Pet p3=new Pet(103, "Holland Lop", Category.RABBIT, 500, 20);
		Pet p4=new Pet(104, "Goldfish", Category.FISH, 50, 100);
		Pet[] pets= {p1,p2,p3,p4};
		List<Pet> petList=new ArrayList<>();
		for(Pet p:pets)
			petList.add(p);
		return petList;
	}
	
	
	public static List<Order> populateOrder(){
		Order o1=new Order(101, 5, Status.PLACED);
		Order o2=new Order(102, 3, Status.IN_PROCESS);
		Order o3=new Order(103, 1, Status.COMPLETED);
		Order[] orders= {o1,o2,o3};
		List<Order> orderList=new ArrayList<>();
		for(Order o:orders)
			orderList.add(o);
		return orderList;
	}
	
}
