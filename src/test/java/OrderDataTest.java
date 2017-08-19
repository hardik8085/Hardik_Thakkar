import org.junit.Assert;
import org.junit.Test;

import datacollection.GetOrderData;
import datacollection.IGetOrderData;

public class OrderDataTest {

	IGetOrderData orderData = new GetOrderData();
	
	
	@Test
	public void getData(){
		Assert.assertNotNull(orderData.getData());
	}
}
