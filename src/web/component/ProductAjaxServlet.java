package web.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.product.ProductBiz;
import com.vo.Product;

@WebServlet({ "/ProductAjaxServlet", "/productajax" })
public class ProductAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductBiz<Product, Integer> biz;
	
    public ProductAjaxServlet() {
        super();
        biz = new ProductBiz<>();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> list = null;
		try {
			list = biz.get();
			JSONArray ja = new JSONArray();
			for(Product p:list) {
				JSONObject jo = new JSONObject();
				jo.put("id", p.getId());
				jo.put("name", p.getName());
				jo.put("price", p.getPrice());
				jo.put("regdate", p.getRegdate().toString());
				ja.add(jo);			
			}
			response.setContentType("text/json;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.print(ja.toJSONString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}










