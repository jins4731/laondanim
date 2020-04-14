package com.laon.tripinfo.model.vo;

public class TripInfoPicture {
	
	private int tripinfoNo;
	private String tripinfoCategory;
	private String tripinfoTag;
	private String tripinfoName;
	private String tripinfoAddress;
	private String tripinfotime;
	private String tripinfoNumber;
	private String tripinfoHomePage;
	private String tripinfoNaver;
	private String tripinfoSns;
	private int pictureNo;
	private int tripNo;
	private int donghangNo;
	private int userNo;
	private String image;
	
	public TripInfoPicture() {
		// TODO Auto-generated constructor stub
	}

	public TripInfoPicture(int tripinfoNo, String tripinfoCategory, String tripinfoTag, String tripinfoName,
			String tripinfoAddress, String tripinfotime, String tripinfoNumber, String tripinfoHomePage,
			String tripinfoNaver, String tripinfoSns, int pictureNo, int tripNo, int donghangNo, int userNo,
			String image) {
		super();
		this.tripinfoNo = tripinfoNo;
		this.tripinfoCategory = tripinfoCategory;
		this.tripinfoTag = tripinfoTag;
		this.tripinfoName = tripinfoName;
		this.tripinfoAddress = tripinfoAddress;
		this.tripinfotime = tripinfotime;
		this.tripinfoNumber = tripinfoNumber;
		this.tripinfoHomePage = tripinfoHomePage;
		this.tripinfoNaver = tripinfoNaver;
		this.tripinfoSns = tripinfoSns;
		this.pictureNo = pictureNo;
		this.tripNo = tripNo;
		this.donghangNo = donghangNo;
		this.userNo = userNo;
		this.image = image;
	}

	public int getTripinfoNo() {
		return tripinfoNo;
	}

	public void setTripinfoNo(int tripinfoNo) {
		this.tripinfoNo = tripinfoNo;
	}

	public String getTripinfoCategory() {
		return tripinfoCategory;
	}

	public void setTripinfoCategory(String tripinfoCategory) {
		this.tripinfoCategory = tripinfoCategory;
	}

	public String getTripinfoTag() {
		return tripinfoTag;
	}

	public void setTripinfoTag(String tripinfoTag) {
		this.tripinfoTag = tripinfoTag;
	}

	public String getTripinfoName() {
		return tripinfoName;
	}

	public void setTripinfoName(String tripinfoName) {
		this.tripinfoName = tripinfoName;
	}

	public String getTripinfoAddress() {
		return tripinfoAddress;
	}

	public void setTripinfoAddress(String tripinfoAddress) {
		this.tripinfoAddress = tripinfoAddress;
	}

	public String getTripinfotime() {
		return tripinfotime;
	}

	public void setTripinfotime(String tripinfotime) {
		this.tripinfotime = tripinfotime;
	}

	public String getTripinfoNumber() {
		return tripinfoNumber;
	}

	public void setTripinfoNumber(String tripinfoNumber) {
		this.tripinfoNumber = tripinfoNumber;
	}

	public String getTripinfoHomePage() {
		return tripinfoHomePage;
	}

	public void setTripinfoHomePage(String tripinfoHomePage) {
		this.tripinfoHomePage = tripinfoHomePage;
	}

	public String getTripinfoNaver() {
		return tripinfoNaver;
	}

	public void setTripinfoNaver(String tripinfoNaver) {
		this.tripinfoNaver = tripinfoNaver;
	}

	public String getTripinfoSns() {
		return tripinfoSns;
	}

	public void setTripinfoSns(String tripinfoSns) {
		this.tripinfoSns = tripinfoSns;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "TripInfoPicture [tripinfoNo=" + tripinfoNo + ", tripinfoCategory=" + tripinfoCategory + ", tripinfoTag="
				+ tripinfoTag + ", tripinfoName=" + tripinfoName + ", tripinfoAddress=" + tripinfoAddress
				+ ", tripinfotime=" + tripinfotime + ", tripinfoNumber=" + tripinfoNumber + ", tripinfoHomePage="
				+ tripinfoHomePage + ", tripinfoNaver=" + tripinfoNaver + ", tripinfoSns=" + tripinfoSns
				+ ", pictureNo=" + pictureNo + ", tripNo=" + tripNo + ", donghangNo=" + donghangNo + ", userNo="
				+ userNo + ", image=" + image + "]";
	}
	
	

}
