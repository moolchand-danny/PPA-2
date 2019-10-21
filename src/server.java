import static spark.Spark.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class server {

	static Database D = new Database();


	public static void run() {
		try
		{
			D.connect("ppa2", "root", "1234");
		} 
		catch (Exception e) 
		{
			System.out.println("Couldn't connect to database.");
			//e.printStackTrace();
		}	

		port(5000);
		
		get("", (req, res) -> "Look at README for proper URL(s)");
		get("/", (req, res) -> "Look at README for proper URL(s)");
		
		get("/distance", (req, res) -> getDistanceTable());
		get("/bmi", (req, res) -> getBMITable());

		get("/distance/:x1/:y1/:x2/:y2", (req, res) -> {
			int x1 = Integer.parseInt(req.params(":x1"));
			int y1 = Integer.parseInt(req.params(":y1"));
			int x2 = Integer.parseInt(req.params(":x2"));
			int y2 = Integer.parseInt(req.params(":y2"));

			float distance = calculateDistance(x1,y1, x2, y2);

			String s = "The distance between (" +
					req.params(":x1") +
					", " +
					req.params(":y1") +
					") and (" +
					req.params(":x2") +
					", " +
					req.params(":y2") +
					") is " +
					distance;

			String saveData = "INSERT INTO distanceTable (x1, y1, x2, y2, result) VALUES (" + x1 + ","+ y1 + ","+ x2 + ","+ y2 + "," + distance + ")";
			try {
				D.execute(saveData);
			} catch (Exception e) {
				System.out.println("Couldn't save distance data.");
			}

			return s;
		});


		get("/bmi/:weight/:feet/:inches", (req, res) -> {
			int weight = Integer.parseInt(req.params(":weight"));
			int feet = Integer.parseInt(req.params(":feet"));
			int inches = Integer.parseInt(req.params(":inches"));

			float bmiVal = calculateBmiVal(weight, feet, inches);
			String category = calculateBmiCat(bmiVal);

			String s = "You weigh " +
					req.params(":weight") +
					" pounds. Your height is " +
					req.params(":feet") +
					" feet " +
					req.params(":inches") +
					" inches. This means your BMI is " +
					bmiVal +
					" which puts you in the " +
					category + 
					" category";

			String saveData = "INSERT INTO bmiTable (weight_lbs, height_ft, height_in, bmi, category) VALUES (" + weight + ","+ feet + ","+ inches + ","+ bmiVal + ",'" + category + "')";
			//System.out.println(saveData);
			try {
				D.execute(saveData);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Couldn't save bmi data.");
			}

			return s;
		});

	}

	private static String calculateBmiCat(float bmival) 
	{
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
		return category;
	}

	private static float calculateBmiVal(int weight, int feet, int inches) 
	{
		float kgs = (float)(weight * 0.45);
		float totalin = (feet * 12) + inches;
		float meters = (float)(totalin * .025);
		float sqm = (meters * meters);
		float bmival = (kgs / sqm);
		return bmival;
	}

	private static float calculateDistance(int x1, int y1, int x2, int y2) 
	{
		float distance = (float) Math.sqrt((float) (Math.pow(x2-x1, 2)) + (float) (Math.pow(y2-y1, 2)));
		return distance;
	}

	public static String getDistanceTable()
	{
		String distance = "";
		ResultSet rs = null;
		try {
			rs = D.query("SELECT CONCAT(\n" + 
					"'[',\n" + 
					"GROUP_CONCAT(JSON_OBJECT (\"timestamp\", timestamp ,\"x1\", x1, \"y1\", y1, \"x2\", x2, \"y2\", y2, \"result\", result)),\n" + 
					"']'\n" + 
					")\n" + 
					"FROM distanceTable;");
			distance = D.stringify(rs);

		} catch (Exception e) {
			System.out.println("Couldn't query distance.");
		}
		return distance;
	}

	public static String getBMITable()
	{
		String bmi = "";
		ResultSet rs = null;
		try {
			rs = D.query("SELECT CONCAT(\n" + 
					"'[',\n" + 
					"GROUP_CONCAT(JSON_OBJECT (\"timestamp\", timestamp ,\"weight_lbs\", weight_lbs, \"height_ft\", height_ft, \"height_in\", height_in, \"bmi\", bmi, \"category\", category)),\n" + 
					"']'\n" + 
					")\n" + 
					"FROM bmiTable;");
			bmi = D.stringify(rs);

		} catch (Exception e) {
			System.out.println("Couldn't query bmi.");
		}
		return bmi;
	}

	public static void stopServer()
	{
		stop();
	}








}