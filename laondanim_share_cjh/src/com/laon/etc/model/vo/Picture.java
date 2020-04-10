package com.laon.etc.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laon.common.PictureKey;
import com.laon.common.robot.LaonRobot;
import com.oreilly.servlet.MultipartRequest;

public class Picture implements LaonRobot<Picture>{

    // 넘버 사진 기본키
    private int no;

    // 여행기 테이블 넘버 여행기 참조키
    private int tripNo;

    // 여행정보 테이블 넘버 여행정보 참조키
    private int tripinfoNo;

    // 동행 테이블 넘버 동행 참조키
    private int donghangNo;

    // 유저 테이블 넘버 회원 참조키
    private int userNo;

    // 사진 사진
    private String image;
    
    
    public Picture() {
		// TODO Auto-generated constructor stub
	}
    
    




	
    
    public Picture(int no, int tripNo, int tripinfoNo, int donghangNo, int userNo, String image) {
		super();
		this.no = no;
		this.tripNo = tripNo;
		this.tripinfoNo = tripinfoNo;
		this.donghangNo = donghangNo;
		this.userNo = userNo;
		this.image = image;
	}








	@Override
	public String toString() {
		return "Picture [no=" + no + ", tripNo=" + tripNo + ", tripinfoNo=" + tripinfoNo + ", donghangNo=" + donghangNo
				+ ", userNo=" + userNo + ", image=" + image + "]";
	}








	public int getNo() {
		return no;
	}








	public void setNo(int no) {
		this.no = no;
	}








	public int getTripNo() {
		return tripNo;
	}








	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}








	public int getTripinfoNo() {
		return tripinfoNo;
	}








	public void setTripinfoNo(int tripinfoNo) {
		this.tripinfoNo = tripinfoNo;
	}








	public int getDonghangNo() {
		return donghangNo;
	}








	public void setDonghangNo(int donghangNo) {
		this.donghangNo = donghangNo;
	}








	public int getUserNo() {
		return userNo;
	}








	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}








	public String getImage() {
		return image;
	}








	public void setImage(String image) {
		this.image = image;
	}








	// PictureTb 모델 복사
    public void CopyData(Picture param)
    {
        this.no = param.getNo();
        this.tripNo = param.getTripNo();
        this.tripinfoNo = param.getTripinfoNo();
        this.donghangNo = param.getDonghangNo();
        this.userNo = param.getUserNo();
        this.image = param.getImage();
    }


    private String cNo = "no";
    private String cTripNo = "trip_no";
    private String cTripinfoNo = "tripinfo_no";
    private String cDonghangNo = "donghang_no";
    private String cUserNo = "user_no";
    private String cImage = "image";





	@Override
	public List<Picture> rsProcess(List<Picture> list, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while (rs.next()) {
			Picture item =  new Picture();
			item.setNo(rs.getInt(cNo));
			item.setTripNo(rs.getInt(cTripNo));
			item.setTripinfoNo(rs.getInt(cTripinfoNo));
			item.setDonghangNo(rs.getInt(cDonghangNo));
			item.setUserNo(rs.getInt(cUserNo));
			item.setImage(rs.getString(cImage));
			list.add(item);
		}
		return list;
	}








	@Override
	public Picture rsProcess(Picture item, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while (rs.next()) {
			item.setNo(rs.getInt(cNo));
			item.setTripNo(rs.getInt(cTripNo));
			item.setTripinfoNo(rs.getInt(cTripinfoNo));
			item.setDonghangNo(rs.getInt(cDonghangNo));
			item.setUserNo(rs.getInt(cUserNo));
			item.setImage(rs.getString(cImage));
		}
		return item;
	}








	@Override
	public Picture mrProcess(Picture item, MultipartRequest mr, Picture pic) {
		if(mr.getParameter(PictureKey.TRIP_NO)!=null) {
			item.setTripNo(Integer.parseInt(mr.getParameter(PictureKey.TRIP_NO)));
		} 
		if(mr.getParameter(PictureKey.TRIPINFO_NO)!=null) {
			item.setTripinfoNo(Integer.parseInt(mr.getParameter(PictureKey.TRIPINFO_NO)));
		} 
		if(mr.getParameter(PictureKey.DONGHANG_NO)!=null) {
			item.setDonghangNo(Integer.parseInt(mr.getParameter(PictureKey.DONGHANG_NO)));
		} 
		if(mr.getParameter(PictureKey.USER_NO)!=null) {
			item.setUserNo(Integer.parseInt(mr.getParameter(PictureKey.USER_NO)));
		} 
		item.setImage(mr.getOriginalFileName(PictureKey.IMAGE));
		return item;
	}
}
