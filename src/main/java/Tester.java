package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

import main.java.model.Product;
import main.util.Taxation;

public class Tester {
	
	public HashMap<String, BigDecimal> prova(List<Product> input) {
		
		HashMap<String, BigDecimal> output = new HashMap<String, BigDecimal>();
		
		HashMap<String, Double> map = Taxation.calculateTaxAndNet(input);
		
		BigDecimal taxTotal = new BigDecimal(map.get("tax")).setScale(2, RoundingMode.HALF_UP);
		BigDecimal totalPrice = (new BigDecimal(map.get("net") + map.get("tax")).setScale(2, RoundingMode.HALF_UP));
		
		output.put("tax", taxTotal);
		output.put("total", totalPrice);
		
		return output;
	}

}
