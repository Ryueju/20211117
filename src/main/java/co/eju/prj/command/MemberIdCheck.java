package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;
import co.eju.prj.member.service.MemberService;
import co.eju.prj.member.service.MemberVO;
import co.eju.prj.member.serviceImpl.MemberServiceImlp;

public class MemberIdCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//아이디 중복체크 (Ajax이용)
		MemberService memberDao = new MemberServiceImlp();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("chkid"));
//										ㄴajax에서 넘겨준 데이터
		boolean b = memberDao.memberIdCheck(vo); //TRUE는 존재 false는 사용가능
		String chk  = "0";
		if(b) {//존재하면 0으로바꿔주고
			chk = "1"; 
		}
		
//		request.setAttribute("idCheck", chk);
							//idCheck라는 변수를 만들어서 b로 
		return "ajax:" + chk;
	}

}
