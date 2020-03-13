package com.cdk.global.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cdk.global.beans.Cart;
import com.cdk.global.beans.Product;
import com.cdk.global.impl.RegularCustomer;

public class RegularCustomerTest {
    
	Cart cart = null;
	
	@Before
    public void prepareCart() {
		cart = new Cart();
    }
	
	public Product getProduct(String productName, double price) {
		Product p = new Product();
		p.setName(productName);
		p.setPrice(price);
		return p;
	}
	
	@Test
	public void discountSlab1Test() {
		cart.addProduct(getProduct("Washing Machine", 4000.0));
		cart.addProduct(getProduct("Mixer", 1000.0));
		Assert.assertEquals(5000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(5000.0, cart.doCheckOut(new RegularCustomer()), 0.0);
	}
	
	@Test
	public void discountSlab2Test() {
		cart.addProduct(getProduct("Washing Machine", 6000.0));
		cart.addProduct(getProduct("Mixer", 4000.0));
		Assert.assertEquals(10000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(9500.0, cart.doCheckOut(new RegularCustomer()), 0.0);
	}
	
	@Test
	public void discountSlab3Test() {
		cart.addProduct(getProduct("Washing Machine", 10000.0));
		cart.addProduct(getProduct("Mixer", 5000.0));
		Assert.assertEquals(15000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(13500.0, cart.doCheckOut(new RegularCustomer()), 0.0);
	}
}
