package yamoyeo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GroupDAO {

	public static Connection getConnection() { // connection 객체 생성
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yaechan1092", "921021");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void insertGroup(GroupVO2 group) { // group 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("groupvo2 group = "+group);

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"insert into ya_group(group_id,group_name,interest,image,memo,address,day,create_date,max_member,now_member,state,user_id) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, group.getGroup_id());
			pstmt.setString(2, group.getGroup_name());
			pstmt.setString(3, group.getInterest());
			pstmt.setString(4, group.getImage());
			pstmt.setString(5, group.getMemo());
			pstmt.setString(6, group.getAddress());
			pstmt.setString(7, group.getDay());
			pstmt.setString(8, group.getCreate_date());
			pstmt.setLong(9, group.getMax_member());
			pstmt.setLong(10, group.getNow_member());
			pstmt.setString(11, group.getState());
			pstmt.setString(12, group.getUser_id());

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

	public GroupVO searchGroup(String group_id) { // group_id로 검색후 GroupVO 객체 반환
		Connection conn = null;
		PreparedStatement pstmt = null;
		GroupVO group = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group where group_id =?");
			pstmt.setString(1, group_id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				group = new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
						rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"),
						rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"),
						rs.getString("state"), rs.getString("user_id"));

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

		return group;
	}

	public void updateGroup(GroupVO2 group) { // User 가입
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update ya_group set group_name=?,interest=?,image=?,memo=?,address=?,day=?,create_date=?,"
							+ "max_member=?,now_member=?,state=?,user_id=? where group_id =?");
			pstmt.setString(1, group.getGroup_name());
			pstmt.setString(2, group.getInterest());
			pstmt.setString(3, group.getImage());
			pstmt.setString(4, group.getMemo());
			pstmt.setString(5, group.getAddress());
			pstmt.setString(6, group.getDay());
			pstmt.setString(7, group.getCreate_date());
			pstmt.setInt(8, group.getMax_member());
			pstmt.setInt(9, group.getNow_member());
			pstmt.setString(10, group.getState());
			pstmt.setString(11, group.getUser_id());
			pstmt.setString(12, group.getGroup_id());
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

	public void deleteGroup(String group_id) { // group 삭제
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		System.out.println("group_id = " + group_id);
		try {
			conn = getConnection();

			pstmt3 = conn.prepareStatement("delete from ya_comment where group_id = ?");
			pstmt3.setString(1, group_id);
			pstmt3.executeUpdate();
			
			pstmt2 = conn.prepareStatement("delete from ya_join where group_id = ?");
			pstmt2.setString(1, group_id);
			pstmt2.executeUpdate();
			System.out.println("ya_join 그룹 삭제 완료 ");

			pstmt = conn.prepareStatement("delete from ya_group where group_id = ?");
			pstmt.setString(1, group_id);

			pstmt.executeUpdate();
			System.out.println("ya_group 그룹 삭제 완료 ");
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

	public ArrayList<GroupVO> weeklyGroup() { // 이 주의 인기 모임
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group order by now_member desc");
			ResultSet rs = pstmt.executeQuery();

			for (int i = 0; i < 3; i++) {
				rs.next();
				list.add(new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
						rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"),
						rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"),
						rs.getString("state"), rs.getString("user_id")));
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

	public ArrayList<GroupVO> recentGroup() { // 최근에 생긴 모임
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group order by create_date desc");
			ResultSet rs = pstmt.executeQuery();

			for (int i = 0; i < 3; i++) {
				rs.next();
				list.add(new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
						rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"),
						rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"),
						rs.getString("state"), rs.getString("user_id")));
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

	public ArrayList<GroupVO> recGroup(String interest, String address) { // 사용자 모임추천
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group where interest = ? and address =?");

			pstmt.setString(1, interest);
			pstmt.setString(2, address);
			ResultSet rs = pstmt.executeQuery();

			for (int i = 0; i < 3; i++) {
				if (rs.next()) {
					list.add(new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
							rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"),
							rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"),
							rs.getString("state"), rs.getString("user_id")));
				}

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

	public ArrayList<GroupVO> groupSearch(String interest, String address, String day) { // 조건 검색
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group where interest = ? and address =? and day =?");

			pstmt.setString(1, interest);
			pstmt.setString(2, address);
			pstmt.setString(3, day);
			System.out.println(interest + address + day);
			ResultSet rs = pstmt.executeQuery();

			// System.out.println(rs.next());
			for (int i = 0; i < 6; i++) {
				if (rs.next()) {
					list.add(new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
							rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"),
							rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"),
							rs.getString("state"), rs.getString("user_id")));
				}

			}
			System.out.println(list);

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

	public ArrayList<GroupVO> searchMygroup(String user_id) {  //내가 개설한 그룹

		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from ya_group where user_id =?");
			pstmt.setString(1, user_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new GroupVO(rs.getString("group_id"), rs.getString("group_name"), rs.getString("interest"),
						rs.getString("image"), rs.getString("memo"), rs.getString("address"), rs.getString("day"),
						rs.getString("create_date"), rs.getInt("max_member"), rs.getInt("now_member"),
						rs.getString("state"), rs.getString("user_id")));

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

}
