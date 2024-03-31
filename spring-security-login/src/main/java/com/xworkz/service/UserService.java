package com.xworkz.service;

import com.xworkz.entity.User;

public interface UserService {

	User saveUser(User user);

	void removeSessionMessage();
}
