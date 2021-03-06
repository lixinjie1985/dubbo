package org.eop.dubbo.component;

import org.eop.dubbo.entity.Post;
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
	
	public Post getCmp(String id, String name) {
		return postService.getPost(id, name);
	}
}
