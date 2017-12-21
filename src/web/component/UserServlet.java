package web.component;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBiz<User, String> biz;
	public UserServlet() {
        super();
        biz = new UserBiz<>();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		RequestDispatcher rd = null;
		
		if(cmd.equals("add")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			name = Util.convertKr(name);
			User user = new User(id, pwd, name);
			try {
				biz.register(user);
				response.sendRedirect("user.mc?cmd=list");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("list")) {
			ArrayList<User> list = null;
			try {
				list = biz.get();
				request.setAttribute("userlist", list);
				request.setAttribute("center", "user/list");
				request.setAttribute("nav", Navi.userlist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("delete")) {
			String id = request.getParameter("id");
			try {
				biz.remove(id);
				response.sendRedirect("user.mc?cmd=list");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("update")) {
			String id = request.getParameter("id");
			User user = null;
			try {
				user = biz.get(id);
				request.setAttribute("center", "user/update");
				request.setAttribute("updateuser", user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(cmd.equals("updateimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			name = Util.convertKr(name);
			User user = new User(id, pwd, name);
			try {
				biz.modify(user);
				response.sendRedirect("user.mc?cmd=detail&id="+id);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("detail")) {
			String id = request.getParameter("id");
			User user = null;
			try {
				user = biz.get(id);
				request.setAttribute("center", "user/detail");
				request.setAttribute("detailuser", user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}







