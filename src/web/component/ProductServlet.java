package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductBiz;
import com.vo.Product;

@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductBiz<Product,Integer> biz;
	
    public ProductServlet() {
        super();
        biz = new ProductBiz<>();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "";
		RequestDispatcher rd = null;
		if(cmd.equals("add")) {
			next = "padd.jsp";
		}else if(cmd.equals("addimpl")){
			String strid = request.getParameter("id");
			String name = request.getParameter("name");
			String strprice = request.getParameter("price");
			name = Util.convertKo(name);
			int id = Integer.parseInt(strid);
			int price = Integer.parseInt(strprice);
			
			Product p = new Product(id, name, price);
			
			try {
				biz.register(p);
				next = "main.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("list")) {
			ArrayList<Product> list = null;
			try {
				list = biz.get();
				next = "plist.jsp";
				request.setAttribute("plist", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("detail")) {
			String strid = request.getParameter("id");
			int id = Integer.parseInt(strid);
			Product p = null;
			try {
				p = biz.get(id);
				next = "detail.jsp";
				request.setAttribute("product", p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("update")) {
			String strid = request.getParameter("id");
			int id = Integer.parseInt(strid);
			Product p = null;
			try {
				p = biz.get(id);
				next = "update.jsp";
				request.setAttribute("product", p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("updateimpl")) {
			String strid = request.getParameter("id");
			String name = request.getParameter("name");
			String strprice = request.getParameter("price");
			name = Util.convertKo(name);
			int id = Integer.parseInt(strid);
			int price = Integer.parseInt(strprice);
			Product p = new Product(id, name, price);
			try {
				biz.modify(p);
				next = "product?cmd=detail&id="+id;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("delete")) {
			String strid = request.getParameter("id");
			int id = Integer.parseInt(strid);
			try {
				biz.remove(id);
				next = "product?cmd=list";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}









