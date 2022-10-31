package reservation;

import java.sql.*;

public class dbconfig {
	Connection con = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String db = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://kbsn.or.kr:3306/aclass";
		String user = "java_a";
		String pw = "java_aclass";

		Class.forName(db);
		con = DriverManager.getConnection(url, user, pw);
		return con;
	}
}
