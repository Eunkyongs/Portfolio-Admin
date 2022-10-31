package couponandpopup;

import java.sql.Connection;
import java.sql.PreparedStatement;

import basesetting.*;

public class CouponInsertModel {
	String []data = null;
	String msg = null;
	public void coupon_in(String a[]) {
		this.data = a;
		
		DBConnect db = new DBConnect();
		Connection con = null;
		int n = 0;
		try {
			con = db.cafe24();
			
			String sql = "insert into coupon values('0',?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, this.data[0]);
			ps.setString(2, this.data[1]);
			ps.setString(3, this.data[2]);
			ps.setString(4, this.data[3]);
			ps.setString(5, this.data[4]);
			ps.setString(6, this.data[5]);
			ps.setString(7, this.data[6]);
			ps.setString(8, this.data[7]);
			n=ps.executeUpdate();
			if(n>0) {
				this.msg = "ok";
			}else {
				throw new Exception("error");
			}
		}catch(Exception e) {
			this.msg = "no";
			System.out.println(e);
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
