package mybatis.spring;

import mybatis.spring.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author: lds
 * @Date: 2019/6/12 9:42
 */
@Service
public class UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	public void selectAllUser(){
		System.out.println (userDao.selectAllUser ());
	}
	

}
