package com.spring.pds.service.impl;

import com.spring.pds.vo.PdsVo;

public class BoardPaging {
	private int totalCount;
	private int nowPage;
	private int prevNowPage;
	private int nextNowPage;
	private int pageCount;
	
	private int pageTotalCount;
	private int pageGrpNum;
	
	private int startPageNum;
	private int endPageNum;
	
	private int totalRecordPageCount;
	
	private boolean isShowPagePrev = true;
	private boolean isShowPageNext = true;
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPrevNowPage() {
		return prevNowPage;
	}
	public void setPrevNowPage(int prevNowPage) {
		this.prevNowPage = prevNowPage;
	}
	public int getNextNowPage() {
		return nextNowPage;
	}
	public void setNextNowPage(int nextNowPage) {
		this.nextNowPage = nextNowPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getPageGrpNum() {
		return pageGrpNum;
	}
	public void setPageGrpNum(int pageGrpNum) {
		this.pageGrpNum = pageGrpNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getTotalRecordPageCount() {
		return totalRecordPageCount;
	}
	public void setTotalRecordPageCount(int totalRecordPageCount) {
		this.totalRecordPageCount = totalRecordPageCount;
	}
	public boolean isShowPagePrev() {
		return isShowPagePrev;
	}
	public void setShowPagePrev(boolean isShowPagePrev) {
		this.isShowPagePrev = isShowPagePrev;
	}
	public boolean isShowPageNext() {
		return isShowPageNext;
	}
	public void setShowPageNext(boolean isShowPageNext) {
		this.isShowPageNext = isShowPageNext;
	}
	
	
	public BoardPaging() {

	}
	public BoardPaging(int nowPage, int pageCount, int totalCount, int pageTotalCount, int pageGrpNum) {
		this.totalCount = totalCount;
		this.nowPage = nowPage;
		this.pageCount = pageCount;
		this.pageTotalCount = pageTotalCount;
		this.pageGrpNum = pageGrpNum;
	}
	
	
	//필요한 메소드 구현
	//paging.jspf --> pagePdsVo
	
	public PdsVo getPdsPagingInfo() {
		
		PdsVo vo = new PdsVo();
		
		//전체페이지 수 계산
		// 전체페이지수 / 페이지 수
		
		this.totalRecordPageCount = (int) Math.ceil((double) this.totalCount /(double) this.pageCount);
		
		//페이지 시작번호 계산
		//(페이지그룹번호 - 1) * 페이지 수 + 1
		this.startPageNum = (this.pageGrpNum - 1) * this.pageTotalCount + 1;
		
		//페이지 끝번호 계산
		//전체페이지수 < 페이지그룹번호 * 페이지 수 이면 전체페이지수, 그렇지 않으면 페이지 그룹번호 * 페이지 수
		//삼항연산자                           조건문                                                    참일때                            거짓일때
		this.endPageNum = this.totalRecordPageCount < (this.pageGrpNum * this.pageTotalCount) ? this.totalRecordPageCount : (this.pageGrpNum * this.pageTotalCount); 
		
		//이전페이지 클릭시
		//페이지 시작번호 - 1
		this.prevNowPage = this.startPageNum - 1;
		
		//다음페이지 클릭시
		//페이지 끝번호 + 1
		this.nextNowPage = this.endPageNum + 1;
		
		
		//돌려주기 위해 값을 저장
		vo.setNowpage(nowPage);
		
		vo.setPrevnowpage(prevNowPage);
		vo.setNextnowpage(nextNowPage);
		
		vo.setTotalcount(totalCount);
		vo.setTotalpagecount(pageTotalCount);
		
		vo.setPagestartnum(startPageNum);
		vo.setPageendnum(endPageNum);
		
		vo.setPagecount(pageCount);
		vo.setPagegrpnum(pageGrpNum);
		
		
		//이전페이지 표시조건
		if(this.startPageNum == 1) {
			this.isShowPagePrev = false;
		}
		
		//다음페이지 표시조건
		if(this.endPageNum >= this.totalRecordPageCount) {
			this.isShowPageNext = false;
		}
		
		vo.setIsshowpageprev(isShowPagePrev);
		vo.setIsshowpagenext(isShowPageNext);
		
		return vo;
	
	
	
	
	}
}