package com.laon.tripinfo.model.vo;

public class TripinfoMyMind {
	private int no;
	private String category;
	private String tag;
	private String name;
	private String address;
	private String time;
	private String number;
	private String homePage;
	private String naver;
	private String sns;
	private String image;
	
	public TripinfoMyMind() {}

	public TripinfoMyMind(int no, String category, String tag, String name, String address, String time, String number,
			String homePage, String naver, String sns, String image) {
		super();
		this.no = no;
		this.category = category;
		this.tag = tag;
		this.name = name;
		this.address = address;
		this.time = time;
		this.number = number;
		this.homePage = homePage;
		this.naver = naver;
		this.sns = sns;
		this.image = image;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getNaver() {
		return naver;
	}

	public void setNaver(String naver) {
		this.naver = naver;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
