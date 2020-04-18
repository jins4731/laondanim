package com.laon.admin.model.vo;

public class ReportsJoinUser {

	

	private int no;
	private int userNo;
	private int donghangNo;
	private int boardNo;
	private String reportContent;
	private String status;//default n����.y�ϰ�� ȸ�� ����
	private String userId;
	
	
	public ReportsJoinUser() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	public ReportsJoinUser(int no, int userNo, int donghangNo, int boardNo, String reportContent, String status,
			String userId) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.donghangNo = donghangNo;
		this.boardNo = boardNo;
		this.reportContent = reportContent;
		this.status = status;
		this.userId = userId;
	}
	
	
	@Override
	public String toString() {
		return "ReportsJoinUser [no=" + no + ", userNo=" + userNo + ", donghangNo=" + donghangNo + ", boardNo="
				+ boardNo + ", reportContent=" + reportContent + ", status=" + status + ", userId=" + userId + "]";
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getDonghangNo() {
		return donghangNo;
	}


	public void setDonghangNo(int donghangNo) {
		this.donghangNo = donghangNo;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getReportContent() {
		return reportContent;
	}


	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}




	
	
	
}
