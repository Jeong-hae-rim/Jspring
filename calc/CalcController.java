package my.spring.springedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vo.MyVO;

@Controller

public class CalcController {

	@Autowired
	ServletContext context;

	public CalcController() {
		System.out.println("CalcController Create object");
	}

	@RequestMapping(value = "/calc1", method = RequestMethod.GET)
	public ModelAndView mycalc(@RequestParam("num1") int num1, @RequestParam("num2") int num2,
			@RequestParam("calc") String calc) {
		
		int result = 0;
		
		ModelAndView mav = new ModelAndView();
		
		if (calc.equals("+")) {
			result = num1 + num2;
			mav.addObject("result", result);
		} else if (calc.equals("-")) {
			result = num1 - num2;
			mav.addObject("result", result);
		} else if (calc.equals("*")) {
			result = num1 * num2;
			mav.addObject("result", result);
		} else if (calc.equals("/")) {
			if (num2 != 0) {
				result = num1 / num2;
				mav.addObject("result", result);
			} else {
				mav.addObject("result", "나눗셈 연산 시 두 번째 숫자는 0일 수 없습니다.");
				mav.setViewName("errorResult");
			}
		}
		mav.setViewName("calcResult");
		return mav;
	}

}
