package com.laon.donghang.model.vo;

import java.sql.Date;

public class MyDong {
	private int noDH;
	private int noJD;
	private int userNoDH;
	private int userNoDJ;
	private int tripNo;
	private Date writeDate;
	private int viewcount;
	private String tag;
	private String title;
	private String content;
	private String travleLocale;
	private Date travleStartDate;
	private Date travleEndDate;
	private Date recruitStartDate;
	private Date recruitEndDate;
	private int pw;
	private String publicEnabled;
	private String ended;
	private String deletedDH;
	private String deletedJD;
	private int recruitPeopleNo;
	private int joinPeopleNo;
	private String image;
	private String confirmed;
	private String cancled;
	private String nickName;
	
	public MyDong() {}

	public MyDong(int noDH, int noJD, int userNoDH, int userNoDJ, int tripNo, Date writeDate, int viewcount, String tag,
			String title, String content, String travleLocale, Date travleStartDate, Date travleEndDate,
			Date recruitStartDate, Date recruitEndDate, int pw, String publicEnabled, String ended, String deletedDH,
			String deletedJD, int recruitPeopleNo, int joinPeopleNo, String image, String confirmed, String cancled,
			String nickName) {
		super();
		this.noDH = noDH;
		this.noJD = noJD;
		this.userNoDH = userNoDH;
		this.userNoDJ = userNoDJ;
		this.tripNo = tripNo;
		this.writeDate = writeDate;
		this.viewcount = viewcount;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.travleLocale = travleLocale;
		this.travleStartDate = travleStartDate;
		this.travleEndDate = travleEndDate;
		this.recruitStartDate = recruitStartDate;
		this.recruitEndDate = recruitEndDate;
		this.pw = pw;
		this.publicEnabled = publicEnabled;
		this.ended = ended;
		this.deletedDH = deletedDH;
		this.deletedJD = deletedJD;
		this.recruitPeopleNo = recruitPeopleNo;
		this.joinPeopleNo = joinPeopleNo;
		this.image = image;
		this.confirmed = confirmed;
		this.cancled = cancled;
		this.nickName = nickName;
	}

	public int getNoDH() {
		return noDH;
	}

	public void setNoDH(int noDH) {
		this.noDH = noDH;
	}

	public int getNoJD() {
		return noJD;
	}

	public void setNoJD(int noJD) {
		this.noJD = noJD;
	}

	public int getUserNoDH() {
		return userNoDH;
	}

	public void setUserNoDH(int userNoDH) {
		this.userNoDH = userNoDH;
	}

	public int getUserNoDJ() {
		return userNoDJ;
	}

	public void setUserNoDJ(int userNoDJ) {
		this.userNoDJ = userNoDJ;
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

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
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

	public Date getRecruitEndDate() {
		return recruitEndDate;
	}

	public void setRecruitEndDate(Date recruitEndDate) {
		this.recruitEndDate = recruitEndDate;
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

	public String getDeletedDH() {
		return deletedDH;
	}

	public void setDeletedDH(String deletedDH) {
		this.deletedDH = deletedDH;
	}

	public String getDeletedJD() {
		return deletedJD;
	}

	public void setDeletedJD(String deletedJD) {
		this.deletedJD = deletedJD;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public String getCancled() {
		return cancled;
	}

	public void setCancled(String cancled) {
		this.cancled = cancled;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
