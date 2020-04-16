package com.laon.trip.model.vo;

public class Schedule {
	private String tripinfoNo;
	private String day;
	private String orders;
	private String requiredHours;
	private String transport;
	
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}


	public Schedule(String tripinfoNo, String day, String orders, String requiredHours, String transport) {
		super();
		this.tripinfoNo = tripinfoNo;
		this.day = day;
		this.orders = orders;
		this.requiredHours = requiredHours;
		this.transport = transport;
	}


	public String getTripinfoNo() {
		return tripinfoNo;
	}


	public void setTripinfoNo(String tripinfoNo) {
		this.tripinfoNo = tripinfoNo;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getOrders() {
		return orders;
	}


	public void setOrders(String orders) {
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


	@Override
	public String toString() {
		return "Schedule [tripinfoNo=" + tripinfoNo + ", day=" + day + ", orders=" + orders + ", requiredHours="
				+ requiredHours + ", transport=" + transport + "]";
	}
	
	
}
