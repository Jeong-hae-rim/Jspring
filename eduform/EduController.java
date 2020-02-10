package my.spring.springedu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
	@Autowired
	ServletContext context;

	public EduController() {
		System.out.println("EduController Create object");
	}

	@RequestMapping(value = "/eduform1", method = {RequestMethod.GET, RequestMethod.POST})
	 
		public ModelAndView myPost( 
				@RequestParam("id") String id,
			    @RequestParam("score") int score) {
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("id", id);
			switch(score/10) {
			case 10:
			case 9: 
				mav.setViewName("gradeA");
				break;
			case 8:
				mav.setViewName("gradeB");
				break;
			case 7:
				mav.setViewName("gradeC");
				break;
			default:
				mav.setViewName("gradeD");
				break;
			}
			
			return mav;
		}
	

}
