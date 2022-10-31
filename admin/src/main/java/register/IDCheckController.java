package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basesetting.DBConnect;

public class IDCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IDCheckController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("admin_id").intern();
		String msg=null;
		Connection ct = null;
		try {
			DBConnect db = new DBConnect();
			ct = db.cafe24();

			String sql = "select * from admin_account where Id='"+id+"'";
			PreparedStatement ps = ct.prepareStatement(sql);
			
			int n = 0;
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == true) {
				msg = "no";
			}
			else {
				msg = "ok";
			}
			pw.print(msg);
			
		}catch(Exception e) {
			pw.print("DB오류");
			System.out.println(e);
		}finally {
			try {
				ct.close();
			}catch(Exception e) {
				
			}
		}
		
	}

}
