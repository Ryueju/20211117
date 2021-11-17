package co.eju.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.command.HomeCommand;
import co.eju.prj.command.Logout;
import co.eju.prj.command.MemberDelete;
import co.eju.prj.command.MemberEditSave;
import co.eju.prj.command.MemberIdCheck;
import co.eju.prj.command.MemberInfo;
import co.eju.prj.command.MemberJoin;
import co.eju.prj.command.MemberJoinForm;
import co.eju.prj.command.MemberList;
import co.eju.prj.command.MemberLoginForm;
import co.eju.prj.command.MemberUpdate;
import co.eju.prj.command.Memberlogin;


	
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       1.해시맵을만들어줌
	private HashMap<String, Command> map = new HashMap<String, Command>();
//					<키 값, 밸류 값>
	
    public FrontController() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
//		명령 커맨드 그룹들을 쌓아주면 됨, command들을 요청에 따라 처리할 수 있도록 
//		메모리에 구성함.
		map.put("/home.do", new HomeCommand()); //인터페이스를 상속받아 만든 커멘드를 써줌 //홈 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberlogin.do", new Memberlogin()); //로그인 처리
		map.put("/logout.do", new Logout());//로그아웃 처리
		map.put("/memberList.do", new MemberList()); //멤버 목록
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입
		map.put("/ajaxIdCheck.do", new MemberIdCheck()); //아이디 중복체크하기
		map.put("/memberJoin.do", new MemberJoin());//회원 가입 처리
		map.put("/memberInfo.do", new MemberInfo()); //회원 정보 
		map.put("/memberUpdate.do", new MemberUpdate());//회원정보수정
		map.put("/memberEditSave.do", new MemberEditSave()); //회원정보 수정 저장하기
		map.put("/memberDelete.do", new MemberDelete()); //회원탈퇴 정말로 db에도 삭제하기
		
	}

//												서버가자동으로만들어준
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		어떤요청이 들어왔는지 요청을 분석하고 실행할 command들을 찾아서 수행하고 결과를 돌려주는 메소드
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		//도메인 네임을 뺀 나머지를 구하고 
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length()); // /부터만 남아있게 됨.
		
		Command command = map.get(page);//키 값을 보내주면 담겨있는 value값이 나에게 들어오게됨. new HomeCommand
		String viewPage = command.run(request, response);
				//2 결과페이지				//1 여기가 먼저수행되면
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) { //ajax처리
						response.setContentType("text/html; charset=UTF-8");
						response.getWriter().append(viewPage.substring(5));
						return;			
			} else {
				
				viewPage = "WEB-INF/views/" +viewPage +".jsp";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
