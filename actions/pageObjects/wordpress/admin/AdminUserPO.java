package pageObjects.wordpress.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePage {
	WebDriver driver;

	public AdminUserPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getUserNumberAtUI() {
		waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		String totalNumber = getElementText(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);

		// TOTAL_NUMBER_TEXT = 3 items
		// split chuỗi - sau đó lấy ra giá trị đầu tiên - cuối cùng đổi về kiểu int
		return Integer.parseInt(totalNumber.split(" ")[0]);

	}

	public int getUserNumberAtDB() {
		// Lấy ra đối tượng Connection kết nối vào database.
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement;
		List<Integer> totalUsers = new ArrayList<Integer>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM wp_users";

			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				totalUsers.add(rs.getInt(1));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Đóng kết nối
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("---------- Closed connection ----------");
		}

		return totalUsers.size();
	}

}
