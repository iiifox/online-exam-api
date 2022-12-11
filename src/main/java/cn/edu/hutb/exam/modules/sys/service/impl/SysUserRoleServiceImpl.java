package cn.edu.hutb.exam.modules.sys.service.impl;

import cn.edu.hutb.exam.modules.sys.entity.SysUserRole;
import cn.edu.hutb.exam.modules.sys.mapper.SysUserRoleMapper;
import cn.edu.hutb.exam.modules.sys.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 田章
 * @description 系统用户角色关联业务类
 * @datetime 2022/12/11 10:19
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
        implements SysUserRoleService {
}
