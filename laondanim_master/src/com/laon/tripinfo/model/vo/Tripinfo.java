package com.laon.tripinfo.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laon.common.PictureKey;
import com.laon.common.TripinfoKey;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;

//여행정보 테이블
public class Tripinfo implements LaonRobot<Tripinfo>{
	
private List<Picture> pictureList;

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








public List<Picture> getPictureList() {
	if(pictureList == null) {
		pictureList = new ArrayList<Picture>();
	}
	return pictureList;
}


public void setPictureList(List<Picture> pictureList) {
	this.pictureList = pictureList;
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

 
 
 private String cNo = "no";
 private String cCategory   = "category";
 private String cTag = "tag";
 private String cName = "name";
 private String cAddress = "address";
 private String cBusinessHours = "business_hours";
 private String cTel = "tel";
 private String cHomepage = "homepage";
 private String cNaver = "naver";
 private String cSns = "sns";

@Override
public List<Tripinfo> rsProcess(List<Tripinfo> list, ResultSet rs) throws SQLException {
	while (rs.next()) {
		Tripinfo item = new Tripinfo();
		item.setNo(rs.getInt(cNo));
		item.setCategory(rs.getString(cCategory));
		item.setTag(rs.getString(cTag));
		item.setName(rs.getString(cName));
		item.setAddress(rs.getString(cAddress));
		item.setBusinessHours(rs.getString(cBusinessHours));
		item.setTel(rs.getString(cTel));
		item.setHomepage(rs.getString(cHomepage));
		item.setNaver(rs.getString(cNaver));
		item.setSns(rs.getString(cSns));
		list.add(item);
	}
	return list;
}


@Override
public Tripinfo rsProcess(Tripinfo item, ResultSet rs) throws SQLException {
	// TODO Auto-generated method stub
	while (rs.next()) {
		item.setNo(rs.getInt(cNo));
		item.setCategory(rs.getString(cCategory));
		item.setTag(rs.getString(cTag));
		item.setName(rs.getString(cName));
		item.setAddress(rs.getString(cAddress));
		item.setBusinessHours(rs.getString(cBusinessHours));
		item.setTel(rs.getString(cTel));
		item.setHomepage(rs.getString(cHomepage));
		item.setNaver(rs.getString(cNaver));
		item.setSns(rs.getString(cSns));
	}
	return item;
}


@Override
public Tripinfo mrProcess(Tripinfo item, MultipartRequest mr, List<Picture> picList) {
	// TODO Auto-generated method stub
	// 사진 추가
			pictureList = picList;
			String fileNames = mr.getParameter("fileNames");
			fileNames = fileNames.substring(0, fileNames.length()-1);
			String[] fileName = fileNames.split(",");
			for (int i = 0; i < fileName.length; i++) {
				Picture pic = new Picture();
				pic.setImage(fileName[i]);
				pictureList.add(pic);
			}
			
	item.setNo(Integer.parseInt(mr.getParameter(TripinfoKey.NO)));
	item.setCategory(mr.getParameter(TripinfoKey.CATEGORY));
	item.setTag(mr.getParameter(TripinfoKey.TAG));
	item.setName(mr.getParameter(TripinfoKey.NAME));
	item.setAddress(mr.getParameter(TripinfoKey.ADDRESS));
	item.setBusinessHours(mr.getParameter(TripinfoKey.BUSINESS_HOURS));
	item.setTel(mr.getParameter(TripinfoKey.TEL));
	item.setHomepage(mr.getParameter(TripinfoKey.HOMEPAGE));
	item.setNaver(mr.getParameter(TripinfoKey.NAVER));
	item.setSns(mr.getParameter(TripinfoKey.SNS));
	return item;
}
}
