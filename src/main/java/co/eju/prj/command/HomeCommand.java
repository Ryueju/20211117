package co.eju.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.eju.prj.comm.Command;

public class HomeCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//여기서는 단순히 처음 들어오는 홈 페이지를 열어줌.
		return "home/home";
	}

}
