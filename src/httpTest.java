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
	public void testDistancePathCalculation() throws IOException
	{
		url = new URL(uri + "/distance/0/0/100/100");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		InputStream inputStream = connection.getInputStream();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						inputStream));

		StringBuilder response = new StringBuilder();
		String currentLine;

		while ((currentLine = in.readLine()) != null) 
			response.append(currentLine);

		in.close();

		String responseBody = response.toString();
		String trueValue = "The distance between (0, 0) and (100, 100) is 141.42136";
		
		assertTrue(responseBody.equals(trueValue));

	}


	@Test
	public void testBmiPathCalculation() throws IOException
	{
		url = new URL(uri + "/bmi/200/5/10");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		InputStream inputStream = connection.getInputStream();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						inputStream));

		StringBuilder response = new StringBuilder();
		String currentLine;

		while ((currentLine = in.readLine()) != null) 
			response.append(currentLine);

		in.close();

		String responseBody = response.toString();
		String trueValue = "You weigh 200 pounds. Your height is 5 feet 10 inches. This means your BMI is 29.387754 which puts you in the overweight category";

		assertTrue(responseBody.equals(trueValue));
	}


	@AfterClass
	public static void stopServer()
	{
		s.stopServer();
	}
}
