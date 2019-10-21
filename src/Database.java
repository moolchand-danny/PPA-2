import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class Database {

		public static final String JDBC_DRIVER = "org.mysql.jdbc.Driver";
		public static final String LOCAL_HOST = "jdbc:mariadb://172.17.0.2";
		public static final String port = "3306";

		public static final String USERNAME = "root";
		public static final String PASSWORD = "1234"; 

		public static Connection conn = null;
		public static ResultSet rs;
		public static Statement statement;


		public static void create (String name) throws Exception {

			/**
			 * Creates a new database if it does not exist already.
			 */

			String command = "CREATE DATABASE IF NOT EXISTS " + name;
			statement = connectLocalHost();
			statement.executeUpdate(command);

			if(statement != null) {
				statement.close();
			}
		}

		public static void connect (String db, String USERNAME, String PASSWORD) throws Exception {

			/**
			 * Connects to the database specified
			 */

			final String DB_URL = LOCAL_HOST + ":" + port +"/" + db;

			//System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			//System.out.println("Connected to database successfully!");
		}

		public static Statement connectLocalHost () throws Exception {

			/**
			 * Method used for the Database.create() function
			 */

			System.out.println("Connecting to the Local Host");

			//opens a connection to the localhost database
			conn = DriverManager.getConnection(LOCAL_HOST, USERNAME, PASSWORD);
			System.out.println("Connected to Local Host successfully!");

			return conn.createStatement();
		}

		public static ResultSet query(String sql) throws Exception {

			/**
			 * Performs an SQL query. Must be connected to a database for function to work.
			 */

			statement = conn.createStatement();
			rs = statement.executeQuery( sql );

			//printRS(rs);

			statement.executeUpdate(sql);

			return rs;
		}

		public static void execute(String sql) throws Exception {

			/**
			 * Executes an SQL statement. Must be connected to a database for function to work.
			 */

			statement = conn.createStatement();
			statement.executeUpdate(sql);
		}

		public static void printRS(ResultSet rs) throws Exception {

			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();
			System.out.println("");

			String columnName[] = new String[numColumns];

			for (int i = 1; i <= numColumns; i++) 
			{
				columnName[i-1] = rsmd.getColumnLabel(i);
				//					if(i-1 == 0)
				//						System.out.print("\t");
				System.out.print(columnName[i-1]);
				System.out.print(" / ");
			}
			System.out.println("");

			while (rs.next()) {		
				for (int i = 1; i <= numColumns; i++) {

					if(i == numColumns) {
						System.out.print(rs.getString(i));	
					}
					else System.out.print(rs.getString(i) + " / ");
				}
				System.out.println("");
			}
			System.out.println("");
		}

		public static String stringify(ResultSet rs) throws Exception {
			String result = "";
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			result += "\n";

			while (rs.next()) {		
				for (int i = 1; i <= numColumns; i++) {

					if(i == numColumns) {
						result += rs.getString(i);
					}
					else result += rs.getString(i) + "";
				}
				result += "\n";
			}
			result += "\n";

			return result;
		}

		public static boolean isNull (ResultSet rs) throws Exception {

			boolean result = false;

			if (!rs.next() ) {
				result = true;
			} 

			return result;
		}

		public static void printMenu(ResultSet rs) throws Exception {

			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();
			System.out.println("");

			while (rs.next()) {
				for (int i = 1; i <= numColumns; i++) {

					if(i == numColumns) {
						System.out.print(rs.getString(i));	
					}
					else { 
						System.out.print("["+i+"]\t");
						System.out.print(rs.getString(i) + ", ");
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}

		public static void disconnect () throws Exception {

			/**
			 * Disconnects from database
			 */

			if ( conn != null ) {
				conn.close();
				System.out.println("Goodbye.");
			} else {
				System.out.println("Error in closing database connection.");
			}

		}

	}//END OF DATABASE CLASS
