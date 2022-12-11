package cn.edu.hutb.exam.core.shiro;

import com.auth0.jwt.interfaces.Claim;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Map;

class JwtUtilsTest {

    @Test
    void test() {
        System.out.println(JwtUtils.TOKEN_HEADER_FIELD);
        // System.out.println(JwtUtils.EXPIRE_TIME);


        String token1 = JwtUtils.getToken(Map.of("username", "admin", "测试k", "测试v"));
        Map<String, Claim> claims = JwtUtils.getClaims(token1);
        System.out.println(claims.get("username"));
        System.out.println(claims.get("pwd"));

        String token2 = JwtUtils.getToken(null);
        System.out.println(token2);
        System.out.println(JwtUtils.getClaims(token2));

    }

    @Test
    void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        // calendar.add(JwtUtils.EXPIRE_TIME_UNIT, JwtUtils.EXPIRE_TIME);
        System.out.println(calendar.getTime());
    }

}