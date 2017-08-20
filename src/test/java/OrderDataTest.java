import org.junit.Assert;
import org.junit.Test;

import createconnection.ListOfRequest;
import datacollection.GetData;
import datacollection.IGetData;

public class OrderDataTest {

	IGetData orderData = new GetData();
	
	
	@Test
	public void getOrderDataCount(){
		Assert.assertNotNull(orderData.getData(ListOfRequest.GET_ALL_ORGER_COUNT));
	}
	
	@Test
	public void getOrderData(){
		Assert.assertNotNull(orderData.getData(ListOfRequest.GET_ALL_ORDER_DETAIL));
	}
	
	@Test
	public void getCustomerDataCount(){
		Assert.assertNotNull(orderData.getData(ListOfRequest.GET_ALL_CUSTOMER_COUNT));
	}
	
	@Test
	public void getCustomerData(){
		Assert.assertNotNull(orderData.getData(ListOfRequest.GET_ALL_CUSTOMER_DETAIL));
	}
}
