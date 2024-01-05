package dml_prepared_callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DMLPreparedCallable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db12b5", "root", "root");

			// Prepared statement
			String insert = "insert into Students (sid, sname) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(insert);
			System.out.println("Enter details: id name");
			for (int i = 0; i < 3; i++) {
				ps.setInt(1, sc.nextInt());
				ps.setString(2, sc.next());
				ps.executeUpdate();
			}

			// Callable statement
			// In MySql workbench:
			//
			// > DELIMITER //
			// > CREATE PROCEDURE getDetails()
			// > BEGIN
			// > select sid, sname from Students;
			// > END //
			// > DELIMITER ;
			CallableStatement cs = conn.prepareCall("{call getDetails}");
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				System.out.printf("%d: %s\n", rs.getInt("sid"), rs.getString("sname"));
			}

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
