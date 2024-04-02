package com.example.demo.Reposiatory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface UserRepository extends JpaRepository<User, Long> {

}
