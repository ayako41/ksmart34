package kr.or.ksmart.springboot34_34_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "kr.or.ksmart.springboot34_34_mybatis")
public class Sqringboot34MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sqringboot34MybatisApplication.class, args);
	}

}
