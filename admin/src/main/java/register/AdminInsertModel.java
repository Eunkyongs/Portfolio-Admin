package register;
import java.sql.*;
import basesetting.DBConnect;

public class AdminInsertModel {
	String result=null;
	String list[] = null; 
	Connection ct = null;

	public AdminInsertModel(String[] list) {
		this.list = list;
	}
	public String insert() {
		try {
		DBConnect db = new DBConnect();
		this.ct = db.cafe24();
		String sql="insert into admin_account values('0',?,?,?,?,?,?,?,?,'N')";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setString(1, this.list[0]);
		ps.setString(2, this.list[1]);
		ps.setString(3, this.list[2]);
		ps.setString(4, this.list[3]);
		ps.setString(5, this.list[4]);
		ps.setString(6, this.list[5]);
		ps.setString(7, this.list[6]);
		ps.setString(8, this.list[7]);
		int n = 0;
		n = ps.executeUpdate();
		if(n>0) {
			this.result = "ok";
		}else {
			throw new Exception("error");
		}
		}catch(Exception e) {
			this.result = "no";
		}finally {
			try {
				this.ct.close();
			}catch(Exception e) {
				
			}
		}
		
		return result;
	}
}
