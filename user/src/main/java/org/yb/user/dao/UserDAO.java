package org.yb.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.yb.user.entities.User;
@RepositoryRestResource
public interface UserDAO extends MongoRepository<User, String> {

}
