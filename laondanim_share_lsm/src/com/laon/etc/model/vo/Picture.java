package com.laon.etc.model.vo;

public class Picture {
	private int no;
    private int tripNo;
    private int tripinfoNo;
    private int donghangNo;
    private int userNo;
    private String image;
    
    public Picture() {}

	public Picture(int no, int tripNo, int tripinfoNo, int donghangNo, int userNo, String image) {
		super();
		this.no = no;
		this.tripNo = tripNo;
		this.tripinfoNo = tripinfoNo;
		this.donghangNo = donghangNo;
		this.userNo = userNo;
		this.image = image;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public int getTripinfoNo() {
		return tripinfoNo;
	}

	public void setTripinfoNo(int tripinfoNo) {
		this.tripinfoNo = tripinfoNo;
	}

	public int getDonghangNo() {
		return donghangNo;
	}

	public void setDonghangNo(int donghangNo) {
		this.donghangNo = donghangNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
}
