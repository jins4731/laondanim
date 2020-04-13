package com.laon.donghang.model.dao;

import static com.laon.common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.laon.common.PropPath; //<-com.laon.common.template.PropPath;로 되어있어 변경함
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.user.model.vo.UserProfile;

public class DonghangDao {
	private Properties prop = new Properties();

	private String no = "no";
	private String userNo = "user_no";
	private String tripNo = "trip_no";
	private String writeDate = "write_date";
	private String viewcount = "viewcount";
	private String tag = "tag";
	private String title = "title";
	private String content = "content";
	private String travleLocale = "travle_locale";
	private String travleStartDate = "travle_start_date";
	private String travleEndDate = "travle_end_date";
	private String recruitStartDate = "recruit_start_date";
	private String recruitEndDate = "recruit_end_date";
	private String pw = "pw";
	private String publicEnabled = "public_enabled";
	private String ended = "ended";
	private String deleted = "deleted";
	private String recruitPeopleNo = "recruit_people_no";
	private String joinPeopleNo = "join_people_no";
	private String nickName = "nick_Name";
	private String image = "image";

	
	
	private String selectDonghang = "selectDonghang";
	private String selectDonghangPage = "selectDonghangPage";
	private String selectDonghangCount = "selectDonghangCount";
	private String selectDonghangKeywordCount = "selectDonghangKeywordCount";
	private String selectDonghangKeywordRecent = "selectDonghangKeywordRecent";
	private String selectDonghangKeywordViewcount = "selectDonghangKeywordViewcount";
	private String selectDonghangKeywordNearSchedule = "selectDonghangKeywordNearSchedule";
	private String selectDonghangRecent = "selectDonghangRecent";
	private String selectDonghangViewcount = "selectDonghangViewcount";
	private String selectDonghangNearSchedule = "selectDonghangNearSchedule";
	private String selectDonghangView = "selectDonghangView";
	private String selectDonghangJoinMember = "selectDonghangJoinMember";
	private String selectDonghangJoinUserPicture = "selectDonghangJoinUserPicture";
	private String updateDonghaong = "updateDonghaong";

