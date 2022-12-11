package cn.edu.hutb.exam.modules.sys.user.service;

import cn.edu.hutb.exam.modules.sys.user.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 田章
 * @description 系统用户角色关联业务接口
 * @datetime 2022/12/11 10:18
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户表主键id查找用户角色列表
     */
    List<String> listRoles(String userId);
}
