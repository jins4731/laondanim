package com.laon.trip.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;

public class TripData implements LaonRobot<TripData>{
	private String userNo;
	private String category;
	private String tag;
	private String title;
	private String content;
	private String travleLocale;
	private String peopleNum;
	private String travleTyp;
	private String travleStartDate;
	private String travleEndDate;
	private String publicEnabled;
	private String deleted;
	private Day[] scheduleData;

	public TripData() {
		// TODO Auto-generated constructor stub
	}

	public TripData(String userNo, String category, String tag, String title, String content, String travleLocale,
			String peopleNum, String travleTyp, String travleStartDate, String travleEndDate, String publicEnabled,
			String deleted, Day[] scheduleData) {
		super();
		this.userNo = userNo;
		this.category = category;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.travleLocale = travleLocale;
		this.peopleNum = peopleNum;
		this.travleTyp = travleTyp;
		this.travleStartDate = travleStartDate;
		this.travleEndDate = travleEndDate;
		this.publicEnabled = publicEnabled;
		this.deleted = deleted;
		this.scheduleData = scheduleData;
	}

	@Override
	public String toString() {
		return "TripData [userNo=" + userNo + ", category=" + category + ", tag=" + tag + ", title=" + title
				+ ", content=" + content + ", travleLocale=" + travleLocale + ", peopleNum=" + peopleNum
				+ ", travleTyp=" + travleTyp + ", travleStartDate=" + travleStartDate + ", travleEndDate="
				+ travleEndDate + ", publicEnabled=" + publicEnabled + ", deleted=" + deleted + ", scheduleData="
				+ Arrays.toString(scheduleData) + "]";
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
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

	public String getTravleLocale() {
		return travleLocale;
	}

	public void setTravleLocale(String travleLocale) {
		this.travleLocale = travleLocale;
	}

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getTravleTyp() {
		return travleTyp;
	}

	public void setTravleTyp(String travleTyp) {
		this.travleTyp = travleTyp;
	}

	public String getTravleStartDate() {
		return travleStartDate;
	}

	public void setTravleStartDate(String travleStartDate) {
		this.travleStartDate = travleStartDate;
	}

	public String getTravleEndDate() {
		return travleEndDate;
	}

	public void setTravleEndDate(String travleEndDate) {
		this.travleEndDate = travleEndDate;
	}

	public String getPublicEnabled() {
		return publicEnabled;
	}

	public void setPublicEnabled(String publicEnabled) {
		this.publicEnabled = publicEnabled;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Day[] getScheduleData() {
		return scheduleData;
	}

	public void setScheduleData(Day[] scheduleData) {
		this.scheduleData = scheduleData;
	}

	@Override
	public List<TripData> rsProcess(List<TripData> list, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TripData rsProcess(TripData item, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TripData mrProcess(TripData item, MultipartRequest mr, List<Picture> picList) {
		String tripData = mr.getParameter("tripData");
		System.out.println("tripData : " + tripData);
		
		Gson g = new Gson();
		item = g.fromJson(tripData, TripData.class);
		System.out.println("item : " + item);
		
		
		return item;
	}
	
	
	
}
