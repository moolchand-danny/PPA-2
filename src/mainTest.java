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
		
		//1st Iteration
		String input = "0\n0\n0\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertTrue("Should return a 0", main.distance() == 0);
		

		input = "0\n0\n0\n10\n"; 
		double expectedDistance = 10;
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertEquals("Should calculate the correct distance 10 with inputs (0,0) (0,10)", expectedDistance, main.distance(), 0.001);

		//2nd Iteration
		input = "12\n14\n2\n3\n";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals("Should return correct distance", 14.866, main.distance(), 0.001);
		

		input = "-10\n-10\n-20\n-12\n"; 
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertTrue("Should calculate a positive distance",main.distance() >= 0);
		
	}

	@Test
		public void testBMI()
		{
			main main = new main();
	
			String input = "200\n5\n6\n";
			float expectedBmi = (float)33.057854;
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);	
			assertEquals("Should calculate the correct BMI 33.057854 with weight 200 lbs, height 5 ft 6 in", expectedBmi, main.bmi(), 0.001);
	
			input = "100\n6\n4\n";
			in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			assertTrue("Should place person in the underweight category", main.bmi() < 18.5);
	
		}
		@Test
		public void testRetire()
		{
			main main = new main();
	
			String input = "99\n10000\n4\n30000\n";
			float expectedAge = (float)99.55556;
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);	
			assertEquals("Should calculate the correct retirement age of 99.55556 starting at 99, making 10,000 per year, saving 4% and settting a goal of 30000", expectedAge, main.retire(), 0.001);
	
	
			input = "99\n100\n1\n1000000\n";
			in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			assertTrue("Should tell the user they will die before reaching their goal :'( ", main.retire() > 100);
	
		}
		
	
		@Test
		public void testSplitTip()
		{
			main main = new main();
			
			String input = "0\n0\n";
			double expectedValue = 0.0;
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			assertEquals("Should return a precise 0.0", expectedValue, main.splitTip(), 0.000 );
			
			input = "15.157345\n3\n";
			expectedValue = 17.43;
			in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			assertEquals("Should return a value precisely equal to expectedValue, with 2 decimal places", expectedValue, main.splitTip(), 0.000 );	
			
		}

}

