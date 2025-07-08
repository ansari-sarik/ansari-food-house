package com.ansari.config;

//Two method write here one for generate token and another get email for the jwt token

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service


public class JwtProvider {

   private SecretKey key = Keys.hmacShaKeyFor(jwtConstant.SECRET_KEY.getBytes()) ;

   public String generateToken(Authentication auth){
       Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

       String roles = populateAuthorities(authorities);

       String jwt = Jwts.builder()
               .setIssuedAt(new Date()) // current time
               .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours later
               .claim("email", auth.getName()) // user email
               .claim("authorities", roles) // user roles
               .signWith(key) // signing with secret key
               .compact();

       return jwt;

   }

   public String getEmailFromJwtToken(String jwt){
       jwt = jwt.substring(7);

       Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

       String email = String.valueOf(claims.get("email"));

       return email;
   }

    private String populateAuthorities(Collection <? extends GrantedAuthority> authorities) {
       Set<String> auths = new HashSet<>();

       for(GrantedAuthority authority : authorities){
           auths.add(authority.getAuthority());
       }

       return String.join(",", auths);
    }
}















