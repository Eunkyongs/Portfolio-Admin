package basesetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
		
		public Connection cafe24() throws ClassNotFoundException, SQLException {
			String dbdriver="com.mysql.jdbc.Driver";
//			String dburl="jdbc:mysql://umj7-016.cafe24.com/p23456";
			String dburl="jdbc:mysql://localhost:3306/p23456";
			String dbuser="p23456";
			String dbpass="";
			
			Class.forName(dbdriver);
			Connection ct = DriverManager.getConnection(dburl,dbuser,dbpass);
			return ct;
		}

	}
