package mybatis.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * @Author: lds
 * @Date: 2019/6/12 9:56
 */
@Configuration
@PropertySource({"classpath:jdbc.properties"})
@ComponentScan (
	value = "mybatis.spring",excludeFilters = {
	@ComponentScan.Filter(type = FilterType.REGEX,pattern = { "mybatis.spring.mapper"}),
	@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = { Configuration.class})
})
@MyMapperScan("mybatis.spring.mapper")
public class AppConfig {
	
	
	@Bean
	DataSource dataSource (@Value ("${db.driverClassName}") String driverClass,
			       @Value("${db.url}") String jdbcUrl,
			       @Value("${db.userName}") String userName,
			       @Value("${db.password}") String passWord) {
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource ();
		driverManagerDataSource.setDriverClassName (driverClass);
		driverManagerDataSource.setUrl (jdbcUrl);
		driverManagerDataSource.setUsername (userName);
		driverManagerDataSource.setPassword (passWord);
		return driverManagerDataSource;
	}
	
}
