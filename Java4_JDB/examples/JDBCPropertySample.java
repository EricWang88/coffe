import java.sql.*;
import java.util.Properties;
import java.io.*;

public class JDBCPropertySample {
	public static void main(String args[]) {
	final String FILENAME = "jdbc.drivers.properties";
		try {
			Properties prop = new Properties();
			// プロパティファイルからデータを読み込む
			prop.load(new FileInputStream(FILENAME));
			String driver = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String user = prop.getProperty("jdbc.user");
			String password = prop.getProperty("jdbc.password");

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();

				ResultSet rset = stmt.executeQuery("SELECT * from emp");

			while( rset.next() ) {
				System.out.print( rset.getString("empno") + " ");
				System.out.println( rset.getString("ename") );
			}
				conn.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
