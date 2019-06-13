package mybatis.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: lds
 * @Date: 2019/6/12 9:34
 */
@Retention ( RetentionPolicy.RUNTIME)
@Target (value = { ElementType.METHOD })
public @interface Select {
	
	String value () default "";
}
