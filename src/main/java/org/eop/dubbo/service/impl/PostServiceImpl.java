package org.eop.dubbo.service.impl;

import org.eop.dubbo.entity.Post;
import org.eop.dubbo.service.PostService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author lixinjie
 * @since 
 */
@Service
public class PostServiceImpl implements PostService {

	@Override
	public Post getPost(String id, String name) {
		return new Post(id, name);
	}

}
