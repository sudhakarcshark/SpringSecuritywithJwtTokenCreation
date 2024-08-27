package com.SpringSecurityExample.service;

import com.SpringSecurityExample.model.UserPrincipal;
import com.SpringSecurityExample.model.UserRegister;
import com.SpringSecurityExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserRegister> userRegister = repo.findByUserName(username);
        return userRegister.map(UserPrincipal::new)
                .orElseThrow(()-> new UsernameNotFoundException(" User not found " + username));
    }
}
