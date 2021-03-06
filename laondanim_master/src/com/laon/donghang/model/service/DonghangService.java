package com.laon.donghang.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.getConnection;
import static com.laon.common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.laon.admin.model.vo.Reports;
import com.laon.donghang.model.dao.DonghangDao;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.donghang.model.vo.DonghangJoinDonghangJoinTb;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.User;
import com.laon.user.model.vo.UserProfile;

public class DonghangService {
	private DonghangDao dao = new DonghangDao();
	
	public Donghang selectDonghang(String no) {
		Connection conn = getConnection();
		Donghang donghang = dao.selectDonghang(conn, no);
		close(conn);
		return donghang;
	}
	
	public List<DonghangJoinUserPicture> selectDonghangPage(int start,int end, String keyword, String recent, String viewcount, String nearSchedule, String searchFilter){
		Connection conn = getConnection();
		List<DonghangJoinUserPicture> list = dao.selectDonghangPage(conn, start ,end, keyword, recent, viewcount, nearSchedule, searchFilter);
		close(conn);
		return list;
	}

	public int selectDonghangCount() {
		Connection conn = getConnection();
		int result = dao.selectDonghangCount(conn);
		close(conn);
		return result;
	}
	
	public int selectDonghangCount(String keyword, String searchFilter) {
		Connection conn = getConnection();
		int result = dao.selectDonghangCount(conn, keyword, searchFilter);
		close(conn);
		return result;
	}

	public List<DonghangJoinUserPicture> selectDonghangTag(int start, int end, String userTag) {
		Connection conn = getConnection();
		List<DonghangJoinUserPicture> list = dao.selectDonghangTag(conn, start ,end, userTag);
		close(conn);
		return list;
	}

	public DonghangJoinUserPicture selectDonghangView(int no, boolean hasRead) {
		Connection conn = getConnection();
		DonghangJoinUserPicture donghangItem = dao.selectDonghangView(conn, no);

		if(!hasRead && donghangItem!=null) {
			int result = dao.updateViewCount(conn, no);
			if(result>0) {
				commit(conn);
				donghangItem.setViewcount(dao.selectDonghangView(conn, no).getViewcount());
			}else {
				rollback(conn);
			}
			
		}
		close(conn);
		return donghangItem;
	}

	public List<UserProfile> selectDonghangJoinMember(int no) {
		Connection conn = getConnection();
		List<UserProfile> joinList = dao.selectDonghangJoinMember(conn, no);
		close(conn);
		return joinList;
	}

	public List<TripMyCon> selectMyTripList(int no) {
		Connection conn = getConnection();
		List<TripMyCon> list = dao.selectMyTripList(conn, no);
		close(conn);
		return list;
	}

	public List<Like> selectLike(List<TripMyCon> list) {
		Connection conn = getConnection();
		List<Like> likeList = dao.selectLike(conn, list);
		close(conn);
		return likeList;
	}

	public int insertDonghaong(Donghang donghang) {
		Connection conn = getConnection();
		int result = dao.insertDonghaong(conn, donghang);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		return result;
	}

	public int selectDonghangSeqNextVal(int userNo, String title) {
		Connection conn = getConnection();
		int nextVal = dao.selectDonghangSeqNextVal(conn, userNo, title);
		close(conn);
		return nextVal;
	}

	public int insertPicture(Picture pic) {
		Connection conn = getConnection();
		int result = dao.insertPicture(conn, pic);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		
		return result;
	}

	public int deleteDonghang(int no) {
		Connection conn = getConnection();
		int result = dao.deleteDonghang(conn, no);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		return result;
	}

	public DonghangJoinUserPicture selectDonghangJoinUserPicture(String no) {
		Connection conn = getConnection();
		DonghangJoinUserPicture donghang = dao.selectDonghangJoinUserPicture(conn, no);
		close(conn);
		return donghang;
	}

	public int updateDonghaong(Donghang donghang) {
		Connection conn = getConnection();
		int result = dao.updateDonghaong(conn, donghang);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		return result;
	}

	public int updatePicture(Picture pic) {
		Connection conn = getConnection();
		int result = dao.updatePicture(conn, pic);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		
		return result;
	}

	public int donghangJoin(DonghangJoin join) {
		Connection conn = getConnection();

		int result = dao.donghangJoin(conn, join);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		
		return result;
	}

	public DonghangJoin selectUserDonghangJoin(int no, int loginUserNo) {
		Connection conn = getConnection();
		DonghangJoin userJoinTb = dao.selectUserDonghangJoin(conn, no, loginUserNo);
		close(conn);
		return userJoinTb;
	}

	public List<Donghang> selectDonghangList(int userNo) {
		Connection conn = getConnection();
		List<Donghang> list = dao.selectDonghangList(conn, userNo);
		close(conn);
		return list;
	}

	public List<DonghangJoinDonghangJoinTb> selectDonghangJoinList(int loginUserNo, int no, String filter) {
		Connection conn = getConnection();
		List<DonghangJoinDonghangJoinTb> list = dao.selectDonghangJoinList(conn, loginUserNo, no, filter);
		close(conn);
		return list;
	}

	public List<UserProfile> selectUserProfileAll() {
		Connection conn = getConnection();
		List<UserProfile> list = dao.selectUserProfileAll(conn);
		close(conn);
		return list;
	}

	public int selectJoinCount(int userNo, int no) {
		Connection conn = getConnection();
		int result = dao.selectJoinCount(conn, userNo, no);
		close(conn);
		return result;
	}
	
	//by 승연
	public ArrayList<Donghang> selectDonghangAll(){
		Connection conn = getConnection();
		ArrayList<Donghang> donghangList = dao.selectDonghangAll(conn);
		close(conn);
		return donghangList;
	}
	
	public ArrayList<Picture> selectPicture(ArrayList<Donghang> donghangList){
		Connection conn = getConnection();
		ArrayList<Picture> pictureList = dao.selectPicture(conn, donghangList);
		close(conn);
		return pictureList;
	}
	
	public ArrayList<User> selectUser(ArrayList<Donghang> donghangList){
		Connection conn = getConnection();
		ArrayList<User> userList = dao.selectUser(conn, donghangList);
		close(conn);
		return userList;
	}

	public int joinComfirmedUpdate(String confirmedValue, int joinNo, int dhNo) {
		Connection conn = getConnection();
		int result = dao.joinComfirmedUpdate(conn, confirmedValue, joinNo, dhNo);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		
		return result;
	}

	public int donghangJoinPlus(int dhNo) {
		Connection conn = getConnection();
		int result = dao.donghangJoinPlus(conn, dhNo);
		if(result>0) {
			commit(conn);
		} else rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int insertReport(Reports re) {
		Connection conn=getConnection();
		int result=dao.insertReport(conn,re);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}




}
