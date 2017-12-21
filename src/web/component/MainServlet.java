package web.component;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/MainServlet", "/main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "main";
		if(cmd == null || cmd.equals("")) {
			next = "main.jsp";
		}else if(cmd.equals("register")) {
			next = "register.jsp";
		}else if(cmd.equals("login")) {
			next = "login.jsp";
		}
		response.sendRedirect(next);
	}

}




