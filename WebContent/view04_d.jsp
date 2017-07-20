<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>모임 상세 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
  <script type="text/javascript">
  
 
 	var flag=${join_state};
  $(document).ready(function() {
	   if (flag == 1) { //가입 상태면 '가입하기' 버튼이 사라짐
		  $("#joinGroup").css("display","none");
	  }
	  else if (flag ==0) { //가입하지 않은 상태면 '탈퇴하기' 버튼이 사라짐
		  $("#disjoinGroup").css("display","none");
	  }
	});
  
  </script>
  
  <style>
 	table {text-align:center; align:center;}
  	
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
    .container-fluid{
     background-color: #f1f1f1;
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
                            <a href="view07_d.jsp" ><i class="glyphicon glyphicon-user" ></i> 마이 페이지</a>
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
<div class="container-fluid">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8"> 
		<table align="center">
			<thead>
				<td colspan="2" class="gname" align="center"><h3><b>${group.group_name}</b></h3><br/><br/></td><br/><br/>
			</thead>
			<tbody>
				<tr>
					<td><img src = "${detailImg}" width="200" height="200" alt = "모임대표이미지를 등록해 주세요"></td>
					<td><ul style="list-style:none">
						<li><h4>카테고리  ${group.interest}</h4></li>
						<li><h4>요일  ${group.day}</h4></li>
						<li><h4>지역  ${group.address}</h4></li>
						<li><h4>상태  ${group.state}</h4></li>
						<li><h4>모임장  ${group.user_id}</h4></li>
					<li><br></li>
					<li><a href= "groupJoin.do?group_id=${group.group_id}" class="btn btn-primary" id = "joinGroup"><b>가입하기</b></a>
					<a href = "groupDrop.do?group_id=${group.group_id}" class="btn btn-primary" id = "disjoinGroup"><b>탈퇴하기</b></a></li>
						</ul>
					</td>
				</tr>
		
				<tr>
					<td colspan="2" class="introduce" align="center"><br><br><h3><b>모임 소개글</b></h3></td>
					<td colspan="2" class="introduce" align="center"><h4>${group.memo}</h4></td>
				</tr>
			</tbody>
		</table>

<hr>

		
		<form action="commentInsert.do" >
		<div align="center">
			<h3><b>댓 글</b></h3>
				<div align="center">
 					<input type=text size="80" class="ui" name = "comment_text">
 					<input type = hidden name = "group_id" value = ${group.group_id}> 
					<input type = submit id="enter" class="ui" value = "댓글쓰기">
				</div>
				
		</div>
		</form>
		
		<br/><br/>

	<table width = 700 align = "center" background-color="#f1f1f1">
		<thead>
			<tr>
				<td width = 50><b>번호</b></td>
				<td width = 100><b>작성자</b></td>
				<td width = 550><b>댓글내용</b></td>
			</tr>
		</thead>
		<tbody >
			<tr>
				<td>${comment0.comment_id}</td>
				<td>${comment0.user_id}</td>
				<td>${comment0.comment_text}</td>
			</tr>
			<tr>
				<td>${comment1.comment_id}</td>
				<td>${comment1.user_id}</td>
				<td>${comment1.comment_text}</td>
			</tr>
			<tr>
				<td>${comment2.comment_id}</td>
				<td>${comment2.user_id}</td>
				<td>${comment2.comment_text}</td>
			</tr>
			<tr>
				<td>${comment3.comment_id}</td>
				<td>${comment3.user_id}</td>
				<td>${comment3.comment_text}</td>
			</tr>
			<tr>
				<td>${comment4.comment_id}</td>
				<td>${comment4.user_id}</td>
				<td>${comment4.comment_text}</td>
			</tr>
			<tr>
				<td>${comment5.comment_id}</td>
				<td>${comment5.user_id}</td>
				<td>${comment5.comment_text}</td>
			</tr>
			<tr>
				<td>${comment6.comment_id}</td>
				<td>${comment6.user_id}</td>
				<td>${comment6.comment_text}</td>
			</tr>
			<tr>
				<td>${comment7.comment_id}</td>
				<td>${comment7.user_id}</td>
				<td>${comment7.comment_text}</td>
			</tr>
			<tr>
				<td>${comment8.comment_id}</td>
				<td>${comment8.user_id}</td>
				<td>${comment8.comment_text}</td>
			</tr>
			<tr>
				<td>${comment9.comment_id}</td>
				<td>${comment9.user_id}</td>
				<td>${comment9.comment_text}</td>
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