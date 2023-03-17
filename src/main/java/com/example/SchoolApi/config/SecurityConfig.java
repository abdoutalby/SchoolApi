package com.example.SchoolApi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    final jwtAuthentificationFilter jwtAuthentificationFilter;
    final AuthenticationProvider authenticationProvider;
    final LogoutHandler logoutHandler;
    @Bean  // maaneha ray hedhi config
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf().disable()//nahina config par defaut
                .authorizeHttpRequests()//tkhali les requete yetaadew maghir filtrage
                .requestMatchers("/api/auth/**")// entre parenthése bch nhot list ta3 hajet li nhebhom yetaadew sans filtrage
                .permitAll()// hne kotlou 3adehom kol
                .anyRequest()// hedhi maaneha kotlou ay request
                .authenticated()// lezemha tkoun authentifier
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//hedhi kotlou raw session mouch bch nbdadel feha chy
                .and()
                .authenticationProvider(authenticationProvider).//hne kotlou chkoun ili bch yaati token
                addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class)//hatitlou chkoun bch yaaml filtrage w aala asses ana type
                .logout()
                .logoutUrl("api/logout")//hedha lien li bch taaml alih logout
                .addLogoutHandler(logoutHandler)//w hedha sayed li mas2oul aala logout
                .logoutSuccessHandler(
                        ((request, response, authentication) -> SecurityContextHolder.clearContext())
                );
        return http.build();



    }
}
