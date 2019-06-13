package mybatis.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by lds on 2019/4/29.
 */
public class MyMapperHandler implements InvocationHandler {
	
//	MySqlSessionFactoryBean mySqlSessionFactoryBean = null;
//
//	public MyMapperHandler(MySqlSessionFactoryBean mySqlSessionFactoryBean) {
//		this.mySqlSessionFactoryBean = mySqlSessionFactoryBean;
//	}
	
	Sqlsession sqlsession = null;
	
	public MyMapperHandler(Sqlsession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	/**
	 *
	 * @param proxy
	 * @param method  mapper中的方法
	 * @param args  方法的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke( Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("运行invoke方法");
		System.out.println(method.getDeclaringClass().getName());
		
		Select select = method.getAnnotation (Select.class);
		
//		return mySqlSessionFactoryBean.sqlsession.selectAll (select.value ());
		return sqlsession.selectAll (select.value ());
	}
}
