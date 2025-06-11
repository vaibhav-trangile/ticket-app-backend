package com.trangile.services.security.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.trangile.services.security.UserDetailsImpl;
import com.trangile.util.AppConstants;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	
	
//	@Value("${jwt.secret}")
    private String jwtSecret = "TSPL_$SUPPORT_wms-@512";

////    @Value("${jwt.expiration}")
//    private long jwtExpiration = 1800000;

    
//    public String generateToken(UserDetails userByUsername) {
//    	Date date = new Date(new Date().getTime() + AppConstants.EXPIRATION_TIME);
//    	return Jwts.builder()
//                .setSubject(userByUsername.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(date)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    	
//    }

    public boolean validateJwtToken(String authToken) {
		   try {
			      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			      return true;
			    } catch (SignatureException e) {
//			      logger.error("Invalid JWT signature: {}", e.getMessage());
//			    	System.out.println(e.getLocalizedMessage());
			    	e.printStackTrace();
			    } catch (MalformedJwtException e) {
//			      logger.error("Invalid JWT token: {}", e.getMessage());
//			    	System.out.println(e.getLocalizedMessage());
			    	e.printStackTrace();
			    } catch (ExpiredJwtException e) {
//			      logger.error("JWT token is expired: {}", e.getMessage());
//			    	System.out.println(e.getLocalizedMessage());
			    	e.printStackTrace();
			    } catch (UnsupportedJwtException e) {
//			      logger.error("JWT token is unsupported: {}", e.getMessage());
			    	System.out.println(e.getLocalizedMessage());
			    	e.printStackTrace();
			    } catch (IllegalArgumentException e) {
//			      logger.error("JWT claims string is empty: {}", e.getMessage());
//			    	System.out.println(e.getLocalizedMessage());
			    	e.printStackTrace();
			    }
			    return false;	
	}
    
    
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

	public String generateToken(UserDetailsImpl userByUsername) {
//		 TODO Auto-generated method stub
    	Date date = new Date(new Date().getTime() + AppConstants.EXPIRATION_TIME);
    	return Jwts.builder()
                .setSubject(userByUsername.getUsername())
                .claim("email", userByUsername.getEmail())
                .claim("roles", userByUsername.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
	}
}
