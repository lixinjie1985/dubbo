package org.eop.dubbo.test;

import org.eop.dubbo.component.PostComponent;
import org.eop.dubbo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lixinjie
 * @since 
 */
public class TestConsumer1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		UserService userService = (UserService)context.getBean("userService");
		System.out.println(userService.getUser("1010", "李新杰", "男", 32));
		PostComponent postCmp = (PostComponent)context.getBean("postComponent");
		postCmp.getCmp();
	}

}
