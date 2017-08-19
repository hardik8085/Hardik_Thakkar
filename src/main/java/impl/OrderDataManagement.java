package impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
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
		
		List<Order> container = new ArrayList<>();
		String response = orderData.getOrderData(ListOfRequest.GET_ALL_ORDER_DETAIL);
		JSONParser parser = new JSONParser();
		JSONObject object;
		try {
			object = (JSONObject) parser.parse(response);
			JSONArray listOfOrder = (JSONArray) object.get("orders");
			int length = listOfOrder.size();
			for(int i = 0;i< length ;i++){
				JSONObject order = (JSONObject) listOfOrder.get(i);
				String orderName = (String) order.get("name");
				String date = (String) order.get("created_at");
				Date finalDate = new Date(Integer.parseInt(date.substring(0,4)),Integer.parseInt(date.substring(5,7)),Integer.parseInt(date.substring(8,10)),Integer.parseInt(date.substring(11,13)),Integer.parseInt(date.substring(14,16)),Integer.parseInt(date.substring(17,19)));
				Double totalPrice = Double.parseDouble((String) order.get("total_price_usd"));
				JSONObject customer = (JSONObject) order.get("customer"); 
				String customerName = (String) customer.get("email");
				Order orderObject = new Order(orderName,customerName,totalPrice,finalDate);
				container.add(orderObject);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e);
			return null;

		}
		return container;
	}

}
