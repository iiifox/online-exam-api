package cn.edu.hutb.exam.core.util;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class BCryptTest {

    @Test
    void test() throws NoSuchAlgorithmException {
        String pwd1 = BCrypt.hashpw("admin", BCrypt.gensalt());
        System.out.println(pwd1);
        System.out.println(BCrypt.checkpw("admin", pwd1));

        String pwd2 = BCrypt.hashpw("admin", BCrypt.gensalt(6));
        System.out.println(BCrypt.checkpw("admin", pwd2));

        String pwd3 = BCrypt.hashpw("admin", BCrypt.gensalt(6, SecureRandom.getInstance("SHA1PRNG")));
        System.out.println(BCrypt.checkpw("admin", pwd3));
    }
}