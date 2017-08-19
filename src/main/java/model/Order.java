package model;

import java.util.Calendar;
import java.util.Date;

public class Order {
	String orderName;
	String customerName;
	Double value;
	Date date;

	public Order(String orderName, String customerName, Double value, Date date) {
		super();
		this.orderName = orderName;
		this.customerName = customerName;
		this.value = value;
		this.date = date;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
		return "Order [orderName=" + orderName + ", customerName=" + customerName + ", value=" + value + ", date="
				+ date + "]";
	}

}
