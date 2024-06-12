package com.petstoreapplication.tester;

import java.util.List;
import java.util.Scanner;

import javax.security.sasl.AuthenticationException;

import com.petstoreapplication.core.Category;
import com.petstoreapplication.core.Order;
import com.petstoreapplication.core.Pet;
import com.petstoreapplication.core.Status;
import com.petstoreapplication.custom_exception.AuthorisationException;
import com.petstoreapplication.utils.PetStoreApplicationUtils;

public class PetStoreApplication {


	
	public static void main(String[] args) {
		
    try(Scanner sc=new Scanner(System.in)){
    	//init phase
    	boolean exit=false;
    	//init data 
    	
    	List<Pet> petList= PetStoreApplicationUtils.populatePet();
    	
    	List<Order> orderList=PetStoreApplicationUtils.populateOrder();
//    	System.out.println(sc.nextLine());
    	System.out.println("Welcome to pet store application");
		System.out.println("Enter your loginId");
		String loginId=sc.nextLine();
	    System.out.println("Enter password");
	    String password=sc.nextLine();
    	
    	while(!exit)
    	{
    		
    		System.out.println("Options: \n"
    				+ "1.Login \n"
    				+ "2.Add new Pet \n"
    				+ "3.Update pet details \n"
    				+ "4.Display all available pets \n"
    				+ "5.Order a pet \n"
    				+ "6.Check oredr status by oredr Id \n"
    				+ "7.Update order status \n"
    				+ "8.Display orders"
    				+ "0.Exit ");
    		System.out.println("Choose an option: ");
    		try {
    			switch(sc.nextInt())
    			{
    			case 1:
    				// user login
    				
    				com.petstoreapplication.utils.PetStoreValidations.userLogin(loginId, password);
    				
    				break;
    				
    			case 2:
    				//int petId, String name, Category category, double unitPrice, int stocks
//    				System.out.println(sc.nextLine());
//    				System.out.println("Enter your loginId");
//    				String id=sc.nextLine();
//    			    System.out.println("Enter password");
//    			    String pass=sc.nextLine();
    				String loggedInUser=com.petstoreapplication.utils.PetStoreValidations.userLogin(loginId, password);
    				
    				if("admin".equals(loggedInUser)) {
    				System.out.println(sc.nextLine());
    				System.out.println("Enter Pet Id: ");
    				int petId=sc.nextInt();
    				System.out.println("Enter pet name: ");
    				String name=sc.next();
    				sc.nextLine();
    				System.out.println("Enter Category: CAT,DOG,RABBIT,FISH ");
    				String category=sc.nextLine();
    				Category c=Category.valueOf(category.toUpperCase());
    				System.out.println("Enter unitPrice: ");
    				double unitPrice=sc.nextDouble();
    				System.out.println("Enter stock: ");
    				int stock=sc.nextInt();
    				Pet pet=com.petstoreapplication.utils.PetStoreValidations.addNewPet(petId,name,c,unitPrice,stock, petList);
    	
    				petList.add(pet);
    				System.out.println("new pet added successfully");
    				}
    				else
    					throw new AuthorisationException("Only admin can have access to add new pet");
    					//System.out.println("Only admin can have access to add new pet");
    		
    				break;
    				
    			case 3:
    				//update pet details
    				String user=com.petstoreapplication.utils.PetStoreValidations.userLogin(loginId, password);
    				if("admin".equals(user)) {
    				System.out.println("Enter petId:");
    				com.petstoreapplication.utils.PetStoreValidations.updatePetDetails(sc.nextInt(),petList);
    				}
    				else
    					throw new AuthorisationException("Only admin can update the details");
    				    				
    				break;
    				
    			case 4:
    				for(Pet p:petList)
    				{
    					System.out.println(p);
    				}
    				break;
    				
    			case 5:
    				//order a pet
    				String loggedinUser=com.petstoreapplication.utils.PetStoreValidations.userLogin(loginId, password);
    				if(loggedinUser!=null) {
    				System.out.println("Enter petId to order :");
    				sc.nextLine();
    				System.out.println("Enter quantity");
    				int quantity=sc.nextInt();
    				com.petstoreapplication.utils.PetStoreValidations.orderPet(sc.nextInt(),quantity,petList,orderList);
    				//orderList.add(new Order(sc.nextInt(),quantity));
                     System.out.println("Order placed succesfully");
    				}
    				else
    					throw new AuthenticationException("Login required to order a pet");
    				break;
    				
    			case 6:
    				//check order status by order Id
    				String loggedinUser1=com.petstoreapplication.utils.PetStoreValidations.userLogin(loginId, password);
    				if(loggedinUser1!=null) {
    				System.out.println("Enter ordetId:");
    				int orderId=sc.nextInt();
    				com.petstoreapplication.utils.PetStoreValidations.checkOredrStatus(orderId,orderList);
    				}
    				else 
    				throw new AuthenticationException("Login required to check oredr status");
    				
    				break;
    				
    			case 7:
    				//update oreder status
    				String loggedInUser2=com.petstoreapplication.utils.PetStoreValidations.userLogin(loginId, password);
    				if("admin".equals(loggedInUser2)) {
    					System.out.println("Enter oreder Id: ");
    					int orderId=sc.nextInt();
    					sc.nextLine();
    					System.out.println("Enter status you want to update: ");
    					String s=sc.nextLine();
    					Status status=Status.valueOf(s.toUpperCase());
    				com.petstoreapplication.utils.PetStoreValidations.updateOrderStatus(orderId,status,orderList);
    				}
    				else
    					throw new AuthorisationException("Admin has access to update the status");
    				break; 
    			case 8:
    				//display oredrs
    				for(Order o:orderList)
    				{
    					System.out.println(o);
    				}
    				break;
    			case 0:
    				System.out.println("Exiting!!!!");
    				exit=true;
    				break;
    				
    			
    			}
    		}
    		catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	
    }
 }
}