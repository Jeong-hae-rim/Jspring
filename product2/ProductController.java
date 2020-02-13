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
@SessionAttributes({ "psession" })
public class ProductController {
	@ModelAttribute("psession")
	public ProductVO productMethod1() {
		System.out.println("productMethod1 호출 - psession");
		return new ProductVO();
	}

	@RequestMapping(value = "/product")
	public String handle(@ModelAttribute("psession") ProductVO vo) {
		return "productView";
	}

	@RequestMapping(value = "/productdel")
	public String handle(SessionStatus s) {
		s.setComplete(); // 세션 객체는 남겨두지만 그 안에 있는 객체는 전부 다 삭제함.
		return "productdel";
	}

}
