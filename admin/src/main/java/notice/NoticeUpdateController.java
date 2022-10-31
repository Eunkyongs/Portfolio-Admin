package notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import basesetting.Time;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 2, maxRequestSize = 1024 * 1024 * 2)
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeUpdateController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();

		String idx = request.getParameter("no_idx");
		String top = request.getParameter("notice_ck");
		String title = request.getParameter("notice_title");
		String writer = request.getParameter("notice_writer");
		String contents = request.getParameter("notice_contents");
		
		if (top == null) {
			top = "N";
		}

		Time time = new Time();
		String moddate = time.now_datetime();

		//파일 업로드
		try {
			Part part = request.getPart("file");
			String fn = part.getSubmittedFileName();// 첨부파일명 가져오기

			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
			String time2 = sf.format(date);

			String fileName = time2 + fn;// 가져온 첨부파일명에 날짜 붙이기

			String path = request.getServletContext().getRealPath(""); // 상대경로
			// C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\portfolio\
			InputStream is = part.getInputStream();
			String upload = path + "/admin/notice/" + fileName;// 업로드

			String url = null;
			if (fn != null && !fn.equals("")) { // null첨부파일 없애기
				url = "./notice/" + fileName;
				FileOutputStream fo = new FileOutputStream(upload);

				// 폴더없으면 생성
				File folder = new File(path);
				if (!folder.exists()) {
					folder.mkdir();
				}

				byte[] bf = new byte[1024 * 2];
				int size = 0;
				while ((size = is.read(bf)) != -1) {
					fo.write(bf, 0, size);
					fo.flush();

				}
				fo.close();
			} else {
				url = "";
			}
			is.close();

			ArrayList<String> data = new ArrayList<String>();
			data.add(0, top);
			data.add(1, title);
			data.add(2, url);
			data.add(3, contents);
			data.add(4, moddate);

			NoticeUpdateModel up = new NoticeUpdateModel();
			up.notice_up(data,idx);

			String result = up.remsg().intern();

			if (result == "ok") {
				pw.print("<script>alert('수정완료'); location.href='admin_notice_view.jsp?no="+idx+"';</script>");
			} else {
				pw.print("<script>alert('수정실패'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
