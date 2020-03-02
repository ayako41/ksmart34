package kr.or.ksmart.springboot34_34_mybatis.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	
	

	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	//preHandleだけ入力したら、このメソッドが自動で入力される
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("CommonInterceptor------------------");
		logger.info("ACCESS INFO-------------------------start");
		logger.info("getLocalPort	::::::{}", request.getLocalPort());
		logger.info("getServerName	::::::{}", request.getServerName());
		logger.info("getMethod	::::::{}", request.getMethod());
		logger.info("getRequestURI	::::::{}", request.getRequestURI());
		logger.info("ACCESS INFO-------------------------end");
		
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("CommonInterceptor---------------");
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
