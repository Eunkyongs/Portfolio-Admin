package category;

import java.sql.*;
import java.util.ArrayList;

import basesetting.DBConnect;

public class CateInsertModel {
	ArrayList<String> list = null;
	String msg = null;

	public void insert(ArrayList<String> data) {
		this.list = data;
		DBConnect db = new DBConnect();
		Connection con = null;
		int n = 0;
		try {
			con=db.cafe24();
			String sql = "insert into category values('0',?,?,?,?,?,?,?)";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, this.list.get(0));
			pr.setString(2, this.list.get(1));
			pr.setString(3, this.list.get(2));
			pr.setString(4, this.list.get(3));
			pr.setString(5, this.list.get(4));
			pr.setString(6, this.list.get(5));
			pr.setString(7, this.list.get(6));
			n = pr.executeUpdate();
			if (n > 0) {
				this.msg = "ok";
			} else {
				throw new Exception("error");
			}
		}catch (Exception e) {
			this.msg = "no";
			System.out.println(e.getMessage());
		}finally {
			try {
				if(n>0) {
					con.close();
				}
			}catch(Exception e) {
				
			}
		}
	}

	public String result() {
		return this.msg;
	}
}