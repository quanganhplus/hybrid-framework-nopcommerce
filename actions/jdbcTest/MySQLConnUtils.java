package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "quanganhblog";
		String userName = "root";
		String password = "";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// Khai báo class Driver cho MySQL
			// Việc này cần thiết với Java 5
			// Java 6 tự động tìm kiếm Driver thích hợp - ko bắt buộc cần dòng này
			Class.forName("com.mysql.jdbc.Driver");

			// Cấu trúc URL Connection dành cho MySQL
			// Ví dụ: jdbc:mysql://localhost:3306/automationfc
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
