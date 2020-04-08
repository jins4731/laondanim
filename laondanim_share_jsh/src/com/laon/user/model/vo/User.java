package com.laon.user.model.vo;

import java.sql.Date;

//ȸ�� ���̺�
public class User {

	 // �ѹ� ȸ�� �⺻Ű
	 private int no;
	
	 // ������ ��¥ ���� ��¥
	 private Date createdDate;
	
	 // ���� ���̵� ȸ�� ���̵�
	 private String userId;	

	// ��й�ȣ ��й�ȣ
	 private String password;
	
	 // �̸� ȸ�� �̸�
	 private String name;
	
	 // �� �̸� �س���
	 private String nickName;
	
	 // ������� �������
	 private Date birthday;
	
	 // ���� ����
	 private String gender;
	
	 // �޴���ȭ �޴���ȭ
	 private int phone;
	
	 // �̸��� �̸���
	 private String email;
	
	 // �±� ���Խ� �߰��ϴ� ���� �±�
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
	
	 public int getPhone() {
	     return phone;
	 }
	
	 public void setPhone(int phone) {
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
	
	 // User �� ����
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
	 
	 @Override
	public String toString() {
		return "User [no=" + no + ", createdDate=" + createdDate + ", userId=" + userId + ", password=" + password
				+ ", name=" + name + ", nickName=" + nickName + ", birthday=" + birthday + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", tag=" + tag + "]";
	}
	 
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int no, Date createdDate, String userId, String password, String name, String nickName, Date birthday,
			String gender, int phone, String email, String tag) {
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
	
}