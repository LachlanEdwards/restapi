package com.metlease.Entity.Helpers;

import com.metlease.Entity.ApplicationUser;
import com.metlease.Service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.metlease.Config.ConfigConstants.SECRET;
import static com.metlease.Config.ConfigConstants.TOKEN_PREFIX;

@Component
public class BearerTokenParser {

    @Autowired
    private UserService service;

    public ApplicationUser Parse(String token) {
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            return service.getByUsername(user);
        } else {
            return null;
        }
    }
}
