package com.laon.trip.model.service;

import static com.laon.common.template.JDBCTemplate.*;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.laon.etc.model.dao.EtcDao;
import com.laon.etc.model.vo.Mind;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripData;
import com.laon.trip.model.vo.TripSchedule;
import com.laon.tripinfo.model.vo.Tripinfo;
import com.laon.user.model.dao.UserDao;
import com.laon.user.model.vo.User;

public class TripService {
private TripDao tripDao = new TripDao();
private EtcDao etcDao = new EtcDao();
private UserDao userDao = new UserDao();
	public Trip selectTripViewAllData(String no) {
		Connection conn = getConnection();
		Trip trip = tripDao.selectTrip(conn, no);  // trip 가져오고
		User user = userDao.selectUser(conn, trip.getUserNo());
		List<Picture> userPicList = etcDao.selectPictureListUserNo(conn,user.getNo()); //사진 가져오고
		user.setPictureList(userPicList); // user에 사진 넣고
		trip.setUser(user); // trip에 user 넣고
		List<Picture> tripPicList = etcDao.selectPictureListTripNo(conn,trip.getNo()); //사진 가져오고
		trip.setPictureList(tripPicList);  // trip에다가 사진넣고

		List<TripSchedule> scheduleList = tripDao.selectTripScheduleList(conn,trip.getNo()); // 스케쥴 목록 가져오고
		List<Integer> tripinfoNoList = new ArrayList();
		for (TripSchedule tripSchedule : scheduleList) {
			tripinfoNoList.add(tripSchedule.getTripinfoNo());
		}
		
		List<Tripinfo> tripinfoList = tripDao.selectTripinfoWhereNoIn(conn,tripinfoNoList); // 스케쥴 목록과 일치되는 여행정보 목록 가져오고
		List<Picture> pictureList = etcDao.selectPictureWhereNoIn(conn, tripinfoNoList,"TRIPINFO_NO" ); //여행정보 목록과 일치하는 사진목록 가져오고
		for (Tripinfo tripinfo : tripinfoList) { // 여행정보 목록에 사진 목록 넣고
			for (Picture picture : pictureList) {
				if (tripinfo.getNo() == picture.getTripinfoNo()) {
					tripinfo.getPictureList().add(picture);
				}
			}
		}
		for (TripSchedule schedule : scheduleList) {
			for (Tripinfo tripinfo : tripinfoList) {
				if(schedule.getTripinfoNo() == tripinfo.getNo() ) {
					schedule.setTripinfo(tripinfo);
				}
			}
		}
		trip.setTripScheduleList(scheduleList);
		close(conn);
		return trip;
	}
	
//	public Trip selectTrip(String no) {
//		Connection conn = getConnection();
//		Trip trip = tripDao.selectTrip(conn, no);  // trip 가져오고
////		trip.setPicture(pic);  // trip에다가 사진넣고
//		close(conn);
//		return trip;
//	}
	
	public List<Trip> selectTripPage(int start,int end){
		Connection conn = getConnection();
		List<Trip> list = tripDao.selectTripPage(conn, start ,end);
		close(conn);
		return list;
	}

	public int selectTripCount() {
		Connection conn = getConnection();
		int result = tripDao.selectTripCount(conn);
		close(conn);
		return result;
	}

//	public List<TripSchedule> selectTripScheduleList(int no) {
//		// TODO Auto-generated method stub
//		Connection conn = getConnection();
//		List<TripSchedule> schedulelist = tripDao.selectTripScheduleList(conn,no);
//		close(conn);
//		return schedulelist;
//	}

	public List<Tripinfo> selectTripinfoWhereNoIn(List<Integer> tripinfoNoList) {
		Connection conn = getConnection();
		List<Tripinfo> list = tripDao.selectTripinfoWhereNoIn(conn, tripinfoNoList);
		close(conn);
		return list;
	}

	public List<Tripinfo> selectZzimList(String userNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		List<Mind> mindList = etcDao.selectMindListUserNo(conn,userNo);
		List<Integer> tripinfoNoList = new ArrayList();
		for (Mind mind : mindList) {
			tripinfoNoList.add(mind.getTripinfoNo());
		}
		List<Tripinfo> tripinfoList = tripDao.selectTripinfoWhereNoIn(conn,tripinfoNoList);
		close(conn);
		return tripinfoList;
	}

	public List<Tripinfo> selectTripinfoList() {
		Connection conn = getConnection();
		List<Tripinfo> tripinfoList = tripDao.selectTripinfoList(conn);
		List<Integer> tripinfoNoList = new ArrayList();
		for (Tripinfo tripinfo : tripinfoList) {
			tripinfoNoList.add(tripinfo.getNo());
		}
		List<Picture> picList = etcDao.selectPictureWhereNoIn(conn, tripinfoNoList, "tripinfo_no");
		for (Tripinfo tripinfo : tripinfoList) {
			
			List<Picture> list = new ArrayList();
			for (Picture picture : picList) {
				if(tripinfo.getNo() == picture.getTripinfoNo()) {
					list.add(picture);
				}
			}
			tripinfo.setPictureList(list);
		}
		
		close(conn);
		return tripinfoList;
	}

	public boolean insertTrip(TripData data) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = tripDao.insertTrip(conn,data);
		int scheduleResult[] = {};
		boolean isGood = false;
		if(result>0) {
			int tripNo = tripDao.selectTripLastSeq(conn);
			scheduleResult = tripDao.insertTripSchedule(conn,data,1);
			
			for (int i = 0; i < scheduleResult.length; i++) {
				System.out.println("scheduleResult[i] : " + scheduleResult[i]);
				if(scheduleResult[i] >= 0 || scheduleResult[i] == -2) {
					
				}else {
					isGood = false;
				}
			}
			if(isGood) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		
		
		return isGood;
	}
	
}
