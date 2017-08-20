package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import createconnection.ListOfRequest;
import datacollection.GetData;
import datacollection.IGetData;
import datamanagement.IOrderDataManagement;
import model.Item;
import model.Order;

/**
 * Order Data Management
 * 
 * @author hardik thakkar
 *
 */
public class OrderDataManagement implements IOrderDataManagement {

	IGetData orderData = new GetData();
	Map<String, List<Order>> container = null;
	String orderAsString = null;

	/**
	 * {@link IOrderDataManagement#getOrderCount()}
	 */
	@Override
	public Long getOrderCount() {

		String response = orderData.getData(ListOfRequest.GET_ALL_ORGER_COUNT);
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

	/**
	 * {@link IOrderDataManagement#getAllOrderDetails()}
	 */
	@Override
	public Map<String, List<Order>> getAllOrderDetails() {

		container = new HashMap<>();
		orderAsString = orderData.getData(ListOfRequest.GET_ALL_ORDER_DETAIL);
		JSONParser parser = new JSONParser();
		JSONObject object;
		try {
			object = (JSONObject) parser.parse(orderAsString);
			JSONArray listOfOrder = (JSONArray) object.get("orders");
			int length = listOfOrder.size();
			for (int i = 0; i < length; i++) {
				JSONObject order = (JSONObject) listOfOrder.get(i);
				String orderName = (String) order.get("name");
				String date = (String) order.get("created_at");
				DateTime finalDate = new DateTime(Integer.parseInt(date.substring(0, 4)),
						Integer.parseInt(date.substring(5, 7)), Integer.parseInt(date.substring(8, 10)),
						Integer.parseInt(date.substring(11, 13)), Integer.parseInt(date.substring(14, 16)),
						Integer.parseInt(date.substring(17, 19)));
				Double totalPrice = Double.parseDouble((String) order.get("total_price_usd"));
				JSONObject customer = (JSONObject) order.get("customer");
				String customerName = (String) customer.get("email");
				JSONArray listOfItem = (JSONArray) order.get("line_items");
				int numberOfItem = listOfItem.size();
				List<Item> finalListOfItem = new ArrayList<>();
				for (int j = 0; j < numberOfItem; j++) {
					JSONObject item = (JSONObject) listOfItem.get(j);
					String itemName = (String) item.get("name");
					Long quantity = (Long) item.get("quantity");
					Item finalItem = new Item(itemName, quantity);
					finalListOfItem.add(finalItem);
				}

				Order finalOrder = new Order(orderName, totalPrice, finalDate, finalListOfItem);

				if (container.containsKey(customerName)) {
					List<Order> temp = container.get(customerName);
					temp.add(finalOrder);
					container.put(customerName, temp);
				} else {
					List<Order> temp = new ArrayList<>();
					temp.add(finalOrder);
					container.put(customerName, temp);
				}

			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e);
			return null;

		}
		return container;
	}

	/**
	 * {@link IOrderDataManagement#minAndMaxFrequentItem()}
	 */
	@Override
	public Map<String, List<String>> minAndMaxFrequentItem() {

		Map<String, Integer> itemContainer = new HashMap<>();
		if (null == container) {
			container = getAllOrderDetails();
		}

		for (String customer : container.keySet()) {

			List<Order> listOfOrder = container.get(customer);
			for (Order order : listOfOrder) {
				List<Item> listOfItem = order.getListOfItem();
				for (Item item : listOfItem) {
					if (itemContainer.containsKey(item.getName())) {
						int tempCount = itemContainer.get(item.getName());
						tempCount++;
						itemContainer.put(item.getName(), tempCount);
					} else {
						itemContainer.put(item.getName(), 1);
					}
				}

			}
		}
		List<String> minItem = null;
		Integer minValue = -1;
		List<String> maxItem = null;
		Integer maxValue = -1;
		for (String itemName : itemContainer.keySet()) {
			if (null == minItem && null == maxItem) {
				minItem = new ArrayList<>();
				minItem.add(itemName);
				minValue = itemContainer.get(itemName);
				maxItem = new ArrayList<>();
				maxItem.add(itemName);
				maxValue = itemContainer.get(itemName);
			} else {
				if (itemContainer.get(itemName) < minValue) {
					minItem = new ArrayList<>();
					minItem.add(itemName);
					minValue = itemContainer.get(itemName);
				} else if (itemContainer.get(itemName) == minValue) {
					minItem.add(itemName);
				}
				if (itemContainer.get(itemName) > maxValue) {
					maxItem = new ArrayList<>();
					maxItem.add(itemName);
					maxValue = itemContainer.get(itemName);
				} else {
					maxItem.add(itemName);
				}

			}
		}
		Map<String, List<String>> response = new HashMap<>();
		response.put("Minimum Frequent Item", minItem);
		response.put("Maximum Frequent Item", maxItem);
		return response;
	}

	/**
	 * {@link IOrderDataManagement#getAllOrderDetails()()}
	 */
	@Override
	public Long shortestDuration() {

		Duration minDuration = null;
		if (null == container) {
			container = getAllOrderDetails();
		}

		for (String customer : container.keySet()) {

			List<Order> listOfOrder = container.get(customer);

			// Sort order by Data
			Collections.sort(listOfOrder, new Comparator<Order>() {
				@Override
				public int compare(Order o1, Order o2) {

					return o1.getDate().compareTo(o2.getDate());

				}
			});

			// If size of list if more than 1 then consider the difference
			if (listOfOrder.size() > 1) {
				if (null == minDuration) {
					DateTime firstDate = listOfOrder.get(0).getDate();
					DateTime secondDate = listOfOrder.get(1).getDate();
					Interval interval = new Interval(firstDate, secondDate);
					minDuration = interval.toDuration();
				}
				for (int i = 1; i < listOfOrder.size(); i++) {
					DateTime firstDate = listOfOrder.get(i).getDate();
					int j = i - 1;
					DateTime secondDate = listOfOrder.get(j).getDate();
					Interval interval = new Interval(secondDate, firstDate);
					Duration duration = interval.toDuration();
					if (duration.getStandardSeconds() < minDuration.getStandardSeconds()) {
						minDuration = duration;
					}
				}

			}

		}

		return minDuration.getStandardSeconds();
	}

	/**
	 * {@link IOrderDataManagement#medianOrderValue()}
	 */
	@Override
	public Double medianOrderValue() {

		if (null == orderAsString) {
			orderAsString = orderData.getData(ListOfRequest.GET_ALL_ORDER_DETAIL);
		}
		JSONParser parser = new JSONParser();
		JSONObject object;

		try {
			object = (JSONObject) parser.parse(orderAsString);
			JSONArray listOfOrder = (JSONArray) object.get("orders");
			int length = listOfOrder.size();
			if (length % 2 == 0) {
				int median = length / 2;
				JSONObject medianOrder1 = (JSONObject) listOfOrder.get(median);
				median--;
				JSONObject medianOrder2 = (JSONObject) listOfOrder.get(median);
				Double medianValue = (Double.parseDouble((String) medianOrder1.get("total_price_usd"))
						+ Double.parseDouble((String) medianOrder2.get("total_price_usd"))) / 2;
				return medianValue;
			} else {
				int median = (int) Math.floor(length / 2);
				Order medianOrder = (Order) listOfOrder.get(median);
				return medianOrder.getValue();
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}

	}

}
