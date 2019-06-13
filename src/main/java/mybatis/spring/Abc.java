package mybatis.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: lds
 * @Date: 2019/6/12 15:30
 */
@Component
public class Abc implements ApplicationContextAware, InitializingBean, DisposableBean,BeanNameAware,
			    BeanFactoryAware {
	
	public Abc () {
		
		System.out.println ("Abc()");
	}
	
	@Override
	public void setApplicationContext (
		ApplicationContext applicationContext ) throws BeansException {
		
		try {
//			System.out.println (applicationContext);
//			System.out.println (
//				applicationContext.getBean (MySqlSessionFactoryBean.class));
			System.out.println ("ApplicationContextAware----》setApplicationContext");
		} catch ( Exception e ) {
			System.out.println (e);
		}
	}
	
	@Override
	public void afterPropertiesSet () throws Exception {
		System.out.println ("InitializingBean----》afterPropertiesSet");
	}
	
	@Override
	public void destroy () throws Exception {
		System.out.println ("DisposableBean----》destroy");
	}
	
	@Override
	public void setBeanFactory ( BeanFactory beanFactory ) throws BeansException {
		System.out.println ("BeanFactoryAware----》setBeanFactory");
	}
	
	@Override
	public void setBeanName ( String name ) {
		System.out.println ("BeanNameAware----》setBeanName");
	}
	
	@PostConstruct
	public void init(){
		System.out.println ("init-method");
	}
	
	@PreDestroy
	public void PreDestroy(){
		System.out.println ("PreDestroy");
	}
	
}
