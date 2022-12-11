package cn.edu.hutb.exam.modules.sys.user.service.impl;

import cn.edu.hutb.exam.core.exception.BizException;
import cn.edu.hutb.exam.core.result.BizErrorEnum;
import cn.edu.hutb.exam.core.shiro.JwtUtils;
import cn.edu.hutb.exam.core.util.BCrypt;
import cn.edu.hutb.exam.modules.sys.user.dto.response.SysUserLoginRespDTO;
import cn.edu.hutb.exam.modules.sys.user.entity.SysUser;
import cn.edu.hutb.exam.modules.sys.user.enums.UserState;
import cn.edu.hutb.exam.modules.sys.user.mapper.SysUserMapper;
import cn.edu.hutb.exam.modules.sys.user.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

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
        //  账号被冻结
        if (UserState.ABNORMAL.getStatue().equals(user.getState())) {
            throw new BizException(BizErrorEnum.ERROR_90010005);
        }
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
        // 生成Token
        respDTO.setToken(JwtUtils.getToken(Map.of("username", user.getUsername())));
        // TODO 填充角色表
        return respDTO;
    }

}
