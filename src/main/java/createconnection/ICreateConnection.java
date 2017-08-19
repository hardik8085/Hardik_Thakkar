package createconnection;
import java.net.HttpURLConnection;

public interface ICreateConnection {
	
	
	public HttpURLConnection createConnection(Enum requireData);
}
