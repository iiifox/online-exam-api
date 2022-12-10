package cn.edu.hutb.exam.modules.sys.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 田章
 * @description 用户登录响应类
 * @datetime 2022/12/10 18:51
 */
@Data
@Schema(name = "用户登录响应类", description = "用户登录响应类")
public class SysUserLoginRespDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name = "ID", required = true)
    private String id;

    @Schema(name = "用户名", required = true)
    private String userName;

    @Schema(name = "真实姓名", required = true)
    private String realName;

    @Schema(name = "角色列表", required = true)
    private String roleIds;

    @Schema(name = "部门ID", required = true)
    private String departId;

    @Schema(name = "创建时间", required = true)
    private Date createTime;

    @Schema(name = "更新时间", required = true)
    private Date updateTime;

    @Schema(name = "状态", required = true)
    private Integer state;

    @Schema(name = "角色列表", required = true)
    private List<String> roles;

    @Schema(name = "登录令牌", required = true)
    private String token;

}