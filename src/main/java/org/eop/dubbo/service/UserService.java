package org.eop.dubbo.service;

import org.eop.dubbo.entity.User;

/**
 * @author lixinjie
 * @since 2017-04-17
 */
public interface UserService {

	public User getUser(String id, String name, String sex, int age);
}
