<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

  

<div id="comment">
	<h1>¥Ò±€√¢</h1>
	<form action = "commentInsert.do" method ="post" >
	${error}
	¥Ò±€ : <input type = "text" name="comment_text">
	
	<input type="submit" value = "æ≤±‚"/>
	</form>
	<br/>
	</div>
	<div id ="comment_view" style="border:1px solid black" >
	
	<br><br><br><br>
	
	</div>
	
	
	