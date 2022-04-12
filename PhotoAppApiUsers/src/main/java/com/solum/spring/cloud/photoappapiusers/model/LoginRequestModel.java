package com.solum.spring.cloud.photoappapiusers.model;

import lombok.Data;

@Data
public class LoginRequestModel {

    private String email;
    private String password;

}