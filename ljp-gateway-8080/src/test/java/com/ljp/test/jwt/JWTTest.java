package com.ljp.test.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/29
 * @since 1.0.0
 **/
public class JWTTest {

    @Test
    public void testOne() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("Asia/Chongqing")));
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        String jwtStr = JWT.create().withExpiresAt(calendar.getTime()).withClaim("userId", "9876543210").withClaim("username", "so young").sign(Algorithm.HMAC512("ljp"));
        System.out.println("jwtStr = " + jwtStr);
        String username = JWT.decode(jwtStr).getClaim("username").asString();
        System.out.println("username = " + username);
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("ljp")).build().verify(jwtStr);
        System.out.println("decodedJWT.getClaim(\"username\").asString() = " + decodedJWT.getClaim("username").asString());
    }

}
