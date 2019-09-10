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
		
		String input = "0\n0\n0\n10\n"; 
		double expectedDistance = 10;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertEquals("Should calculate the correct distance 10 with inputs (0,0) (0,10)", expectedDistance, main.distance(), 0.001);
		
		
		input = "12\n14\n2\n3\n"; 
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertTrue("Should calculate a positive distance",main.distance() >= 0);
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 03d8ee1... Merge branch 'master' of https://github.com/TimCrowley99/PPA-1
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
	
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 0463ffc... test
	@Test
	public void testBMI()
	{
		main main = new main();

<<<<<<< HEAD
		String input = "200\n5\n6\n";
		float expectedBmi = (float)33.057854;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertEquals("Should calculate the correct BMI 33.057854 with weight 200 lbs, height 5 ft 6 in", expectedBmi, main.bmi(), 0.001);
		
		input = "100\n6\n4\n";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertTrue("Should place person in the underweight category", main.bmi() < 18.5);
=======
		String input = "";
		float expectedBmi = 25;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertEquals();
		
		input = "";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertTrue();
>>>>>>> parent of 0463ffc... test
		
	}
	@Test
	public void testRetire()
	{
		main main = new main();

<<<<<<< HEAD
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
>>>>>>> b62d65d8a97bb75cc9bd6ffcd2bac1a3b4828a90
=======
		String input = "";
		float expectedAge = 75;
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);	
		assertEquals();
		
		
		input = "";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertTrue();
		
	}
>>>>>>> parent of 0463ffc... test
=======
>>>>>>> parent of 03d8ee1... Merge branch 'master' of https://github.com/TimCrowley99/PPA-1
	@Test
	public void testSplitTip()
	{
		
		
	}

}

  