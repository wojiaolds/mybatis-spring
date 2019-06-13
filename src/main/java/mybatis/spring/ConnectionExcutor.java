package mybatis.spring;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.util.List;
import java.util.Map;

/**
 * Created by lds on 2019/4/29.
 */
public interface ConnectionExcutor {
	
	
	List<Map<String,Object>> query(String sql) throws Exception;
	
	 <T> List<T> query(String sql,RowMapper<T> rowMapper) throws Exception ;
	
	 <T> T query(String sql,ResultSetExtractor<T> rse) throws Exception;
		
	
	
}
