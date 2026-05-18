package top.campus.security.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

public class JwtUtils {

    private static final String SECRET = "campus-management-system-secret-key-2026";

    private static final long EXPIRE = 1000 * 60 * 60 * 24;

    public static String createToken(Long userId,String username){

        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE);

        return Jwts.builder()
                .setSubject(username)
                .claim("userId",userId)
                .setExpiration(expireDate)
                .signWith(
                        Keys.hmacShaKeyFor(SECRET.getBytes()),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()                   // 1. 创建解析器构建器
                .setSigningKey(                       // 2. 设置签名验证密钥
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()
                        )
                )
                .build()                              // 3. 构建解析器
                .parseClaimsJws(token)                // 4. 解析并验证 JWT
                .getBody();                           // 5. 获取载荷（Claims）
    }

    public static String getUsername(String token){
        return parseToken(token).getSubject();
    }

    public static boolean isTokenExpired(String token){
        return parseToken(token)
                .getExpiration()
                .before(new Date());
    }

}
