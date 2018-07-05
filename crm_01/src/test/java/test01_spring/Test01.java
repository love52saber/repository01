package test01_spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Test01 {
	
	@SuppressWarnings("resource")
	@Test
	public void test01() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object object = context.getBean("sessionFactory");
	}
}
