package com.engineerscodes.app.repository;

import com.engineerscodes.app.Entity.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepo extends JpaRepository<person, Long> {
}
