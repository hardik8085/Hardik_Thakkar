import org.junit.Assert;
import org.junit.Test;

import datacollection.GetData;
import datacollection.IGetData;

public class OrderDataTest {

	IGetData orderData = new GetData();
	
	
	@Test
	public void getData(){
		Assert.assertNotNull(orderData.getData());
	}
}
