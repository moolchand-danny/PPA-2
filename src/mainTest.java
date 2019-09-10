import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.*;
import org.junit.Test;

public class mainTest {
	
	Scanner scanner = new Scanner(System.in);

	
	@Test
	public void testDistance() 
	{
		main main = new main();
		
		String input = "0\n 0\n 0\n 10\n"; 
		double expectedDistance = 10;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertEquals("Should calculate the correct distance 10 with inputs (0,0) (0,10)", expectedDistance, main.distance(), 0.001);
		
		
		input = "12\n 14\n 2\n 3\n"; 
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertTrue("Should calculate a positive distance",main.distance() >= 0);
	}
	
//	@Test
//	public void testBMI()
//	{
//		main main = new main();
//
//		String input = "";
//		float expectedBmi = 25;
//		InputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);	
//		assertEquals();
//		
//		input = "";
//		in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
//		assertTrue();
//		
//	}
//	
//	@Test
//	public void testRetire()
//	{
//		main main = new main();
//
//		String input = "";
//		float expectedAge = 75;
//		InputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);	
//		assertEquals();
//		
//		
//		input = "";
//		in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
//		assertTrue();
//		
//	}
	
	@Test
	public void testSplitTip()
	{
		
		
	}

}

  