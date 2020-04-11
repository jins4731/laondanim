package com.laon.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.TagCountComparator;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.service.TripService;
import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;

public class TagFilter {

	public ArrayList<TagCount> tagCountList(String userTag){
		System.out.println("로그인한 유저의 tag : " + userTag);
		
		ArrayList<Trip> tagList = new TripService().selectTagList();	//모든 여행기 게시물에 대한 태그 정보를 태그 리스트에 저장
				
		String[] userTagArr = userTag.split(",");	//로그인한 유저의 tag String 을 배열로 쪼개기
		
		ArrayList<TagCount> tripTagCountList = new ArrayList<TagCount>();
		
		int cnt = 0;
		
		TagCount tagCount = null;
		
		
		//여행기 게시물 번호, 태그(배열) 로 tagListArr 리스트에 저장
		for(Trip t : tagList) {	
			int tripNo = t.getNo();
			String stringTag = t.getTag();
			
			tagCount = new TagCount();
			
			tagCount.setTripNo(tripNo);
			tagCount.setTag(stringTag.split(",")); //모든 여행기 게시물의 tag String 을 배열로 쪼개서 리스트에 저장
			
			tripTagCountList.add(tagCount);
		}
		
		for(TagCount t : tripTagCountList) {	//Tag 일치 카운트 
			for(String u : userTagArr) {
				if(Arrays.asList(t.getTag()).contains(u)) {	//배열에 값 포함 확인
					t.setTagCount(t.getTagCount()+1);
				}
			}
		}
		
		//정렬 인터페이스 클래스 객체 생성
		TagCountComparator tcc = new TagCountComparator();
		
		System.out.println("====정렬 전 확인====");
		
		for(TagCount t : tripTagCountList) {
			System.out.println(t);
		}
		
		//정렬
		Collections.sort(tripTagCountList, tcc);
		
		System.out.println("====정렬 확인====");
		
		for(TagCount t : tripTagCountList) {
			System.out.println(t);
		}
		
		return tripTagCountList;
	}
}
