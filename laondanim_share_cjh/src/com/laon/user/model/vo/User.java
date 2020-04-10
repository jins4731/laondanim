package com.laon.user.model.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.common.PictureKey;
import com.laon.common.UserKey;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;

//회원 테이블
public class User implements LaonRobot<User>{

private Picture picture;

 // 넘버 회원 기본키
 private int no;

 // 생성된 날짜 가입 날짜
 private Date createdDate;

 // 유저 아이디 회원 아이디
 private String userId;

 // 비밀번호 비밀번호
 private String password;

 // 이름 회원 이름
 private String name;

 // 닉 이름 넥네임
 private String nickName;

 // 생년월일 생년월일
 private Date birthday;

 // 성별 성별
 private String gender;

 // 휴대전화 휴대전화
 private String phone;

 // 이메일 이메일
 private String email;
 
 public User() {
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

// 태그 가입시 추가하는 관심 태그
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

 // UserTb 모델 복사
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

 	
    private String cNo = "no";
	private String cCreatedDate = "created_date";
	private String cUserId = "user_id";
	private String cPassword = "password";
	private String cName = "name";
	private String cNickName = "nick_name";
	private String cBirthday = "birthday";
	private String cGender = "gender";
	private String cPhone = "phone";
	private String cEmail = "email";
	
	
 
@Override
public List<User> rsProcess(List<User> list, ResultSet rs) throws SQLException {
	while (rs.next()) {
		User item = new User();
		item.setNo(rs.getInt(cNo));
		item.setCreatedDate(rs.getDate(cCreatedDate));
		item.setUserId(rs.getString(cUserId));
		item.setPassword(rs.getString(cPassword));
		item.setName(rs.getString(cName));
		item.setNickName(rs.getString(cNickName));
		item.setBirthday(rs.getDate(cBirthday));
		item.setGender(rs.getString(cGender));
		item.setPhone(rs.getString(cPhone));
		item.setEmail(rs.getString(cEmail));
		list.add(item);
	}
	return list;
}

@Override
public User rsProcess(User item, ResultSet rs) throws SQLException {
	while (rs.next()) {
		item.setNo(rs.getInt(cNo));
		item.setCreatedDate(rs.getDate(cCreatedDate));
		item.setUserId(rs.getString(cUserId));
		item.setPassword(rs.getString(cPassword));
		item.setName(rs.getString(cName));
		item.setNickName(rs.getString(cNickName));
		item.setBirthday(rs.getDate(cBirthday));
		item.setGender(rs.getString(cGender));
		item.setPhone(rs.getString(cPhone));
		item.setEmail(rs.getString(cEmail));
	}
	return item;
}


@Override
public User mrProcess(User item, MultipartRequest mr, Picture pic) {
	picture = pic;
	picture.setImage(mr.getOriginalFileName(PictureKey.IMAGE));
	item.setUserId(mr.getParameter(UserKey.USER_ID));
	item.setPassword(mr.getParameter(UserKey.PASSWORD));
	item.setName(mr.getParameter(UserKey.NAME));
	item.setNickName(mr.getParameter(UserKey.NICK_NAME));
	item.setBirthday(Date.valueOf(mr.getParameter(UserKey.BIRTHDAY)));
	item.setGender(mr.getParameter(UserKey.GENDER));
	item.setPhone(mr.getParameter(UserKey.PHONE));
	item.setEmail(mr.getParameter(UserKey.EMAIL));
	return item;
}
}