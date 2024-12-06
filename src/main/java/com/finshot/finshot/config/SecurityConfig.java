package com.finshot.finshot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable() // Disable CSRF for simplicity; re-enable for production with proper setup
        .cors().and() // Enable CORS
        .authorizeRequests()
        .anyRequest().permitAll(); // Allow all requests for now

    return http.build();
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOriginPattern("*"); // Allow requests from any origin
    config.addAllowedMethod("*");       // Allow all HTTP methods
    config.addAllowedHeader("*");       // Allow all headers
    config.setAllowCredentials(true);   // Allow credentials
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
