package com.laon.mypage.model.service;

import static com.laon.common.template.JDBCTemplate.close;
import static com.laon.common.template.JDBCTemplate.commit;
import static com.laon.common.template.JDBCTemplate.getConnection;
import static com.laon.common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.laon.board.model.vo.Board;
import com.laon.donghang.model.vo.DonghangJoin;
import com.laon.donghang.model.vo.MyDong;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Mind;
import com.laon.etc.model.vo.Picture;
import com.laon.mypage.model.dao.MypageDao;
import com.laon.trip.model.vo.TripMyCon;
import com.laon.tripinfo.model.vo.TripinfoMyMind;
import com.laon.user.model.vo.User;
import com.laon.user.model.vo.UserProfile;

public class MypageService {
	private MypageDao dao=new MypageDao();
	
	//�α��� ���� ������ ����
	public UserProfile selectUserNo(int no) {
		Connection conn=getConnection();
		UserProfile up=dao.selectUserNo(conn,no);
		close(conn);
		
		return up;
	}
	
	//�������������� �� �н����� üũ
	public boolean selectPwck(int userNo,String pw){
		Connection conn=getConnection();
		boolean flag=dao.selectPwck(conn,userNo,pw);
		close(conn);
		
		return flag;
	}
	
	//�������� + ������ ����
	public int updateUserProfile(User u,Picture p) {
		Connection conn=getConnection();
		int result=dao.updateUserInfo(conn,u);
		if(result>0) {
			result=dao.updateUserProfile(conn, p);
			if(result>0) {				
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		close(conn);
		
		return result;
	}
	
	//�� ������ �ֽű� 4��
	public List<TripMyCon> selectMyTrip(int userNo){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectMyTrip(conn,userNo);
		close(conn);
		
		return list;
	}
	
	//�� ������ �������� ��� ����Ʈ
	public List<TripMyCon> selectMyTripAll(int userNo,int start,int end){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectMyTripAll(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	//�� ������ ���ƿ� ����
	public List selectMyTripLike(int userNo) {
		Connection conn=getConnection();
		List like=dao.selectMyTripLike(conn,userNo);
		close(conn);
		
		return like;
	}
	
	//�� ������ �� ����
	public int selectMyTripCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyTripCount(conn,userNo);
		close(conn);
		return result;
	}
	
	//�� �Խñ� ����Ʈ
	public List<Board> selectMyBoard(int userNo,int start,int end){
		Connection conn=getConnection();
		List<Board> list=dao.selectMyBoard(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	//�� �Խñ� �� ����
	public int selectMyBoardCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyBoardCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	//�� ���� �ֽű� 4��
	public List<MyDong> selectMyDong(int userNo){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectMyDong(conn,userNo);
		close(conn);
		
		return list;
	}
	
	//�� ���� �������� ��� ����Ʈ
	public List<MyDong> selectMyDHAll(int userNo,int start,int end){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectMyDHAll(conn,userNo,start,end);
		close(conn);
		
		return list;
	}
	
	//�� ���� �� ����
	public int selectMyDongCount(int userNo) {
		Connection conn = getConnection();
		int result = dao.selectMyDongCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	//�������� ��ȸ
	public List<DonghangJoin> selectJoin(int userNo){
		Connection conn=getConnection();
		List<DonghangJoin> list=dao.selectJoin(conn,userNo);
		close(conn);
		
		return list;
	}
	
	//�������� �������� ���� ����Ʈ �ֽű� 4��
	public List<MyDong> selectOriJoin(List<DonghangJoin> jd){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectOriJoin(conn,jd);
		close(conn);
		
		return list;
	}
	
	//�������� �������� �������� �� ������ ��� ����Ʈ
	public List<MyDong> selectOriJoinAll(List<DonghangJoin> jd,int start,int end){
		Connection conn=getConnection();
		List<MyDong> list=dao.selectOriJoinAll(conn,jd,start,end);
		close(conn);
		
		return list;
	}
	
	//�������� ����Ʈ�� ���� �ۼ��� �г���
	public List<UserProfile> selectUserNick(List<MyDong> ojd){
		Connection conn=getConnection();
		List<UserProfile> userNick=dao.selectUserNick(conn,ojd);
		close(conn);

		return userNick;
	}
	
	//�������� �� ����
	public int selectMyJDCount(int userNo) {
		Connection conn=getConnection();
		int result=dao.selectMyJDCount(conn,userNo);
		close(conn);
		
		return result;
	}
	
	//���� ���ƿ��� ����� �ѹ�
	public List<Like> selectTripLike(int userNo){
		Connection conn=getConnection();
		List<Like> likeT=dao.selectTripLike(conn, userNo);
		close(conn);
		
		return likeT;
	}
	
	//���� ���ƿ��� ����� ����Ʈ
	public List<TripMyCon> selectTripList(List<Like> likeT){
		Connection conn=getConnection();
		List<TripMyCon> list=dao.selectTripList(conn,likeT);
		List<TripMyCon> tripList=new ArrayList<TripMyCon>();
		
		int cnt=0;
		for(TripMyCon t:list) {
			tripList.add(t);
			cnt++;
			if(cnt==4) {
				break;
			}
		}
		close(conn);
		
		return tripList;
	}
	
	//���� ���ƿ��� ����� ����Ʈ ��ü
	public List<TripMyCon> selectTripListAll(List<Like> likeT,int start,int end){
		Connection conn=getConnection();
		List<TripMyCon> tripList=dao.selectTripListAll(conn,likeT,start,end);
		close(conn);
		
		return tripList;
	}
	
	//���� ���ƿ��� ����� �ۼ��� �г���
	public List<UserProfile> selectTripUserNick(List<TripMyCon> tl){
		Connection conn=getConnection();
		List<UserProfile> userNick=dao.selectTripUserNick(conn,tl);
		close(conn);
		
		return userNick;
	}
	
	//���� ���ƿ��� ����� �� ����
	public int selectLikeTripCount(int userNo) {
		Connection conn=getConnection();
		int count=dao.selectLikeTripCount(conn,userNo);
		close(conn);
		
		return count;
	}
	
	//���� ���� �������� �ѹ�
	public List<Mind> selectMind(int userNo){
		Connection conn=getConnection();
		List<Mind> mind=dao.selectMind(conn,userNo);
		close(conn);
		
		return mind;
	}
	
	//���� ���� �������� ����Ʈ
	public List<TripinfoMyMind> selectMindList(List<Mind> mind){
		Connection conn=getConnection();
		List<TripinfoMyMind> mindList=dao.selectMindList(conn,mind);
		close(conn);
		
		return mindList;
	}
	
	//���� ���� ���� ����
	public int dongJoinRefusal(int no) {
		Connection conn=getConnection();
		int result=dao.dongJoinRefusal(conn,no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//내 여행기 삭제
	public int myTripDelete(int tripNo) {
		Connection conn=getConnection();
		int result=dao.myTripDelete(conn,tripNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//내 게시글 삭제
	public int myBoardDelete(int[] boardNo) {
		Connection conn=getConnection();
		int result=dao.myBoardDelete(conn,boardNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//내 여행기 다중삭제
	public int myConTripDelete(int[] tripNo) {
		Connection conn=getConnection();
		int result=dao.myConTripDelete(conn,tripNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//내 동행 다중삭제
	public int myDongMultiDelete(int[] myDongNo) {
		Connection conn=getConnection();
		int result=dao.myDongMultiDelete(conn,myDongNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//내 동행 삭제
	public int myDongDelete(int myDongNo) {
		Connection conn=getConnection();
		int result=dao.myDongDelete(conn,myDongNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//찜 취소
	public int myMindCancled(int mindNo,int userNo) {
		Connection conn=getConnection();
		int result=dao.myMindCancled(conn,mindNo,userNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//좋아요 다중취소
	public int likeTripMultiCancled(int userNo,int[] myLikeNo) {
		Connection conn=getConnection();
		int result=dao.likeTripMultiCancled(conn,userNo,myLikeNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
}
