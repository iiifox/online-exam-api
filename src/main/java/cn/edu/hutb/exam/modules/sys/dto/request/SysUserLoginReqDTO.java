package cn.edu.hutb.exam.modules.sys.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 田章
 * @description 用户登录请求类
 * @datetime 2022/12/10 14:47
 */
@Data
@Schema(name = "用户登录请求类", description = "用户登录请求类")
public class SysUserLoginReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name = "用户名", required = true)
    private String username;

    @Schema(name = "密码", required = true)
    private String password;

}