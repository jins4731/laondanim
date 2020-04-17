package com.laon.tripinfo.model.vo;

import java.util.Arrays;

public class InfoTagCount {

	private int no;
	private String category;
	private String[] tag;
	private String name;
	private String address;
	private String businessHours;
	private String tel;
	private String homepage;
	private String naver;
	private String SNS;
	
	private int tagCount;
	
	public InfoTagCount() {
		// TODO Auto-generated constructor stub
	}

	public InfoTagCount(int no, String category, String[] tag, String name, String address, String businessHours,
			String tel, String homepage, String naver, String sNS, int tagCount) {
		super();
		this.no = no;
		this.category = category;
		this.tag = tag;
		this.name = name;
		this.address = address;
		this.businessHours = businessHours;
		this.tel = tel;
		this.homepage = homepage;
		this.naver = naver;
		SNS = sNS;
		this.tagCount = tagCount;
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

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
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

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getNaver() {
		return naver;
	}

	public void setNaver(String naver) {
		this.naver = naver;
	}

	public String getSNS() {
		return SNS;
	}

	public void setSNS(String sNS) {
		SNS = sNS;
	}

	public int getTagCount() {
		return tagCount;
	}

	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}

	@Override
	public String toString() {
		return "InfoTagCount [no=" + no + ", category=" + category + ", tag=" + Arrays.toString(tag) + ", name=" + name
				+ ", address=" + address + ", businessHours=" + businessHours + ", tel=" + tel + ", homepage="
				+ homepage + ", naver=" + naver + ", SNS=" + SNS + ", tagCount=" + tagCount + "]";
	}
	
	
}
