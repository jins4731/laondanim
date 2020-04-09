package com.laon.tripinfo.model.vo;

public class TripInfo {
	
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
	
	public TripInfo() {
		// TODO Auto-generated constructor stub
	}

	public TripInfo(int tripinfoNo, String tripinfoCategory, String tripinfoTag, String tripinfoName,
			String tripinfoAddress, String tripinfotime, String tripinfoNumber, String tripinfoHomePage,
			String tripinfoNaver, String tripinfoSns) {
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

	@Override
	public String toString() {
		return "TripInfo [tripinfoNo=" + tripinfoNo + ", tripinfoCategory=" + tripinfoCategory + ", tripinfoTag="
				+ tripinfoTag + ", tripinfoName=" + tripinfoName + ", tripinfoAddress=" + tripinfoAddress
				+ ", tripinfotime=" + tripinfotime + ", tripinfoNumber=" + tripinfoNumber + ", tripinfoHomePage="
				+ tripinfoHomePage + ", tripinfoNaver=" + tripinfoNaver + ", tripinfoSns=" + tripinfoSns + "]";
	}
	

}
