package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.service.MemberVO;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class MemberEditSave implements Command {
	private String message;
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원수정
		MemberService memberDao = new MemberServiceImlp();
		MemberVO vo  = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddress(request.getParameter("address"));
		vo.setAuthor("USER");
		int n = memberDao.memberUpdate(vo);
		
		if(n!=0) {
			message = "회원 정보가 수정되었습니다.";
		}
		request.setAttribute("message", message);
		
		return "member/memberInfo";
	}

}
