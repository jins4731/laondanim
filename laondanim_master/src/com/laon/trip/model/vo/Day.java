package com.laon.trip.model.vo;

import java.util.Arrays;
import java.util.List;

public class Day {
	private String no;
	private Schedule[] scheduleList;
	
	
	public Day() {
		// TODO Auto-generated constructor stub
	}


	public Day(String no, Schedule[] scheduleList) {
		super();
		this.no = no;
		this.scheduleList = scheduleList;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public Schedule[] getScheduleList() {
		return scheduleList;
	}


	public void setScheduleList(Schedule[] scheduleList) {
		this.scheduleList = scheduleList;
	}


	@Override
	public String toString() {
		return "Day [no=" + no + ", scheduleList=" + Arrays.toString(scheduleList) + "]";
	}
	
	
	
}
