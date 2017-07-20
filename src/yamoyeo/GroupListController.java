package yamoyeo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class GroupListController {

	@RequestMapping(value = "groupList.do")
	public void groupList(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException { // 내 그룹 리스트 출력
		// Parameter
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("현재 user_id = " + user_id);
		// user 확인
		if (user_id.isEmpty()) {
			request.setAttribute("error", "로그인 해주세요.");
			HttpUtil.forward(request, response, "/view01_d.jsp");
			return;
		}

		// Service
		Service service = Service.getInstance();
		ArrayList<GroupVO> list = service.searchGroups(user_id);

		// Output View
		if (list == null) {
			request.setAttribute("result", "가입된 모임이 없습니다.");
		}
		for(int i = 0; i<list.size(); i++){
			request.setAttribute("mygroup"+i, list.get(i));
			System.out.println("mygroup 들 = " + list.get(i).getGroup_name());
		}
		HttpUtil.forward(request, response, "/view08_d.jsp");
	}


}
