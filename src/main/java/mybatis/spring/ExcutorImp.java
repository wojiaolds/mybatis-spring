package mybatis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by lds on 2019/4/29.
 */
@Component
public class ExcutorImp implements ConnectionExcutor {
	@Autowired
	private DataSource dataSource;
	
	public ExcutorImp () {
	
	}
	
//	public ExcutorImp ( DataSource dataSource ) {
//
//		this.dataSource = dataSource;
//	}
	
	@Override
	public List <Map <String, Object>> query (String sql) throws Exception {
		
		return query(sql,new ColumnMapRowMapper ());
	}
	
	public <T> List<T> query(String sql,RowMapper<T> rowMapper) throws
							 Exception {
		return query( sql,new RowMapperResultSetExtractor<T> (rowMapper));
	}
	
	@Override
	public <T> T query ( String sql,ResultSetExtractor<T> rse ) throws Exception {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = dataSource.getConnection ();
		try {
			PreparedStatement pre = connection.prepareStatement (sql);
			ResultSet set = pre.executeQuery ();
			User user = new User ();

			return rse.extractData (set);
	
		} catch ( SQLException e ) {
			e.printStackTrace ();
		}
		return null;
	}
	
	
}
