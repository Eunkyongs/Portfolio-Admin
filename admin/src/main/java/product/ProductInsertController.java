package product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import basesetting.Time;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 2, maxRequestSize = 1024 * 1024 * 2)
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductInsertController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String bcate = request.getParameter("bcate");
		String scate = request.getParameter("scate");
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String padd_ex = request.getParameter("padd_ex");
		String cost = request.getParameter("cost");
		String discount = request.getParameter("discount");
		String dis_cost = request.getParameter("dis_cost");
		String stock = request.getParameter("stock");
		String sell = request.getParameter("sell");
		String soldout = request.getParameter("soldout");
//		Part img1 = request.getPart("product_img1"); //사용자pc이미지경로
//		Part img2 = request.getPart("product_img2"); //사용자pc이미지경로
//		Part img3 = request.getPart("product_img3"); //사용자pc이미지경로
		String pdetail = request.getParameter("pdetail");

		/* 파일 업로드 */
		try {
			// 파일 업로드 (web경로)
			Collection<Part> p = request.getParts();
			String path = request.getServletContext().getRealPath("");
			// C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\portfolio\
			
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
			String time = sf.format(date);
			String pimg1 = null;
			String pimg2 = null;
			String pimg3 = null;

			for (Part part : p) {
//				System.out.println(part.getName()); //첨부파일 Name
				String names = part.getName();
				String fileName = time + part.getSubmittedFileName(); // 첨부파일명 가져오기
				String upload = path + "/admin/product/";
				String imgurl = null;
				if (fileName != null && !fileName.equals("")) { // null첨부파일 없애기
					// 폴더없으면 생성
					File folder = new File(path);
					if (!folder.exists()) {
						folder.mkdir();
					}
					imgurl = "./product/" + fileName;
					if(imgurl.indexOf("null")== -1) {
						part.write(upload + fileName);
					}
				} else {
					imgurl = "";
				}
				
				switch (names) {
				case "product_img1":
					pimg1 = imgurl;
					break;
				case "product_img2":
					pimg2 = imgurl;
					break;
				case "product_img3":
					pimg3 = imgurl;
					break;
				}
			}

			Time time1 = new Time();
			String indate = time1.now_datetime();

			ArrayList<String> product = new ArrayList<String>();
			product.add(bcate);
			product.add(scate);
			product.add(pcode);
			product.add(pname);
			product.add(padd_ex);
			product.add(cost);
			product.add(discount);
			product.add(dis_cost);
			product.add(stock);
			product.add(sell);
			product.add(soldout);
			product.add(pimg1);
			product.add(pimg2);
			product.add(pimg3);
			product.add(pdetail);
			product.add(indate);

			ProductInsertModel pi = new ProductInsertModel();
			pi.insert(product);

			String search_select=request.getParameter("search_select");
			String search_p= request.getParameter("search_p");
			
			String result = pi.result().intern();
			if (result == "ok") {
				pw.print("<script>alert('상품등록완료'); location.href='product?page=1&search_select="+search_select+"&search_p="+search_p+"';</script>");
			} else {
				pw.print("<script>alert('상품등록실패'); history.go(-1);</script>");
			}

		} catch (Exception e) {
			System.out.println(e);
			pw.print(e);
		}

	}

}
