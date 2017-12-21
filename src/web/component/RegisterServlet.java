package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.UserBiz;
import com.vo.User;

import web.dispatcher.Navi;
import web.dispatcher.Util;

@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserBiz< User, String> biz;
	public RegisterServlet() {
        super();
        biz = new UserBiz<>();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		name = Util.convertKr(name);
		User user = new User(id, pwd, name);
		try {
			biz.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("registeruser", user.getId());
		request.setAttribute("center", "registerok");
		request.setAttribute("nav", Navi.registerok);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}




