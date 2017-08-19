package datamanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import impl.OrderDataManagement;
import junit.framework.Assert;

public class GetOrderDataTest {

	IOrderDataManagement orderData = new OrderDataManagement();
	
	@Test
	public void orderCountTest(){
		Assert.assertNotNull(orderData.getOrderCount());

	}
	
	@Test
	public void orderDetailTest(){
		Assert.assertNotNull(orderData.getAllOrderDetails());
	}
}
