package com.example.usereventservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Mateusz on 2017-08-25.
 */
@RepositoryRestResource
public interface UserEventRepository extends JpaRepository<UserEvent, Long>{

    List<UserEvent> findByUserId(Long id);

}
