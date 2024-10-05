package com.example.securityday.repository;

import com.example.securityday.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.authority = :authority") // JPQL
    Role getAuthorityByName(String authority);

}
