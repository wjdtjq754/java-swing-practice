import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {

	public static void main(String[] args) {
		createTable();
		
	}
	
	public static String[][] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender, age, note From customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {results.getString("name"),
						results.getString("phone"), results.getString("gender"),
						results.getString("age"), results.getString("note")});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createCustomer(String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+"INSERT INTO customer"
					+"(name, phone, gender, age, note) "
					+"VALUE "
					+"('"+ name +"','"+phone+"','"+gender+"','"+age+"','"+note+"')");	//('name','phone','gender','age','note')
			insert.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255),"
					+"phone varChar(255),"
					+"gender varChar(255),"
					+"age varChar(255),"
					+ "note varChar(255),"
					+ "PRIMARY KEY(id))");
			create.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table successfully created");
		}
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12394397";	//jdbc:mysql//Database host:port number/database name
			String user = "sql12394397";												//database User
			String pass = "yyXkzw5uA8";													//database password
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
