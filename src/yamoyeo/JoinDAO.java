package yamoyeo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JoinDAO {
	
	public static Connection getConnection() { //connection 객체 생성
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	public void addJoin(String user_id, String group_id){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"insert into ya_join(user_id,group_id) values(?,?)");
			pstmt.setString(1, user_id); pstmt.setString(2, group_id);
			

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteJoin(String user_id, String group_id){
		System.out.println("딜리트조인");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement( "delete from ya_join where user_id = ? and group_id = ?" );
			pstmt.setString(1, user_id); pstmt.setString(2, group_id);
			

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public ArrayList<GroupVO> searchGroups(String user_id){ //groupVO list 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		
		try {
			System.out.println("user_id 를 받아왔어 = " + user_id);
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group where group_id in (select group_id from ya_join where user_id= ?) ");
			pstmt.setString(1, user_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
						rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"), 
						rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"), 
						rs.getString("state"), rs.getString("user_id")));
			}
			System.out.println("list = " + list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
		
	}
	
	public  ArrayList<UserVO> searchUsers(String group_id){//UserVO list리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_user where user_id =(select user_id from ya_join where group_id= ?) ");
			pstmt.setString(1, group_id); 
			

			ResultSet rs = pstmt.executeQuery();;
			
			while(rs.next()){
				list.add(new UserVO(rs.getString("user_id"), rs.getString("user_pwd"), rs.getString("user_name"),
						rs.getString("phone"), rs.getString("sex"), rs.getString("interest"), rs.getString("adress")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
		
		
	}
	
public  int searchJoin(String group_id, String user_id){//그룹 가입여부 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_join where user_id =? and group_id =?");
			pstmt.setString(1, user_id);
			pstmt.setString(2, group_id); 
			

			ResultSet rs = pstmt.executeQuery();;
			
			if(rs.next()){
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
		
		
	}
	
	
}
