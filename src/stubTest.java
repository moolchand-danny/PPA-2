import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class stubTest {

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
	public void testDistancePathCalculation1() throws IOException
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
	public void testDistancePathCalculation2() throws IOException
	{
		url = new URL(uri + "/distance/1/1/1/1");
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
		String trueValue = "The distance between (1, 1) and (1, 1) is 0.0";

		assertTrue(responseBody.equals(trueValue));

	}


	@Test
	public void testBmiPathCalculation1() throws IOException
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
		
		assertTrue(responseBody.contains("BMI is 29.387754"));
	}
	
	@Test
	public void testBmiPathCalculation2() throws IOException
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

		assertTrue(responseBody.contains("overweight category"));
	}

	
	@AfterClass
	public static void stopServer()
	{
		s.stopServer();
	}
}
