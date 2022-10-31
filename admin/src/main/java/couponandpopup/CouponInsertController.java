package couponandpopup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import basesetting.Time;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 2, maxRequestSize = 1024 * 1024 * 2)
public class CouponInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CouponInsertController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();

		String couponname = request.getParameter("couponname");
		String couponcate = request.getParameter("couponcate");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String coupontype = request.getParameter("coupontype");
		String discount = request.getParameter("discount");
		String mincost = request.getParameter("mincost");

		try {
			Part file = request.getPart("couponimg"); // 사용자pc이미지경로
			String path = request.getServletContext().getRealPath(""); // 상대경로
			File fe = new File(path);
			// 경로에 디렉토리가 없을 경우 새로 디렉토리 생성되게 하는 부분
			if (!fe.exists()) {
				fe.mkdir();
			}
			String fn = file.getSubmittedFileName().intern(); // 파일명 가져오기
			InputStream is = file.getInputStream();
			String upload = path + "/admin/coupon/" +fn;//업로드
			
			String url = null;
			if (fn != null && !fn.equals("")) { // null첨부파일 없애기
				url = "./coupon/" + fn;
				FileOutputStream fo =new FileOutputStream(upload);
				
				byte[] bf = new byte[1024*2];
				int size =0;
				while((size=is.read(bf)) != -1) {
					fo.write(bf,0,size);
					fo.flush();
					
				}
				fo.close();
			} else {
				url = "";
			}
			is.close();
			
			String[] data = { couponname, couponcate, startdate, enddate, coupontype, discount, mincost, url };

			CouponInsertModel ci = new CouponInsertModel();
			ci.coupon_in(data);

			String result = ci.result().intern();

			if (result == "ok") {
				pw.print("<script>alert('쿠폰등록완료'); location.href='shopconfig?page=1';</script>");
			} else {
				pw.print("<script>alert('쿠폰등록실패'); history.go(-1);</script>");
			}
		} catch (Exception e) {

		}
	}

}
