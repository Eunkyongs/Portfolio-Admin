package product;

import java.sql.*;
import java.util.ArrayList;

import basesetting.DBConnect;

public class ProductInsertModel {

	ArrayList<String> plist = null;
	String msg = null;
	public void insert(ArrayList<String> a) {
		this.plist = a;
		DBConnect db= new DBConnect();
		Connection con = null;
		int n = 0;
		try {
			con=db.cafe24();
			
			String sql = "insert into product values('0',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, this.plist.get(0));
			ps.setString(2, this.plist.get(1));
			ps.setString(3, this.plist.get(2));
			ps.setString(4, this.plist.get(3));
			ps.setString(5, this.plist.get(4));
			ps.setString(6, this.plist.get(5));
			ps.setString(7, this.plist.get(6));
			ps.setString(8, this.plist.get(7));
			ps.setString(9, this.plist.get(8));
			ps.setString(10, this.plist.get(9));
			ps.setString(11, this.plist.get(10));
			ps.setString(12, this.plist.get(11));
			ps.setString(13, this.plist.get(12));
			ps.setString(14, this.plist.get(13));
			ps.setString(15, this.plist.get(14));
			ps.setString(16, this.plist.get(15));
			n=ps.executeUpdate();
			if(n>0) {
				this.msg = "ok";
			}else {
				throw new Exception("error");
			}
			
		}catch(Exception e) {
			this.msg="no";
			System.out.println(e);
		}finally {
			try {
				if(n>0) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
	}
	
	public String result() {
		return this.msg;
	}
}
