package com.metlease.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metlease.Entity.ApplicationUser;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;

import static com.metlease.Config.ConfigConstants.EXPIRATION_TIME;
import static com.metlease.Config.ConfigConstants.HEADER_STRING;
import static com.metlease.Config.ConfigConstants.TOKEN_PREFIX;
import static com.metlease.Config.ConfigConstants.SECRET;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            String res = IOUtils.toString(request.getInputStream(), Charsets.UTF_8);
            ApplicationUser credentials = new ObjectMapper().readValue(res, ApplicationUser.class);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(), new ArrayList<>()));
            return authentication;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        //System.out.println(auth.getPrincipal());
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        response.getWriter().write("Good credentials");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(failed.getMessage());
        throw failed;
        //this.rememberMeServices.loginFail(request, response);
        //this.failureHandler.onAuthenticationFailure(request, response, failed);
    }

}
