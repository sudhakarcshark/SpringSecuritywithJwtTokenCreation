package com.SpringSecurityExample.service;

import com.SpringSecurityExample.request.UserRegisterRequest;
import com.SpringSecurityExample.response.APIResponse;
import org.springframework.http.ResponseEntity;



public interface UserRegisterService {

    ResponseEntity<APIResponse> adduser(UserRegisterRequest request);

    public String verify(UserRegisterRequest request);
}
