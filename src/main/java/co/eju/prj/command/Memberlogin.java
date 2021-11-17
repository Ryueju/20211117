package co.eju.prj.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.service.MemberVO;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class Memberlogin implements Command {
	
	private String message;
	
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 모델을 호출해야 하므로 db와 연결되어야 함. 
		//session인터페이스 하나 불러오자
		HttpSession session = request.getSession();
		MemberService memberDao = new MemberServiceImlp();
//				ㄴ 인터페이스는 자기자신안되고 구현체로 초기화할 수 있음
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member = memberDao.memberSelect(member);
							//역할 1한 명 조회, 2로그인 체크
		if(member !=null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("author", member.getAuthor());
			session.setAttribute("name", member.getName());
//			세션에먼저 담아주고
			message = member.getName() + "님 환영합니다!" ;
		} else {
			message = "아이디 또는 패스워드를 확인하세요..." ;
		}
		//리퀘스틑 객체에 메시지를 담아줌
		request.setAttribute("message", message);
		return "member/memberLogin";
	}


}
