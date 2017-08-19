package createconnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

public class CreateShopifyConnection implements ICreateConnection {

	private static String apiCredential = "b1ade8379e97603f3b0d92846e238ad8";
	static HttpURLConnection connection = null;
	private static HashMap<Enum, String> container = null;

	@Override
	public HttpURLConnection createConnection(Enum requireData) {

		if (null == container) {
			mapKeyWithUrl();
		}
		// Create connection
		URL url;
		try {
			url = new URL(container.get(requireData));
			connection = (HttpURLConnection) url.openConnection();
			setRequestType(requireData.toString());
			connection.setRequestProperty("X-Shopify-Access-Token", apiCredential);
		} catch (MalformedURLException e) {
			System.out.println(e);
			return null;
		} catch (IOException e) {
			System.out.println(e);
			return null;
		}

		return connection;
	}

	public static void setRequestType(String requireData) {
		try {
			if (requireData.toLowerCase().contains("get")) {
				connection.setRequestMethod("GET");
			} else if (requireData.toLowerCase().contains("post")) {
				connection.setRequestMethod("POST");
			} else if (requireData.toLowerCase().contains("put")) {
				connection.setRequestMethod("PUT");
			} else if (requireData.toLowerCase().contains("delete")) {
				connection.setRequestMethod("DELETE");
			}
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mapKeyWithUrl() {
		container = new HashMap<>();
		container.put(ListOfRequest.GET_ALL_ORDER_DETAIL, " https://100pure-demo.myshopify.com/admin/orders.json");
		container.put(ListOfRequest.GET_ALL_CUSTOMER_DETAIL,
				" https://100pure-demo.myshopify.com/admin/customers.json");
		container.put(ListOfRequest.GET_ALL_ORGER_COUNT, " https://100pure-demo.myshopify.com/admin/orders/count.json");

	}
}
