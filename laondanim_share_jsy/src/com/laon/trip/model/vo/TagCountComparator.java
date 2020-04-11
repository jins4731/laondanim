package com.laon.trip.model.vo;

import java.util.Comparator;

public class TagCountComparator implements Comparator<TagCount>{

	@Override
	public int compare(TagCount first, TagCount second) {
		// TODO Auto-generated method stub
		int firstValue = first.getTagCount();
		int secondValue = second.getTagCount();
		
		if(firstValue>secondValue) {
			return -1;
		} else if(firstValue<secondValue) {
			return 1;
		}else {
			return 0;
		}
	}

}
