package category;

import java.sql.*;
import java.util.ArrayList;

import basesetting.DBConnect;

public class CateSelectModel {
	String no = null;
	String code = null;
	String menucode_big = null;
	String menuname_big = null; 
	String menucode_small = null;
	String menuname_small = null;
	String usecate = null;
	int tot=0;
	int pageview = 0;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMenucode_big() {
		return menucode_big;
	}
	public void setMenucode_big(String menucode_big) {
		this.menucode_big = menucode_big;
	}
	public String getMenuname_big() {
		return menuname_big;
	}
	public void setMenuname_big(String menuname_big) {
		this.menuname_big = menuname_big;
	}
	public String getMenucode_small() {
		return menucode_small;
	}
	public void setMenucode_small(String menucode_small) {
		this.menucode_small = menucode_small;
	}
	public String getMenuname_small() {
		return menuname_small;
	}
	public void setMenuname_small(String menuname_small) {
		this.menuname_small = menuname_small;
	}
	public String getUsecate() {
		return usecate;
	}
	public void setUsecate(String usecate) {
		this.usecate = usecate;
	}
	
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	public ArrayList<CateSelectModel> catelist(String pgno, String search_select ,String search_cate){
		int pageview = 10; // 한페이지당 보여지는 데이터 개수
		setPageview(pageview);
		int startpage = 0; //시작 페이지 값
		double pagenumber = 1; //페이징 개수
		String pno = pgno;
		String ct = null ;
		int total = 0;
		PreparedStatement psct = null;
		PreparedStatement ps = null;
		ArrayList<CateSelectModel> list = new ArrayList<>();
		DBConnect db = new DBConnect();
		Connection con = null;
		try {
			con = db.cafe24();
			
			// 데이터의 총 개수 확인
			if(search_select.equals("cate_name")) {
				ct ="select count(*) as ct from category where b_name like '%"+search_cate+"%' or s_name like '%"+search_cate+"%'";
				psct = con.prepareStatement(ct);
			}else if(search_select.equals("cate_code")) {
				ct ="select count(*) as ct from category where catecode like CONCAT('%','"+search_cate+"','%') or b_code like CONCAT('%','"+search_cate+"','%') or s_code like CONCAT('%','"+search_cate+"','%')";
				psct = con.prepareStatement(ct);
			}else {
				ct = "select count(*) as ct from category";
				psct = con.prepareStatement(ct);
			}
			ResultSet rsct = psct.executeQuery();
			
			while(rsct.next()){
			total = rsct.getInt("ct");
			}
			
			setTot(total);
			
			if(pno==null || pno == ""){
				startpage = 0;
			}else{//페이지 2번부터 적용되는 사항
				startpage = (Integer.parseInt(pno)-1)*pageview;
			}
			
			//페이징 총 개수 파악
			if(total % pageview == 0){
				pagenumber=total/pageview;
			}else{
				pagenumber=(total/pageview)+1;
			}
			
			String sql = null;
			
			if(search_select.equals("cate_name")) {
				sql ="select * from category where b_name like '%"+search_cate+"%' or s_name like '%"+search_cate+"%' limit "+startpage+","+pageview;
				ps = con.prepareStatement(sql);
			}else if(search_select.equals("cate_code")) {
				sql ="select * from category where catecode like '%"+search_cate+"%' or b_code like '%"+search_cate+"%' or s_code like'%"+search_cate+"%' limit "+startpage+","+pageview;
				ps = con.prepareStatement(sql);
			}else {
				sql = "select * from category limit "+startpage+","+pageview;
				ps = con.prepareStatement(sql);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CateSelectModel cs = new CateSelectModel();
				cs.setNo(rs.getString("no"));
				cs.setCode(rs.getString("catecode"));
				cs.setMenucode_big(rs.getString("b_code"));
				cs.setMenuname_big(rs.getString("b_name"));
				cs.setMenucode_small(rs.getString("s_code"));
				cs.setMenuname_small(rs.getString("s_name"));
				cs.setUsecate(rs.getString("codeuse"));
				list.add(cs);
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				
			}
		}
		
		return list;
	}
}
