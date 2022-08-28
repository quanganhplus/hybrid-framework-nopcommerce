package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		// Lấy ra đối tượng Connection kết nối vào database.
		Connection conn = MySQLTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM wp_users";

		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);

		// Duyệt trên kết quả trả về
		while (rs.next()) {
			// Di chuyển con trỏ xuống bản ghi kế tiếp.
			int userId = rs.getInt(1);
			String userLogin = rs.getString(2);
			String userEmail = rs.getString("user_email");

			System.out.println("--------------------");
			System.out.println("User Id:" + userId);
			System.out.println("User Login:" + userLogin);
			System.out.println("User Email:" + userEmail);
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}
}
