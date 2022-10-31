package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeDeleteController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	String ck[];

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
	
		String ck[] = request.getParameterValues("cknotice"); // 체크된 체크박스의 no값
		String no[] = request.getParameterValues("no_idx");
		
		NoticeDeleteModel del= new NoticeDeleteModel();
		
		if(ck != null) {
			del.del(ck);
		}else {
			del.del(no);
		}
		
		String result=del.result_m().intern();
		
		if(result=="ok") {
			pw.print("<script>alert('삭제완료'); location.href='notice?page=1';</script>");
		}else {
			pw.print("<script>alert('삭제할 공지내용을 체크해 주세요.'); history.go(-1);</script>");
		}
	}

}
