package org.eop.dubbo.component;

import org.eop.dubbo.service.PostService;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author lixinjie
 * @since 
 */
@Component
public class PostComponent {

	@Reference
	private PostService postService;
	
	public void getCmp() {
		System.out.println(postService.getPost("3030", "开发人员"));
	}
}
