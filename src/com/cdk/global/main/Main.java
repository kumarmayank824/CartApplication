package com.cdk.global.main;

import com.cdk.global.beans.Cart;
import com.cdk.global.beans.Product;
import com.cdk.global.impl.RegularCustomer;

public class Main {
  
	public static void main(String[] args) {
		
		Cart cart = new Cart();
		Product p1 = new Product();
		p1.setName("Washing Machine");
		p1.setPrice(4000.0);
		cart.addProduct(p1);
		cart.addProduct(p1);
		Product p2 = new Product();
		p2.setName("Mixer");
		p2.setPrice(3000.0);
		cart.addProduct(p2);
		Product p3 = new Product();
		p3.setName("Mixer");
		p3.setPrice(4000.0);
		cart.addProduct(p3);
		System.out.println(cart.getTotalCartPrice());
		System.out.println(cart.doCheckOut(new RegularCustomer()));
		System.out.println("After Removing");
		cart.removeProduct(p1);
		System.out.println(cart.getTotalCartPrice());
		System.out.println(cart.doCheckOut(new RegularCustomer()));
	}
}
