<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

  ${error}  

<div id="member">
	<h1>회원 가입 하기</h1>
	<form action = "userInsert.do" method ="post" >
	I.D : <INPUT TYPE=text name="user_id"><br/><br/>
	P.W : <input type=password name="user_pwd"><br/><br/>
	이름 : <input type=text name="user_name"><br/><br/>
	폰 : <input type=text name="phone"><br/><br/>
	
	성별 : 
		<input type="radio" name ="sex"  value="m"/> 남자
		<input type="radio" name ="sex"  value="f"/> 여자
		
	
	관심사 : 
		<input type="radio" name ="interest"  value="travel"/> 여행
		<input type="radio" name ="interest"  value="study"/> 스터디
		<input type="radio" name ="interest"  value="friend"/> 친목
		<input type="radio" name ="interest"  value="culture"/> 문화
		<input type="radio" name ="interest"  value="sports"/> 운동<br/><br/>
	</div>
	주소 : <input type=text name="address"><br/><br/>
	<br/>
	<br/>
	<input type= "submit" value="회원가입"/>
	</form>