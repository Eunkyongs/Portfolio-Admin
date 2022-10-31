package login;

import java.sql.*;

import basesetting.*;

public class LoginModel {
	Connection ct = null;
	private String id = null;
	private String pw = null;
	private String name = null;
	private String msg = null;
	private String recog = null;
	private String info[];
	
	public String[] getter(String id, String pw) {
		this.id = id;
		this.pw = pw;
		try {
			DBConnect db = new DBConnect();
			this.ct = db.cafe24();
			
			String sql = "select Id,Pw,Name,recog from admin_account where Id=? and Pw=?";
			PreparedStatement ps = this.ct.prepareStatement(sql);
			
			ps.setString(1, this.id);
			ps.setString(2, this.pw);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				this.msg = "no";
				this.info= new String[] {this.msg};
			}else {
				this.msg = "ok";
				this.name=rs.getString("Name");
				this.recog=rs.getString("recog");
				this.info= new String[]{this.msg,this.id,this.name,this.recog};
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
			this.ct.close();
			}catch(Exception e) {
				 
			}
		}
		return this.info;
	}
}
