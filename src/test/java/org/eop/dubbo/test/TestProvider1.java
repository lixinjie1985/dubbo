package org.eop.dubbo.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lixinjie
 * @since 
 */
public class TestProvider1 {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		
		System.in.read();
	}

}
