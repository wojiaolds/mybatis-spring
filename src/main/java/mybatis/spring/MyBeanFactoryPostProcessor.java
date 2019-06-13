package mybatis.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/6/13 14:44
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	@Override
	public void postProcessBeanFactory (
		ConfigurableListableBeanFactory beanFactory ) throws BeansException {
		System.out.println ("MyBeanFactoryPostProcessor--->>>postProcessBeanFactory");
		BeanDefinition beanDefinition= beanFactory.getBeanDefinition ("userDao");
		System.out.println(beanDefinition.getFactoryBeanName ());
		System.out.println(beanDefinition.getConstructorArgumentValues ());
		System.out.println(beanDefinition.getFactoryMethodName ());
		System.out.println(beanDefinition.getParentName ());
		System.out.println(beanDefinition.getPropertyValues ());
		
		
	}
}
