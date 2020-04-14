<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,com.laon.tripinfo.model.vo.*,com.laon.user.model.vo.User"%>
<%
	List<Mind> userMindList = (List)request.getAttribute("userMindList");
	List<Picture> pictureList = (List)request.getAttribute("pictureList");
	List<TripInfo2> tripInfoList = (List)request.getAttribute("tripInfoList");
	List<Mind> mindList = (List)request.getAttribute("mindList");
	
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!------------------------------------------------찜목록----------------------------------------------------->
		
			
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<!---------------------------------------찜목록 헤더----------------------------------------------->
						<div class="modal-header">
							<h4 class="modal-title"><%=loginUser==null?1:loginUser.getNickName()%>님의 찜목록
							</h4>
							<!-- <button class="btn" onclick="$("#myModal").modal('hide')">X</button>
							 -->
							<button class="btn" onclick="location.replace('<%=request.getContextPath()%>/tripinfo/tripinfoMain?category=<%="맛집"%>&userNo=<%=loginUser==null?1:loginUser.getNo()%>')">X</button>
							<!-- <button id="mind-close" class="btn" data-dismiss="modal">&times;</button> -->
						</div>
						<!-----------------------------------------찜목록 바디---------------------------------------------->
						<div class="modal-body">
							<div id="accordion">
							
							<%
							List<TripInfo2> foodList = new ArrayList<TripInfo2>();
							List<TripInfo2> hotelList = new ArrayList<TripInfo2>();
							List<TripInfo2> hotspotList = new ArrayList<TripInfo2>();
							List<Picture> foodPictureList = new ArrayList<Picture>();
							List<Picture> hotelPictureList = new ArrayList<Picture>();
							List<Picture> hotspotPictureList = new ArrayList<Picture>();
							
							for(Mind m : userMindList){
								for(Picture p : pictureList){
									if(m.getTripinfoNo()==p.getTripinfoNo()){
										int tripNo = m.getTripinfoNo();
										for(TripInfo2 ti : tripInfoList){
											if(tripNo == ti.getTripinfoNo()){
												String category = ti.getTripinfoCategory();
												
												switch(category){
												case "맛집":
													foodList.add(ti);
													foodPictureList.add(p);
													break;
													
												case "명소":
													hotspotList.add(ti);
													hotspotPictureList.add(p);
													break;
													
												case "숙소":
													hotelList.add(ti);
													hotelPictureList.add(p);
													break;
												}
											}
										}
									}
								}
							}
												
															
							%>
							
							
								<div class="card">
									<div class="card-header card-link" data-toggle="collapse"
										href="#collapseOne">
										<h4>맛집</h4>
									</div>
									<div id="collapseOne" class="collapse show"
										data-parent="#accordion">
										<div class="card-body">
											<div class="msg002" style="margin-bottom: 10px;">
												<span>총 10개의 맛집</span>
											</div>
											<div class="heart-cafe" >
											
											
											
											<div class="heart-cafe-card d-flex">
											<%
												for(int i=0; i<foodPictureList.size(); i++){	
											%>												
														<div class="user-mind-card">
															<div class="user-mind-card-img">									
																<img src="<%=request.getContextPath()%><%=foodPictureList.get(i).getImage() %>" alt="..." width="140px" height="140px">
															</div>
															<div class="del d-flex justify-content-center">
																<img src="<%=request.getContextPath()%>/views/picture/icon/142125213.jpg" alt="..." width="30px" height="30px">
															</div>
														</div>
											<%
												}
											%>	
											</div>
						
											
											
											</div>																	
											</div>
										</div>
									</div>
								</div>
							
																	
							
							
								<div class="card">
									<div class="card-header collapsed card-link"
										data-toggle="collapse" href="#collapseTwo">
										<h4>숙소</h4>
									</div>
									<div id="collapseTwo" class="collapse" data-parent="#accordion">
										<div class="card-body">
											<div class="msg003">
												<span>총 11개의 숙소</span>
											</div>
											<div class="heart-rooms d-flex">
												<%
												for(Picture p : hotelPictureList){
														
												
												%>
												<div class="heart-cafe-card">
													<img src="<%=request.getContextPath()%><%=p.getImage() %>" alt="..." width="150px" height="150px">
												</div>				
												<%
													}
												%>	
											</div>
										</div>
									</div>
								</div>
								<div class="card">
									<div class="card-header collapsed card-link"
										data-toggle="collapse" href="#collapseThree">
										<h4>명소</h4>
									</div>
									<div id="collapseThree" class="collapse"
										data-parent="#accordion">
										<div class="card-body">
											<div class="msg004">
												<span>총 17개의 명소</span>
											</div>
											<div class="heart-attraction d-flex">
												<%
												for(Picture p : hotspotPictureList){
														
												
												%>
													<div class="heart-cafe-card">
														<img src="<%=request.getContextPath()%><%=p.getImage() %>" alt="..." width="150px" height="150px">
													</div>				
												<%
													}
												%>	
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			
</body>
</html>