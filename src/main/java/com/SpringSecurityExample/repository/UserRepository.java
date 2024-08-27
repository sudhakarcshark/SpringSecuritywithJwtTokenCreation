package com.SpringSecurityExample.repository;

import com.SpringSecurityExample.model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserRegister,Integer>{

   Optional<UserRegister> findByUserName(final String customerName);

}
