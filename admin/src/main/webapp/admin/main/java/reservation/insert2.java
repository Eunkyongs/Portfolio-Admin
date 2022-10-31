package reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insert2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public insert2() {
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html; charset=utf-8");
    	PrintWriter pw =resp.getWriter();
    	Connection con2 = null;
		int n =0;
    	try {
    		dbconfig dbc=new dbconfig(); //dbconfig.java 호출
    		con2=dbc.getConnection(); //dbconfig class 안에 있는 getConnection () 메소드를 가져옴
    		
    		String sql = "insert into reservation(ridx,rnm,rpw,rno,remail,rtel,rperson,rindate) values('0',?,?,?,?,?,?,?)";
    		
    		PreparedStatement ps = con2.prepareStatement(sql);
    		ps.setString(1, "루피");
    		ps.setString(2, "qwer1234");
    		ps.setString(3, "167823");
    		ps.setString(4, "hong@naver.com");
    		ps.setString(5, "01091233432");
    		ps.setString(6, "7");
    		ps.setString(7, "2022-08-24 13:12:00");
    		

    		n = ps.executeUpdate();
    		if(n>0){
    			pw.write("정상적으로 예약이 완료 되었습니다.");
    		}else{
    			pw.write("올바른 값이 아닙니다."); 
    		}
    		
    		//pw.write(con.toString()); //db연결확인
    		
    	}catch(Exception e) {
    		
    	}finally {
    		try {
   			//int n =0; 이 try 밖에 위치할때 이런식으로 Connection 종료
    		if(n>0) {
    			con2.close();
    		}
   			
    		}catch(Exception e) {
    			
    		}
    	}
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
