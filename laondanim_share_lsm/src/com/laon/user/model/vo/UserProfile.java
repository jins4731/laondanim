package com.laon.user.model.vo;

import java.util.Date;

public class UserProfile {
    private int no;
    private Date createdDate;
    private String userId;
    private String password;
    private String name;
    private String nickName;
    private Date birthday;
    private String gender;
    private String phone;
    private String email;
    private String tag;
    private String image;

    public UserProfile() {}

	public UserProfile(int no, Date createdDate, String userId, String password, String name, String nickName,
			Date birthday, String gender, String phone, String email, String tag, String image) {
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
		this.image = image;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
