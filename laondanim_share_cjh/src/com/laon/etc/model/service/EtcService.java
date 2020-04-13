package com.laon.etc.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.etc.model.dao.EtcDao;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;

public class EtcService {
	private EtcDao dao = new EtcDao();

	

	public List<Like> selectLikeList() {
		Connection conn = getConnection();
		List<Like> list = dao.selectLikeList(conn);
		close(conn);
		return list;
	}



	public List<Picture> selectPictureUserNo(int no) {
		Connection conn = getConnection();
		List<Picture> picList = dao.selectPictureListUserNo(conn,no);
		close(conn);
		return picList;
	}


}
