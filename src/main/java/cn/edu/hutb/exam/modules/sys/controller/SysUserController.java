package cn.edu.hutb.exam.modules.sys.controller;

import cn.edu.hutb.exam.core.result.JsonResult;
import cn.edu.hutb.exam.modules.sys.dto.request.SysUserLoginReqDTO;
import cn.edu.hutb.exam.modules.sys.dto.response.SysUserLoginRespDTO;
import cn.edu.hutb.exam.modules.sys.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 田章
 * @description 管理用户的接口
 * @datetime 2022/12/9 18:57
 */
@Tag(name = "管理用户")
@RestController
@RequestMapping("/exam/api/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public JsonResult<SysUserLoginRespDTO> login(SysUserLoginReqDTO reqDTO) {
        SysUserLoginRespDTO respDTO = sysUserService.login(reqDTO.getUsername(), reqDTO.getPassword());
        return null;
    }
}
