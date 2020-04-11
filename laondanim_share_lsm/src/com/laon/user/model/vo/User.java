package com.laon.user.model.vo;

import java.sql.Date;

//회원 테이블
public class User {

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

	public User() {// 기본생성자
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
				+ ", name=" + name + ", nickName=" + nickName + ", birthday=" + birthday + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", tag=" + tag + "]";
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
	public void CopyData(User param) {
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