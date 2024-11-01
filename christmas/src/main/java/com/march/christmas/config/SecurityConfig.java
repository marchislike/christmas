package com.march.christmas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/posts/**").permitAll() // 모든 요청에 대해 인증 없이 허용
                        .anyRequest().authenticated() // 다른 요청은 인증이 필요
                )
                .csrf(csrf -> csrf.disable()); // CSRF 보호 비활성화

        return http.build();
    }
}
