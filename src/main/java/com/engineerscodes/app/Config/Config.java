package com.engineerscodes.app.Config;

import jakarta.servlet.DispatcherType;
import org.keycloak.TokenVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class Config {

    private String KS_ADMIN = "ks_admin";
    private String KS_USER = "ks_user";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"*/**").hasAuthority(KS_ADMIN)
                .requestMatchers(HttpMethod.POST,"*/**").hasAnyAuthority(KS_ADMIN)
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .oauth2ResourceServer()
                .jwt();

        return http.build();
    }

    public String token(){
        Jwt principal = getPrincipal();
        return principal.getTokenValue();
    }

    public Jwt getPrincipal(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Jwt) authentication.getPrincipal();
    }

    public AccessToken getAccessToken() throws VerificationException {
        String tokenString = token();
        return TokenVerifier.create(tokenString,AccessToken.class).getToken();
    }
}
