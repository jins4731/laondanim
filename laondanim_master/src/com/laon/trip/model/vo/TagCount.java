package com.laon.trip.model.vo;

import java.util.Arrays;
import java.util.Date;

public class TagCount {

	private int no;
	private int userTbNo;
	private String category;
	private Date writeDate;
	private String[] tag;
	private String title;
	private String content;
	private String tripLocate;
	private int peopleNum;
	private String tripType;
	private Date startDate;
	private Date endDate;
	private char publicEnabled;
	private char deleted;
	
	private int tagCount;
	
//	private int tripNo; 
//	private int viewcount;
//	private String travleLocale;
//	private Date travleStartDate; 
//	private Date travleEndDate;
//	private Date recruitStartDate;
//	private Date recruitEndDate;
//	private int pw;
//	private String ended;
//	private int recruitPeopleNo;
//	private int joinPeopleNo;
	
	public TagCount() {
		// TODO Auto-generated constructor stub
	}

//	public tagCount(int no, int userTbNo, int tripNo, Date writeDate, int viewcount, String[] tag, String title, String content,
//		String travleLocale, Date travleStartDate, Date travleEndDate, Date recruitStartDate, Date recruitEndDate,
//		int pw, String publicEnabled, String ended, String deleted, int recruitPeopleNo, int joinPeopleNo) {
//		
//		this.no = no;
//		this.userTbNo = userTbNo;
//		this.tripNo = tripNo;
//		this.writeDate = writeDate;
//		this.viewcount = viewcount;
//		this.tag = tag;
//		this.title = title;
//		this.content = content;
//		this.travleLocale = travleLocale;
//		this.travleStartDate = travleStartDate;
//		this.travleEndDate = travleEndDate;
//		this.recruitStartDate = recruitStartDate;
//		this.recruitEndDate = recruitEndDate;
//		this.pw = pw;
//		this.publicEnabled = publicEnabled;
//		this.ended = ended;
//		this.deleted = deleted;
//		this.recruitPeopleNo = recruitPeopleNo;
//		this.joinPeopleNo = joinPeopleNo;
//	}
	
	public TagCount(int no, int userTbNo, String category, Date writeDate, String[] tag, String title, String content,
			String tripLocate, int peopleNum, String tripType, Date startDate, Date endDate, char publicEnabled,
			char deleted, int tagCount) {
		super();
		this.no = no;
		this.userTbNo = userTbNo;
		this.category = category;
		this.writeDate = writeDate;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.tripLocate = tripLocate;
		this.peopleNum = peopleNum;
		this.tripType = tripType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.publicEnabled = publicEnabled;
		this.deleted = deleted;
		this.tagCount = tagCount;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTripLocate() {
		return tripLocate;
	}

	public void setTripLocate(String tripLocate) {
		this.tripLocate = tripLocate;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public char getPublicEnabled() {
		return publicEnabled;
	}

	public void setPublicEnabled(char publicEnabled) {
		this.publicEnabled = publicEnabled;
	}

	public char getDeleted() {
		return deleted;
	}

	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}

	public int getTagCount() {
		return tagCount;
	}

	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}

	@Override
	public String toString() {
		return "TagCount [no=" + no + ", userTbNo=" + userTbNo + ", category=" + category + ", writeDate=" + writeDate
				+ ", tag=" + Arrays.toString(tag) + ", title=" + title + ", content=" + content + ", tripLocate="
				+ tripLocate + ", peopleNum=" + peopleNum + ", tripType=" + tripType + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", publicEnabled=" + publicEnabled + ", deleted=" + deleted + ", tagCount="
				+ tagCount + "]";
	}

	
}
