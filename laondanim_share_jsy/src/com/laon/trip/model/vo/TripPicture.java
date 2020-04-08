package com.laon.trip.model.vo;

public class TripPicture {

	private int no;
	private int TRIP_NO;
	private String image;
	
	public TripPicture() {
		// TODO Auto-generated constructor stub
	}

	public TripPicture(int no, int tRIP_NO, String image) {
		super();
		this.no = no;
		TRIP_NO = tRIP_NO;
		this.image = image;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getTRIP_NO() {
		return TRIP_NO;
	}

	public void setTRIP_NO(int tRIP_NO) {
		TRIP_NO = tRIP_NO;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
