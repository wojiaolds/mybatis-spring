package mybatis.spring;

import java.lang.annotation.*;

/**
 * @Author: lds
 * @Date: 2019/6/13 11:47
 */
@Documented
@Inherited
@Retention ( RetentionPolicy.RUNTIME)
@Target ({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface MyMapper {

}
