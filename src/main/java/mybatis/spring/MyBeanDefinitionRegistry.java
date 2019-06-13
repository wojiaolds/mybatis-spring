package mybatis.spring;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lds
 * @Date: 2019/6/12 11:15
 */

public class MyBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
	
	@Override
	public void registerBeanDefinitions (
		AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry ) {
		
		AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
		List<String> basePackages = new ArrayList<> ();
		for (String pkg : annoAttrs.getStringArray("value")) {
			if (StringUtils.hasText(pkg)) {
				basePackages.add(pkg);
			}
		}
		
		for (String basePackage : basePackages) {
			String basePackageTmp = basePackage.replace (".","/");
			URL url = this.getClass ().getClassLoader ().getResource (basePackageTmp);
			File srcDir = new File (url.getFile ());
			File files[] = srcDir.listFiles ();
			for ( File file:files ) {
				String fileName = file.getName ();
				System.out.println (fileName);
				String constructorArgValue = basePackage+"."+fileName.substring (0,fileName.lastIndexOf ("."));
				System.out.println (constructorArgValue);
				
				String firstLetter = fileName.substring (0,fileName.lastIndexOf (".")).substring(0, 1).toLowerCase ();
				String beanName = firstLetter + fileName.substring (0,fileName.lastIndexOf (".")).substring(1);
				
				BeanDefinitionBuilder beanDefinitionBuilder =
					BeanDefinitionBuilder.genericBeanDefinition (MyMapperFactoryBean.class);
				//beanDefinition.setBeanClassName ();
				beanDefinitionBuilder.addConstructorArgValue (constructorArgValue);
				beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
				registry.registerBeanDefinition (beanName,beanDefinitionBuilder.getBeanDefinition ());
			}
		}
		
		
		
	}
	
	
	
	
}
