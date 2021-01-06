package com.winter.adlist.repositories;

import com.winter.adlist.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
