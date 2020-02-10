package my.spring.springedu;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController {	

	@RequestMapping(value = "/member1", method = RequestMethod.POST)
	public ModelAndView proc(MemberVO vo) {
		
		ModelAndView mav = new ModelAndView();
		String name = vo.getName();
		String phone = vo.getPhone();
		String id = vo.getId();
		String passwd = vo.getPasswd();

		System.out.println(name);
		if(name=="") vo.setName("없음");;
		if(phone=="") vo.setPhone("없음");
		if(id=="") vo.setId("없음");
		if(passwd=="") vo.setPasswd("없음");
		
		mav.addObject("name", name);
		mav.addObject("phone", phone);
		mav.addObject("id", id);
		mav.addObject("passwd", passwd);
		
		mav.setViewName("memberView");
		return mav;
		              	
	}

}

