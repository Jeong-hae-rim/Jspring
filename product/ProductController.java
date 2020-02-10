package my.spring.springedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import vo.ProductVO;
import vo.CountVO;

@Controller 
@SessionAttributes({"pid1", "pid2", "pid3"})
public class ProductController {
	@ModelAttribute("pid1")
	public ProductVO productMethod1() {	
		System.out.println("productMethod1 호출 - product1");
		return new ProductVO();
	}
	@ModelAttribute("pid2")
	public ProductVO productMethod2() {	
		System.out.println("productMethod1 호출 - product2");
		return new ProductVO();
	}
	@ModelAttribute("pid3")
	public ProductVO productMethod3() {	
		System.out.println("productMethod1 호출 - product3");
		return new ProductVO();
	}
	
	@RequestMapping(value="/product1")
	public void handle(@ModelAttribute("pid1")ProductVO vo1, 
		      @ModelAttribute("pid2")ProductVO vo2, 
		      @ModelAttribute("pid3")ProductVO vo3, int num1, int num2, int num3) {
		
		vo1.setApple(num1);
		vo2.setBanana(num2);
		vo3.setHanra(num3);
		System.out.println("handle() : "+ 
			      vo1.getApple() + " : " + vo2.getBanana() + " : " + vo3.getHanra());
		System.out.println("=============================");
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		if(session.getAttribute("list") == null) {
			session.setAttribute("list", new ProductVO());
		}
		ProductVO vo = (ProductVO)session.getAttribute("list");
		if(pid.equals("p001")) {
			vo.setApple(1);
		}else if(pid.equals("p002")) {
			vo.setBanana(1);
		}else if(pid.equals("p003")) {
			vo.setHanra(1);
		} else {
			session.invalidate();
			PrintWriter out = response.getWriter();
			String str = "{\"msg\" : \"장바구니가 비워졌습니다.\"}";
	        out.print(str);
	        return;
		}
		
		request.getRequestDispatcher("/jspexam/productView.jsp").
        forward(request, response);

	}

}
