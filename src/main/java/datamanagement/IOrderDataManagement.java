package datamanagement;

import java.util.List;
import java.util.Map;

import model.Order;

public interface IOrderDataManagement {

	public Long getOrderCount();

	public Map<String, List<Order>> getAllOrderDetails();

	public Map<String, String> minAndMaxFrequentOrder();
	
	
	public Long shortestDuration();
	
	
	public Double medianOrderValue();
}
