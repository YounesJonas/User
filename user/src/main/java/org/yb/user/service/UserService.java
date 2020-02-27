package org.yb.user.service;


import java.util.Optional;

import org.springframework.stereotype.Component;
import org.yb.user.entities.User;

@Component
public interface UserService {

	
	
	
	User saveUser(User user);

	
	Optional<User> displayDetailsUser(String id);
}
