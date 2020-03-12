package com.cdk.global.impl;

public class PremiumCustomer implements CustomerType {

	@Override
	public double applyDiscount(double totalCartPrice) {
		return determineDiscount(totalCartPrice);
	}

	private static double determineDiscount(double totalCartPrice) {
		
		double discountSlab1 = (4000.0 *0.1);
		double discountSlab2 = discountSlab1 + ((totalCartPrice- 4000.0) > 4000.0 ? 
                4000.0 *0.15 : (totalCartPrice- 4000.0) *0.15);
		double discountSlab3 = discountSlab2 + ((totalCartPrice- 8000.0) > 4000.0 ? 
                4000.0 *0.20 : (totalCartPrice- 8000.0) *0.20);
		double discountSlab4 = discountSlab3 + ((totalCartPrice-12000.0)*0.30);
		
		if( 0.0 <= totalCartPrice && 4000.0 >= totalCartPrice ) {
			return totalCartPrice - discountSlab1;
		} else if ( 4000.00 < totalCartPrice && 8000.0 >= totalCartPrice ) {
			return (totalCartPrice - discountSlab2);
		}  else if ( 8000.00 < totalCartPrice && 12000.0  >= totalCartPrice ) {
			return (totalCartPrice - discountSlab3);
		}  else {
			return (totalCartPrice - discountSlab4);
		}
		
	}

}
