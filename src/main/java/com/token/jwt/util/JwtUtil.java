package com.token.jwt.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;

/**
 * @author KingSum
 * @date 2018/3/13
 */
public class JwtUtil {
    static final String SECRET = "myFaceKey";

    public static String generateToken(String username) {
        HashMap<String, Object> map = new HashMap<>();
        //you can put any data in the map
        map.put("username", username);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 7200_000L))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer "+jwt;
    }

    public static Object validateToken(String token) {
        Object user = null;
        try {
            user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ",""))
                    .getBody().get("username");
            if(StringUtils.isEmpty(user)){
                throw new IllegalStateException("Invalid Token.");
            }
        }catch (Exception e){
            throw new IllegalStateException("Invalid Token. "+e.getMessage());
        }
        return user;
    }
}
