package com.laon.board.model.vo;

import java.util.Date;

public class BoardJoinUser {

	private int no;
	private int userNo;
	private String category;
	private Date writeDate;
	private int viewCount;
	private String tag;
	private String title;
	private String content;
	private char deleted;
	private String nickName;//유저테이블의 닉네임 참조
	
	public BoardJoinUser() {
		// TODO Auto-generated constructor stub
	}
	public BoardJoinUser(int no, int userNo, String category, Date writeDate, int viewCount, String tag, String title,
			String content, char deleted, String nickName) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.category = category;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.deleted = deleted;
		this.nickName = nickName;
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "BoardJoinUser [no=" + no + ", userNo=" + userNo + ", category=" + category + ", writeDate=" + writeDate
				+ ", viewCount=" + viewCount + ", tag=" + tag + ", title=" + title + ", content=" + content
				+ ", deleted=" + deleted + ", nickName=" + nickName + "]";
	}
	
	
	
	
	
	
}
