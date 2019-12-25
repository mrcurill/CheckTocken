package com.kaagapov.checkToken.repo;

import com.kaagapov.checkToken.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLogin(String login);
}
