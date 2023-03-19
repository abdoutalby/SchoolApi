package com.example.SchoolApi.config;

import com.example.SchoolApi.repositories.TokenRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor // analogie lel autowired lkol varibale final
public class jwtAuthentificationFilter extends OncePerRequestFilter {

    final JWTService jwtService;
    final UserDetailsService userDetailsService;

    final TokenRepo tokenRepo;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
            String token=request.getHeader("Authorization");
            final String jwt;
            final String userEmail;
            if(token==null || !token.startsWith("Bearer ")){
                filterChain.doFilter(request,response);
                return;
            }
            jwt=token.substring(7);
            userEmail=jwtService.extractUsername(jwt);
            if (userEmail!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails=userDetailsService.loadUserByUsername(userEmail);
                boolean isTokenValid=tokenRepo.findByToken(jwt).map
                        (tok ->!tok.isExpired() && !tok.isRevoked() )
                        .orElse(false);
                if(isTokenValid && jwtService.isTokenValid(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            filterChain.doFilter(request,response);


    }
}
