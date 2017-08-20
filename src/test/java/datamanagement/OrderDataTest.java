package datamanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import impl.OrderDataManagement;
import junit.framework.Assert;

public class OrderDataTest {

	IOrderDataManagement orderData = new OrderDataManagement();
	
	@Test
	public void orderCountTest(){
		Assert.assertNotNull(orderData.getOrderCount());

	}
	
	@Test
	public void orderDetailTest(){
		Assert.assertNotNull(orderData.getAllOrderDetails());
	}
	
	@Test
	public void minAndMaxOrderDetailTest(){
		Assert.assertNotNull(orderData.minAndMaxFrequentOrder());
	}
	
	@Test
	public void medianOrderValueTest(){
		Assert.assertNotNull(orderData.medianOrderValue());
	}
	
	@Test
	public void shortestDurationTest(){
		Assert.assertNotNull(orderData.shortestDuration());
	}
}
