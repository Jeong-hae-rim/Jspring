package my.spring.springedu;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController {	

	@RequestMapping("/member1")
	public ModelAndView proc(MemberVO vo) {
		
		
		ModelAndView mav = new ModelAndView();
		String name = vo.getName();
		String phone = vo.getPhone();
		String id = vo.getId();
		String passwd = vo.getPasswd();

		System.out.println(name);
		if(name=="") name="없음";
		if(phone=="") phone="없음";
		if(id=="") id="없음";
		if(passwd=="") passwd="없음";
		
		mav.addObject("name", name);
		mav.addObject("phone", phone);
		mav.addObject("id", id);
		mav.addObject("passwd", passwd);
		
		mav.setViewName("memberView");
		return mav;
		              	
	}

}

