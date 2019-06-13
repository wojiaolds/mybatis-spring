package mybatis.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: lds
 * @Date: 2019/6/13 10:42
 */
@Retention ( RetentionPolicy.RUNTIME)
@Target ( ElementType.TYPE)
@Documented
@Import (MyBeanDefinitionRegistry.class)
public @interface MyMapperScan {
	
	String[] value() default {};
}
