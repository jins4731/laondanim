package com.laon.tripinfo.model.vo;

public class Mind {
	
	private int no;
	private int userNo;
	private int tripinfoNo;
	private String cancled;
	private int count;
	
	public Mind() {
		// TODO Auto-generated constructor stub
	}

	public Mind(int no, int userNo, int tripinfoNo, String cancled, int count) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.tripinfoNo = tripinfoNo;
		this.cancled = cancled;
		this.count = count;
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

	public int getTripinfoNo() {
		return tripinfoNo;
	}

	public void setTripinfoNo(int tripinfoNo) {
		this.tripinfoNo = tripinfoNo;
	}

	public String getCancled() {
		return cancled;
	}

	public void setCancled(String cancled) {
		this.cancled = cancled;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Mind [no=" + no + ", userNo=" + userNo + ", tripinfoNo=" + tripinfoNo + ", cancled=" + cancled
				+ ", count=" + count + "]";
	}

	
	
	
	
}