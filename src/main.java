import java.util.Scanner;
import java.lang.Math;


public class main {

	public static void main(String[] args) {

		boolean exitMenu = false;

		while(!exitMenu)
		{
			Scanner scanner = new Scanner(System.in);
		
			System.out.println("Choose one of the following options: ");
			System.out.println("1. Body Mass Index Calculator");
			System.out.println("2. Retirement Calculator");
			System.out.println("3. Shortest Distance Calculator");
			System.out.println("4. Split the Tip Calculator");
			System.out.println("5. Exit Menu");
			System.out.print("Choice: ");

			int menuOption = scanner.nextInt();

			switch (menuOption)
			{
			case 0:
				break;
			case 1:
				//System.out.println("Case 1");
				break;
			case 2:
				//System.out.println("Case 2");
				break;
			case 3:
				distance();
				break;
			case 4:
				//System.out.println("Case 4");
				break;
			case 5:
				System.out.println("Exiting. Thank You.");
				exitMenu = true;
				scanner.close();
				break;
			default:
				System.out.println("Not a valid option.");
				break;
			}
		}

	}

	public static float distance ()
	{
		Scanner scan = new Scanner(System.in);
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

		System.out.print("Enter x1: ");
		x1 = scan.nextInt();

		System.out.print("Enter y1: ");
		y1 = scan.nextInt();

		System.out.print("Enter x2: ");
		x2 = scan.nextInt();

		System.out.print("Enter y2: ");
		y2 = scan.nextInt();

		float distance = (float) Math.sqrt((float) (Math.pow(x2-x1, 2)) + (float) (Math.pow(y2-y1, 2)));
		System.out.println("Distance between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is: " + distance + "\n");

		return distance;
	}



}
