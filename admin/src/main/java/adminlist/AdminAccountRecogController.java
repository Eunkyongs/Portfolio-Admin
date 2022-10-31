package adminlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import basesetting.DBConnect;

public class AdminAccountRecogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminAccountRecogController() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		String recog=request.getParameter("recog");//승인여부
		String no = request.getParameter("no");//idx
		
		String result = null;
		Connection con = null;
		int n =0;
		try {
			DBConnect db = new DBConnect();
			con=db.cafe24();
			
			String sql = "UPDATE admin_account set recog=? where No=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, recog);
			ps.setString(2, no);
			
			n=ps.executeUpdate();
			if(n>0) {
				result="ok";
			}else {
				result ="no";
			}
			pr.print(result);
			
		}catch(Exception e) {
			pr.print(e);
		}finally {
			try {
				if(n>0) {
					con.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
