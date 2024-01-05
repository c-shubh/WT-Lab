package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	public static final String CONN_URL = "jdbc:mysql://localhost/db12b5", UNAME = "root", PASS = "root";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(CONN_URL, UNAME, PASS);
			Statement stmt = conn.createStatement();
			String insert = "insert into Students (sid, sname) values (100, 'Jack')";
			String update = "update Students set sname='Jackie' where sid=100";
			String delete = "delete from Students where sid=100";
			String raf = "%s:\n%d rows affected.\n";

			System.out.printf(raf, "Insert", stmt.executeUpdate(insert));
			runSelect(stmt);
			System.out.printf(raf, "Update", stmt.executeUpdate(update));
			runSelect(stmt);
			System.out.printf(raf, "Delete", stmt.executeUpdate(delete));
			runSelect(stmt);

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void runSelect(Statement stmt) throws SQLException {
		String select = "select sid, sname from Students";
		ResultSet rs = stmt.executeQuery(select);
		while (rs.next()) {
			System.out.printf("%d: %s\n", rs.getInt("sid"), rs.getString("sname"));
		}
	}
}
