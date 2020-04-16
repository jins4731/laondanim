package com.laon.tripinfo.model.vo;

public class Picture {
	
	private int pictureNo;
	private int tripNo;
	private int donghangNo;
	private int userNo;
	private int tripinfoNo;
	private String image;
	
	public Picture() {
		// TODO Auto-generated constructor stub
	}

	public Picture(int pictureNo, int tripNo, int donghangNo, int userNo, int tripinfoNo, String image) {
		super();
		this.pictureNo = pictureNo;
		this.tripNo = tripNo;
		this.donghangNo = donghangNo;
		this.userNo = userNo;
		this.tripinfoNo = tripinfoNo;
		this.image = image;
	}

	public int getPictureNo() {
		return pictureNo;
	}

	public void setPictureNo(int pictureNo) {
		this.pictureNo = pictureNo;
	}

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
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

	public int getTripinfoNo() {
		return tripinfoNo;
	}

	public void setTripinfoNo(int tripinfoNo) {
		this.tripinfoNo = tripinfoNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Picture [pictureNo=" + pictureNo + ", tripNo=" + tripNo + ", donghangNo=" + donghangNo + ", userNo="
				+ userNo + ", tripinfoNo=" + tripinfoNo + ", image=" + image + "]";
	}
	
	
}