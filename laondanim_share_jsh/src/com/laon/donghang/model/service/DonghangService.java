package com.laon.donghang.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.laon.donghang.model.dao.DonghangDao;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.user.model.vo.UserProfile;

public class DonghangService {
	private DonghangDao dao = new DonghangDao();
	
	public Donghang selectDonghang(String no) {
		Connection conn = getConnection();
		Donghang donghang = dao.selectDonghang(conn, no);
		close(conn);
		return donghang;
	}
	
	public List<DonghangJoinUserPicture> selectDonghangPage(int start,int end, String keyword, String recent, String viewcount, String nearSchedule){
		Connection conn = getConnection();
		List<DonghangJoinUserPicture> list = dao.selectDonghangPage(conn, start ,end, keyword, recent, viewcount, nearSchedule);
		close(conn);
		return list;
	}

	public int selectDonghangCount() {
		Connection conn = getConnection();
		int result = dao.selectDonghangCount(conn);
		close(conn);
		return result;
	}
	
	public int selectDonghangCount(String keyword) {
		Connection conn = getConnection();
		int result = dao.selectDonghangCount(conn, keyword);
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
		
		return donghangItem;
	}

	public List<UserProfile> selectDonghangJoinMember(int no) {
		Connection conn = getConnection();
		List<UserProfile> joinList = dao.selectDonghangJoinMember(conn, no);
		close(conn);
		return joinList;
	}
}
