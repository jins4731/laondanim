package com.laon.trip.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.laon.common.CommonKey;
import com.laon.etc.model.dao.EtcDao;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.dao.TripDao;
import com.laon.trip.model.vo.Trip;
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
		Trip trip = tripDao.selectTrip(conn, no);  // trip ��������
		User user = userDao.selectUser(conn, trip.getUserNo());
		List<Picture> userPicList = etcDao.selectPictureListUserNo(conn,user.getNo()); //���� ��������
		user.setPictureList(userPicList); // user�� ���� �ְ�
		trip.setUser(user); // trip�� user �ְ�
		List<Picture> tripPicList = etcDao.selectPictureListTripNo(conn,trip.getNo()); //���� ��������
		trip.setPictureList(tripPicList);  // trip���ٰ� �����ְ�

		List<TripSchedule> scheduleList = tripDao.selectTripScheduleList(conn,trip.getNo()); // ������ ��� ��������
		List<Integer> tripinfoNoList = new ArrayList();
		for (TripSchedule tripSchedule : scheduleList) {
			tripinfoNoList.add(tripSchedule.getTripinfoNo());
		}
		
		List<Tripinfo> tripinfoList = tripDao.selectTripinfoWhereNoIn(conn,tripinfoNoList); // ������ ��ϰ� ��ġ�Ǵ� �������� ��� ��������
		List<Picture> pictureList = etcDao.selectPictureWhereNoIn(conn, tripinfoNoList,"TRIPINFO_NO" ); //�������� ��ϰ� ��ġ�ϴ� ������� ��������
		for (Tripinfo tripinfo : tripinfoList) { // �������� ��Ͽ� ���� ��� �ְ�
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
//		Trip trip = tripDao.selectTrip(conn, no);  // trip ��������
////		trip.setPicture(pic);  // trip���ٰ� �����ְ�
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
	
}
