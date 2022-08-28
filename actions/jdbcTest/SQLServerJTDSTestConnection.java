package jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class SQLServerJTDSTestConnection {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerJTDSConnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		// Lấy ra đối tượng Connection kết nối vào database.
		Connection conn = SQLServerJTDSTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		// Statement statement = conn.createStatement();

		// String sql = "Select * FROM [automationfpt].[dbo].[BRANCH];";
		// String insertSql = "INSERT INTO [automationfpt].[dbo].[BRANCH] ([ADDRESS],[CITY],[NAME],[STATE],[ZIP_CODE]) VALUES ('17 Duy Tan', 'Ha Noi','FPT', 'HN', '68000')";
		String paramSql = "Select emp.Emp_Id, emp.First_Name, emp.Title, emp.Dept_Id from [automationfpt].[dbo].[EMPLOYEE] emp  where emp.Title like ? and emp.Dept_Id = ?";

		// int rowCount = statement.executeUpdate(insertSql);
		// System.out.println("Row Count affected = " + rowCount);

		// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		// ResultSet rs = statement.executeQuery(sql);

		PreparedStatement pstm = conn.prepareStatement(paramSql);

		// 1 với 2 ở đây là set vào vị trí nào ở câu leenhjj query ở trên where emp.Title like ? and emp.Dept_Id = ?
		pstm.setString(1, "%ent");
		pstm.setInt(2, 3);
		ResultSet rs = pstm.executeQuery();

		// Duyệt trên kết quả trả về
		while (rs.next()) {
			// Di chuyển con trỏ xuống bản ghi kế tiếp.
			System.out.println("--------------------");
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
		}
		// Đóng kết nối
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}

}
