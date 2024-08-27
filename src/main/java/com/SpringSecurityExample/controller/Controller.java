package com.SpringSecurityExample.controller;

import com.SpringSecurityExample.model.UserRegister;
import com.SpringSecurityExample.request.UserRegisterRequest;
import com.SpringSecurityExample.response.APIResponse;
import com.SpringSecurityExample.service.UserRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class Controller {


    @Autowired
    private UserRegisterService service;

   @PostMapping("/create/user")
   public ResponseEntity<APIResponse> addNewuser(@RequestBody UserRegisterRequest request){
       return service.adduser(request);
}

    @PostMapping("/login")
    public String greet(@RequestBody UserRegisterRequest request) {

       return service.verify(request);
    }

}

