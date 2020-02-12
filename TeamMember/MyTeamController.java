package my.spring.springedu;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.TeamMemberVO;
import vo.TeamVO;

@Controller
public class MyTeamController {
	
	
	@RequestMapping(value = "/body/xml3/{id}", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public TeamVO TeamMember1(@PathVariable String id) {
		TeamVO vo = new TeamVO();
		ArrayList<TeamMemberVO> list = new ArrayList<TeamMemberVO>();
		TeamMemberVO my = new TeamMemberVO();
		my.setName("정해림");
		my.setNicName("지각쟁이");
		list.add(my);
		my = new TeamMemberVO();
		my.setName("김수이");
		my.setNicName("팀의 기둥");
		list.add(my);
		my = new TeamMemberVO();
		my.setName("황지원");
		my.setNicName("에이스");
		list.add(my);
		vo.setTeamName("잉력시장");
		vo.setTeamMember(list);
		return vo;
	}	
	
	
	@RequestMapping(value = "/body/json5/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public TeamVO TeamMember2(@PathVariable String id) {
		TeamVO vo = new TeamVO();
		ArrayList<TeamMemberVO> list = new ArrayList<TeamMemberVO>();
		TeamMemberVO my = new TeamMemberVO();
		my.setName("정해림");
		my.setNicName("지각쟁이");
		list.add(my);
		my = new TeamMemberVO();
		my.setName("김수이");
		my.setNicName("팀의 기둥");
		list.add(my);
		my = new TeamMemberVO();
		my.setName("황지원");
		my.setNicName("에이스");
		list.add(my);
		vo.setTeamName("잉력시장");
		vo.setTeamMember(list);
		return vo;
	}	
	
	

}
