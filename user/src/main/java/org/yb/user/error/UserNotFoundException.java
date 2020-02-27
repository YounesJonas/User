package org.yb.user.error;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String id) {
		super("this User is not found : " + id);
	}
}
