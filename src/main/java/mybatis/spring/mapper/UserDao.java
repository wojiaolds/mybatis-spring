package mybatis.spring.mapper;

import mybatis.spring.MyMapper;
import mybatis.spring.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: lds
 * @Date: 2019/6/12 9:32
 */
@MyMapper
public interface UserDao {
	@Select ("select * from user")
	List<Map<String,Object>> selectAllUser( );
}
