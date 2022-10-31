package category;
import java.sql.Connection;
import java.sql.PreparedStatement;

import basesetting.DBConnect;

public class CateDeleteModel {
	String msg=null;
	String []idx = null;
	public void del(String[] no) {
		this.idx = no;
		DBConnect db = new DBConnect();
		Connection con = null;
		int n = 0;
		
		try {
			con=db.cafe24();

			for (int f = 0; f < this.idx.length; f++) {
				String sql = "delete from category where no=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, this.idx[f]);
				n = ps.executeUpdate();
				if (n > 0) {
					this.msg="ok";
				} else {
					throw new Exception("error");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
				this.msg = "no";
		}finally {
			try{
				if(n>0) {
					con.close();
				}
			}catch(Exception e) {
		
			}
		}
		
	}
	public String result_del() {
		return this.msg;
	}
}