	public DonghangDao() {
		try {
			prop.load(new FileReader(DonghangDao.class.getResource(PropPath.DONGHANG).getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Donghang rsProcess(ResultSet rs, Donghang donghang) throws SQLException {
		while (rs.next()) {
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			donghang.setTripNo(rs.getInt(tripNo));
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
		}
		return donghang;
	}
	
	//join vo용 rd
	public DonghangJoinUserPicture rsProcess(ResultSet rs, DonghangJoinUserPicture donghang) throws SQLException {
		while (rs.next()) {
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			if(rs.getObject(tripNo)==null) {
				donghang.setTripNo((Integer) null);
			}else {
				donghang.setTripNo(rs.getInt(tripNo));				
			}
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
			donghang.setNickName(rs.getString(nickName));
			donghang.setImage(rs.getString(image));
		}
		return donghang;
	}
	
	
	//join vo용 rs list
	public List<DonghangJoinUserPicture> joinRsProcess(ResultSet rs, List<DonghangJoinUserPicture> list) throws SQLException {
		while (rs.next()) {
			DonghangJoinUserPicture donghang = new DonghangJoinUserPicture();
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			if(rs.getObject(tripNo)==null) {
				donghang.setTripNo((Integer) null);
			}else {
				donghang.setTripNo(rs.getInt(tripNo));				
			}
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
			donghang.setNickName(rs.getString(nickName));
			donghang.setImage(rs.getString(image));

			list.add(donghang);
		}
		return list;
	}

	public List<Donghang> rsProcess(ResultSet rs, List<Donghang> list) throws SQLException {
		while (rs.next()) {
			Donghang donghang = new Donghang();
			donghang.setNo(rs.getInt(no));
			donghang.setUserNo(rs.getInt(userNo));
			donghang.setTripNo(rs.getInt(tripNo));
			donghang.setWriteDate(rs.getDate(writeDate));
			donghang.setViewcount(rs.getInt(viewcount));
			donghang.setTag(rs.getString(tag));
			donghang.setTitle(rs.getString(title));
			donghang.setContent(rs.getString(content));
			donghang.setTravleLocale(rs.getString(travleLocale));
			donghang.setTravleStartDate(rs.getDate(travleStartDate));
			donghang.setTravleEndDate(rs.getDate(travleEndDate));
			donghang.setRecruitStartDate(rs.getDate(recruitStartDate));
			donghang.setRecruitEndDate(rs.getDate(recruitEndDate));
			donghang.setPw(rs.getInt(pw));
			donghang.setPublicEnabled(rs.getString(publicEnabled));
			donghang.setEnded(rs.getString(ended));
			donghang.setDeleted(rs.getString(deleted));
			donghang.setRecruitPeopleNo(rs.getInt(recruitPeopleNo));
			donghang.setJoinPeopleNo(rs.getInt(joinPeopleNo));
			list.add(donghang);
		}
		return list;
	}

	public Donghang selectDonghang(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghang);
		Donghang donghang = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs = pstmt.executeQuery();
			donghang = rsProcess(rs, new Donghang());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return donghang;
	}

	public DonghangJoinUserPicture selectDonghangJoinUserPicture(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghangJoinUserPicture);
		DonghangJoinUserPicture donghang = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(no));
			rs = pstmt.executeQuery();
			donghang = rsProcess(rs, new DonghangJoinUserPicture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return donghang;
	}	
	
	public List<DonghangJoinUserPicture> selectDonghangPage(Connection conn, int start, int end, String keyword, String recent, String viewcount, String nearSchedule) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		List<DonghangJoinUserPicture> list = null;
		System.out.println("strat num은?????: "+start+ "  end넘은?? : "+end);
		//sql문 나누기
		if( !keyword.equals("null") && !recent.equals("null") ) { //키워드 O, 최신순
			sql = prop.getProperty(selectDonghangKeywordRecent);
		}else if( !keyword.equals("null") && !viewcount.equals("null") ) { //키워드 O, 조회수순
			sql = prop.getProperty(selectDonghangKeywordViewcount);
		}else if( !keyword.equals("null") && !nearSchedule.equals("null") ) { //키워드 O, 가까운 일정순
			sql = prop.getProperty(selectDonghangKeywordNearSchedule);
		}else if( keyword.equals("null") && !recent.equals("null") ) { //키워드 X, 최근순
			sql = prop.getProperty(selectDonghangRecent);
		}else if( keyword.equals("null") && !viewcount.equals("null") ) { //키워드 X, 조회수순
			sql = prop.getProperty(selectDonghangViewcount);
		}else if( keyword.equals("null") && !nearSchedule.equals("null") ) { //키워드 X, 가까운 일정순
			sql = prop.getProperty(selectDonghangNearSchedule);
		}else if( !keyword.equals("null") && recent.equals("null") && viewcount.equals("null") && nearSchedule.equals("null")) {
			sql = prop.getProperty(selectDonghangKeywordRecent); //검색만 했을 때! (기본 최신순 정렬)
		}else {
			sql = prop.getProperty(selectDonghangPage);
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			//키워드 o, x 분기
			if(!keyword.equals("null")) {
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			rs = pstmt.executeQuery();
			list = joinRsProcess(rs, new ArrayList<DonghangJoinUserPicture>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectDonghangCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghangCount);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public int selectDonghangCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		if(keyword.equals("null")) {			
			sql = prop.getProperty(selectDonghangCount);
		} else {
			sql = prop.getProperty(selectDonghangKeywordCount);
		}
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);			
			if(!keyword.equals("null")) {	
				pstmt.setString(1, "%"+keyword+"%");
			}
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public List<DonghangJoinUserPicture> selectDonghangTag(Connection conn, int start, int end, String userTag) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		List<DonghangJoinUserPicture> list = null;
		//태그길이만큼  when~then sql문 만들기
		String[] userTagArr = userTag.split(",");
		String likeSql = "";
		for(String tag : userTagArr) {
			likeSql += "WHEN DH.TAG LIKE '%" + tag + "%' THEN '1' ";
		}

		sql = "SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT DH.*, U.NICK_NAME, P.IMAGE, CASE "
				+ likeSql 
				+"ELSE '0' END AS TAG_COUNT FROM DONGHANG_TB DH "
				+ "INNER JOIN USER_TB U ON DH.USER_NO = U.NO INNER JOIN PICTURE_TB P ON DH.NO = P.DONGHANG_NO"
				+ " WHERE DH.DELETED!='Y' ORDER BY TAG_COUNT DESC) A) "
				+ "WHERE RNUM BETWEEN "+ start +" AND "+end;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = joinRsProcess(rs, new ArrayList<DonghangJoinUserPicture>());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	public DonghangJoinUserPicture selectDonghangView(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghangView);
		DonghangJoinUserPicture donghangItem = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			donghangItem = rsProcess(rs, new DonghangJoinUserPicture());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return donghangItem;
	}

	public int updateViewCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateViewCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<UserProfile> selectDonghangJoinMember(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = prop.getProperty(selectDonghangJoinMember);
		List<UserProfile> list = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			//▼기억하기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserProfile up = new UserProfile(); 
				up.setNickName(rs.getString("nick_name"));
				up.setImage(rs.getString("image"));
				list.add(up);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);	
		}
		return list;
	}

