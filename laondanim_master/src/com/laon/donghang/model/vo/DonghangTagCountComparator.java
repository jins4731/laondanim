package com.laon.donghang.model.vo;

import java.util.Comparator;

public class DonghangTagCountComparator implements Comparator<DonghangTagCount>{

	@Override
	public int compare(DonghangTagCount first, DonghangTagCount second) {
		// TODO Auto-generated method stub
		
		int firstValue = first.getTagCount();
		int secondValue = second.getTagCount();
		
		if(firstValue>secondValue) {
			return -1;
		}else if(firstValue<secondValue) {
			return 1;
		}else {
			return 0;
		}
	}

}
