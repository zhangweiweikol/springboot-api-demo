package com.demo.platform.common.utils;

import io.jsonwebtoken.*;
import java.util.Date;

/**
 * @author SHILING_DENG
 * @version 2020-05-05
 *
 */
public class JwtUtil {


    //设置过期时间为15分钟
    public static final long EXPIRE_TIME = 15*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "6CvvNscuUDAq*JxE";

    /**
     * 签发JWT
     * @param id 可以设置为登录账户的ID
     * @param subject 可以是JSON数据,如登录用户的JSON字符串 尽可能少
     * @param ttlMillis token有效时间
     * @return
     */
    public static String signToken(String id, String subject, long ttlMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)   // 主题
                .setIssuer("admin")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param token
     * @return
     */
    public static boolean validateToken(String token) {
        try {
            Claims claims = parseToken(token);
            if (claims!=null){
                return true;
            }else{
                return false;
            }

        } catch (ExpiredJwtException e) {
           return false;
        } catch (SignatureException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }



    /**
     * 解析JWT字符串
     * @param token
     * @return
     * @throws Exception
     */
    public static Claims parseToken(String token){
        Claims body = null;
        try {
            body = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static void main(String[] args){
//        String token = signToken("1", "admin", EXPIRE_TIME);
//        System.out.println(token);
//        System.out.println(validateToken(token));
    }
}
