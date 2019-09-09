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
		int expectedDistance = 10;
		
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
				
		assertEquals("Should calculate the correct distance", expectedDistance, main.distance(), 0.001);
	}

}

  