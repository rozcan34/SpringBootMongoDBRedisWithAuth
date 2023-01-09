package com.mwp.sbmdbr.payload.request;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SignupRequest {

    private String username;

    private String password;

    private String email;

    private Set<String> roles = new HashSet<>();
}
