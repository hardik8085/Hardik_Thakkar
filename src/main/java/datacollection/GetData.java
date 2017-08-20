package datacollection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import createconnection.CreateShopifyConnection;
import createconnection.ICreateConnection;

/**
 * Get data from shopify api
 * @author hardik thakkar
 *
 */
public class GetData implements IGetData {

	private ICreateConnection httpConnection = new CreateShopifyConnection();

	/**
	 * {@link IGetData # getData(Enum)}
	 */
	@Override
	public String getData(Enum request) {

		//Connection based on the request
		HttpURLConnection connection = httpConnection.createConnection(request);

		// Get Response
		InputStream is;
		try {
			is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder(); 
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}

		finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

	}

	

}
