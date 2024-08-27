package com.SpringSecurityExample.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class UserRegisterResponse {

    @JsonProperty("customerId")
    private int customerId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("customerPassword")
    private String customerPassword;
}
