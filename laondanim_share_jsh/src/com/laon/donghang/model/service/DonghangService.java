package com.laon.donghang.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.donghang.model.dao.DonghangDao;
import com.laon.donghang.model.vo.Donghang;

public class DonghangService {
	private DonghangDao dao = new DonghangDao();
	
	public Donghang selectDonghang(String no) {
		Connection conn = getConnection();
		Donghang donghang = dao.selectDonghang(conn, no);
		close(conn);
		return donghang;
	}
	
	public List<Donghang> selectDonghangPage(int start,int end, String userTag){
		Connection conn = getConnection();
		List<Donghang> list = dao.selectDonghangPage(conn, start ,end, userTag);
		close(conn);
		return list;
	}

	public int selectDonghangCount() {
		Connection conn = getConnection();
		int result = dao.selectDonghangCount(conn);
		close(conn);
		return result;
	}

	public String selectUserTag(String userId) {
		Connection conn = getConnection();
		String userTag = dao.selectUserTag(conn, userId);
		close(conn);
		return userTag;
	}

	public List<Donghang> selectDonghangKeyword(int start, int end, String keyword) {
		Connection conn = getConnection();
		List<Donghang> list = dao.selectDonghangKeyword(conn, start ,end, keyword);
		close(conn);
		return list;
	}

	public int selectDonghangKeywordCount(String keyword) {
		Connection conn = getConnection();
		int result = dao.selectDonghangKeywordCount(conn, keyword);
		close(conn);
		return result;
	}
}
