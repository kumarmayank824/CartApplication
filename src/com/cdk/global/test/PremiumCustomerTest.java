package com.cdk.global.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cdk.global.beans.Cart;
import com.cdk.global.beans.Product;
import com.cdk.global.impl.PremiumCustomer;

public class PremiumCustomerTest {
    
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
		cart.addProduct(getProduct("Washing Machine", 3000.0));
		cart.addProduct(getProduct("Mixer", 1000.0));
		Assert.assertEquals(4000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(3600.0, cart.doCheckOut(new PremiumCustomer()), 0.0);
	}
	
	@Test
	public void discountSlab2Test() {
		cart.addProduct(getProduct("Washing Machine", 5000.0));
		cart.addProduct(getProduct("Mixer", 3000.0));
		Assert.assertEquals(8000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(7000.0, cart.doCheckOut(new PremiumCustomer()), 0.0);
	}
	
	@Test
	public void discountSlab3Test() {
		cart.addProduct(getProduct("Washing Machine", 10000.0));
		cart.addProduct(getProduct("Mixer", 2000.0));
		Assert.assertEquals(12000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(10200.0, cart.doCheckOut(new PremiumCustomer()), 0.0);
	}
	
	@Test
	public void discountSlab4Test() {
		cart.addProduct(getProduct("Washing Machine", 10000.0));
		cart.addProduct(getProduct("Mixer", 10000.0));
		Assert.assertEquals(20000.0, cart.getTotalCartPrice(), 0.0);
		Assert.assertEquals(15800.0, cart.doCheckOut(new PremiumCustomer()), 0.0);
	}
}
