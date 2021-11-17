package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 멤버목록
		MemberService memberDao = new MemberServiceImlp();
		request.setAttribute("members", memberDao.memberSelectList());
							//리스트변수이면 자동으로 리스트로 담김
		return "member/memberList";
	}

}
