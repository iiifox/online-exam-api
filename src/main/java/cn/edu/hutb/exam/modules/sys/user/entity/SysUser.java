package cn.edu.hutb.exam.modules.sys.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author 田章
 * @description 系统用户实体类
 * @datetime 2022/12/10 14:54
 */
@Data
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String username;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门ID
     */
    @TableField("depart_id")
    private String departId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 状态
     */
    private Integer state;

}
