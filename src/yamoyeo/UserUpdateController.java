package yamoyeo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserUpdateController {

	@RequestMapping(value = "userUpdate.do")
	public void updateUser(@ModelAttribute("user") UserVO user, HttpServletRequest request,
			HttpServletResponse response, 
			HttpSession session) {
		
		String user_id = (String) session.getAttribute("user_id");
		user.setUser_id(user_id);
		System.out.println("user_id = " + session.getAttribute("user_id"));
		System.out.println("user = " + user);
		// 유효성 검사
		if (user.getUser_pwd().isEmpty() || user.getUser_name().isEmpty()
				|| user.getSex().isEmpty() || user.getPhone().isEmpty() || user.getInterest().isEmpty()
				|| user.getAddress().isEmpty()) {
			request.setAttribute("error", "모든 정보를 입력해주세요");
			request.setAttribute("user", user);
			HttpUtil.forward(request, response, "/view07_d.jsp");
			return;
		}
		request.setAttribute("user_pwd", user.getUser_pwd());
		request.setAttribute("user_name", user.getUser_name());
		request.setAttribute("sex", user.getSex());
		request.setAttribute("phone", user.getPhone());
		request.setAttribute("interest", user.getInterest());
		request.setAttribute("address", user.getAddress());

		// Service
		Service service = Service.getInstance();
		service.updateUser(user);

		// Output View
		request.setAttribute("user", user);
		request.setAttribute("id", user.getUser_id());
		HttpUtil.forward(request, response, "/view07_d.jsp");
	}
	@RequestMapping(value = "myData.do")	
	public void myData(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Service service = new Service().getInstance();
		String user_id = (String)session.getAttribute("user_id");
		UserVO user = service.searchUser(user_id);
		request.setAttribute("user", user);
		HttpUtil.forward(request, response, "/view07_d.jsp");
	}
		
}
