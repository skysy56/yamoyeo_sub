package yamoyeo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class GroupUpdateController {

	@RequestMapping(value = "groupUpdate.do")
	public String groupUpdate(@ModelAttribute("group") GroupVO2 group) {
		
		Service service = Service.getInstance();
		service.updateGroup(group);

		return "view08_d";
	}

}
