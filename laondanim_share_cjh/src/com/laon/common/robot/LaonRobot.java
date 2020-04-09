package com.laon.common.robot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;

public interface LaonRobot<E> {
	abstract public List<E> rsProcess(List<E>list, ResultSet rs) throws SQLException;
	abstract public E rsProcess(E item, ResultSet rs) throws SQLException;
	abstract public E mrProcess(E item, MultipartRequest mr, Picture pic);
}
