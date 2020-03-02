package kr.or.ksmart.springboot34_34_mybatis.inteceptor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterseptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) 
			throws Exception {
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("SID");
		if(sId==null) {
			response.sendRedirect("/login");
		}//ログインしていなければ、loginに移動。
		return super.preHandle(request, response, handler);
		
	};
}
