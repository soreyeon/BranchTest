package com.spring.board.vo;

public class BoardVo {
	private int idx;
	private String title;
	private String cont;
	private String writer;
	private String regdate;
	private int readcount;
	
	private int bnum;
	private int lvl;
	private int step;
	private int nref;
	private int delnum;
	
	private String menu_id;
	private String menu_name;
	private String menu_seq;
	
	//페이징관련
	private int nowpage; //현재 페이지 정보
	private int prevnowpage; // 이전 10개클릭시 적용되는 페이지
	private int nextnowpage; // 다음 10개클릭시 적용되는 페이지
	
	private int totalcount; //조회된 전체 자료수 (if.256개)
	private int totalpagecount; //화면에 보여줄 전체 페이지 수(26페이지)
	
	private int pagestartnum; //페이지 시작번호
	private int pageendnum; //페이지 끝번호
	private int pagegrpnum; //페이지 그룹번호
	
	private int pagecount; //한페이지에 보여줄 자료라인 수(한페이지당 10개의 자료)
	
	private boolean isshowpageprev; // 이전페이지 표시 여부
	private boolean isshowpagenext; // 다음페이지 표시 여부
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getNref() {
		return nref;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public int getDelnum() {
		return delnum;
	}
	public void setDelnum(int delnum) {
		this.delnum = delnum;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_seq() {
		return menu_seq;
	}
	public void setMenu_seq(String menu_seq) {
		this.menu_seq = menu_seq;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPrevnowpage() {
		return prevnowpage;
	}
	public void setPrevnowpage(int prevnowpage) {
		this.prevnowpage = prevnowpage;
	}
	public int getNextnowpage() {
		return nextnowpage;
	}
	public void setNextnowpage(int nextnowpage) {
		this.nextnowpage = nextnowpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpagecount() {
		return totalpagecount;
	}
	public void setTotalpagecount(int totalpagecount) {
		this.totalpagecount = totalpagecount;
	}
	public int getPagestartnum() {
		return pagestartnum;
	}
	public void setPagestartnum(int pagestartnum) {
		this.pagestartnum = pagestartnum;
	}
	public int getPageendnum() {
		return pageendnum;
	}
	public void setPageendnum(int pageendnum) {
		this.pageendnum = pageendnum;
	}
	public int getPagegrpnum() {
		return pagegrpnum;
	}
	public void setPagegrpnum(int pagegrpnum) {
		this.pagegrpnum = pagegrpnum;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public boolean isIsshowpageprev() {
		return isshowpageprev;
	}
	public void setIsshowpageprev(boolean isshowpageprev) {
		this.isshowpageprev = isshowpageprev;
	}
	public boolean isIsshowpagenext() {
		return isshowpagenext;
	}
	public void setIsshowpagenext(boolean isshowpagenext) {
		this.isshowpagenext = isshowpagenext;
	}
	
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", title=" + title + ", cont=" + cont + ", writer=" + writer + ", regdate="
				+ regdate + ", readcount=" + readcount + ", bnum=" + bnum + ", lvl=" + lvl + ", step=" + step
				+ ", nref=" + nref + ", delnum=" + delnum + ", menu_id=" + menu_id + ", menu_name=" + menu_name
				+ ", menu_seq=" + menu_seq + ", nowpage=" + nowpage + ", prevnowpage=" + prevnowpage + ", nextnowpage="
				+ nextnowpage + ", totalcount=" + totalcount + ", totalpagecount=" + totalpagecount + ", pagestartnum="
				+ pagestartnum + ", pageendnum=" + pageendnum + ", pagegrpnum=" + pagegrpnum + ", pagecount="
				+ pagecount + ", isshowpageprev=" + isshowpageprev + ", isshowpagenext=" + isshowpagenext + "]";
	}
	
}
