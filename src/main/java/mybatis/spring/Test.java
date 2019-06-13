package mybatis.spring;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Author: lds
 * @Date: 2019/6/12 9:57
 */
public class Test {
	
	public static void main(String...args) throws Exception{
		
		AnnotationConfigApplicationContext annotationConfigApplicationContext=
			new AnnotationConfigApplicationContext (AppConfig.class);
		
		UserService userService =
			annotationConfigApplicationContext.getBean (UserService.class);
		
		userService.selectAllUser ();
		
		
		BeanInfo beanInfo = Introspector.getBeanInfo(Test.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if (pd.getName().equals("class")) {
				continue;
			}
			System.out.println(pd.getName());
			System.out.println(pd.getReadMethod());
			System.out.println(pd.getWriteMethod());
			System.out.println("********");
		}
	}
	
	public void setName(String name){}
}
