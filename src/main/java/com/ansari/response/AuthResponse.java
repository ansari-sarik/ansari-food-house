package com.ansari.response;


import com.ansari.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;

    private String message;

    private USER_ROLE role;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setRole(String role){
        this.role = USER_ROLE.valueOf(role);
    }
}
