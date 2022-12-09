package cn.edu.hutb.exam.modules.sys;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 田章
 * @description 管理用户的接口
 * @datetime 2022/12/9 18:57
 */
@Tag(name = "管理用户")
@RestController
@RequestMapping("/exam/api/sys/user")
public class SysUserController {

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Object login(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println(token);
        return token;
    }
}
