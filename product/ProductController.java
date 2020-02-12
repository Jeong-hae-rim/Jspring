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
import org.springframework.web.bind.support.SessionStatus;

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
	
	@RequestMapping(value="/product")
	public void handle(@ModelAttribute("p001")ProductVO vo1, 
		      @ModelAttribute("p002")ProductVO vo2, 
		      @ModelAttribute("p003")ProductVO vo3, String list, int num1, int num2, int num3) {
		if(list == "p001") {
			vo1.setApple(num1);
		}else if(list == "p002") {
			vo2.setBanana(num2);
		}else if(list == "p003") {
			vo3.setHanra(num3);
		}
	        return ;
		}
	
	@RequestMapping(value="/productdel")
	public void handle(SessionStatus s) {
		s.setComplete(); //세션 객체는 남겨두지만 그 안에 있는 객체는 전부 다 삭제함.
		return;
	}
		
	}

