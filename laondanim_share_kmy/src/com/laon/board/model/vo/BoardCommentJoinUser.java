package com.laon.board.model.vo;

import java.sql.Date;

public class BoardCommentJoinUser {
	//닉네임까지 담아서 boardview에 출력할용

	// 넘버 게시판 댓글 기본키
	 private int no;

	 // 유저 테이블 넘버 회원 외래키
	 private int userNo;

	 // 게시판 테이블 넘버 게시판 외래키
	 private int boardNo;

	 // 작성 날짜 작성 날짜
	 private Date writeDate;

	 // 내용 댓글 내용
	 private String content;

	 // 삭제여부 삭제 여부
	 private String deleted;
	 
	 // 대댓글 구현용
	 //코멘트 참조번호
	 private int boardCommentRef;
	 //댓글 레벨(댓글,대댓글 나눌용)
	 private int level;
	 
	 private String commentWriter;
	 
	 public BoardCommentJoinUser() {
		// TODO Auto-generated constructor stub
	}

	public BoardCommentJoinUser(int no, int userNo, int boardNo, Date writeDate, String content, String deleted,
			int boardCommentRef, int level, String commentWriter) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.boardNo = boardNo;
		this.writeDate = writeDate;
		this.content = content;
		this.deleted = deleted;
		this.boardCommentRef = boardCommentRef;
		this.level = level;
		this.commentWriter = commentWriter;
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

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getBoardCommentRef() {
		return boardCommentRef;
	}

	public void setBoardCommentRef(int boardCommentRef) {
		this.boardCommentRef = boardCommentRef;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	

	@Override
	public String toString() {
		return "BoardCommentJoinUser [no=" + no + ", userNo=" + userNo + ", boardNo=" + boardNo + ", writeDate="
				+ writeDate + ", content=" + content + ", deleted=" + deleted + ", boardCommentRef=" + boardCommentRef
				+ ", level=" + level + ", commentWriter=" + commentWriter + "]";
	}

	 
	
}
