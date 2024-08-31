package com.SpringSecurityExample.service;

import com.SpringSecurityExample.controller.Controller;
import com.SpringSecurityExample.exceptions.DuplicateUserNameException;
import com.SpringSecurityExample.mapper.Mappers;
import com.SpringSecurityExample.model.UserRegister;
import com.SpringSecurityExample.repository.UserRepository;
import com.SpringSecurityExample.request.UserRegisterRequest;
import com.SpringSecurityExample.response.APIResponse;
import com.SpringSecurityExample.securityconfig.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{


    @Autowired
    private UserRepository repo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public ResponseEntity<APIResponse> adduser(UserRegisterRequest request) {

        if (repo.findByUserName(request.getUserName()).isPresent()){
            throw new DuplicateUserNameException("User Already Exit");
        }

       UserRegister userRegister = repo.save(Mappers.modelToMapper(request));
       return ResponseEntity.ok(
               APIResponse.builder()
                       .errorCode(0)
                       .errorMessage("Success")
                       .data(Mappers.modelToResponse(userRegister))
                       .build()
       );


    }

    @Override
    public String verify(UserRegisterRequest request) {

Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getCustomerPassword()));
if (authentication.isAuthenticated()){
    return jwtService.generateToken(request.getUserName());
}else {
    return "fail";
}

    }
}
