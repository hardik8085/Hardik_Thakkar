package datamanagement;

import java.util.List;

import model.Order;

public interface IOrderDataManagement {
	
	public Long getOrderCount();
	public List<Order> getAllOrderDetails();
}
