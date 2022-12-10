package cn.edu.hutb.exam.modules.sys.service;

import cn.edu.hutb.exam.modules.sys.dto.response.SysUserLoginRespDTO;
import cn.edu.hutb.exam.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 田章
 * @description 系统用户的业务接口
 * @datetime 2022/12/10 14:52
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 登录
     */
    SysUserLoginRespDTO login(String username, String password);

}

