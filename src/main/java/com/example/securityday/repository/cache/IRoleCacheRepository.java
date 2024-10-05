package com.example.securityday.repository.cache;

import com.example.securityday.entity.cache.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleCacheRepository extends CrudRepository<Role, Integer> {
}
