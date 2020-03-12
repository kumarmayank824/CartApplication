package com.cdk.global.impl;

public class RegularCustomer implements CustomerType {
   
	@Override
	public double applyDiscount(double totalCartPrice) {
		return determineDiscount(totalCartPrice);
 	}
    
	private static double determineDiscount(double totalCartPrice) {
		
		double discountSlab1 = 0.0;
		double discountSlab2 = discountSlab1 + ((totalCartPrice- 5000.0) > 5000.0 ? 
				                         5000.0 *0.10 : (totalCartPrice- 5000.0) *0.10);
		double discountSlab3 = discountSlab2 + ((totalCartPrice-10000.0)*0.2);
		
		if( 0.0 <= totalCartPrice && totalCartPrice <= 5000.0) {
			return totalCartPrice - discountSlab1;
		} else if ( 5000.00 < totalCartPrice && totalCartPrice <= 10000.0 ) {
			return (totalCartPrice - discountSlab2);
		} else {
			return (totalCartPrice - discountSlab3);
		}
		
	}

}
