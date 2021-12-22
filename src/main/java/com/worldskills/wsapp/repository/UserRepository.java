package com.worldskills.wsapp.repository;

import com.worldskills.wsapp.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
}
