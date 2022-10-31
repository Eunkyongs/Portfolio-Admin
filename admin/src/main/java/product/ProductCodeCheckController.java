package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basesetting.DBConnect;

public class ProductCodeCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductCodeCheckController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
//		response.setContentType("text/html; charset=utf-8;");
		PrintWriter pr = response.getWriter();
		String code = request.getParameter("code");
		
		String row = null;
		String result=null; //ajax로 보내는 변수값
		Connection con =null;
		try {
			DBConnect db = new DBConnect();
			con = db.cafe24();
			
			String ck_sql = "select count(*) as ctn from product where p_code=?";
			PreparedStatement ps = con.prepareStatement(ck_sql);
			ps.setString(1,code);
			
			ResultSet rs = ps.executeQuery();
			
//			if(rs.next()==true) {
//				result="no";
//			}else {
//				result="ok";
//			}
			
			while(rs.next()) {
				row = rs.getString("ctn").intern();
			}
			if(row !="0") {
				result="no";
			}else {
				result="yes";
			}
			pr.print(result);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			pr.print(e);
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
