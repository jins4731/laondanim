package com.laon.donghang.model.vo;

import java.sql.Date;

//동행 채팅 테이블
public class DonghangChat {

 // 넘버 동행 채팅 기본키
 private int no;

 // 유저 테이블 넘버 회원 외래키
 private int userNo;

 // 동행 테이블 넘버 동행 외래키
 private int donghangNo;

 // 작성 날짜 작성 날짜
 private Date writeDate;

 // 메세지 메세지
 private String massage;

 // 송신자 이름 송신자 이름 보류
 private String transferName;

 // 수신자 이름 수신자 이름 보류
 private String recieverName;
 
 public DonghangChat() {
	// TODO Auto-generated constructor stub
}
 
 

 

 public DonghangChat(int no, int userNo, int donghangNo, Date writeDate, String massage, String transferName,
		String recieverName) {
	super();
	this.no = no;
	this.userNo = userNo;
	this.donghangNo = donghangNo;
	this.writeDate = writeDate;
	this.massage = massage;
	this.transferName = transferName;
	this.recieverName = recieverName;
}





@Override
public String toString() {
	return "DonghangChat [no=" + no + ", userNo=" + userNo + ", donghangNo=" + donghangNo + ", writeDate=" + writeDate
			+ ", massage=" + massage + ", transferName=" + transferName + ", recieverName=" + recieverName + "]";
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





public int getDonghangNo() {
	return donghangNo;
}





public void setDonghangNo(int donghangNo) {
	this.donghangNo = donghangNo;
}





public Date getWriteDate() {
	return writeDate;
}





public void setWriteDate(Date writeDate) {
	this.writeDate = writeDate;
}





public String getMassage() {
	return massage;
}





public void setMassage(String massage) {
	this.massage = massage;
}





public String getTransferName() {
	return transferName;
}





public void setTransferName(String transferName) {
	this.transferName = transferName;
}





public String getRecieverName() {
	return recieverName;
}





public void setRecieverName(String recieverName) {
	this.recieverName = recieverName;
}





// DonghangChatTb 모델 복사
 public void CopyData(DonghangChat param)
 {
     this.no = param.getNo();
     this.userNo = param.getUserNo();
     this.donghangNo = param.getDonghangNo();
     this.writeDate = param.getWriteDate();
     this.massage = param.getMassage();
     this.transferName = param.getTransferName();
     this.recieverName = param.getRecieverName();
 }
}
