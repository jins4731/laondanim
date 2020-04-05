package com.laon.trip.model.vo;

//여행 일정 테이블
public class TripSchedule {

 // 넘버 여행기 일정 기본키
 private int no;

 // 여행기 테이블 넘버 여행기 참조키
 private int tripNo;

 // 여행정보 테이블 넘버 여행정보 참조키
 private int tripinfoNo;

 // 일차 일차
 private int day;

 // 순서 일정 순서
 private int orders;

 // 소요 시간 이동 소요 시간
 private String requiredHours;

 // 교통수단 교통 수단
 private String transport;
 
 public TripSchedule() {
	// TODO Auto-generated constructor stub
}
 
 






 public TripSchedule(int no, int tripNo, int tripinfoNo, int day, int orders, String requiredHours, String transport) {
	super();
	this.no = no;
	this.tripNo = tripNo;
	this.tripinfoNo = tripinfoNo;
	this.day = day;
	this.orders = orders;
	this.requiredHours = requiredHours;
	this.transport = transport;
}








@Override
public String toString() {
	return "TripSchedule [no=" + no + ", tripNo=" + tripNo + ", tripinfoNo=" + tripinfoNo + ", day=" + day + ", orders="
			+ orders + ", requiredHours=" + requiredHours + ", transport=" + transport + "]";
}








public int getNo() {
	return no;
}








public void setNo(int no) {
	this.no = no;
}








public int getTripNo() {
	return tripNo;
}








public void setTripNo(int tripNo) {
	this.tripNo = tripNo;
}








public int getTripinfoNo() {
	return tripinfoNo;
}








public void setTripinfoNo(int tripinfoNo) {
	this.tripinfoNo = tripinfoNo;
}








public int getDay() {
	return day;
}








public void setDay(int day) {
	this.day = day;
}








public int getOrders() {
	return orders;
}








public void setOrders(int orders) {
	this.orders = orders;
}








public String getRequiredHours() {
	return requiredHours;
}








public void setRequiredHours(String requiredHours) {
	this.requiredHours = requiredHours;
}








public String getTransport() {
	return transport;
}








public void setTransport(String transport) {
	this.transport = transport;
}








// TripScheduleTb 모델 복사
 public void CopyData(TripSchedule param)
 {
     this.no = param.getNo();
     this.tripNo = param.getTripNo();
     this.tripinfoNo = param.getTripinfoNo();
     this.day = param.getDay();
     this.orders = param.getOrders();
     this.requiredHours = param.getRequiredHours();
     this.transport = param.getTransport();
 }
}
