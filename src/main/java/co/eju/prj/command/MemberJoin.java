package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.service.MemberVO;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class MemberJoin implements Command {

	private String message;
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService memberDao = new MemberServiceImlp();
		MemberVO vo  = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddress(request.getParameter("address"));
		vo.setAuthor("USER");
		int n = memberDao.memberInsert(vo); //insert할때 vo 객체를 실어서 보내주면됨
		
		if(n != 0) {
			//성공적으로 들어가면
			message="회원가입이 성공적으로 되었습니다.";
		}else {
			message="회원가입이 실패하였습니다..<br>관리자에 문의하세요. ";
		}
		request.setAttribute("message", message);
		return "member/memberJoin";
	}

}
