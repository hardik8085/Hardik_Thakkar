package createconnection;
import java.net.HttpURLConnection;

/**
 * Cretae connection 
 * @author hardik thakkar
 *
 */
public interface ICreateConnection {
	
	/**
	 * Create connection based on the input parameter and send it back
	 * @param requireData represent the url to create connection
	 * @return Connection
	 */
	public HttpURLConnection createConnection(Enum requireData);
}
