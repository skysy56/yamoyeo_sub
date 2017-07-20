<%@ page language="java" contentType="text/html; charset=UTF-8" %>

  ${error}  
 <form action ="groupInsert.do" method="post" enctype="multipart/form-data">
 
 	group_id  : <input type = "text" name="group_id" ><br>
	group_name : <input type = "text" name="group_name" ><br>
	interest : <input type = "text" name="interest" ><br>
	image : <input type = "file" name="image" ><br>
	memo : <input type = "text" name="memo" ><br>
	address : <input type = "text" name="address" ><br>
	day : <input type = "text" name="day" ><br>
	create_date : <input type = "text" name="create_date" ><br>
	max_member : <input type = "number" name="max_member" ><br>
	now_member : <input type = "number" name="now_member" ><br>
	state : <input type = "text" name="state" ><br>
 	
	<input type ="submit" value ="그룹 생성">
 
 	
 
 </form>