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

@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserBiz<User, String> biz;
	public RegisterServlet() {
        super();
        biz = new UserBiz<>();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		name = Util.convertKo(name);
		User user = new User(id, pwd, name);
		String next = "main.jsp";
		RequestDispatcher rd = null;
		try {
			biz.register(user);
			next = "registerok.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			next = "error.jsp";
		}
		request.setAttribute("id", id);
		rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}









