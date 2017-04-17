package org.eop.dubbo.service.impl;

import org.eop.dubbo.entity.User;
import org.eop.dubbo.service.UserService;

/**
 * @author lixinjie
 * @since 2017-04-17
 */
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String id, String name, String sex, int age) {
		return new User(id, name, sex, age);
	}

}
