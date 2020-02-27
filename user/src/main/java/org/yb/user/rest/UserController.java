package org.yb.user.rest;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yb.user.entities.User;
import org.yb.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		// get Id 
		String id = userService.saveUser(user).getId();
		return ResponseEntity.created(URI.create("/user/" + id)).build();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		Optional<User> userDB =  userService.displayDetailsUser(id);
		if(userDB.isPresent()) {
			return ResponseEntity.ok(userDB.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
