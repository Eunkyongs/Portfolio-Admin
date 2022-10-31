package adminlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import basesetting.*;


public class AdminListModel {
	
	private String No;
	private String Id;
	private String Pw;
	private String Name;
	private String Email;
	private String Tel;
	private String Department;
	private String Position;
	private String RegisterDate;
	
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getRegisterDate() {
		return RegisterDate;
	}
	public void setRegisterDate(String registerDate) {
		RegisterDate = registerDate;
	}
	public ArrayList<AdminListModel> adminlist() {
		ArrayList<AdminListModel> list=new ArrayList<>();
		Connection ct =null;
		try {
			DBConnect db = new DBConnect();
			 ct = db.cafe24();
			String sql = "select * from admin_account order by RegisterDate desc ";
			PreparedStatement ps = ct.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AdminListModel ld = new AdminListModel();
				ld.setNo(rs.getString("No"));
				ld.setId(rs.getString("Id"));
				ld.setPw(rs.getString("Pw"));
				ld.setName(rs.getString("Name"));
				ld.setEmail(rs.getString("Email"));
				ld.setTel(rs.getString("Tel"));
				ld.setDepartment(rs.getString("Department"));
				ld.setPosition(rs.getString("Position"));
				ld.setRegisterDate(rs.getString("RegisterDate"));
				list.add(ld);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				ct.close();
			}catch(Exception e) {
				
			}
		}
		
		return list;
	}
	
}
