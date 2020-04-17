package com.laon.tripinfo.model.vo;

import java.util.Comparator;

public class InfoTagCountComparator implements Comparator<InfoTagCount>{

	@Override
	public int compare(InfoTagCount o1, InfoTagCount o2) {
		// TODO Auto-generated method stub
		int firstValue = o1.getTagCount();
		int secondValue = o2.getTagCount();
		
		if(firstValue>secondValue) {
			return -1;
		}else if(firstValue<secondValue) {
			return 1;
		}else {
			return 0;
		}
	}

	
}
