package com.laon.trip.model.vo;

import java.util.Arrays;

public class TagCount {

	private int tripNo;
	private String[] tag;
	
	private int tagCount;
	
	public TagCount() {
		// TODO Auto-generated constructor stub
	}

	public TagCount(int tripNo, String[] tag, int tagCount) {
		super();
		this.tripNo = tripNo;
		this.tag = tag;
		this.tagCount = tagCount;
	}

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}

	public int getTagCount() {
		return tagCount;
	}

	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}

	@Override
	public String toString() {
		return "TagCount [tripNo=" + tripNo + ", tag=" + Arrays.toString(tag) + ", tagCount=" + tagCount + "]";
	}

	
	
}
