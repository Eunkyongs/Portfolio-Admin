package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import basesetting.DBConnect;

public class NoticeSelectModel {
	String no = null;
	String title = null;
	String writer = null;
	String date = null;
	String views = null;
	String top = null;
	String img = null;
	String content = null;
	
	int tot=0;
	int pageview = 0; 

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	public ArrayList<NoticeSelectModel> noticelist(String pgno) {
		
		int pageview = 10;// 한페이지당 보여지는 데이터 개수
		setPageview(pageview);
		int startpage = 0; //시작 페이지 값
		double pagenumber = 1; //페이징 개수
		String pno = pgno;
		String ct = "select count(*) as ct from notice"; // 데이터의 총 개수 확인
		int total = 0;
		PreparedStatement psct = null;
		PreparedStatement ps = null;
		
		ArrayList<NoticeSelectModel> list = new ArrayList<>();
		Connection con = null;
		try {
			DBConnect db = new DBConnect();
			con = db.cafe24();
			
			psct=con.prepareStatement(ct);
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
			
//			String sql = "select @rownum := @rownum+1 as rownum, notice.* from notice, (select @rownum := 0)=n order by rownum desc limit "+startpage+","+pageview;
			String sql= "select * from notice order by top, no desc limit "+startpage+","+pageview;
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				NoticeSelectModel ns = new NoticeSelectModel();
				ns.setNo(rs.getString("no"));
				ns.setTop(rs.getString("top"));
				ns.setTitle(rs.getString("title"));
				ns.setWriter(rs.getString("writer"));
				ns.setDate(rs.getString("indate"));
				ns.setViews(rs.getString("views"));
				ns.setContent(rs.getString("contents"));
				ns.setImg(rs.getString("file"));
				list.add(ns);
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
	public NoticeSelectModel getter() {
		NoticeSelectModel ns1 = new NoticeSelectModel();
		return ns1;
	}
}

