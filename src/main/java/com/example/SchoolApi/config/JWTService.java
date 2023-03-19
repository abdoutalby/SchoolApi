package com.example.SchoolApi.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JWTService {
    private static final String KEY="knenfisofzefnokjdrkeg2432P5URU34RJZ3eFMEQSFNIQ34O49O320";

    public boolean isTokenValid(String token, UserDetails userDetails){
        String email=extractUsername(token);
        return (email.equals(userDetails.getUsername())) && !isTokenExpired(token) ;
    }

    private boolean isTokenExpired(String token){
        return extractClaim(token,Claims::getExpiration)
                .before(new Date());
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] bytes= Decoders.BASE64.decode(KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken(UserDetails userDetails ){
        return createToken(new HashMap<>(),userDetails);
    }

    private  String createToken(HashMap<String, Object> extraClaim, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


}
