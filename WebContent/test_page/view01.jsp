<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main_logout</title>
<style>
table {text-align:center;}
form {display:inline;}
div {display:inline;}
#joinbutton {width : 400px}
#accordion .content {display:none;}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
<script> 
$(document).ready(function() { 
   $('#accordion .subject').on('click', function(){ 
      var content = $(this).siblings('.content'); 
      if (content.css('display') == 'none') { 
         $('#accordion .content').slideUp(); 
         content.slideDown(); 
         } else { 
         content.slideUp(); 
      } 
   }); 
}); 
</script>
</head>
<body>
<div align="left">
	<span>
	<a href="#">야모여LOGO</a>
	</span>
</div>

<div style="float:right">
	<!-- 로그인 -->
	<form action="userLogin.do" method="post">
		<div>
			 ID <input type="text" size=10 name="user_id"> PW <input type="password" size=10 name="user_pwd">
			<input id="login" type="submit" value="로그인">
		</div>
	</form>

	<button id="join" onclick="javascript:location.href='view05.html';">회원가입</button>
</div>

<hr>
<ul style="list-style:none" id="accordion">
	<li>
	<form action="groupInsert.do" method="post">
	<p class="subject">
		<button id="joinbutton">모임 조회하기</button>&nbsp;&nbsp;<button id="group_create" onclick="javascript:location.href='view06.html';">모임 생성하기</button>
	</p>
	</form>
	
	<div class="content">
	<form action = "view03.jsp" method = "get">
	
		<b>카테고리</b>
		<input type="radio" name="interest" value="여행">여행 <input type="radio" name="interest" value="스터디">스터디 <input type="radio" name="interest" value="친목">친목 <input type="radio" name="interest" value="문화">문화 <input type="radio" name="interest" value="운동">운동
		<br>
		<b>지역&nbsp;</b>
		<select name="address">
			<option value="서울">서울</option>
			<option value="경기도">경기도</option>
			<option value="강원도">강원도</option>
			<option value="충청북도">충청북도</option>
			<option value="충청남도">충청남도</option>
			<option value="전라북도">전라북도</option>
			<option value="전라남도">전라남도</option>
			<option value="경상북도">경상북도</option>
			<option value="경상남도">경상남도</option>
			<option value="제주도">제주도</option>
		</select>
		<br>
		<div>
			<b>요일</b><input type="radio" name="day" value="월">월 <input type="radio" name="day" value="화">화 <input type="radio" name="day" value="수">수 <input type="radio" name="day" value="목">목 <input type="radio" name="day" value="금">금 <input type="radio" name="day" value="토">토 <input type="radio" name="day" value="일">일
		</div>
		<br>
		<b>모임명</b><input id="group_name" type="text" size=18>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="group_search" type = "submit" value = "모임 검색하기">
	</form>
	</div>
	
	</li>
</ul>
<hr>
<div align="center">
	<table>
	<caption><b>금주의 인기모임</b></caption>
	<tr>
		<td>
			<ul style="list-style:none">
				<li><a href=""><img src="" width="200" height="200" alt="이미지를 업로드해주세요"></a></li>
				<li> ${group.group_name} </li>
				<li> ${group.interest} </li>
				<li> ${group.state} </li>
			</ul>
		</td>
		<td>
			<ul style="list-style:none">
				<li><a href=""><img src="" width="200" height="200" alt="이미지를 업로드해주세요"></a></li>
				<li> ${group.group_name} </li>
				<li> ${group.interest} </li>
				<li> ${group.state} </li>
			</ul>
		</td>
		<td>
			<ul style="list-style:none">
				<li><a href=""><img src="" width="200" height="200" alt="이미지를 업로드해주세요"></a></li>
				<li> ${group.group_name} </li>
				<li> ${group.interest} </li>
				<li> ${group.state} </li>
			</ul>
		</td>
	</tr>
	</table>
</div>
<hr>
<div align="center">
	<table>
	<caption><b>최근에 생성된 모임</b></caption>
	<tr>
		<td>
			<ul style="list-style:none">
				<li><a href=""><img src="" width="200" height="200" alt="이미지를 업로드해주세요"></a></li>
				<li> ${group.group_name} </li>
				<li> ${group.interest} </li>
				<li> ${group.state} </li>
			</ul>
		</td>
		<td>
			<ul style="list-style:none">
				<li><a href=""><img src="" width="200" height="200" alt="이미지를 업로드해주세요"></a></li>
				<li> ${group.group_name} </li>
				<li> ${group.interest} </li>
				<li> ${group.state} </li>
			</ul>
		</td>
		<td>
			<ul style="list-style:none">
				<li><a href=""><img src="" width="200" height="200" alt="이미지를 업로드해주세요"></a></li>
				<li> ${group.group_name} </li>
				<li> ${group.interest} </li>
				<li> ${group.state} </li>
			</ul>
		</td>
	</tr>
	</table>
</div>
</body>
</html>