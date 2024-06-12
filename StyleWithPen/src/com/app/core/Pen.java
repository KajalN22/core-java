package com.app.core;

import java.time.LocalDate;

public class Pen {

	private static int count=0;
	private int id;
	private String brand;
	private String color;
	private String inkColor;
	private String material;
	private int stock;
	private LocalDate stockpdateDate;
	private LocalDate stockListinDate;
	private double price;
	private double discount;
	
	//constructor
	public Pen(String brand, String color, String inkColor, String material, int stock, LocalDate stockpdateDate,
			LocalDate stockListinDate, double price, double discount) {
		super();
		this.id=++count;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stockpdateDate = stockpdateDate;
		this.stockListinDate = stockListinDate;
		this.price = price;
		this.discount = discount;
	}

	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getStockpdateDate() {
		return stockpdateDate;
	}

	public void setStockpdateDate(LocalDate stockpdateDate) {
		this.stockpdateDate = stockpdateDate;
	}

	public LocalDate getStockListinDate() {
		return stockListinDate;
	}

	public void setStockListinDate(LocalDate stockListinDate) {
		this.stockListinDate = stockListinDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	//toString
	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", stockpdateDate=" + stockpdateDate + ", stockListinDate="
				+ stockListinDate + ", price=" + price + ", discount=" + discount + "]";
	}
	

	
	
	
}
