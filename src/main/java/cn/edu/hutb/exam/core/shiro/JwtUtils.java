package cn.edu.hutb.exam.core.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author 田章
 * @description 使用对称签名的通用JWT工具类
 * @datetime 2022/12/10 23:28
 */
public class JwtUtils {

    /**
     * 会话令牌token在请求头中的字段名(供其他类使用)
     */
    public static final String TOKEN_HEADER_FIELD;

    /**
     * 私钥
     */
    private static final String SECRET;

    /**
     * 令牌有效期（单位：天）
     */
    private static final int EXPIRE_TIME;

    /**
     * 令牌过期时间单位
     */
    private static final int EXPIRE_TIME_UNIT = Calendar.DAY_OF_MONTH;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jwt");
        SECRET = bundle.getString("jwt.secret");
        TOKEN_HEADER_FIELD = bundle.getString("jwt.tokenHeaderField");
        EXPIRE_TIME = Integer.parseInt(bundle.getString("jwt.expire-time"));
    }

    //************ JWT结构 ************//
    /*
    Header(标头)
        {
            "alg": "HS256",  // alg属性表示签名使用的算法，默认为HMAC SHA256（写为HS256）
            "typ": "JWT"     // typ属性表示令牌的类型，JWT令牌统一写为JWT
        }

    Payload(有效载荷)
        //=== JWT指定七个默认字段供选择,也可以将用户信息放入自定义字段 ===//
            iss：发行人
            exp：到期时间
            sub：主题
            aud：用户
            nbf：在此之前不可用
            iat：发布时间
            jti：JWT ID用于标识该JWT

    Signature(签名)
        对上面两部分数据签名，需要使用base64编码后的header和payload数据，通过指定的算法生成哈希，以确保数据不会被篡改。
        首先，需要指定一个密钥（secret）。该密码仅仅为保存在服务器中，并且不能向用户公开。
        然后，使用header中指定的签名算法（默认情况下为HMAC SHA256）根据以下公式生成签名
            HMACSHA256(base64UrlEncode(header)+"."+base64UrlEncode(payload), secret)
     */

    /**
     * 生成JWT Token字符串
     *
     * @param payload 以键值对map的形式设置有效负载
     * @return a new JWT token
     */
    public static String getToken(Map<String, ?> payload) {
        Calendar.getInstance().add(EXPIRE_TIME_UNIT, EXPIRE_TIME);
        Date expireDate = new Date(System.currentTimeMillis() + 24L * 60 * 60 * 1000 * EXPIRE_TIME);
        return JWT.create()
                .withPayload(payload)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 获取所有的令牌键值对
     */
    public static Map<String, Claim> getClaims(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getClaims();
    }

}
