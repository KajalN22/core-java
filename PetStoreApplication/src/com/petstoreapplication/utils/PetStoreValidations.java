package com.petstoreapplication.utils;

import java.util.List;
import java.util.Scanner;

import com.petstoreapplication.core.Category;
import com.petstoreapplication.core.Order;
import com.petstoreapplication.core.Pet;
import com.petstoreapplication.core.Status;
import com.petstoreapplication.custom_exception.AuthenticationException;
import com.petstoreapplication.custom_exception.AuthorisationException;
import com.petstoreapplication.custom_exception.OutOfStockException;

public class PetStoreValidations {
       
	public static String userLogin(String loginId,String password) throws AuthenticationException {
	 
		if("admin".equals(loginId)&& "admin".equals(loginId) && "admin".equals(password))
		{
		    String loggedInUser=loginId;
			System.out.println("You are logged in as an ADMIN");
			return loginId;
		}
		else if("customer".equals(loginId)&& "customer".equals(password))
		{
			String loggedInUser=loginId;
			System.out.println("You are logged in as Customer");
			return loginId;
		}
		else
			throw new AuthenticationException("Invalid login credentials!!! Please try again!!");
		
	}
	
	public static Pet addNewPet(int petId, String name, Category c, double unitPrice, int stock, List<Pet> petList) throws AuthorisationException {
	   
		return new Pet(petId, name, c, unitPrice, stock);
	}

	public static void updatePetDetails(int petId, List<Pet> petList ) throws Exception{
		Scanner sc=new Scanner(System.in);
		for(Pet p:petList) {
			if(p.getPetId()==petId) {
	            System.out.print("Enter new name: ");
	            p.setName(sc.nextLine());
	            System.out.print("Enter new category (CAT, DOG, RABBIT, FISH): ");
	            p.setCategory(Category.valueOf(sc.nextLine().toUpperCase()));
	            System.out.print("Enter new unit price: ");
	            p.setUnitPrice(sc.nextDouble());
	            System.out.print("Enter new stocks: ");
	            p.setStocks(sc.nextInt());
	            System.out.println("Pet details updated successfully!!");
			}	
		
		}
		throw new Exception("Pet with"+ petId+ " not found");
		
		
	}

	public static void orderPet(int petId, int quantity, List<Pet> petList, List<Order> orderList) throws OutOfStockException,AuthorisationException{
		Scanner sc=new Scanner(System.in);
		
		for(Pet p:petList) {
			
			if(p.getPetId()==petId) 
			{
				if(p.getStocks()-quantity<=0) 
				{
					
					throw new OutOfStockException("Stock not available");
				}
				Order newOrder = new Order(petId, quantity);
				orderList.add(newOrder);
				p.setStocks(p.getStocks()-quantity);
				System.out.println("Order has been placed");
			
			
		}
			throw new AuthorisationException("Pet not found");
	}
		
}

	public static void checkOredrStatus(int orderId, List<Order> orderList) {
		
	        for (Order order : orderList) {
	            if (order.getOrderId() == orderId) {
	                System.out.println("Order Status: " + order.getStatus());
	                return;
	            }
	        }
	        System.out.println("Order not found with ID: " + orderId);
	    }

		
	public static void updateOrderStatus(int orderId, Status status,List<Order> orderList) throws AuthorisationException {
       
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                System.out.println("Current status: " + order.getStatus());
                order.setStatus(status);
                System.out.println("Order status updated successfully!");
                return;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
    }

	
	
	
	
}





 