package com.laon.tripinfo.model.vo;

import java.sql.Date;

public class TripInfoComment {
	
	private int tripinfoCommentNo;
	private int tripinfoTbNo;
	private int userTbNo;
	private Date writeDate;
	private String content;
	private char deleted;
	
	public TripInfoComment() {
		// TODO Auto-generated constructor stub
	}

	public TripInfoComment(int tripinfoCommentNo, int tripinfoTbNo, int userTbNo, Date writeDate, String content,
			char deleted) {
		super();
		this.tripinfoCommentNo = tripinfoCommentNo;
		this.tripinfoTbNo = tripinfoTbNo;
		this.userTbNo = userTbNo;
		this.writeDate = writeDate;
		this.content = content;
		this.deleted = deleted;
	}

	public int getTripinfoCommentNo() {
		return tripinfoCommentNo;
	}

	public void setTripinfoCommentNo(int tripinfoCommentNo) {
		this.tripinfoCommentNo = tripinfoCommentNo;
	}

	public int getTripinfoTbNo() {
		return tripinfoTbNo;
	}

	public void setTripinfoTbNo(int tripinfoTbNo) {
		this.tripinfoTbNo = tripinfoTbNo;
	}

	public int getUserTbNo() {
		return userTbNo;
	}

	public void setUserTbNo(int userTbNo) {
		this.userTbNo = userTbNo;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public char getDeleted() {
		return deleted;
	}

	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "TripInfoComment [tripinfoCommentNo=" + tripinfoCommentNo + ", tripinfoTbNo=" + tripinfoTbNo
				+ ", userTbNo=" + userTbNo + ", writeDate=" + writeDate + ", content=" + content + ", deleted="
				+ deleted + "]";
	}
	
	
	

}
