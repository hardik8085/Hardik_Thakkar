package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
	String orderName;
	Double value;
	Date date;
	List<Item> listOfItem;

	public Order(String orderName, Double value, Date date,List<Item> listOfItem) {
		super();
		this.orderName = orderName;
		this.value = value;
		this.date = date;
		this.listOfItem = listOfItem;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", value=" + value + ", date=" + date + "]";
	}

}
