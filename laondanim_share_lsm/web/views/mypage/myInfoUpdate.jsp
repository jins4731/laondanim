<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<div class="d-flex flex-column justify-content-center align-items-center">
	<form action="#" method="post">
		<table>
			<tr>
				<td>USERID</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="userId" name="userId" placeholder="ID" class="d-flex text-center border-0 p-2" style="width:250px;">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>PASSWORD</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="password" name="password" placeholder="Password" class="d-flex text-center border-0 p-2" style="width:250px;">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="pwck" name="pwck" placeholder="Password Check" class="d-flex text-center border-0 p-2" style="width:250px;">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>NAME</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="userName" name="userName" placeholder="Name" class="d-flex text-center border-0 p-2" style="width:250px;">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>NICK NAME</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="nickName" name="nickName" placeholder="NickName" class="d-flex text-center border-0 p-2" style="width:200px;">
					<input type="button" value="중복확인">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>BIRTH DAY</td>
			</tr>
			<tr>
				<td>
					
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>GENDER</td>
			</tr>
			<tr>
				<td>
					<select>
						<option>선택</option>
						<option>남자</option>
						<option>여자</option>
					</select>
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>PHONE</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="phone" name="phone" placeholder="Phone" class="d-flex text-center border-0 p-2" style="width:250px;">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>EMAIL</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="email" name="email" placeholder="Email" class="d-flex text-center border-0 p-2" style="width:250px;">
					<hr style="width:250px;">
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="btn btn-info" style="width:250px;">정보수정</button>
				</td>
			</tr>
		</table>
	</form>
</div>