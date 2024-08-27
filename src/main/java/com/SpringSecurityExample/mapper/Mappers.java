package com.SpringSecurityExample.mapper;

import com.SpringSecurityExample.model.UserRegister;
import com.SpringSecurityExample.request.UserRegisterRequest;
import com.SpringSecurityExample.response.UserRegisterResponse;


public class Mappers {

   public static UserRegister modelToMapper(UserRegisterRequest request){
       return UserRegister.builder()
               .userName(request.getUserName())
               .customerPassword(request.getCustomerPassword())
               .build();

   }

   public static UserRegisterResponse modelToResponse(UserRegister userRegister){
       return UserRegisterResponse.builder()
               .customerId(userRegister.getCustomerId())
               .userName(userRegister.getUserName())
               .customerPassword(userRegister.getCustomerPassword())
               .build();
   }
}
