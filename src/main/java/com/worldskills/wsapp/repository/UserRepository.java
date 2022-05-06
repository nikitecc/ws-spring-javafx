package com.worldskills.wsapp.repository;

import com.worldskills.wsapp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();

    @Query(value = "SELECT u FROM User u WHERE u.login = :name AND u.password = :password")
    Optional<User> userByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
