package admininfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import basesetting.*;

public class AdminInfoUpdateModel {
	String pw=null;
	String name=null;
	String email=null;
	String tel = null;
	String Department = null;
	String position = null;
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String info_update(String[] a) {
		String msg = null;
		Connection con = null;
		try {
			DBConnect db = new DBConnect();
			con = db.cafe24();
			String sql = "update admin_account set Pw=?, Name=?, Email=?, Tel=?, Department=?, Position=? where Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a[1] );
			ps.setString(2, a[2]);
			ps.setString(3, a[3]);
			ps.setString(4, a[4]);
			ps.setString(5, a[5]);
			ps.setString(6, a[6]);
			ps.setString(7, a[0]);
			
			int n = 0;
			n=ps.executeUpdate();
			
			if(n>0) {
				msg = "ok";
			}else {
				msg = "no";
			}

		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				
			}
		}
		return msg;
	}
	
	
}
