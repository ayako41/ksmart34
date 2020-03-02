package kr.or.ksmart.springboot34_34_mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.ksmart.springboot34_34_mybatis.inteceptor.CommonInterceptor;
import kr.or.ksmart.springboot34_34_mybatis.inteceptor.LoginInterseptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private CommonInterceptor commonInterceptor;
	
	@Autowired
	private LoginInterseptor loginInterseptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/css/**");
		//LoginInterseptorで設定したものを適用させる
		//フォルダ名を記入。今回は全てのフォルダ。
		//下記四つを除外したページはログインしないと見れない。
		//ログインしていない場合、ログインページが表示される。
		/*
		registry.addInterceptor(loginInterseptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/mInsert")
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**");
		*/
	}
}
