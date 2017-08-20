package datamanagement;

import org.junit.Assert;
import org.junit.Test;

import impl.CustomerDataManagement;

public class CustomerDataTest {

	ICustomerDataManagement customerData = new CustomerDataManagement();
	
	
	@Test
	public void orderCountTest(){
		Assert.assertNotNull(customerData.getCustomerData());

	}
}
