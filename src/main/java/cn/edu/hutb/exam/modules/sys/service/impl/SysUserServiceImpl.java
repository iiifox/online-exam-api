package cn.edu.hutb.exam.modules.sys.service.impl;

import cn.edu.hutb.exam.core.exception.BizException;
import cn.edu.hutb.exam.core.result.BizErrorEnum;
import cn.edu.hutb.exam.core.util.BCrypt;
import cn.edu.hutb.exam.modules.sys.dto.response.SysUserLoginRespDTO;
import cn.edu.hutb.exam.modules.sys.entity.SysUser;
import cn.edu.hutb.exam.modules.sys.mapper.SysUserMapper;
import cn.edu.hutb.exam.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
    public SysUserLoginRespDTO login(String username, String password) {
        SysUser user = super.getOne(
                new QueryWrapper<SysUser>().lambda().eq(SysUser::getUsername, username), false);
        // 账号不存在
        if (user == null) {
            throw new BizException(BizErrorEnum.ERROR_90010001);
        }
        // TODO 账号被冻结
        // if (user.getState())
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new BizException(BizErrorEnum.ERROR_90010002);
        }
        return this.setToken(user);
    }


    /**
     * 保存会话信息
     */
    private SysUserLoginRespDTO setToken(SysUser user) {
        SysUserLoginRespDTO respDTO = new SysUserLoginRespDTO();
        BeanUtils.copyProperties(user, respDTO);
        // TODO 生成Token
        // TODO 填充角色表
        return respDTO;
    }

}
