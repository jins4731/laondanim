package com.laon.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.laon.trip.model.service.TripService2;
import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.TagCountComparator;
import com.laon.trip.model.vo.Trip2;
import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;

public class TagFilter {

	public ArrayList<TagCount> tagCountList(String userTag){
		
		//userTag = userTag.replaceAll(" ", "");
		System.out.println("로그인한 유저 tag : " + userTag);
		
		ArrayList<Trip2> tagList = new TripService2().selectTagList();	//��� ����� �Խù��� ���� �±� ������ �±� ����Ʈ�� ����
				
		String[] userTagArr = userTag.split(",");	//�α����� ������ tag String �� �迭�� �ɰ���
		
		ArrayList<TagCount> tripTagCountList = new ArrayList<TagCount>();
		
		int cnt = 0;
		
		TagCount tagCount = null;
		
		//����� �Խù� ��ȣ, �±�(�迭) �� tagListArr ����Ʈ�� ����
		for(Trip2 t : tagList) {	
			int tripNo = t.getNo();
			
			String stringTag = t.getTag();
			
			tagCount = new TagCount();
			
			tagCount.setNo(t.getNo());
			tagCount.setUserTbNo(t.getUserTbNo());
			tagCount.setCategory(t.getCategory());
			tagCount.setWriteDate(t.getWriteDate());
			tagCount.setTag(t.getTag().split(",")); //��� ����� �Խù��� tag String �� �迭�� �ɰ��� ����Ʈ�� ����
			tagCount.setTitle(t.getTitle());
			tagCount.setContent(t.getContent());
			tagCount.setTripLocate(t.getTripLocate());
			tagCount.setPeopleNum(t.getPeopleNum());
			tagCount.setTripType(t.getTripType());
			tagCount.setStartDate(t.getStartDate());
			tagCount.setPublicEnabled(t.getPublicEnabled());
			tagCount.setDeleted(t.getDeleted());
			
			tripTagCountList.add(tagCount);
		}
		
		for(TagCount t : tripTagCountList) {	//Tag ��ġ�� ī��Ʈ ����
			for(String u : userTagArr) {
				if(Arrays.asList(t.getTag()).contains(u)) {	//�迭�� �� ���� Ȯ��
					t.setTagCount(t.getTagCount()+1);
				}
			}
		}
		
		//���� �������̽� Ŭ���� ��ü ����
		TagCountComparator tcc = new TagCountComparator();
		
		System.out.println("====정렬 전====");
		
		for(TagCount t : tripTagCountList) {
			System.out.println(t);
		}
		
		//����
		Collections.sort(tripTagCountList, tcc);
		
		System.out.println("====정렬 후====");
		
		for(TagCount t : tripTagCountList) {
			System.out.println(t);
		}
		
		return tripTagCountList;
	}
}
