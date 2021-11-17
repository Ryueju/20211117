package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.service.MemberVO;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class MemberInfo implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원 정보 조회
		HttpSession session = request.getSession();
		MemberService memberDao = new MemberServiceImlp();
		MemberVO vo = new MemberVO();
		vo.setId((String) session.getAttribute("id")); //세션정보가 가지고 있느 회원 아이디를 가져옴 (String)타입으로 캐스케이딩해줘야함.cast argument
//		vo.setName((String) session.getAttribute("name"));
//		vo.setTel((String) session.getAttribute("tel"));
		
		request.setAttribute("member", memberDao.memberSelect(vo));
				
		return "member/memberInfo";
	}

}
