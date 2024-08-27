package com.SpringSecurityExample.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class UserRegisterRequest {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("customerPassword")
    private String customerPassword;
}
