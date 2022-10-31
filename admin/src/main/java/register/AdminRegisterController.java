package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basesetting.Time;

public class AdminRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminRegisterController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		String id=request.getParameter("admin_id");
		String pw=request.getParameter("admin_pw1");
		String name=request.getParameter("admin_name");
		String email=request.getParameter("admin_email");
		String tel1=request.getParameter("admin_tel1");
		String tel2=request.getParameter("admin_tel2");
		String tel3=request.getParameter("admin_tel3");
		String part=request.getParameter("admin_part");
		String duty=request.getParameter("admin_duty");
		String tel = tel1+tel2+tel3;
		Time time = new Time();
		String indate = time.now_datetime(); 
		String admin_account[]= {id,pw,name,email,tel,part,duty,indate};
		AdminInsertModel insert = new AdminInsertModel(admin_account);
		
		try {
			String result=insert.insert().intern();
			if(result == "ok" ) {
				pr.print("<script>alert('관리자 등록이 완료되었습니다.'); location.href='./index.html';</script>");
			}
			else {
				throw new Exception("error");
			}
		}catch(Exception e){
			pr.print("<script>alert('관리자 등록에 실패했습니다.'); history.go(-1);</script>");
		}
		
	}

}
