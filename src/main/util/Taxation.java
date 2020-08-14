package main.util;

import java.util.HashMap;
import java.util.List;

import main.java.model.Product;

public class Taxation {
	
	public static HashMap<String, Double> calculateTaxAndNet (List<Product> products) {
		HashMap<String, Double> map = new HashMap<String, Double>();
		double totalNet = 0;
		double taxAmount = 0;
		
		for (Product prod : products) {
			
			totalNet += prod.getPrice();
			
			//calculate basic tax if product is not tax free
			if (!prod.isTaxFree(prod.getName())) {
				taxAmount += calculateBasicTax(prod);
			}
			
			//case of imported products with additional tax
			if (prod.isImported(prod.getName())) {
				taxAmount += calculateImportedTax(prod);
			}
		}
		
		//Round up tax to 0.05
		taxAmount = Math.ceil(taxAmount * 20) / 20.0;
		
		map.put("tax", taxAmount);
		map.put("net", totalNet);
		
		return map;
	}

	private static double calculateImportedTax(Product prod) {
		return (prod.getPrice()*0.05);
	}

	private static double calculateBasicTax(Product prod) {
		return (prod.getPrice()*0.1);
		
	}
	
}
