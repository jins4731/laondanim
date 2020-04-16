package com.laon.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangTagCount;
import com.laon.donghang.model.vo.DonghangTagCountComparator;
import com.laon.trip.model.service.TripService2;
import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.TagCountComparator;
import com.laon.trip.model.vo.Trip2;

public class TagFilter {

	public ArrayList<TagCount> tagCountList(String userTag){
		
		//userTag = userTag.replaceAll(" ", "");
		System.out.println("로그인한 유저 tag : " + userTag);
		
		ArrayList<Trip2> tagList = new TripService2().selectTagList();	//여행기 정보 다 가져오기 
				
		String[] userTagArr = userTag.split(",");	//로그인한 유저의 tag String을 배열로 쪼개기
		
		ArrayList<TagCount> tripTagCountList = new ArrayList<TagCount>();	//
		
		int cnt = 0;
		
		TagCount tagCount = null;
		
		//모든 여행기 정보(tagList) 의 tag String을 tag String 배열로 바꿔주고 새로운 tagCount vo에 저장 하고 리스트 생성
		for(Trip2 t : tagList) {	
			int tripNo = t.getNo();
			
			String stringTag = t.getTag();
			
			tagCount = new TagCount();
			
			tagCount.setNo(t.getNo());
			tagCount.setUserTbNo(t.getUserTbNo());
			tagCount.setCategory(t.getCategory());
			tagCount.setWriteDate(t.getWriteDate());
			tagCount.setTag(t.getTag().split(",")); //태그 배열로 쪼개기
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
				if(t.getTripLocate().equals(u)) {
					t.setTagCount(t.getTagCount()+1);
				}
			}
		}
		
		//���� �������̽� Ŭ���� ��ü ����
		TagCountComparator tcc = new TagCountComparator();
		
//		System.out.println("====정렬 전====");
//		
//		for(TagCount t : tripTagCountList) {
//			System.out.println(t);
//		}
//		
//		//����
		Collections.sort(tripTagCountList, tcc);
//		
//		System.out.println("====정렬 후====");
//		
//		for(TagCount t : tripTagCountList) {
//			System.out.println(t);
//		}
		
		return tripTagCountList;
	}
	
	public ArrayList<DonghangTagCount> donghangTagCountList(String userTag){
		//1. 로그인한 유저의 태그 가져오기
		String[] userTagArr = userTag.split(",");
		
		//2. 동행 정보 다 가져오기
		ArrayList<Donghang> dongHangList = new DonghangService().selectDonghangAll();
	
		//3. 모든 동행 정보(donghangList) 의 tag String을 tag String 배열로 바꿔주고 
		//새로운 tagCount vo에 저장 하고 리스트 생성
		DonghangTagCount tagCount = null;
		ArrayList<DonghangTagCount> countList = new ArrayList<DonghangTagCount>();
		
		for(Donghang d : dongHangList) {
			tagCount = new DonghangTagCount();
			
			tagCount.setNo(d.getNo());
			tagCount.setUserNo(d.getUserNo());
			tagCount.setTripNo(d.getTripNo());
			tagCount.setWriteDate(d.getWriteDate());
			tagCount.setTag(d.getTag().split(","));
			tagCount.setTitle(d.getTitle());
			tagCount.setContent(d.getContent());
			tagCount.setTravleLocale(d.getTravleLocale());
			tagCount.setTravleStartDate(d.getTravleStartDate());
			tagCount.setTravleEndDate(d.getTravleEndDate());
			tagCount.setPw(d.getPw());
			tagCount.setPublicEnabled(d.getPublicEnabled());
			tagCount.setEnded(d.getEnded());
			tagCount.setDeleted(d.getDeleted());
			tagCount.setRecruitPeopleNo(d.getRecruitPeopleNo());
			tagCount.setJoinPeopleNo(d.getJoinPeopleNo());
			
			countList.add(tagCount);
		}
		
		for(DonghangTagCount t : countList) {	//Tag ��ġ�� ī��Ʈ ����
			for(String u : userTagArr) {
				if(Arrays.asList(t.getTag()).contains(u)) {	//�迭�� �� ���� Ȯ��
					t.setTagCount(t.getTagCount()+1);
				}
				if(t.getTravleLocale().equals(u)) {
					t.setTagCount(t.getTagCount()+1);
				}
			}
		}
		
		DonghangTagCountComparator tcc = new DonghangTagCountComparator();
		
//		System.out.println("====정렬 전====");
//		
//		for(DonghangTagCount t : countList) {
//			System.out.println(t);
//		}
//		
//		//����
//		Collections.sort(countList, tcc);
//		
//		System.out.println("====정렬 후====");
//		
//		for(DonghangTagCount t : countList) {
//			System.out.println(t);
//		}
		
		return countList;
	}
	
}
