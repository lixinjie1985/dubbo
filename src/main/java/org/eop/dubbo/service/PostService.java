package org.eop.dubbo.service;

import org.eop.dubbo.entity.Post;

/**
 * @author lixinjie
 * @since 2017-04-17
 */
public interface PostService {

	public Post getPost(String id, String name);
}
