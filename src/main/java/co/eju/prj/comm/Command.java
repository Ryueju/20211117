package co.eju.prj.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
//이 인터페이스는 우리가 결과를 view페이지로 돌려주기때문에 string으로 함
	public String run(HttpServletRequest request, HttpServletResponse response);
						//전달 인자로 받음.서버가 만들어준 이 값들을 이용하는 것임.
}
