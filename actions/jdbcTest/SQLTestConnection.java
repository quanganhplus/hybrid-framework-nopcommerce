package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerConnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		// Lấy ra đối tượng Connection kết nối vào database.
		Connection conn = SQLTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM [automationfpt].[dbo].[Product_Type];";

		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);

		// Duyệt trên kết quả trả về
		while (rs.next()) {
			// Di chuyển con trỏ xuống bản ghi kế tiếp.
			String empFirstName = rs.getString(1);
			String empLastName = rs.getString("NAME");

			System.out.println("--------------------");
			System.out.println("Emp Firstname:" + empFirstName);
			System.out.println("Emp Lastname:" + empLastName);
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}

}
