package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.model.Product;

class UnitTesting {
	
	Tester t = new Tester();

	@Test
	void testCaseOne() {
		
		List<Product> products= new ArrayList<Product>();
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		Product p1 = new Product("book", 12.49, 1);
		Product p2 = new Product("music CD", 14.99, 1);
		Product p3 = new Product("chocolate bar", 0.85, 1);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		output.put("tax", new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
		output.put("total", new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(t.prova(products), output);
	}
	
	@Test
	void testCaseTwo() {
		
		List<Product> products= new ArrayList<Product>();
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		Product p4 = new Product("imported box of chocolates", 10.00, 1);
		Product p5 = new Product("imported bottle of perfume", 47.50, 1);
		products.add(p4);
		products.add(p5);
		
		output.put("tax", new BigDecimal(7.65).setScale(2, RoundingMode.HALF_UP));
		output.put("total", new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(t.prova(products), output);
	}
	
	@Test
	void testCaseThree() {
		
		List<Product> products= new ArrayList<Product>();
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		Product p6 = new Product("imported bottle of perfume", 27.99, 1);
		Product p7 = new Product("bottle of perfume", 18.99, 1);
		Product p8 = new Product("packet of headache pills", 9.75, 1);
		Product p9 = new Product("box of imported chocolates", 11.25, 1);
		products.add(p6);
		products.add(p7);
		products.add(p8);
		products.add(p9);
		
		output.put("tax", new BigDecimal(6.70).setScale(2, RoundingMode.HALF_UP));
		output.put("total", new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(t.prova(products), output);
	}

}
