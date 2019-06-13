package mybatis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

/**
 * Created by lds on 2019/4/29.
 */
@Component
public class Sqlsession {
	@Autowired
	private ConnectionExcutor connectionExcutor ;
	
	public Sqlsession(){}
	
//	public Sqlsession( DataSource dataSource){
//		this.excutorImp = new ExcutorImp (dataSource);
//	}
	//查询数据库操作
	public List<Map<String,Object>> selectAll( String sql) throws Exception{
		return connectionExcutor.query (sql);
	}
	
	//用动态代理完成传入的Mapper接口要完成的操作
	public <T> T getMapper(Class<T> tClass) {
		return (T)
			Proxy.newProxyInstance(
				tClass.getClassLoader(), new Class[] {tClass}, new MyMapperHandler(this));
	}
	
}
