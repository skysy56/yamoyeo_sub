package yamoyeo;

import java.util.ArrayList;

public class Service {
   
   private static Service service = new Service();
   
   public static Service getInstance(){
      return service;
   }
   
   public void insertUser(UserVO user){ //회원가입  userInserController "userInsert.do"
      new UserDAO().insertUser(user);
   }
   
   public UserVO searchUser(String user_id){ //회원정보수정 userUpdateController "userUpdate.do"
      return new UserDAO().searchUser(user_id);
   }
   
   public String searchID(String id, String pwd){ //로그인 유효성 검사 UserLoginController "userLogin.do"
      return new UserDAO().searchID(id, pwd);
   }
   
   public void updateUser(UserVO user){ //회원정보수정 userUpdateController "userUpdate.do"
       new UserDAO().updateUser(user);
   }
   
//   --------------User 접근 메소드----------------------
   
   public void insertGroup(GroupVO2 group){ //그룹 등록 GroupInsertController "groupInsert.do"
      new GroupDAO().insertGroup(group);
   }
   
   public void updateGroup(GroupVO2 group){ //그룹 정보 갱신 GroupUpdateController "groupUpdate.do"
      new GroupDAO().updateGroup(group);
   }

   
   public GroupVO searchGroup(String group_id){ //그룹상세정보 GroupSearchController "groupSearch.do"
      return new GroupDAO().searchGroup(group_id);
   }
   
   public ArrayList<GroupVO> searchMygroup(String user_id){ //내가 개설한 그룹조회 GroupSearchController "searchMygroup.do"
      return new GroupDAO().searchMygroup(user_id);
   }
   
   public void deleteGroup(String group_id){ //내가 생성한 그룹삭제  GroupdeleteController "groupDelete.do"
      new GroupDAO().deleteGroup(group_id);
   }
   
   public ArrayList<GroupVO> weeklyGroup(){ //이 주의 그룹 GroupLoginController "userLogin.do"
      return new GroupDAO().weeklyGroup();
   }
   
   public ArrayList<GroupVO> recentGroup(){ //최근 생성된 그룹 GroupLoginController "userLogin.do"
      return new GroupDAO().recentGroup();
   }
   
   public ArrayList<GroupVO> recGroup(String interest, String address){ //개인 추천 그룹 GroupLoginController "userLogin.do"
      return new GroupDAO().recGroup(interest, address);
   }
   
   public ArrayList<GroupVO> groupSearch(String interest, String address, String day, String group_name){ //그룹 조건검색  GroupSearchController "searchGroup.do"
      return new GroupDAO().groupSearch(interest, address,day, group_name);
   }
//   --------------Group 접근 메소드----------------------
   
   public void insertComment(CommentVO comment){ //댓글 입력 CommentInsertController "commentInsert.do"
      new CommentDAO().insertComment(comment);
   }
   
   public ArrayList<CommentVO> getComment(String group_id){ //댓글 보여주기 CommentInsertController "commentInsert.do"
      return new CommentDAO().getComment(group_id);
   }
   
   public void deleteComment(int comment_id){ //댓글 삭제 
      new CommentDAO().deleteComment(comment_id);
   }
   
//   --------------Comment 접근 메소드----------------------
   
   public void addJoin(String user_id, String group_id){ //그룹가입하기 GroupJoinController "GroupJoin.do"
      new JoinDAO().addJoin(user_id, group_id);
   }
   
   public void deleteJoin(String user_id, String group_id){ //그룹탈퇴하기 GroupDropController "GroupDrop.do"
      new JoinDAO().deleteJoin(user_id, group_id);
   }
   
   
   public ArrayList<GroupVO> searchGroups(String user_id){ //내가 가입한 그룹 조회 GroupListController "GroupList.do"
      return new JoinDAO().searchGroups(user_id);
   }
   
   public  ArrayList<UserVO> searchUsers(String group_id){ //그룹 회원 조회 
      return new JoinDAO().searchUsers(group_id);
   }
   
   public  int searchJoin(String group_id, String user_id){ //그룹가입여부 조회 GroupSearchController "groupSearch.do"
      return new JoinDAO().searchJoin(group_id, user_id);
   }}
//   --------------Join 접근 메소드----------------------
