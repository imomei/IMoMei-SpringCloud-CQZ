package com.imomei.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenUtils {
    public static void main(String[] args) {
        // 生成JWTToken
        String jwtToken = getJWT();
        // 解析JWTToken
        parseJWT(jwtToken);
    }

    // 加密
    public static String getJWT() {
        JwtBuilder builder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "imomei")
                .setId("1")
                .setSubject("小明")
                .setIssuedAt(new Date())
                 .setExpiration(new Date(new Date().getTime() + 60000))
                .claim("haha", "123");
        return builder.compact();
    }

    // 解密
    public static String parseJWT(String jwtToken) {
        Claims claims = Jwts.parser().setSigningKey("imomei").parseClaimsJws(jwtToken).getBody();
        System.out.println("用户ID：" + claims.getId());
        System.out.println("用户名：" + claims.getSubject());
        System.out.println("登陆时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("自定义数据：" + claims.get("haha"));
        return "";
    }
}
