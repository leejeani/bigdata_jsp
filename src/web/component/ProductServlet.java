package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;

import web.dispatcher.Navi;

@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductBiz<Product, Integer> biz;

	String dir = "C:\\jsp\\d03\\web\\img";
	int size = 1024 * 1024 * 1024;
	MultipartRequest mr;

	public ProductServlet() {
		super();
		biz = new ProductBiz<>();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		RequestDispatcher rd = null;
		String next = "main.jsp";
		if (cmd.equals("add")) {
			mr = new MultipartRequest(request, dir, size, "EUC-KR");
			int id = Integer.parseInt(mr.getParameter("id"));
			int price = Integer.parseInt(mr.getParameter("price"));
			String name = mr.getParameter("name");
			String imgname = mr.getOriginalFileName("img");

			Product p = new Product(id, name, price, imgname);
			try {
				biz.register(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("detailp", p);
			request.setAttribute("center", "product/detail");
			request.setAttribute("nav", Navi.productdetail);

		} else if (cmd.equals("detail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = null;
			try {
				p = biz.get(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("detailp", p);
			request.setAttribute("nav", Navi.productdetail);
			request.setAttribute("center", "product/detail");
		} else if (cmd.equals("list")) {
			ArrayList<Product> list = null;
			try {
				list = biz.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("listp", list);
			request.setAttribute("nav", Navi.productlist);
			request.setAttribute("center", "product/list");
		} else if (cmd.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				biz.remove(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("product.mc?cmd=list");
			return;
		} else if (cmd.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = null;
			try {
				p = biz.get(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("updatep", p);
			request.setAttribute("nav", Navi.productupdate);
			request.setAttribute("center", "product/update");
		} else if (cmd.equals("updateimpl")) {
			mr = new MultipartRequest(request, dir, size, "EUC-KR");
			int id = Integer.parseInt(mr.getParameter("id"));
			int price = Integer.parseInt(mr.getParameter("price"));
			String name = mr.getParameter("name");
			String imgname = mr.getParameter("imgname");
			String newimgname = mr.getOriginalFileName("newimgname");
			Product p = null;
			if(newimgname == null
				|| newimgname.equals("")) {
				p = new Product(id, name, price, imgname);
			}else {
				p = new Product(id, name, price, newimgname);	
			}
			
			try {
				biz.modify(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect(
				"product.mc?cmd=detail&id="+id);
			return;
		}
		rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
