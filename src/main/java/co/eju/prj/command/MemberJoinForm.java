package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;

public class MemberJoinForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 폼 만 호출하면 됨
		
		return "member/memberJoinForm";
	}

}
