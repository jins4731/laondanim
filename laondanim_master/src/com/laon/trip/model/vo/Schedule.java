package com.laon.trip.model.vo;

public class Schedule {
	private String tripinfoNo;
	private String days;
	private String orders;
	private String requiredHours;
	private String transport;
	
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}


	public Schedule(String tripinfoNo, String days, String orders, String requiredHours, String transport) {
		super();
		this.tripinfoNo = tripinfoNo;
		this.days = days;
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


	public String getDays() {
		return days;
	}


	public void setDays(String days) {
		this.days = days;
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
		return "Schedule [tripinfoNo=" + tripinfoNo + ", days=" + days + ", orders=" + orders + ", requiredHours="
				+ requiredHours + ", transport=" + transport + "]";
	}


	
	
	
}
