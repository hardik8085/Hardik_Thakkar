import org.junit.Assert;
import org.junit.Test;

import createconnection.CreateShopifyConnection;
import createconnection.ICreateConnection;
import createconnection.ListOfRequest;

public class ConnectionTest {

	ICreateConnection createConnection = new CreateShopifyConnection();

	@Test
	public void getOrderDataCountConnection(){
		Assert.assertNotNull(createConnection.createConnection(ListOfRequest.GET_ALL_ORGER_COUNT));
	}
	@Test
	public void getOrderDataDetailConnection(){
		Assert.assertNotNull(createConnection.createConnection(ListOfRequest.GET_ALL_ORDER_DETAIL));
	}
	@Test
	public void getCustomerDataCountConnection(){
		Assert.assertNotNull(createConnection.createConnection(ListOfRequest.GET_ALL_CUSTOMER_COUNT));
	}
	@Test
	public void getCustomerDataDetailsConnection(){
		Assert.assertNotNull(createConnection.createConnection(ListOfRequest.GET_ALL_CUSTOMER_DETAIL));
	}
}
