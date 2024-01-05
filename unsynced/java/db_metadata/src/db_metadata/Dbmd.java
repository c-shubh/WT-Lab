package db_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Dbmd {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db12b5", "root", "root");
			DatabaseMetaData m = con.getMetaData();

			p("Driver Name", m.getDriverName());
			p("Driver Version", m.getDriverVersion());
			p("UserName", m.getUserName());
			p("Database Product Name", m.getDatabaseProductName());
			p("Database Product Version", m.getDatabaseProductVersion());

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void p(String a, String b) {
		System.out.println(a + ": " + b);
	}
}
