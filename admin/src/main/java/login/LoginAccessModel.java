package login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import basesetting.DBConnect;
import basesetting.Time;

public class LoginAccessModel {
	Connection ct = null;
	String result=null;
	public void aa(String id) {
		try {
		DBConnect db= new DBConnect();
		this.ct = db.cafe24();
		Time time = new Time();
		String indate = time.now_datetime();
		
		String sql = "insert into admin_access values('0',?,?)";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, indate);
		int n = 0;
		n=ps.executeUpdate();
		if (n > 0) {
			this.result="ok";
		} else {
			throw new Exception("error");
		}
		}catch(Exception e) {
			this.result="no";
		}finally {
			try {
				this.ct.close();
			}catch(Exception e) {
				
			}
		}
		
	}
	public String getter() {
		return this.result;
	}
}
