package com.laon.tripinfo.model.vo;

//여행정보 테이블
public class Tripinfo {

 // 넘버 여행정보 기본키
 private int no;

 // 카테고리 맛집, 명소, 숙소
 private String category;

 // 태그 태그
 private String tag;

 // 이름 상호명
 private String name;

 // 주소 주소
 private String address;

 // 영업 시간 영업시간
 private String businessHours;

 // 전화번호 전화번호
 private String tel;

 // 홈페이지 홈페이지 주소
 private String homepage;

 // 네이버 네이버 주소
 private String naver;

 // SNS SNS 주소
 private String sns;
 
 public Tripinfo() {
	// TODO Auto-generated constructor stub
}
 

 public Tripinfo(int no, String category, String tag, String name, String address, String businessHours, String tel,
		String homepage, String naver, String sns) {
	super();
	this.no = no;
	this.category = category;
	this.tag = tag;
	this.name = name;
	this.address = address;
	this.businessHours = businessHours;
	this.tel = tel;
	this.homepage = homepage;
	this.naver = naver;
	this.sns = sns;
}

@Override
public String toString() {
	return "TripinfoTb [no=" + no + ", category=" + category + ", tag=" + tag + ", name=" + name + ", address="
			+ address + ", businessHours=" + businessHours + ", tel=" + tel + ", homepage=" + homepage + ", naver="
			+ naver + ", sns=" + sns + "]";
}

public int getNo() {
     return no;
 }

 public void setNo(int no) {
     this.no = no;
 }

 public String getCategory() {
     return category;
 }

 public void setCategory(String category) {
     this.category = category;
 }

 public String getTag() {
     return tag;
 }

 public void setTag(String tag) {
     this.tag = tag;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getAddress() {
     return address;
 }

 public void setAddress(String address) {
     this.address = address;
 }

 public String getBusinessHours() {
     return businessHours;
 }

 public void setBusinessHours(String businessHours) {
     this.businessHours = businessHours;
 }

 public String getTel() {
     return tel;
 }

 public void setTel(String tel) {
     this.tel = tel;
 }

 public String getHomepage() {
     return homepage;
 }

 public void setHomepage(String homepage) {
     this.homepage = homepage;
 }

 public String getNaver() {
     return naver;
 }

 public void setNaver(String naver) {
     this.naver = naver;
 }

 public String getSns() {
     return sns;
 }

 public void setSns(String sns) {
     this.sns = sns;
 }

 // TripinfoTb 모델 복사
 public void CopyData(Tripinfo param)
 {
     this.no = param.getNo();
     this.category = param.getCategory();
     this.tag = param.getTag();
     this.name = param.getName();
     this.address = param.getAddress();
     this.businessHours = param.getBusinessHours();
     this.tel = param.getTel();
     this.homepage = param.getHomepage();
     this.naver = param.getNaver();
     this.sns = param.getSns();
 }
}
