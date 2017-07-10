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
		/**
		 * 服务被注册到zookeeper里面，路径是/dubbo/org.eop.dubbo.service.PostService
		 * 服务提供者路径/dubbo/org.eop.dubbo.service.PostService/providers，对应的数据也以子节点形式提供，如下
		 * dubbo://192.168.95.236:20880/org.eop.dubbo.service.PostService?anyhost=true&application=app-provider&dubbo=2.5.3
		 * &interface=org.eop.dubbo.service.PostService&methods=getPost
		 * &pid=2616&side=provider&timestamp=1499674190015，上面这么多数据其实是一个节点的名称，因名称中不能包含斜线
		 * 所以会进行url编码，如下
		 * dubbo%3A%2F%2F192.168.95.236%3A20880%2Forg.eop.dubbo.service.PostService%3Fanyhost%3Dtrue%26application%3Dapp-provider%26dubbo%3D2.5.3
		 * %26interface%3Dorg.eop.dubbo.service.PostService%26methods%3DgetPost
		 * %26pid%3D2616%26side%3Dprovider%26timestamp%3D1499674190015
		 * 
		 * 如果注册多个服务的话/dubbo节点下就有多个子节点[org.eop.dubbo.service.PostService, org.eop.dubbo.service.UserService]
		 * 子节点的名称就是接口名称，再往下一层的子节点名称就是具体dubbo服务地址信息，如上
		 * 
		 * 同一个应用在不同的节点上运行多次，就提供了多份服务，它们对应同一个接口名称，在zookeeper里位于同一个子节点下面，起到水平扩展和负载均衡的作用
		 * 在同一个节点上只能运行一次，否则报端口已绑定错误
		 * 
		 * 当某个节点的dubbo服务运行出问题时，它和zookeeper间的心跳信息就会中断，然后过一定时间zookeeper中和该节点相关的session就会超时，zookeeper中
		 * 表示该dubbo服务节点地址信息的那个子节点是临时节点，随着session的超时就会被删除，这样服务消费方就不会再得到该节点的地址信息了，因为该节点已经
		 * 不可用了
		 * 
		 * 其实dubbo就是利用应用程序（服务提供方）所在的节点和zookeeper之间的长连接的有效性，来维护当前可用的所有节点列表，当有新的节点建立长连接时，就
		 * 把该节点添加进去，表明又多了一个新的服务提供者，当某个节点失去长连接时，且在指定时间内没有重新连上，就删除该节点，表明该节点不可用了
		 * 
		 * 完全利用了zookeeper本身的特性
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
		
		System.in.read();
	}

}
