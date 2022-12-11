package cn.edu.hutb.exam.modules.sys.user.service.impl;

import cn.edu.hutb.exam.modules.sys.user.entity.SysUserRole;
import cn.edu.hutb.exam.modules.sys.user.mapper.SysUserRoleMapper;
import cn.edu.hutb.exam.modules.sys.user.service.SysUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 田章
 * @description 系统用户角色关联业务类
 * @datetime 2022/12/11 10:19
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
        implements SysUserRoleService {

    @Override
    public List<String> listRoles(String userId) {
        return super.list(new QueryWrapper<SysUserRole>().lambda().eq(SysUserRole::getUserId, userId))
                .stream()
                .map(SysUserRole::getRoleId)
                .collect(Collectors.toList());
    }
}
