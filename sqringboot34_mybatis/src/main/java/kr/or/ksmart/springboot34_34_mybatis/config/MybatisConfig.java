package kr.or.ksmart.springboot34_34_mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration//設定
@MapperScan(value = "kr.or.ksmart.springboot34_34_mybatis")
*/
public class MybatisConfig {
	/*
	@Bean(name="mybatisSqlSessionFactory")
	*/
	public SqlSessionFactory mybatisSqlSessionFactory(DataSource datasourse,ApplicationContext context) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(context.getResources("classpath:mapper/**/*.xml"));
		bean.setDataSource(datasourse);
		return bean.getObject();
	}
}
