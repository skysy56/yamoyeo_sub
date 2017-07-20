package yamoyeo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class UserLoginController {

	@RequestMapping(value = "userLogin.do")
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter
		
		System.out.println("logindo");
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		HttpSession session = request.getSession();


		// Service
		Service service = Service.getInstance();
		String result = service.searchID(user_id, user_pwd);

		// Output View
		if (result.equals("로그인성공")) {
			System.out.println("logindo2");
			session.setAttribute("user_id", user_id);
			request.setAttribute("error", "로그인 됐습니다.");

			// ======================================그룹 추천
			UserVO user = new UserDAO().searchUser(user_id);

			// Service
			ArrayList<GroupVO> list = service.recGroup(user.getInterest(), user.getAddress());

			// Output View
			if (list == null) {
				request.setAttribute("result", "가입된 모임이 없습니다.");
			}

			for (int i = 0; i < list.size(); i++) {
				try {
					session.setAttribute(("group" + i), list.get(i));
					session.setAttribute("image"+i, "c:/logs/"+list.get(i).getImage());
				} catch (Exception e) {
					System.out.println("그룹부족");
					session.setAttribute(("group" + i), null);
				}
			}

			// ========================================최근 모임, weekly 모임
			ArrayList<GroupVO> list2 = service.weeklyGroup();
			ArrayList<GroupVO> list3 = service.recentGroup();
			for(int i=0; i<list.size(); i++){
			session.setAttribute("weeklyGroup"+i, list2.get(i));
			session.setAttribute("weekimage"+i, "c:/logs/"+list2.get(i).getImage());
			session.setAttribute("recentGroup"+i, list3.get(i));
			session.setAttribute("recentimage"+i, "c:/logs/"+list3.get(i).getImage());
			}
			System.out.println(list);
			System.out.println(list2);
			System.out.println(list3);
			
			

			// =========================================페이지 이동
			HttpUtil.forward(request, response, "/view02_d.jsp");
			
			return;
		} else if (result.equals("비밀번호틀림")) {
			System.out.println("logindo3");
			request.setAttribute("error", "비밀번호가 틀립니다");
			HttpUtil.forward(request, response, "/index.html");
			return;
		} else {
			System.out.println("logindo4");
			request.setAttribute("error", "아이디가 없습니다");
			HttpUtil.forward(request, response, "/index.html");
			return;
		}

	}
	@RequestMapping(value = "userLogut.do")
	public void userLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		HttpUtil.forward(request, response, "/index.html");
		
	}
	
}
