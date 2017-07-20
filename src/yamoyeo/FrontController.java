//package yamoyeo;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class FrontController extends HttpServlet{
//	private static final long serialVersionUID = 1L;
//	
//	String charset = null;
//	HashMap<String, Controller> list = null;
//
//	@Override
//	public void init(ServletConfig sc) throws ServletException {
//		charset = sc.getInitParameter("charset");
//		System.out.println("이닛테스트");
//		list = new HashMap<String, Controller>();
//		
//		//USER
//		list.put("/view/userInsert.do", new UserInsertController()); 
//		list.put("/view/userLogin.do", new UserLoginController()); 
//		list.put("/userUpdate.do", new UserUpdateController()); 
//		//list.put("/userDelete.do", new UserDeleteController()); 
//		
//		//JOIN
//		list.put("/GroupJoin.do", new GroupJoinController()); 
//		list.put("/GroupDrop.do", new GroupDropController()); 
//		list.put("/GroupList.do", new GroupListController()); 
//		
//		//GROUP
//		list.put("/groupInsert.do", new GroupInsertController()); 
//		list.put("/groupSearch.do", new GroupSearchController()); 
//		//list.put("/groupDetail.do", new GroupDetailController()); 
//		list.put("/groupUpdate.do", new GroupUpdateController()); 
//		list.put("/groupDelete.do", new GroupDeleteController()); 
//		list.put("/groupList.do", new GroupListController()); // 가입 모임들 확인
//		
//		//COMMENT
//		list.put("/commentInsert.do", new CommentInsertController()); 
//		list.put("/commentDelete.do", new CommentDeleteController()); 
//	}
//	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding(charset);
//
//		String url = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String path = url.substring(contextPath.length());
//
//		Controller subController = list.get(path);
//		subController.execute(request, response);
//	}
//
//}
