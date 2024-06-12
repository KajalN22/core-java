package com.petstoreapplication.core;

public class Order {

	private static int count;
	 private int orderId;
	 private int petId;
	 private int quantity;
	 private Status status;
	 
	 //constructor
	public Order( int petId, int quantity, Status status) {
		super();
		this.orderId = ++count;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}

	
	public Order(int petId, int quantity) {
		this.orderId=++count;
		this.petId=petId;
		this.status=Status.PLACED;
	}


	//getters and setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

//toString
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
	
	 
	 
}
