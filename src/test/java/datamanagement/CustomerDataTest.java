package datamanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import impl.CustomerDataManagement;
import junit.framework.Assert;

public class CustomerDataTest {

	ICustomerDataManagement customerData = new CustomerDataManagement();
	
	
	@Test
	public void orderCountTest(){
		Assert.assertNotNull(customerData.getCustomerData());

	}
}
