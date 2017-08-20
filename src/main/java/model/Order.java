package model;

import java.util.List;

import org.joda.time.DateTime;

/**
 * Order related data
 * @author hardik thakkar
 *
 */
public class Order implements Comparable<Order>{
	String orderName;
	Double value;
	DateTime date;
	List<Item> listOfItem;

	public Order(String orderName, Double value, DateTime date,List<Item> listOfItem) {
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

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public List<Item> getListOfItem(){
		return this.listOfItem;
	}
	
	
	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", value=" + value + ", date=" + date + "]";
	}

	
	
	@Override
	public int compareTo(Order o) {

		
             return this.getDate().compareTo(o.getDate());
         
	}

}
