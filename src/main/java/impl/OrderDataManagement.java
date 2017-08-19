package impl;

import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import createconnection.ListOfRequest;
import datacollection.GetOrderData;
import datacollection.IGetOrderData;
import datamanagement.IOrderDataManagement;
import model.Order;

public class OrderDataManagement implements IOrderDataManagement{

	IGetOrderData orderData = new GetOrderData();
	
	@Override
	public Long getOrderCount() {

		String response = orderData.getOrderData(ListOfRequest.GET_ALL_ORGER_COUNT);
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

	@Override
	public List<Order> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
