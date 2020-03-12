package com.cdk.global.common;

import com.cdk.global.impl.CustomerType;

public class PriceCalculator {
   
	public double calculatePrice(CustomerType customerType, double totalCartPrice) {
		return customerType.applyDiscount(totalCartPrice);
	}
}
