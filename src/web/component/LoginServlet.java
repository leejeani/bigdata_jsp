package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.UserBiz;
import com.vo.User;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBiz< User, String> biz;
    public LoginServlet() {
        super();
        biz = new UserBiz<>();
    }
    // LOGOUT
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			response.sendRedirect("main.jsp");
		}
	}
	// LOGIN 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// �ش� ID�� ������ ��û�Ͽ�
		// User ������ �ִ��� Ȯ��
		// ���� �Ѵٸ� User������ PWD��
		// �Է� �� PWD�� �� �Ͽ� 
		// �α��� ó��
		//session�� "loginuser"�� ����.
		RequestDispatcher rd = null;
		String next = "main.jsp";
		User user = null;
		try {
			user = biz.get(id);
			if(pwd.equals(user.getPwd())) {
				HttpSession session = 
						request.getSession();
				session.setAttribute("loginuser", user);
			}else {
				next = "loginfail.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			next = "loginfail.jsp";
		}
		rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}










