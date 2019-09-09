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
				bmi();
				break;
			case 2:
				retire();
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

	public static float bmi() {
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Enter your boodyweight in pounds.");
		float lbs = myObj.nextFloat();
		float kgs = (float)(lbs * 0.45);
		
		System.out.println("Enter how many whole feel tall you are. E.g. if I am 5 feet 2 inches tall I will enter 5.");
		float feet = myObj.nextInt();
		System.out.println("Enter how many inches taller you are than your whole foot measurement.");
		float inches = myObj.nextInt();
		
		float totalin = (feet * 12) + inches;
		float meters = (float)(totalin * .025);
		float sqm = (meters * meters);
		float bmival = (kgs / sqm);
		
		String category = "";
		if (bmival <= 18.5) {
			 category = "underweight";
		}
		if ((bmival > 18.5) && (bmival < 25)) {
			 category = "normal weight";
		}
		if ((bmival >= 25) && (bmival < 30)) {
			 category = "overweight";
		}
		if (bmival < 30) {
			 category = "obese";
		}
		
		System.out.println("Your BMI is " + bmival + ", which puts you in the " + category + " category.");
		
		
		return bmival;
	}
	
	public static int retire() {
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Enter your current age in years.");
		int age = myObj.nextInt();
		
		System.out.println("Enter your annual salary to the nearest thousand.");
		int salary = myObj.nextInt();
		
		System.out.println("Enter what percentage of your salary you save. Estimate to the nearest whole percent.");
		int save = myObj.nextInt();
		
		System.out.println("Enter how much you expect to have saved to comfortably retire. Estimate to the nearest whole number.");
		int goalamt = myObj.nextInt();
		
		float goalage = (float)(age + (goalamt)/(salary * save * 1.35));
				
		if (goalage < 100) {
			System.out.println("You will reach your retirement savings goal at the age of " + goalage + ".");
		}
		else 
			System.out.println("Assuming you live to 100 years old, you will die before reaching your retirement savings goal.");
		
		return 2;
	}


}
