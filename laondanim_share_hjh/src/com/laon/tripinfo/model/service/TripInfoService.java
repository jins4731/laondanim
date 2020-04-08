package com.laon.tripinfo.model.service;

import static com.laon.common.JDBCTemplate.close;
import static com.laon.common.JDBCTemplate.commit;
import static com.laon.common.JDBCTemplate.getConnection;
import static com.laon.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.laon.tripinfo.model.dao.TripInfoDao;
import com.laon.tripinfo.model.vo.TripInfo;
import com.laon.tripinfo.model.vo.TripInfoComment;

public class TripInfoService {
	
	private  TripInfoDao dao=new TripInfoDao();
	
	public List<TripInfo> selectTripinfoList(int cPage,int numPerPage ,String category , String key,String type){
		
		Connection conn=getConnection();
		
		List<TripInfo> list=dao.selectTripinfoList(conn,cPage,numPerPage,category,key,type);
		close(conn);
		
		return list;
	}
	
	public int selectCountTripInfo(String category,String key,String type) {
		
		Connection conn=getConnection();
		int count=dao.selectCountTripInfo(conn,category,key,type);
		close(conn);
		return count;
	}
	

	
	
	
	 

}
