package com.example.securityday.entity.cache;


import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;
import jakarta.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String authority;

}
