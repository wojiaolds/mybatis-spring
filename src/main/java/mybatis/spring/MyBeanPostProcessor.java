package mybatis.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: lds
 * @Date: 2019/6/12 16:06
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	//所有bean都会进入
	@Override
	public Object postProcessBeforeInitialization ( Object bean, String beanName )
	throws BeansException {
		System.out.println ("BeanPostProcessor----》"+beanName+"前置处理");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization ( Object bean, String beanName )
	throws BeansException {
		System.out.println ("BeanPostProcessor-----》"+beanName+"后置置处理");
		return bean;
	}
}
