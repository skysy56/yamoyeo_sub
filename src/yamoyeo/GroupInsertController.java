package yamoyeo;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.*;

@Controller
public class GroupInsertController {

	@RequestMapping(value = "groupInsert.do" )
	public String insertGroup(@ModelAttribute("group") GroupVO2 group, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String user_id =(String) session.getAttribute("user_id");
		System.out.println("group = " + group);
		System.out.println("user_id = " + user_id);
		group.setUser_id(user_id);
		Service service = Service.getInstance();
		service.insertGroup(group);
		
		return "view06_d";// output 출력

	}
}
