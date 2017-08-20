package datacollection;

/**
 * Get data from shopify api
 * @author hardik thakkar
 *
 */
public interface IGetData {
	
	/**
	 * Get data for get request without any parameter
	 * @param request Type to create connection based on enum request
	 * @return data from shopify as String
	 */
	public String getData(Enum request);
}
