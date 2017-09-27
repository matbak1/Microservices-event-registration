package com.example.userservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Mateusz on 2017-08-25.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

    public User findByuserName(String name);
}

