package product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import basesetting.DBConnect;

public class ProductDeleteModel {
	String []idx = null;
	String result=null;
	
	public void del(String[] no) {
		this.idx = no;
		
		DBConnect db = new DBConnect();
		Connection con = null;
		int n = 0;
		
		try {
			con=db.cafe24();

			for (int f = 0; f < this.idx.length; f++) {
				String sql = "delete from product where pidx=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, this.idx[f]);
				n = ps.executeUpdate();
				if (n > 0) {
					result="ok";
				} else {
					throw new Exception("error");
				}
			}
		} catch (Exception e) {
				result = "no";
				System.out.println(e);
		}finally {
			try{
				if(n>0) {
					con.close();
				}
			}catch(Exception e) {
		
			}
		}
	}
	
	public String result_m() {
		return this.result;
	}
	
}
