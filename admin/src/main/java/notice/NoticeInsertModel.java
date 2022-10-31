package notice;

import java.sql.*;
import java.util.ArrayList;

import basesetting.DBConnect;


public class NoticeInsertModel {
	ArrayList<String> list = null;
	String msg = null;
	public void notice_in(ArrayList<String> data) {
		this.list = data;
		
		DBConnect db = new DBConnect();
		Connection con = null;
		int n = 0;
		try {
			con= db.cafe24();
			
			String sql = "insert into notice values('0',?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, list.get(0)); // top
			ps.setString(2, list.get(1)); // title
			ps.setString(3, list.get(2)); //writer
			ps.setString(4, list.get(3)); //file
			ps.setString(5, list.get(4)); // contents
			ps.setString(6, "0"); //view
			ps.setString(7, list.get(5)); // indate
			ps.setString(8, list.get(5)); // moddate
			
			n=ps.executeUpdate();
			if(n>0) {
				this.msg = "ok";
			}else {
				throw new Exception("error");
			}
		}catch(Exception e) {
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
	
	public String remsg() {
		return this.msg;
	}

}
