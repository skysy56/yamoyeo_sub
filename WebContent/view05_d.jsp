<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>회원가입 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
 
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      background-color: #2c3e50;
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
    
    .text-center {
    		
           background-color: #f1f1f1;
        }
        
     #id{
     background-color: white;
    color: #0f705d;
    border: 2px solid #18bc9c;
    border-radius: 8px;
    font-size: 16px;
     
     }
     
   hr{
     	border:none;
     	border-top: 2px dotted;
     	color: #18bc9c;
     	width:60%;
     }    
  
  </style>
</head>
<body>

<!--상단 헤드 부분 입니다.  -->
<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="view02_d.jsp">
      	<img src="logogo.bmp" width="100" height="35">
	  </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
      <ul class="nav navbar-nav navbar-right">
      	    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i><font size="4px" color="#ffffff">${user_id} 회원님</font><b class="caret"></b></a>
                    <ul class="dropdown-menu" >
                        <li>
                            <a href="myData.do" ><i class="glyphicon glyphicon-user" ></i> 마이 페이지</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="userLogut.do"><i class="glyphicon glyphicon-log-out"></i> 로그아웃</a>
                        </li>
                    </ul>
                </li>
      </ul>
    </div>
  </div>
</nav>

<!-- 하단 몸체 부분 입니다. 양쪽 사이드 네비 있고 가운데 메인 네비 -->  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-center">  
      <form action="userInsert.do" method="post">
      	<br><br>
		<h1>회원 가입 하기</h1><br>
		<b>I.D</b> : <INPUT TYPE=text id="id" name="user_id"><br/><br/>
		<b>P.W</b> : <input type=password id="id" name="user_pwd"><br/><br/>
		<B>이름</B> : <input type=text id="id" name="user_name"><br/><br/>
		<b>성별</b> : <input type="radio" name="sex" value="남"/><font color="#0f705d"><b>남자</b></font>
			 <input type="radio"  name="sex" value="여"/> <font color="#0f705d"><b>여자</b></font>
			 <br/><br/>
		<b>핸드폰 번호</b> : <input type=text id="id" name="phone"/><br/><br/>
		<b>관심사</b> : 
			<input type="radio" name = "interest" value="여행"/> <font color="#0f705d"><b>여행</b></font>
			<input type="radio" name = "interest" value="스터디"/> <font color="#0f705d"><b>스터디</b></font>
			<input type="radio" name = "interest" value="친목"/><font color="#0f705d"><b> 친목</b></font>
			<input type="radio" name = "interest" value="문화"/> <font color="#0f705d"><b>문화</b></font>
			<input type="radio" name = "interest" value="운동"/> <font color="#0f705d"><b>운동</b></font>
			<br><Br>
		<b>지역</b> : 
		<select id="id" name="address">
			<option value="서울"> 서울
			<option value="경기도"> 경기도
			<option value="강원도"> 강원도
			<option value="충청남도"> 충청남도
			<option value="충청북도"> 충청북도
			<option value="전라북도"> 전라북도
			<option value="전라남도"> 전라남도
			<option value="경상북도"> 경상북도
			<option value="경상남도"> 경상남도	
			<option value="제주도"> 제주도
		</select><br/><br/><br/>
		<hr>
	<div>
		<input type=submit class="btn btn-primary" value="&nbsp회원가입&nbsp"/>
		<input type="reset" class="btn btn-primary" value="다시 쓰기">
	</div>
		</form>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>

<footer class="text-center" bottom="0">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>DEVELOPER</h3>
                        <p>CHO Yu Sung, KIM Seo Yeon<br> KIM Yae Chan, SHIN Sang Yeop </p>
                    </div>
                    <div class="footer-col col-md-4">
                       
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; KODB CLASS-1 GROUP-3
                    </div>
                </div>
            </div>
        </div>
    </footer>
    
</body>
</html>