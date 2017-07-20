package yamoyeo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class CommentDeleteController {

   @RequestMapping(value="commentDelete.do")
   public void commentDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // Parameter
      int comment_id = Integer.parseInt(request.getParameter("comment_id"));

      // Service 
      Service service = Service.getInstance();
      service.deleteComment(comment_id);

      // Output View
      request.setAttribute("comment.comment_text", "");
      HttpUtil.forward(request, response, "/view04_d.jsp");
      
   }

}