package main.java.model;

import main.util.Food;
import main.util.Medicinali;

public class Product {
	
	private String name;
	private double price;
	private int quantity;
	
	public Product (String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	//Method to check if the product is tax free for basic sales tax based on product's name
	public boolean isTaxFree(String name) {
		
		//For books checking the presence of the word 'book' is enough
		if (name.toLowerCase().indexOf("book") >= 0) {
			return true;
		}
		
		//Loop through an enum for various medical products (only one for test cases)
		for (Medicinali med : Medicinali.values()) {
			if (name.toLowerCase().indexOf(med.getVal()) >= 0) {
				return true;
			}
		}
		
		//Loop through an enum for various foods (only one for test cases)
		for (Food food : Food.values()) {
			if (name.toLowerCase().indexOf(food.getVal()) >= 0) {
				return true;
			}
		}
		
		return false;
	}

	///Method to check if a product is imported based on product's name
	public boolean isImported (String name) {
		return name.toLowerCase().indexOf("imported") >= 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
