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
		//내가 개설한 것
		ArrayList<GroupVO> creategroup_list = service.searchMygroup(user_id); 
		//내가 가입한 것 
		ArrayList<GroupVO> joingroup_list = service.searchGroups(user_id);

		
		for(int i = 0; i<creategroup_list.size(); i++){
			request.setAttribute("creategroup"+i, creategroup_list.get(i));
		}
		for(int i = 0; i<joingroup_list.size(); i++){
			request.setAttribute("joingroup"+i, joingroup_list.get(i));
		}
		HttpUtil.forward(request, response, "/view08_d.jsp");
	}


}
