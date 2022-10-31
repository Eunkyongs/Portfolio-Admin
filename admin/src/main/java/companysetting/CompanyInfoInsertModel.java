package companysetting;
import java.sql.*;
import java.util.*;

import basesetting.DBConnect;
public class CompanyInfoInsertModel {
	String []set_join;
	String []set_info;
	String []set_pay;
	String [] result=null;
	String msg;
	String msg2;
	String msg3;
	Connection con = null;
	
	public void set_join_in(String[] a) {
		this.set_join = a;
		try {
			DBConnect dbcon = new DBConnect();
			this.con=dbcon.cafe24();
			String sql_setjoin = "insert into set_join values('0',?,?,?,?,?,?)";
			PreparedStatement ps_setjoin = con.prepareStatement(sql_setjoin);
			ps_setjoin.setString(1, this.set_join[0]);
			ps_setjoin.setString(2, this.set_join[1]);
			ps_setjoin.setString(3, this.set_join[2]);
			ps_setjoin.setString(4, this.set_join[3]);
			ps_setjoin.setString(5, this.set_join[4]);
			ps_setjoin.setString(6, this.set_join[5]);
			int n1=0;
			n1 = ps_setjoin.executeUpdate();
			if(n1>0) {
				this.msg="ok";
			}else {
				throw new Exception("error");
			}
		}catch(Exception e) {
			this.msg="no";
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public void set_info_in(String[] a) {
		this.set_info = a;
		try {
			DBConnect dbcon = new DBConnect();
			this.con=dbcon.cafe24();
			String sql_setinfo = "insert into set_info values('0',?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps_setinfo = con.prepareStatement(sql_setinfo);
			ps_setinfo.setString(1, this.set_info[0]);
			ps_setinfo.setString(2, this.set_info[1]);
			ps_setinfo.setString(3, this.set_info[2]);
			ps_setinfo.setString(4, this.set_info[3]);
			ps_setinfo.setString(5, this.set_info[4]);
			ps_setinfo.setString(6, this.set_info[5]);
			ps_setinfo.setString(7, this.set_info[6]);
			ps_setinfo.setString(8, this.set_info[7]);
			ps_setinfo.setString(9, this.set_info[8]);
			ps_setinfo.setString(10, this.set_info[9]);
			ps_setinfo.setString(11, this.set_info[10]);			
			int n1=0;
			n1 = ps_setinfo.executeUpdate();
			if(n1>0) {
				this.msg2="ok";
			}else {
				throw new Exception("error");
			}
		}catch(Exception e) {
			this.msg2="no";
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public void set_pay_in(String[] a) {
		this.set_pay = a;
		try {
			DBConnect dbcon = new DBConnect();
			this.con=dbcon.cafe24();
			String sql_setpay = "insert into set_pay values('0',?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps_setpay = con.prepareStatement(sql_setpay);
			ps_setpay.setString(1, this.set_pay[0]);
			ps_setpay.setString(2, this.set_pay[1]);
			ps_setpay.setString(3, this.set_pay[2]);
			ps_setpay.setString(4, this.set_pay[3]);
			ps_setpay.setString(5, this.set_pay[4]);
			ps_setpay.setString(6, this.set_pay[5]);
			ps_setpay.setString(7, this.set_pay[6]);
			ps_setpay.setString(8, this.set_pay[7]);
			ps_setpay.setString(9, this.set_pay[8]);
			ps_setpay.setString(10, this.set_pay[9]);
			ps_setpay.setString(11, this.set_pay[10]);
			ps_setpay.setString(12, this.set_pay[11]);
			
			int n1=0;
			n1 = ps_setpay.executeUpdate();
			if(n1>0) {
				this.msg3="ok";
			}else {
				throw new Exception("error");
			}
		}catch(Exception e) {
			this.msg3="no";
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	public String[] re() {
		this.result = new String[3];
		this.result[0] = msg;
		this.result[1] = msg2;
		this.result[2] = msg3;
		return this.result;
	}
}
