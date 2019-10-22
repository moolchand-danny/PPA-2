import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class httpTest {

	static server s = new server();

	static HttpURLConnection connection = null;
	static URL url = null;

	static String port = "5000";
	static String localhost = "http://localhost";
	static String uri = localhost + ":" + port;

	@BeforeClass
	public static void startServer()
	{	
		s.run();

		try {
			url = new URL(uri);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}


	@Test
	public void testServerOnline() {
		int serverStatusCode = 0;
		try 
		{
			serverStatusCode = connection.getResponseCode();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		//Asserts that the server is online and running
		assertTrue(serverStatusCode == 200);
	}


	@Test
	public void testDistancePathExistance() throws IOException
	{
		url = new URL(uri + "/distance");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int serverStatusCode = 0;
		serverStatusCode = connection.getResponseCode();

		//Asserts that the distance path exists
		assertTrue(serverStatusCode == 200);

	}
	
	@Test
	public void testDistancePathInputError() throws IOException
	{
		url = new URL(uri + "/distance/0.1/0.2/0.3/0.4");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int serverStatusCode = 0;
		serverStatusCode = connection.getResponseCode();

		//Asserts that the distance path gives a 500 error with bad input
		assertTrue(serverStatusCode == 500);

	}


	@Test
	public void testBmiPathExistance() throws IOException
	{
		url = new URL(uri + "/bmi");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int serverStatusCode = 0;
		serverStatusCode = connection.getResponseCode();

		//Asserts that the distance path exists
		assertTrue(serverStatusCode == 200);

	}
	
	@Test
	public void testBmiPathInputError() throws IOException
	{
		url = new URL(uri + "/bmi/a/b/c");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int serverStatusCode = 0;
		serverStatusCode = connection.getResponseCode();

		//Asserts that the bmi path gives error on bad input
		assertTrue(serverStatusCode == 500);

	}


	@AfterClass
	public static void stopServer()
	{
		s.stopServer();
	}
}
