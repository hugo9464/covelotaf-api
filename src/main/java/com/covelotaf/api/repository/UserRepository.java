package com.covelotaf.api.repository;

import com.covelotaf.api.entity.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public User findByUserId(String userId);

}
