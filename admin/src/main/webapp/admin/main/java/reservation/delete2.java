package reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public delete2() {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html; charset=utf-8");
    	PrintWriter pw =resp.getWriter();

    	int n =0;
    	dbconfig dbc = null;
    	Connection c = null;
    	String email ="hong@gmail.com";
    	String idx = "9";
    	try {
    		dbc = new dbconfig();
    		c = dbc.getConnection();
    		String sql = "delete from reservation where ridx=?";
    		PreparedStatement ps = c.prepareStatement(sql);
    		ps.setString(1, idx);
    		
    		ps.executeUpdate();
    		pw.write("정상적으로 예약이 취소 되었습니다.");
    		
    	}catch(Exception e) {
    		
    	}
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
