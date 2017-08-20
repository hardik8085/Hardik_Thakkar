import datamanagement.ICustomerDataManagement;
import datamanagement.IOrderDataManagement;
import impl.CustomerDataManagement;
import impl.OrderDataManagement;

public class MainApplication {

	public static void main(String [] args){
		ICustomerDataManagement customer = new CustomerDataManagement();
		IOrderDataManagement order = new OrderDataManagement();
		
		System.out.println("Total Number of Customer");
		System.out.println(customer.getCustomerData());
		System.out.println("Total Number of Order");
		System.out.println(order.getOrderCount());
		System.out.println("Median order value");
		System.out.println(order.medianOrderValue());
		System.out.println("Shortest Duration (Seconds)");
		System.out.println(order.shortestDuration());
		System.out.println("Minimum and Maximum frequent order");
		System.out.println(order.minAndMaxFrequentItem().toString());
		
	}
}
