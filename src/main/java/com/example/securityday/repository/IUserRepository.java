package com.example.securityday.repository;

import com.example.securityday.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<ApplicationUser, Integer> {

    @Query("select a from ApplicationUser a where a.email =:email") // JPQL
    ApplicationUser findUserByEmail(String email);

}
