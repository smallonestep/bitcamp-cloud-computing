package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annoation.RequestMapping;
import bitcamp.pms.dao.MemberDao;

@Controller("/member/delete")
public class MemberDeleteController {
	
	MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public MemberDeleteController(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public MemberDeleteController() {
		super();
	}

	@RequestMapping
	public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		memberDao.delete(request.getParameter("id"));
		return "redirect:list";
	}
}
