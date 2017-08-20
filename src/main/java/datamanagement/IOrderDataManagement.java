package datamanagement;

import java.util.List;
import java.util.Map;

import model.Order;

/**
 * Get order related data management
 * 
 * @author hardik thakkar
 *
 */
public interface IOrderDataManagement {

	/**
	 * Get order Count
	 * 
	 * @return order count
	 */
	public Long getOrderCount();

	/**
	 * Get order details in the form of HashMap
	 * 
	 * @return HashMap<String(Customer_Name),List<Order>>
	 */
	public Map<String, List<Order>> getAllOrderDetails();

	/**
	 * Get Min and Max frequent order
	 * 
	 * @return Map<"Min/Max",String(Order_Name)>
	 */
	public Map<String, List<String>> minAndMaxFrequentItem();

	/**
	 * Get shortest Duration between the two order in milliseconds
	 * 
	 * @return shortest duration in milliseconds
	 */
	public Long shortestDuration();

	/**
	 * Median Order value if number of order value is odd and if its even then take mean of two order value
	 * @return Double value 
	 */
	public Double medianOrderValue();
}
