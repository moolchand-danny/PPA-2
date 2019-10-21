import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.sql.*;


public class main {

	static Database D = new Database();
	static server s = new server();


	public static void main(String[] args) {
		
		s.run();

		try
		{
			D.connect("ppa2", "root", "1234");
		} 
		catch (Exception e) 
		{
			System.out.println("Couldn't connect to database.");
			//e.printStackTrace();
		}	

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
				splitTip();
				break;
			case 5:
				System.out.println("Exiting. Thank You.");
				exitMenu = true;
				s.stopServer();
				scanner.close();
				break;
			default:
				System.out.println("Not a valid option.");
				break;
			}
		}

	}

	public static double splitTip ()
	{
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00"); 

		double billTotal = 0;
		int numGuests = 0;
		double dinnerAmount = 0;

		System.out.print("Enter the total of the bill: $");
		billTotal = Double.parseDouble(df.format(scan.nextDouble()));

		System.out.print("Enter the number of paying guests: ");
		numGuests = scan.nextInt();

		dinnerAmount = Double.parseDouble(df.format(billTotal * 1.15));

		System.out.println("Total dinner amout is: $" + dinnerAmount);

		for(int i = 1; i <= numGuests; i++)
		{
			System.out.println("guest" + i + " - $" + Double.parseDouble(df.format(dinnerAmount / numGuests)));
		}


		return dinnerAmount;
	}

	public static float distance ()
	{

		ResultSet rs;
		try {
			rs = D.query("SELECT * FROM distanceTable");
			D.printRS(rs);
		} catch (Exception e) {
			System.out.println("Couldn't pull from distanceTable");
			//e.printStackTrace();
		}

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

		String saveData = "INSERT INTO distanceTable (x1, y1, x2, y2, result) VALUES (" + x1 + ","+ y1 + ","+ x2 + ","+ y2 + "," + distance + ")";
		//System.out.println(saveData);
		try {
			D.execute(saveData);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Couldn't save distance data.");
		}

		return distance;
	}

	public static float bmi() {

		ResultSet rs;
		try {
			rs = D.query("SELECT * FROM bmiTable");
			D.printRS(rs);
		} catch (Exception e) {
			System.out.println("Couldn't pull from bmiTable");
			//e.printStackTrace();
		}

		Scanner myObj = new Scanner(System.in);

		System.out.println("Enter your bodyweight in pounds.");
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
		if (bmival > 30) {
			category = "obese";
		}

		System.out.println("Your BMI is " + bmival + ", which puts you in the " + category + " category.");

		String saveData = "INSERT INTO bmiTable (weight_lbs, height_ft, height_in, bmi, category) VALUES (" + lbs + ","+ feet + ","+ inches + ","+ bmival + ",'" + category + "')";
		//System.out.println(saveData);
		try {
			D.execute(saveData);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Couldn't save bmi data.");
		}

		return bmival;
	}

	public static float retire() {
		Scanner myObj = new Scanner(System.in);

		System.out.println("Enter your current age in years.");
		float currentAge = myObj.nextFloat();

		System.out.println("Enter your annual salary to the nearest thousand.");
		float annualSalary = myObj.nextFloat();

		System.out.println("Enter what percentage of your salary you save. Estimate to the nearest whole percent.");
		float individualSave = myObj.nextFloat();

		System.out.println("Enter how much you expect to have saved to comfortably retire. Estimate to the nearest whole number.");
		float goalAmount = myObj.nextFloat();

		float yearlySavings = (float)(annualSalary * individualSave * 1.35);

		float yearsToRetire = (goalAmount/yearlySavings);

		float ageOfRetirement = currentAge + yearsToRetire;

		if (ageOfRetirement < 100) {
			System.out.println("You will reach your retirement savings goal at the age of " + ageOfRetirement + ".");
		}
		else 
			System.out.println("Assuming you live to 100 years old, you will die before reaching your retirement savings goal.");

		return ageOfRetirement;
	}


	


}