	public List<TripMyCon> selectMyTripList(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<TripMyCon> list=new ArrayList<TripMyCon>();
		String sql=prop.getProperty("selectMyTripList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TripMyCon t=new TripMyCon();
				t.setNo(rs.getInt("no"));
				t.setCategory(rs.getString("category"));
				t.setWriteDate(rs.getDate("write_date"));
				t.setTitle(rs.getString("title"));
				t.setImage(rs.getString("image"));
				list.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public List<Like> selectLike(Connection conn, List<TripMyCon> list) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectLike");
		
		ArrayList<Like> likeList = new ArrayList<Like>();
		Like l = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<list.size(); i++) {
				
				pstmt.setInt(1, list.get(i).getNo());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					l = new Like();
					l.setTripNo(rs.getInt("NO"));
					l.setLikeCount(rs.getInt("CNT"));
					
					likeList.add(l);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return likeList;
	}

	public int insertDonghaong(Connection conn, Donghang dh) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertDonghaong");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dh.getNo());
			pstmt.setInt(2, dh.getUserNo());
			pstmt.setInt(3, dh.getTripNo());
			pstmt.setString(4, dh.getTag());
			pstmt.setString(5, dh.getTitle());
			pstmt.setString(6, dh.getContent());
			pstmt.setString(7, dh.getTravleLocale());
			pstmt.setDate(8, dh.getTravleStartDate());
			pstmt.setDate(9, dh.getTravleEndDate());
			pstmt.setDate(10, dh.getRecruitStartDate());
			pstmt.setDate(11, dh.getRecruitEndDate());
			pstmt.setInt(12, dh.getPw());
			pstmt.setString(13, dh.getPublicEnabled());
			pstmt.setInt(14, dh.getRecruitPeopleNo());
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}

	public int selectDonghangSeqNextVal(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectDonghangSeqNextVal");
		int nextVal = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			nextVal = rs.getInt("NEXTVAL");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return nextVal;
	}

	public int insertPicture(Connection conn, Picture pic) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertDhPicture");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pic.getDonghangNo());
			pstmt.setInt(2, pic.getUserNo());
			pstmt.setString(3, pic.getImage());
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}

	public int deleteDonghang(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteDonghang");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}

	public int updateDonghaong(Connection conn, Donghang dh) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty(updateDonghaong);
		
		try {
			pstmt = conn.prepareStatement(sql);
//			TAG, TITLE, CONTENT, TRAVLE_LOCALE, TRAVLE_START_DATE, TRAVLE_END_DATE, RECRUIT_START_DATE, RECRUIT_END_DATE, PW, PUBLIC_ENABLED, RECRUIT_PEOPLE_NO			

			if((Integer)dh.getTripNo()==null) {
				pstmt.setInt(1, (Integer) null);
			}else {
				pstmt.setInt(1, dh.getTripNo());
			}
			System.out.println("트립넘 이거 머야?ㅡㅡ");
			System.out.println(dh.getTripNo());
			pstmt.setString(2, dh.getTag());
			pstmt.setString(3, dh.getTitle());
			pstmt.setString(4, dh.getContent());
			pstmt.setString(5, dh.getTravleLocale());
			pstmt.setDate(6, dh.getTravleStartDate());
			pstmt.setDate(7, dh.getTravleEndDate());
			pstmt.setDate(8, dh.getRecruitStartDate());
			pstmt.setDate(9, dh.getRecruitEndDate());
			pstmt.setInt(10, dh.getPw());
			pstmt.setString(11, dh.getPublicEnabled());
			pstmt.setInt(12, dh.getRecruitPeopleNo());
			pstmt.setInt(13, dh.getNo());
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}

	public int updatePicture(Connection conn, Picture pic) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updatePicture");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pic.getImage());
			pstmt.setInt(2, pic.getDonghangNo());
			pstmt.setInt(3, pic.getUserNo());
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}

	public int donghangJoin(Connection conn, DonghangJoin join) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("donghangJoin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, join.getUserNo());
			pstmt.setInt(2, join.getDonghangNo());
			pstmt.setString(3, join.getContent());
						
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return result;
	}
}
