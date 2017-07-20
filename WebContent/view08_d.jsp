<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>마이 페이지/그룹</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
  <script type="text/javascript">
 
  
  </script>
  
  
  <style>
 	table {text-align:center; align:center;}
  	form {display:inline;}
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
    
    
    .ui{
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
     	width:80%;
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
                    <ul class="dropdown-menu">
                        <li>
                            <a href="view07_d.jsp"><i class="glyphicon glyphicon-user"></i> 마이 페이지</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#"><i class="glyphicon glyphicon-log-out"></i> 로그아웃</a>
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
    <div class="col-sm-8 align-center"> 
     <br>
	<h1> 마이 페이지(회원 정보 관리)</h1><br>
		<form action="view07_d.jsp" method="post">
	<input type=submit id="memadmin" class="btn btn-primary" value="회원정보 관리"/>
	</form>

	
	<form action="groupList.do" method="post">
	<input type=submit id="groupadmin" class="btn btn-primary" value="&nbsp&nbsp&nbsp&nbsp모임 관리&nbsp&nbsp&nbsp&nbsp"/>
	</form><p><hr><br/>
	
	<h3>내가 개설한 모임</h3>
	<table  width = 80%  align = "center">
		<thead>
			<tr>
				<td>모임명</td>
				<td>관심사</td>
				<td>지역</td>
				<td>요일</td>
				<td>상태</td>
				<td>모임삭제</td>
			</tr>
		</thead>
		<tbody>
			<tr>
			<form action="groupDelete.do" id="group_delete" method = "get">
			<input type = hidden name = "group_id" value = "${creategroup0.group_id}">
				<td>${creategroup0.group_name}</td>
				<td>${creategroup0.interest}</td>
				<td>${creategroup0.address}</td>
				<td>${creategroup0.day}</td>
				<td>${creategroup0.state}</td>
				<td><input type="submit" id="pdel" class="btn btn-primary" value="삭제하기"></td>
			</form>	
			</tr>					
			<tr>
			<form action="groupDelete.do" id="group_delete" method = "get">
			<input type = hidden name = "group_id" value = "${creategroup1.group_id}">
				<td>${creategroup1.group_name}</td>
				<td>${creategroup1.interest}</td>
				<td>${creategroup1.address}</td>
				<td>${creategroup1.day}</td>
				<td>${creategroup1.state}</td>
				<td><input type="submit" id="pdel" class="btn btn-primary" value="삭제하기"></td>
			</form>	
			</tr>	
			<form action="groupDelete.do" id="group_delete" method = "get">
			<input type = hidden name = "group_id" value = "${creategroup2.group_id}">
				<td>${creategroup2.group_name}</td>
				<td>${creategroup2.interest}</td>
				<td>${creategroup2.address}</td>
				<td>${creategroup2.day}</td>
				<td>${creategroup2.state}</td>
				<td><input type="submit" id="pdel" class="btn btn-primary" value="삭제하기"></td>
			</form>	
			</tr>
		</tbody>
	</table><hr><br>
	
	
	<h3> 내가 가입한 모임</h3>
	<table width = 80% align = "center">
		<thead>
			<tr>
				<td>모임명</td>
				<td>관심사</td>
				<td>지역</td>
				<td>요일</td>
				<td>상태</td>
				<td>모임삭제</td>
			</tr>
		</thead>
		<tbody>
			<tr>
			<form action="groupDrop.do" id="group_delete" method = "get">
			<input type = hidden name = "user_id" value = "${user_id}">
			<input type = hidden name = "group_id" value = "${joingroup0.group_id}">
				<td>${joingroup0.group_name}</td>
				<td>${joingroup0.interest}</td>
				<td>${joingroup0.address}</td>
				<td>${joingroup0.day}</td>
				<td>${joingroup0.state}</td>
				<td><input type="submit" id = "pdel" class="btn btn-primary"  value="탈퇴하기"/></td>
			</form>
			</tr>
			<tr>
			<form action="groupDrop.do" id="group_delete" method = "get">
			<input type = hidden name = "user_id" value = "${user_id}">
			<input type = hidden name = "group_id" value = "${joingroup1.group_id}">
				<td>${joingroup1.group_name}</td>
				<td>${joingroup1.interest}</td>
				<td>${joingroup1.address}</td>
				<td>${joingroup1.day}</td>
				<td>${joingroup1.state}</td>
				<td><input type="submit" id = "pdel" class="btn btn-primary"  value="탈퇴하기"/></td>
			</form>
			</tr>
			<tr>
			<form action="groupDrop.do" id="group_delete" method = "get">
			<input type = hidden name = "user_id" value = "${user_id}">
			<input type = hidden name = "group_id" value = "${joingroup2.group_id}">			
				<td>${joingroup2.group_name}</td>
				<td>${joingroup2.interest}</td>
				<td>${joingroup2.address}</td>
				<td>${joingroup2.day}</td>
				<td>${joingroup2.state}</td>
				<td><input type="submit" id = "pdel" class="btn btn-primary"  value="탈퇴하기"/></td>
			</form>				
			</tr>						
		</tbody>
	</table>
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