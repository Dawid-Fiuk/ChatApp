package com.chatApp.ChatApp.model;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class AuthRequest {
    private String username;
    private String password;
}
