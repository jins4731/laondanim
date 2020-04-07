package com.laon.etc.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.laon.etc.model.dao.EtcDao;
import com.laon.etc.model.vo.Like;

public class EtcService {
	private EtcDao dao = new EtcDao();

	

	public List<Like> selectLikeList() {
		Connection conn = getConnection();
		List<Like> list = dao.selectLikeList(conn);
		close(conn);
		return list;
	}


}
