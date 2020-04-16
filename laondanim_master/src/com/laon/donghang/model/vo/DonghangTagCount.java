package com.laon.donghang.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class DonghangTagCount {

	private int no;
	private int userNo;
	private int tripNo;
	private Date writeDate;
	private int viewCount;
	private String tag[];
	private String title;
	private String content;
	private String travleLocale;
	private Date travleStartDate;
	private Date travleEndDate;
	private Date recruitStartDate;
	private Date recrutiEndDate;
	private int pw;
	private String publicEnabled;
	private String ended;
	private String deleted;
	private int recruitPeopleNo;
	private int joinPeopleNo;
	
	private int tagCount;
	
	public DonghangTagCount() {
		// TODO Auto-generated constructor stub
	}

	public DonghangTagCount(int no, int userNo, int tripNo, Date writeDate, int viewCount, String[] tag, String title,
			String content, String travleLocale, Date travleStartDate, Date travleEndDate, Date recruitStartDate,
			Date recrutiEndDate, int pw, String publicEnabled, String ended, String deleted, int recruitPeopleNo,
			int joinPeopleNo, int tagCount) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.tripNo = tripNo;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.travleLocale = travleLocale;
		this.travleStartDate = travleStartDate;
		this.travleEndDate = travleEndDate;
		this.recruitStartDate = recruitStartDate;
		this.recrutiEndDate = recrutiEndDate;
		this.pw = pw;
		this.publicEnabled = publicEnabled;
		this.ended = ended;
		this.deleted = deleted;
		this.recruitPeopleNo = recruitPeopleNo;
		this.joinPeopleNo = joinPeopleNo;
		this.tagCount = tagCount;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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

	public String getTravleLocale() {
		return travleLocale;
	}

	public void setTravleLocale(String travleLocale) {
		this.travleLocale = travleLocale;
	}

	public Date getTravleStartDate() {
		return travleStartDate;
	}

	public void setTravleStartDate(Date travleStartDate) {
		this.travleStartDate = travleStartDate;
	}

	public Date getTravleEndDate() {
		return travleEndDate;
	}

	public void setTravleEndDate(Date travleEndDate) {
		this.travleEndDate = travleEndDate;
	}

	public Date getRecruitStartDate() {
		return recruitStartDate;
	}

	public void setRecruitStartDate(Date recruitStartDate) {
		this.recruitStartDate = recruitStartDate;
	}

	public Date getRecrutiEndDate() {
		return recrutiEndDate;
	}

	public void setRecrutiEndDate(Date recrutiEndDate) {
		this.recrutiEndDate = recrutiEndDate;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public String getPublicEnabled() {
		return publicEnabled;
	}

	public void setPublicEnabled(String publicEnabled) {
		this.publicEnabled = publicEnabled;
	}

	public String getEnded() {
		return ended;
	}

	public void setEnded(String ended) {
		this.ended = ended;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getRecruitPeopleNo() {
		return recruitPeopleNo;
	}

	public void setRecruitPeopleNo(int recruitPeopleNo) {
		this.recruitPeopleNo = recruitPeopleNo;
	}

	public int getJoinPeopleNo() {
		return joinPeopleNo;
	}

	public void setJoinPeopleNo(int joinPeopleNo) {
		this.joinPeopleNo = joinPeopleNo;
	}

	public int getTagCount() {
		return tagCount;
	}

	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}

	@Override
	public String toString() {
		return "DonghangTagCount [no=" + no + ", userNo=" + userNo + ", tripNo=" + tripNo + ", writeDate=" + writeDate
				+ ", viewCount=" + viewCount + ", tag=" + Arrays.toString(tag) + ", title=" + title + ", content="
				+ content + ", travleLocale=" + travleLocale + ", travleStartDate=" + travleStartDate
				+ ", travleEndDate=" + travleEndDate + ", recruitStartDate=" + recruitStartDate + ", recrutiEndDate="
				+ recrutiEndDate + ", pw=" + pw + ", publicEnabled=" + publicEnabled + ", ended=" + ended + ", deleted="
				+ deleted + ", recruitPeopleNo=" + recruitPeopleNo + ", joinPeopleNo=" + joinPeopleNo + ", tagCount="
				+ tagCount + "]";
	}

	

}
