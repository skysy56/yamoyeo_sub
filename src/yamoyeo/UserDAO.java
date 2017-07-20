package yamoyeo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yamoyeo.UserVO;


public class UserDAO {

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

	public void insertUser(UserVO user) { //User 가입 
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"insert into ya_user(user_id,user_pwd,user_name,phone,sex,interest,address) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getUser_id()); pstmt.setString(2, user.getUser_pwd());
			pstmt.setString(3, user.getUser_name()); pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getSex()); pstmt.setString(6, user.getInterest());
			pstmt.setString(7, user.getAddress());

			pstmt.executeUpdate();

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

	public UserVO searchUser(String user_id) { //User_id로 검색후 UserVO 객체 반환
		Connection conn = null;
		PreparedStatement pstmt = null;
		UserVO user = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_user where user_id =?");
			pstmt.setString(1, user_id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new UserVO(rs.getString("user_id"), rs.getString("user_pwd"), rs.getString("user_name"),
						rs.getString("phone"), rs.getString("sex"), rs.getString("interest"), rs.getString("address"));

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

		return user;
	}
	
	public String searchID(String id, String pwd) { //아이디 유효성 검사
		Connection conn  = null;
		PreparedStatement pstmt = null;
		String result = null;
		
		try{
			conn=  getConnection();
			pstmt = conn.prepareStatement("select user_id, user_pwd from ya_user where user_id =?");
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				if(rs.getString("user_pwd").equals(pwd) && rs.getString("user_id").equals(id)){
					result = "로그인성공";
				}
				else{
					result = "비밀번호틀림";
				}
			}
			else{
				result = "아이디없음";
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				
				if(pstmt !=null)pstmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void updateUser(UserVO user) { //User 가입 
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update ya_user set user_pwd =? , user_name = ? , phone = ?, sex= ? , interest  =? , address = ? where user_id =?");
			pstmt.setString(1, user.getUser_pwd());
			pstmt.setString(2, user.getUser_name()); pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getSex()); pstmt.setString(5, user.getInterest());
			pstmt.setString(6, user.getAddress());pstmt.setString(7,user.getUser_id() );

			pstmt.executeUpdate();

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


}
