package com.trangile.services.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.trangile.services.security.jwt.AuthEntryPointJwt;
import com.trangile.services.security.jwt.AuthTokenFilter;
import com.trangile.util.AppConstants;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private AuthTokenFilter authenticationJwtTokenFilter;

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(authUserDetailsService); // Set UserDetailsService here
        authProvider.setPasswordEncoder(passwordEncoder());        // Set PasswordEncoder here
        return authProvider;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//            .cors(cors -> cors.disable())
//            .exceptionHandling(exceptionHandling -> 
//                exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
//            .sessionManagement(sessionManagement -> 
//                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/trangile/api/support/v1/reg/userauth/**").permitAll()
////                .requestMatchers(HttpMethod.POST, "/trangile/api/support/v1/reg/userauth/register").permitAll()
//                .anyRequest().authenticated()
//            );
//
//        // Add the authentication provider and token filter
//        http.authenticationProvider(authenticationProvider())
//            .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//            .cors(cors -> cors.disable())
//            .exceptionHandling(exceptionHandling -> 
//                exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
//            .sessionManagement(sessionManagement -> 
//                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/trangile/api/support/v1/reg/userauth/register").permitAll()
//                .requestMatchers("/trangile/api/support/v1/userdetail/engineers").permitAll()
//                .requestMatchers("/trangile/api/support/v1/reg/userauth/authenticate").permitAll()
//                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .anyRequest().authenticated()
//            );
//        http.authenticationProvider(authenticationProvider())
//            .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // Using proper CORS config instead of disabling
            .exceptionHandling(exceptionHandling -> 
                exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
            .sessionManagement(sessionManagement -> 
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/trangile/api/support/v1/reg/userauth/register").permitAll()
                .requestMatchers("/trangile/api/support/v1/userdetail/engineers").permitAll()
                .requestMatchers("/trangile/api/support/v1/reg/userauth/authenticate").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // This is correct for OPTIONS preflight
                .anyRequest().authenticated()
            );

        http.authenticationProvider(authenticationProvider())
            .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
            
        return http.build();
    }
    
 // Add this method to your configuration class
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(AppConstants.CORS_URI));  // Or specify exact origins like "http://localhost:3000"
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);  // Cache preflight response for 1 hour
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
