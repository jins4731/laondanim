package com.laon.board.model.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;

//게시판 테이블
public class Board implements LaonRobot<Board>{

 // 넘버 게시판 기본키
 private int no;

 // 유저 테이블 넘버 회원 외래키
 private int userNo;

 // 카테고리 질문 / 자유
 private String category;

 // 작성 날짜 작성 날짜
 private Date writeDate;

 // 조회수 조회수
 private int viewcount;

 // 태그 태그
 private String tag;

 // 제목 제목
 private String title;

 // 내용 글 내용
 private String content;

 // 삭제여부 삭제 여부
 private String deleted;

 
 public Board() {
	// TODO Auto-generated constructor stub
}
 
 
 

 public Board(int no, int userNo, String category, Date writeDate, int viewcount, String tag, String title,
		String content, String deleted) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.category = category;
	this.writeDate = writeDate;
	this.viewcount = viewcount;
	this.tag = tag;
	this.title = title;
	this.content = content;
	this.deleted = deleted;
}




@Override
public String toString() {
	return "Board [no=" + no + ", userNo=" + userNo + ", category=" + category + ", writeDate=" + writeDate
			+ ", viewcount=" + viewcount + ", tag=" + tag + ", title=" + title + ", content=" + content + ", deleted="
			+ deleted + "]";
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




public String getDeleted() {
	return deleted;
}




public void setDeleted(String deleted) {
	this.deleted = deleted;
}




// BoardTb 모델 복사
 public void CopyData(Board param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.category = param.getCategory();
     this.writeDate = param.getWriteDate();
     this.viewcount = param.getViewcount();
     this.tag = param.getTag();
     this.title = param.getTitle();
     this.content = param.getContent();
     this.deleted = param.getDeleted();
 }

 private String cNo = "no";
 private String cUserNo = "user_no";
 private String cCategory = "category";
 private String cWriteDate = "write_date";
 private String cViewcount = "viewcount";
 private String cTag = "tag";
 private String cTitle = "title";
 private String cContent = "content";
 private String cDeleted = "deleted";


@Override
public List<Board> rsProcess(List<Board> list, ResultSet rs) throws SQLException {
	while(rs.next()) {
		Board item = new Board();
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setCategory(rs.getString(cCategory));
		item.setWriteDate(rs.getDate(cWriteDate));
		item.setViewcount(rs.getInt(cViewcount));
		item.setTag(rs.getString(cTag));
		item.setTitle(rs.getString(cTitle));
		item.setContent(rs.getString(cContent));
		item.setDeleted(rs.getString(cDeleted));
		list.add(item);
	}
	return list;
}


@Override
public Board rsProcess(Board item, ResultSet rs) throws SQLException {
	while(rs.next()) {
		item.setNo(rs.getInt(cNo));
		item.setUserNo(rs.getInt(cUserNo));
		item.setCategory(rs.getString(cCategory));
		item.setWriteDate(rs.getDate(cWriteDate));
		item.setViewcount(rs.getInt(cViewcount));
		item.setTag(rs.getString(cTag));
		item.setTitle(rs.getString(cTitle));
		item.setContent(rs.getString(cContent));
		item.setDeleted(rs.getString(cDeleted));
	}
	return item;
}




@Override
public Board mrProcess(Board item, MultipartRequest mr, Picture pic) {
	// TODO Auto-generated method stub
	return null;
}
}