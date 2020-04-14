package com.laon.tripinfo.model.vo;

public class MindPicture {
	
	private int no;
	private int userNo;
	private int tripinfoNo;
	private String cancled;
	private int pictureNo;
	private int tripNo;
	private int donghangNo;
	private String image;
	
	public MindPicture() {
		// TODO Auto-generated constructor stub
	}

	public MindPicture(int no, int userNo, int tripinfoNo, String cancled, int pictureNo, int tripNo, int donghangNo,
			String image) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.tripinfoNo = tripinfoNo;
		this.cancled = cancled;
		this.pictureNo = pictureNo;
		this.tripNo = tripNo;
		this.donghangNo = donghangNo;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "MindPicture [no=" + no + ", userNo=" + userNo + ", tripinfoNo=" + tripinfoNo + ", cancled=" + cancled
				+ ", pictureNo=" + pictureNo + ", tripNo=" + tripNo + ", donghangNo=" + donghangNo + ", image=" + image
				+ "]";
	}
	

}
