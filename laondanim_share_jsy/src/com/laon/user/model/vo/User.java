package com.laon.user.model.vo;

import java.sql.Date;

//�쉶�썝 �뀒�씠釉�
public class User {

 // �꽆踰� �쉶�썝 湲곕낯�궎
 private int no;

 // �깮�꽦�맂 �궇吏� 媛��엯 �궇吏�
 private Date createdDate;

 // �쑀�� �븘�씠�뵒 �쉶�썝 �븘�씠�뵒
 private String userId;

 // 鍮꾨�踰덊샇 鍮꾨�踰덊샇
 private String password;

 // �씠由� �쉶�썝 �씠由�
 private String name;

 // �땳 �씠由� �꽖�꽕�엫
 private String nickName;

 // �깮�뀈�썡�씪 �깮�뀈�썡�씪
 private Date birthday;

 // �꽦蹂� �꽦蹂�
 private String gender;

 // �쑕���쟾�솕 �쑕���쟾�솕
 private String phone;

 // �씠硫붿씪 �씠硫붿씪
 private String email;
 
 public User() {//湲곕낯�깮�꽦�옄
	// TODO Auto-generated constructor stub
}

 public User(int no, Date createdDate, String userId, String password, String name, String nickName, Date birthday,
		String gender, String phone, String email, String tag) {
	super();
	this.no = no;
	this.createdDate = createdDate;
	this.userId = userId;
	this.password = password;
	this.name = name;
	this.nickName = nickName;
	this.birthday = birthday;
	this.gender = gender;
	this.phone = phone;
	this.email = email;
	this.tag = tag;
}

@Override
public String toString() {
	return "UserTb [no=" + no + ", createdDate=" + createdDate + ", userId=" + userId + ", password=" + password
			+ ", name=" + name + ", nickName=" + nickName + ", birthday=" + birthday + ", gender=" + gender + ", phone="
			+ phone + ", email=" + email + ", tag=" + tag + "]";
}

// �깭洹� 媛��엯�떆 異붽��븯�뒗 愿��떖 �깭洹�
 private String tag;

 public int getNo() {
     return no;
 }

 public void setNo(int no) {
     this.no = no;
 }

 public Date getCreatedDate() {
     return createdDate;
 }

 public void setCreatedDate(Date createdDate) {
     this.createdDate = createdDate;
 }

 public String getUserId() {
     return userId;
 }

 public void setUserId(String userId) {
     this.userId = userId;
 }

 public String getPassword() {
     return password;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getNickName() {
     return nickName;
 }

 public void setNickName(String nickName) {
     this.nickName = nickName;
 }

 public Date getBirthday() {
     return birthday;
 }

 public void setBirthday(Date birthday) {
     this.birthday = birthday;
 }

 public String getGender() {
     return gender;
 }

 public void setGender(String gender) {
     this.gender = gender;
 }

 public String getPhone() {
     return phone;
 }

 public void setPhone(String phone) {
     this.phone = phone;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getTag() {
     return tag;
 }

 public void setTag(String tag) {
     this.tag = tag;
 }

 // UserTb 紐⑤뜽 蹂듭궗
 public void CopyData(User param)
 {
     this.no = param.getNo();
     this.createdDate = param.getCreatedDate();
     this.userId = param.getUserId();
     this.password = param.getPassword();
     this.name = param.getName();
     this.nickName = param.getNickName();
     this.birthday = param.getBirthday();
     this.gender = param.getGender();
     this.phone = param.getPhone();
     this.email = param.getEmail();
     this.tag = param.getTag();
 }
}