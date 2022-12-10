package cn.edu.hutb.exam.modules.sys.service.impl;

import cn.edu.hutb.exam.modules.sys.dto.response.SysUserLoginRespDTO;
import cn.edu.hutb.exam.modules.sys.entity.SysUser;
import cn.edu.hutb.exam.modules.sys.mapper.SysUserMapper;
import cn.edu.hutb.exam.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 田章
 * @description 系统用户的业务类
 * @datetime 2022/12/10 19:12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public SysUserLoginRespDTO login(String userName, String password) {
        return null;
    }

}
