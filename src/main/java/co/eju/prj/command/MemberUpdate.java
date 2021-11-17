package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.service.MemberVO;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class MemberUpdate implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//회원정보수정 회원정보를먼저가지고와서 수정하는 폼에 젛어줘야함
		MemberService memberDao = new MemberServiceImlp();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id")); //세션정보가 가지고 있느 회원 아이디를 가져옴 (String)타입으로 캐스케이딩해줘야함.cast argument
//		vo.setName((String) session.getAttribute("name"));
//		vo.setTel((String) session.getAttribute("tel"));
		
		request.setAttribute("member", memberDao.memberSelect(vo));
		return "member/memberUpdate";
	}

}
