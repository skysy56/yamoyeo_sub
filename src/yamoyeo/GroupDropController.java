package yamoyeo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class GroupDropController {

	@RequestMapping(value = "groupDrop.do")
	public void dropGroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter
		HttpSession session = request.getSession();
		String group_id = request.getParameter("group_id");
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("탈퇴하러옴" + group_id + " , "+user_id);
		Service service = Service.getInstance();
		service.deleteJoin(user_id, group_id);
		request.setAttribute("error", "탈퇴했습니다.");
		request.setAttribute("group_id", group_id);
		// Output View

		System.out.println("포워드 전");
		HttpUtil.forward(request, response, "/groupSearch.do");

	}

}
