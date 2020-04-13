package com.laon.etc.model.vo;

public class Mind {
	private int no;
	private int userTbNo;
	private int tripinfoTbNo;
	private String cancled;
	
	public Mind() {}

	public Mind(int no, int userTbNo, int tripinfoTbNo, String cancled) {
		super();
		this.no = no;
		this.userTbNo = userTbNo;
		this.tripinfoTbNo = tripinfoTbNo;
		this.cancled = cancled;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserTbNo() {
		return userTbNo;
	}

	public void setUserTbNo(int userTbNo) {
		this.userTbNo = userTbNo;
	}

	public int getTripinfoTbNo() {
		return tripinfoTbNo;
	}

	public void setTripinfoTbNo(int tripinfoTbNo) {
		this.tripinfoTbNo = tripinfoTbNo;
	}

	public String getCancled() {
		return cancled;
	}

	public void setCancled(String cancled) {
		this.cancled = cancled;
	}
	
}
