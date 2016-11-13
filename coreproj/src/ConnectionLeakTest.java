import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionLeakTest {
	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//First is creating a simple unclosed connection query using java
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ampweb_qa", "ampweb_qa");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM node"); 

		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}

		// make program executes forever
		while(true) {
			Thread.sleep(10000);
			System.out.println("This is making program to run with out stopping. Once execution comes out of main " +
								"block program, resource's will close automatically");
		}
	}
}