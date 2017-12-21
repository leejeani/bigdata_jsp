package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
        System.out.println("Constructor");
    }

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("Service ...");
		 response.setContentType("text/html;charset=EUC-KR");
		 PrintWriter out = 
				 response.getWriter();
		 out.print("<form action='calc' method='get'>");
		 out.print("Num1 <input type='number' name='num1'><br>");
		 out.print("Num2 <input type='number' name='num2'><br>");
		 out.print("<input type='submit' value='°è»ê'>");
		 out.print("</form>");
		 out.close();
	}

}






