package com.ljp.test.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class JWTTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("Asia/Chongqing")));
        calendar.add(Calendar.HOUR, 15 * 24);
        String token = JWT.create().withClaim("username", "username").withClaim("email", "email").withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC512("luojunping"));
        System.out.println("token = " + token);
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512("luojunping")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        System.out.println("decodedJWT.getHeader() = " + decodedJWT.getHeader());
        System.out.println("decodedJWT.getClaim(\"username\") = " + decodedJWT.getClaim("username").asString());
        System.out.println("decodedJWT.getClaim(\"email\") = " + decodedJWT.getClaim("email").asString());
    }

}
