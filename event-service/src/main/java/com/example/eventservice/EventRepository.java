package com.example.eventservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Mateusz on 2017-08-25.
 */
@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event,Long>{


}
