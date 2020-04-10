package com.laon.etc.model.vo;

public class Like {

	private int no;
	private int userNo;
	private int tripNo;
	private String cancled;
	private int likeCount;

	public Like() {}

	public Like(int no, int userNo, int tripNo, String cancled, int likeCount) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.tripNo = tripNo;
		this.cancled = cancled;
		this.likeCount = likeCount;
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

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public String getCancled() {
		return cancled;
	}

	public void setCancled(String cancled) {
		this.cancled = cancled;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
}
