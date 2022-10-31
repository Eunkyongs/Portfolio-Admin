package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import basesetting.DBConnect;

public class NoticeUpdateModel {
	ArrayList<String> list = null;
	String msg = null;
	public void notice_up(ArrayList<String> data, String idx) {
		this.list = data;
		
		DBConnect db = new DBConnect();
		Connection con = null;
		int n = 0;
		try {
			con= db.cafe24();
			
			String sql = "update notice set top=?, title=?, file=?, contents=?, moddate=? where no="+idx;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, list.get(0)); // top
			ps.setString(2, list.get(1)); // title
			ps.setString(3, list.get(2)); //file
			ps.setString(4, list.get(3)); // contents
			ps.setString(5, list.get(4)); // moddate
			
			n=ps.executeUpdate();
			if(n>0) {
				this.msg = "ok";
			}else {
				throw new Exception("error");
			}
		}catch(Exception e) {
			this.msg = "no";
			System.out.println(e.getMessage());
		}finally {
			try{
				if(n>0) {
					con.close();
				}
			}catch(Exception e) {
			}
		}
	}
	
	public String remsg() {
		return this.msg;
	}

	
}
