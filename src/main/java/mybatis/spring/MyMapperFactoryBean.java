package mybatis.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @Author: lds
 * @Date: 2019/6/12 10:21
 */

public class MyMapperFactoryBean implements FactoryBean {
	
	private String mapperInterfaceName;
	
//	@Autowired
//	private MySqlSessionFactoryBean mySqlSessionFactoryBean;
	
//	@Autowired
	private Sqlsession sqlsession;
	
	public void setSqlsession(Sqlsession sqlsession){
		this.sqlsession = sqlsession;
	}
	
	public MyMapperFactoryBean () {
		
		System.out.println ("MyMapperFactoryBean ()");
	}
	
	public MyMapperFactoryBean ( String mapperInterface ) {
		
		System.out.println ("MyMapperFactoryBean (Object mapperInterface)");
		
		this.mapperInterfaceName = mapperInterface;
	}
	
	@Override
	public Object getObject () throws Exception {
		
//		Object object = Proxy.newProxyInstance (MyMapperFactoryBean.class.getClassLoader (),
//							new Class[] { getObjectType() },
//							new MyMapperHandler (
//								mySqlSessionFactoryBean));
		
		return sqlsession.getMapper (getObjectType());
	}
	
	@Override
	public Class <?> getObjectType () {
		
		try {
			return Class.forName (mapperInterfaceName);
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace ();
		}
		return null;
		
	}
	
	@Override
	public boolean isSingleton () {
		
		return false;
	}
	
}
