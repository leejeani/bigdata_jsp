package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/CalcServlet", "/calc" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		System.out.println(num1+" "+num2);
		double dnum1 = Double.parseDouble(num1);
		double dnum2 = Double.parseDouble(num2);
		
		double sum = dnum1 + dnum2;
		double avg = sum/2.0;
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = 
				response.getWriter();
		out.print("<h1>Result</h1>");
		out.print("<h2>SUM:"+sum+"</h2>");
		out.print("<h2>AVG:"+avg+"</h2>");
		out.close();
		
	}

}






