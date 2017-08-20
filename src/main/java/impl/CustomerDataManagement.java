package impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import createconnection.ListOfRequest;
import datacollection.GetData;
import datacollection.IGetData;
import datamanagement.ICustomerDataManagement;
/**
 * Customer Data Management
 * @author hardik thakkar
 *
 */
public class CustomerDataManagement implements ICustomerDataManagement{

	IGetData orderData = new GetData();

	/**
	 * {@link ICustomerDataManagement#getCustomerData()}
	 */
	@Override
	public Long getCustomerData() {
		
		String response = orderData.getData(ListOfRequest.GET_ALL_CUSTOMER_COUNT);
		JSONParser parser = new JSONParser();
		JSONObject object;
		try {
			object = (JSONObject) parser.parse(response);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e);
			return (long) -1;
		}
		Long count = (Long) object.get("count");
		return count;
	}

}
