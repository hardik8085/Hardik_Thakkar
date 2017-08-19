package datacollection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import createconnection.CreateShopifyConnection;
import createconnection.ICreateConnection;
import createconnection.ListOfRequest;

public class GetOrderData implements IGetOrderData {

	private ICreateConnection httpConnection = new CreateShopifyConnection();

	@Override
	public String getOrderData(Enum request) {

		
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
			System.out.println(response.toString());
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
