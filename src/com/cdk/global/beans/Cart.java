package com.cdk.global.beans;

import java.util.HashMap;
import java.util.Map;

import com.cdk.global.common.PriceCalculator;
import com.cdk.global.impl.CustomerType;

public class Cart {
   
	Map<Product, Integer> items;
	double totalCartPrice = 0.0d;
	
	public Cart() {
        items = new HashMap<>();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void addProduct(Product product){
        if(items.containsKey(product)){
            items.compute(product, (p,q) -> Integer.valueOf(q+1));
        }else{
            items.put(product, 1);
        }
        totalCartPrice += product.getPrice();
    }

    public void removeProduct(Product product){
        if(items.get(product).intValue() > 1){
            items.compute(product, (p, q) -> Integer.valueOf(q-1));
        }else{
            items.remove(product);
        }
        totalCartPrice -= product.getPrice();
    }
    
    public double doCheckOut(CustomerType customerType) {
    	PriceCalculator priceCalculator = new PriceCalculator();
    	return priceCalculator.calculatePrice(customerType, totalCartPrice);
    }

	public double getTotalCartPrice() {
		return totalCartPrice;
	}

    
}
