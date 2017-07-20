<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
 
  	
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
  
    background-color: #3366ff;
      margin-bottom: 0;
      border-radius: 0;
      
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 900px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">
      
      <img src="logo.jpg" width="40" height="40">
    
    </a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"><font size="5" color=" #ffffff"></span> Login</font></a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"><font size="5" color=" #ffffff"></span> 회원 가입</font></a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    
    </div>
    <div class="col-sm-8 text-center"> 
      <form action="userInsert.do" method="post">
	
	<h1>회원 가입 하기</h1>
	I.D : <INPUT TYPE=text id="user_id"><br/><br/>
	P.W : <input type=password id="user_pwd"><br/><br/>
	이름 : <input type=text id="user_name"><br/><br/>
	<div id="sex">
	성별 : <input type="radio" name="sex" value="m"/> 남자
		 <input type="radio" name="sex" value="f"/> 여자
	</div><br/><br/>
	핸드폰 번호 : <input type=text id="phone"/><br/><br/>
	<div id="interest">
	관심사 : 
		<input type="radio" name = "favorite" value="travel"/> 여행
		<input type="radio" name = "favorite" value="study"/> 스터디
		<input type="radio" name = "favorite" value="fried"/> 친목
		<input type="radio" name = "favorite" value="culture"/> 문화
		<input type="radio" name = "favorite" value="sports"/> 운동
	</div><br/><br/>
	<div>
	지역 : 
	<select id="address">
		<option value="seoul"> 서울
		<option value="ggd"> 경기도
		<option value="gwd"> 강원도
		<option value="cnd"> 충청남도
		<option value="cbd"> 충청북도
		<option value="jbd"> 전라북도
		<option value="jnd"> 전라남도
		<option value="gbd"> 경상북도
		<option value="gnd"> 경상남도	
		<option value="jjd"> 제주도
	</select><br/>
	</div>
	<br/>
	<br/>
	
	<div>
	<input type=submit value="회원가입"/>
	<input type="reset" value="다시 쓰기">
	</div>
	
	</form>

    </div>
    <div class="col-sm-2 sidenav">
    
    </div>
  </div>
</div>

</body>
</html>