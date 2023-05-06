package com.engineerscodes.app.repository;

import com.engineerscodes.app.Entity.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonRepo extends JpaRepository<person, Long> {


    @Query("select p from emp p where p.name = ?1")
    public List<person> getUser(String name);

}
